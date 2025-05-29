package com.example.graph.domain.user.service;

import com.example.graph.domain.user.dto.TokenDto;
import com.example.graph.global.auth.AuthenticationScheme;
import com.example.graph.global.auth.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;

    // 이메일 인증을 통해 토큰 발급 받기
    public TokenDto issueTokenByEmail(String email) {
        String token = jwtProvider.generateToken(email);

        return new TokenDto(AuthenticationScheme.BEARER.getName(), token);
    }
}