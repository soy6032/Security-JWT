package com.project.jpa1.controller;

import com.project.jpa1.config.auth.LoginUser;
import com.project.jpa1.dto.JoinDto;
import com.project.jpa1.dto.ResponseDto;
import com.project.jpa1.dto.ResponseErrorDto;
import com.project.jpa1.dto.UserReqDto.JoinReqDto;
import com.project.jpa1.dto.UserRespDto;
import com.project.jpa1.handler.ex.CustomApiException;
import com.project.jpa1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@Valid @RequestBody JoinDto joinReqDto) {
        UserRespDto.JoinRespDto joinRespDto = userService.join(joinReqDto);
        return new ResponseEntity<>(new ResponseDto<>(1, "회원가입 성공", joinRespDto), HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public void findUserAccount(@AuthenticationPrincipal LoginUser loginUser) {
        System.out.println(loginUser == null);
    }

    @GetMapping("/admin")
    public void admin(@AuthenticationPrincipal LoginUser loginUser) {
        System.out.println(loginUser.getUsername());
        System.out.println(loginUser.getUser().getId());
        System.out.println(loginUser.getUser().getRole());
        System.out.println(loginUser.getAuthorities());
    }


}
