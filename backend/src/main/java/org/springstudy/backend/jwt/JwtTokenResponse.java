package org.springstudy.backend.jwt;

public record JwtTokenResponse(String token) {}

record JwtTokenRequest(String username, String password) {}