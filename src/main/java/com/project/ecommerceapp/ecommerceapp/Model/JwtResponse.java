package com.project.ecommerceapp.ecommerceapp.Model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String jwtToken;
    private String username;
}
