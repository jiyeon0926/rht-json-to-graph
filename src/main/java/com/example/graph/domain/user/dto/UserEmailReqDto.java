package com.example.graph.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserEmailReqDto {

    private final String email;

    @JsonCreator
    public UserEmailReqDto(@JsonProperty("email") String email) {
        this.email = email;
    }
}
