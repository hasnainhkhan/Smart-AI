package com.chat.ai.DTO;

import java.util.List;

public class ChatResponse {

    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {
        private ChatMessage message;

        public ChatMessage getMessage() {
            return message;
        }

        public void setMessage(ChatMessage message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Choice{" +
                    "message=" + message +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ChatResponse{" +
                "choices=" + choices +
                '}';
    }
}
