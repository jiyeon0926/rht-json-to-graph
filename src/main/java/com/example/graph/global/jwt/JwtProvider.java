package com.example.graph.global.jwt;

import com.example.graph.domain.user.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    private final UserRepository userRepository;

    // 토큰 생성
    public String generateToken(String email) {
        userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."));

        return Jwts.builder()
                .subject(email)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)), Jwts.SIG.HS256)
                .compact();
    }

    // 토큰을 통해 이메일 가져오기
    public String getEmailFromToken(String token) {
        if (!StringUtils.hasText(token)) {
            throw new MalformedJwtException("토큰이 비어 있습니다.");
        }

        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // subject에 이메일 정보가 들어있기 때문에 getSubject() 메서드를 사용해 이메일 추출
    }
}
