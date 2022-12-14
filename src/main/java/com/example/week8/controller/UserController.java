package com.example.week8.controller;

import com.example.week8.dto.request.*;
import com.example.week8.dto.response.ResponseDto;
import com.example.week8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 닉네임 변경
    @RequestMapping(value = "/api/user/nickname", method = RequestMethod.PUT)
    public ResponseDto<?> updateNickname(@RequestBody @Valid MemberInfoRequestDto requestDto, HttpServletRequest request) {
        return userService.setNickname(requestDto, request);
    }

    // 전화번호 변경
    @RequestMapping(value = "/api/user/phonenumber", method = RequestMethod.PUT)
    public ResponseDto<?> updatePhoneNumber(@RequestBody @Valid LoginRequestDto requestDto, HttpServletRequest request) {
        return userService.setPhoneNumber(requestDto, request);
    }

    // 카카오 전화번호 설정
    @RequestMapping(value = "/api/user/phonenumber/kakao", method = RequestMethod.PUT)
    public ResponseDto<?> updateKakaoPhoneNumber(@RequestBody @Valid LoginRequestDto requestDto, HttpServletRequest request, HttpServletResponse response) {
        return userService.setOauthPhoneNumber(requestDto, request, response, "kakao");
    }

    // 네이버 전화번호 설정
    @RequestMapping(value = "/api/user/phonenumber/naver", method = RequestMethod.PUT)
    public ResponseDto<?> updateNaverPhoneNumber(@RequestBody @Valid LoginRequestDto requestDto, HttpServletRequest request, HttpServletResponse response) {
        return userService.setOauthPhoneNumber(requestDto, request, response, "naver");
    }

    // 이메일 설정
    @RequestMapping(value = "/api/user/email", method = RequestMethod.PUT)
    public ResponseDto<?> updateEmail(@RequestBody @Valid EmailLoginRequestDto requestDto, HttpServletRequest request) {
        return userService.setEmail(requestDto, request);
    }

    // 이메일 입력용 인증코드 생성
    @RequestMapping (value = "/api/user/auth/email", method = RequestMethod.POST)
    public ResponseDto<?> sendEmailCode(@RequestBody @Valid AuthRequestDto requestDto) {
        return userService.sendEmailCode(requestDto);
    }

    // 프로필 사진 수정
    @RequestMapping(value = "/api/user/profileimage", method = RequestMethod.PUT)
    public ResponseDto<?> updateProfileImage(@RequestBody @Valid ImgUrlRequestDto requestDto, HttpServletRequest request) {
        return userService.setProfileImg(requestDto, request);
    }

    // 회원정보 불러오기
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public ResponseDto<?> getInfo(HttpServletRequest request) {
        return userService.getMemberInfo(request);
    }

    // 회원탈퇴
    @RequestMapping(value = "/api/user", method = RequestMethod.DELETE)
    public ResponseDto<?> deleteMember(HttpServletRequest request) {
        return userService.deleteMember(request);
    }

    // 포인트 추가
    @RequestMapping (value = "/api/user/point", method = RequestMethod.PUT)
    public ResponseDto<?> conversionPointToCredit(@RequestBody @Valid ConversionPointToCreditDto requestDto, HttpServletRequest request) {
        return userService.conversionPointToCredit(requestDto, request);
    }

    // 활동 내역 조회(완료된 약속)
    @GetMapping("/api/user/event")
    public ResponseDto<?> getClosedEvent(HttpServletRequest request) {
        return userService.getClosedEvent(request);
    }

    //로그인한 사용자가 쓴 글 전체 조회
    @GetMapping("api/user/myposts")
    public ResponseDto<?> getMyPosts(HttpServletRequest request){ return userService.getMyPosts(request);}
}
