package com.nisum.challenge.dto;

public record AuthRequest(
    String username,
    String passwd
) { }
