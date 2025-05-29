package com.example.graph.domain.user.controller;

import com.example.graph.domain.user.dto.TokenDto;
import com.example.graph.domain.user.dto.UserEmailReqDto;
import com.example.graph.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/email")
    public ResponseEntity<TokenDto> issueTokenByEmail(@RequestBody UserEmailReqDto userEmailReqDto) {
        TokenDto token = authService.issueTokenByEmail(userEmailReqDto.getEmail());

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
