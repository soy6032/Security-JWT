package com.project.jpa1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.HashMap;

@RequiredArgsConstructor
@Getter
public class ResponseErrorDto<E> {
    private final Integer code; // 1 성공, -1 실패
    private final HashMap<String, String> msg;
    private final E data;

}