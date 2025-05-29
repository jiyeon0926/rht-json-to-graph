package com.example.graph.global.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthenticationScheme {
    BEARER("Bearer");

    private final String name;

    public static String generateType(AuthenticationScheme authenticationScheme) {
        return authenticationScheme.getName() + " ";
    }
}
