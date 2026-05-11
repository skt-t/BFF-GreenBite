package com.greenbite.bff.client;

import com.greenbite.bff.dto.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthClient {

    private final RestTemplate restTemplate = new RestTemplate();
    
    private final String AUTH_URL = "http://localhost:8080/api/auth";

    public String registrar(UsuarioDTO usuario) {
        return restTemplate.postForObject(AUTH_URL + "/register", usuario, String.class);
    }

    public String login(String email, String password) {
        String url = AUTH_URL + "/login?email=" + email + "&password=" + password;
        return restTemplate.postForObject(url, null, String.class);
    }
}