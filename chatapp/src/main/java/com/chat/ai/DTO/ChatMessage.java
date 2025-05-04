package com.chat.ai.DTO;


public class ChatMessage {
	private String role;
    private String content;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ChatMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChatMessage [role=" + role + ", content=" + content + "]";
	}
    
}
