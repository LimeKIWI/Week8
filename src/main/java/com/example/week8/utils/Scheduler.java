package com.example.week8.utils;

import com.example.week8.domain.Member;
import com.example.week8.repository.MemberRepository;
import com.example.week8.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
@EnableAsync
public class Scheduler {  // 스케쥴링할 메소드의 조건 2가지: void의 return을 가짐. 파라미터를 가질 수 없음.
    private final MemberRepository memberRepository;
    private final EventService eventService;

    @Async
    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void init() {
        List<Member> memberList = memberRepository.findAll();
        for(Member curMember : memberList){
            curMember.setFirstLogin(true); //첫 로그인 여부 초기화
            curMember.setPointOnDay(0L);   //일일 획득 포인트 초기화
        }
        log.info("로그인 보너스 카운터가 초기화 되었습니다");
    }

    @Async
    @Scheduled(cron = "0 */10 * * * *")
    public void eventAlarm() {
        eventService.eventAlarm();
        eventService.scheduledConfirm();
    }


    // 12시가되면 post가 null인 이미지 s3에서 삭제와함께 이미지 entity에서도 삭제하는 구문 추가해야함..
    // 채팅메세지도 개선필요함.
}