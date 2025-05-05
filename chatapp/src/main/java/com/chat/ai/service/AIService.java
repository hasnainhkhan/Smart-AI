package com.chat.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.chat.ai.DTO.ChatRequest;
import com.chat.ai.DTO.ChatResponse;
import com.chat.ai.DTO.ChatMessage;

import java.util.List;

@Service
public class AIService {

    @Value("${netmind.api.key}")
    private String apiKey;

    @Value("${netmind.api.url}")
    private String apiUrl;

    private final WebClient webClient = WebClient.create();

    public String askNetmindAI(String prompt) {
        ChatMessage userMessage = new ChatMessage("user", prompt);

        ChatRequest request = new ChatRequest();
        request.setModel("deepseek-ai/DeepSeek-R1"); // or your desired model
        request.setMessages(List.of(userMessage));

        ChatResponse response = webClient.post()
                .uri(apiUrl)
                .header("Authorization", apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();

        return response.getChoices().get(0).getMessage().getContent();
    }
}
