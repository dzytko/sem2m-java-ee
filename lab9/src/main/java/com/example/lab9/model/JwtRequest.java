package com.example.lab9.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
}