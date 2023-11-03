package com.project.jpa1.dto;

import com.project.jpa1.entity.User;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userIdx;
    private String userId;
    private String userPw;
    private String joinDate;

}


