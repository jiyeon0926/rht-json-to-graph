package com.example.graph.global.auth.jwt;

import com.example.graph.global.auth.AuthenticationScheme;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        authenticate(request);
        filterChain.doFilter(request, response);
    }

    private void authenticate(HttpServletRequest request) {
        String token = getTokenFromRequest(request);

        if (token != null) {
            if (!jwtProvider.validToken(token)) {
                return;
            }

            String username = jwtProvider.getUsername(token);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, List.of());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String headerPrefix = AuthenticationScheme.generateType(AuthenticationScheme.BEARER);

        return StringUtils.hasText(bearerToken) && bearerToken.startsWith(headerPrefix)
                ? bearerToken.substring(headerPrefix.length())
                : null;
    }
}
