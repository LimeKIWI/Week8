package com.example.week8.dto.response;

import com.example.week8.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDto {

    private Long id;
    private List<MemberResponseDto> memberList;
    private EventStatus eventStatus;
    private String title;
    private String eventDateTime;
    private String place;
    private String coordinate;
    private String createdAt;
    private String lastTime;  // 저장된 값을 불러오는 것이 아니라 호출 시마다 새로운 값 생성하여 입력
    private String content;
    private WeatherResponseDto weatherResponseDto;
    private int point;

}
