package com.lufthansa.flightbooking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/token")
@Api(value = "Token API", tags = {"Token Operations"})
public class TokenController {

    private final String oktaIssuer;
    private final String clientId;
    private final String clientSecret;

    public TokenController(@Value("${okta.oauth2.issuer}") String oktaIssuer,
                           @Value("${okta.oauth2.client-id}") String clientId,
                           @Value("${okta.oauth2.client-secret}") String clientSecret) {
        this.oktaIssuer = oktaIssuer;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @ApiOperation(value = "Get Access Token", notes = "Get the OAuth2 access token from Okta")
    @GetMapping()
    public String getToken() {
        String tokenUrl = oktaIssuer + "/v1/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(clientId, clientSecret);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> responseEntity = new RestTemplate().postForEntity(tokenUrl, requestEntity, Map.class);

        String accessToken = (String) Objects.requireNonNull(responseEntity.getBody()).get("access_token");
        return "Access Token: " + "Bearer " + accessToken;
    }

}

