package com.chat.ai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.chat.ai.DTO.ChatResponse;

import java.util.List;

@Controller
public class Controllers {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${netmind.api.url}")
    private String apiUrl;

    @Value("${netmind.api.key}")
    private String apiKey;

    // Endpoint for Home page
    @GetMapping("/")
    public String home() {
        return "chat";
    }

    // Chat endpoint for posting prompt
    @PostMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt, Model model) {

        // Check if the prompt is empty
        if (prompt == null || prompt.trim().isEmpty()) {
            model.addAttribute("error", "Prompt cannot be empty.");
            return "chat";
        }

        // Create user message
        com.chat.ai.DTO.ChatMessage userMessage = new com.chat.ai.DTO.ChatMessage("user", prompt);

        // Build the chat request with updated model name
        com.chat.ai.DTO.ChatRequest chatRequest = new com.chat.ai.DTO.ChatRequest("deepseek-ai/DeepSeek-R1", List.of(userMessage));

        // Set headers for the request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", apiKey);

        // Create the HTTP entity for the request
        HttpEntity<com.chat.ai.DTO.ChatRequest> requestEntity = new HttpEntity<>(chatRequest, headers);

        try {
            // Send the POST request and get the response
            ResponseEntity<com.chat.ai.DTO.ChatResponse> response = restTemplate.postForEntity(apiUrl, requestEntity, com.chat.ai.DTO.ChatResponse.class);
            com.chat.ai.DTO.ChatResponse responseBody = response.getBody();

            // Check if the response is valid
            if (response.getStatusCode() == HttpStatus.OK && responseBody != null && responseBody.getChoices() != null && !responseBody.getChoices().isEmpty()) {
                ChatResponse.Choice choice = responseBody.getChoices().get(0);
                model.addAttribute("prompt", prompt);
                model.addAttribute("response", choice.getMessage().getContent());
            } else {
                model.addAttribute("error", "No response from AI.");
            }

        } catch (RestClientException e) {
            model.addAttribute("error", "API request failed: " + e.getMessage());
            e.printStackTrace();
        }

        return "chat";
    }
}
