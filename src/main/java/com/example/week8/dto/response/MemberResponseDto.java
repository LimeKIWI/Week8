package com.example.week8.dto.response;

import com.example.week8.domain.enums.Attendance;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String phoneNumber;
    private String email;
    private String nicknameByOwner;
    private String nicknameByFriend;
    private String credit;
    private int point;
    private String profileImageUrl;
    private Attendance attendance;

}
