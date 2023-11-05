package com.project.jpa1.service;

import com.project.jpa1.dto.JoinDto;
import com.project.jpa1.dto.UserDto;
import com.project.jpa1.dto.UserReqDto;
import com.project.jpa1.dto.UserRespDto;
import com.project.jpa1.entity.User;
import com.project.jpa1.handler.ex.CustomApiException;
import com.project.jpa1.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//
////    public UserDto login(UserDto dto){
////        User user = new User();
////        user = dto.toEntity();
////        Optional<User> loginCheck = userRepository.findByUserIdAndUserPw(user.getUserId(), user.getUserPw());
////        return loginCheck.map(User::toDto).orElse(null);
////    }
//
////    public List<UserDto> memberList(){
////        List<User> list = userRepository.findAll();
////        List<UserDto> dtoList = list.stream()
////                .map(o -> new UserDto(o))
////                .collect(toList());
////
////        return dtoList;
////    }
//
////    public User join(UserDto userDto){
////        User user = new User();
////        user = userDto.toEntity();
////        return userRepository.save(user);
////    }
//
//}

@RequiredArgsConstructor
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 서비스는 DTO를 요청받고, DTO로 응답한다.
    @Transactional // 트랜잭션이 메서드 시작할 때, 시작되고, 종료될 때 함께 종료
    public UserRespDto.JoinRespDto join(JoinDto joinReqDto) {
        // 1. 동일 유저네임 존재 검사
        Optional<User> userOP = userRepository.findByUsername(joinReqDto.getUsername());
        if (userOP.isPresent()) {
            // 유저네임 중복되었다는 뜻
            throw new CustomApiException("동일한 username이 존재합니다");
        }

        // 2. 패스워드 인코딩 + 회원가입
        User userPS = userRepository.save(joinReqDto.toEntity(passwordEncoder));

        // 3. dto 응답
        return new UserRespDto.JoinRespDto(userPS);
    }

}