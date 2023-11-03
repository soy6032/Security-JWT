package com.project.jpa1.controller;

import com.project.jpa1.config.auth.LoginUser;
import com.project.jpa1.dto.*;
import com.project.jpa1.entity.Note;
import com.project.jpa1.entity.User;
import com.project.jpa1.repository.UserRepository;
import com.project.jpa1.service.NoteService;
import com.project.jpa1.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import  com.project.jpa1.dto.UserReqDto.JoinReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;
    private final NoteService noteService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserReqDto.JoinReqDto joinReqDto, BindingResult bindingResult) {
        //System.out.println(joinReqDto.ge);
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
