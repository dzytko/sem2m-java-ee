package com.example.lab9.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter
public class JwtResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
}
