package com.example.graph.domain.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenDto {

    private final String tokenAuthScheme;
    private final String token;
}
