package com.example.demo.controller.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateRequest {
    private  String email;
    private  String Password;
}
