package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class TokenDTO {
    
    @JsonbProperty("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
