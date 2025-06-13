# 🤖 AI Chat Assistant with Smart Tools (Spring Boot + Thymeleaf)

A powerful, full-stack AI chat application built using **Java Spring Boot**, **Thymeleaf**, and integrated with **Microsoft AI Foundry**. The application enables real-time chat with AI and includes smart productivity tools like **language translation**, **voice-to-text**, **OCR image-to-text**, and **prompt-based text generation**.

---

## ✨ Features

- 💬 **AI Chat Interface** – Chat with a smart AI assistant via web UI
- 🌍 **Language Translator** – Translate user input or AI response to/from multiple languages
- 🎙️ **Voice Input** – Use microphone to convert speech into text
- 🖼️ **OCR Image to Text** – Upload an image and extract readable text
- ✍️ **Text Generator** – Generate summaries, content, or answers based on prompts
- 🔒 **Spring Security (Optional)** – For user authentication and access control

---

## 🛠️ Technology Stack

| Layer        | Technology                      |
|--------------|----------------------------------|
| Backend      | Java 17+, Spring Boot            |
| Frontend     | Thymeleaf (HTML templating)      |
| AI Engine    | Microsoft AI Foundry (LLM API)   |
| Other        | JavaScript (interactions), Web APIs|

---

## 📦 Project Structure

ai-chat-smart-tools/
├── src/
│ ├── main/
│ │ ├── java/com/example/chat/ # Controllers, Services
│ │ ├── resources/
│ │ │ ├── templates/ # Thymeleaf HTML pages
│ │ │ ├── static/ # CSS, JS, images
│ │ │ └── application.yml # Configs
├── pom.xml # Maven dependencies
└── README.md # Project documentation

yaml
Copy
Edit

---

## 🔧 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ai-chat-smart-tools.git
   cd ai-chat-smart-tools
Configure Microsoft AI Foundry

Add your Microsoft AI Foundry API credentials in application.yml:

yaml
Copy
Edit
ai:
  provider: microsoft
  endpoint: https://your-foundry-endpoint
  apiKey: YOUR_API_KEY
Run the application

bash
Copy
Edit
./mvnw spring-boot:run
Access in browser

arduino
Copy
Edit
http://localhost:8080/
💡 Smart Tools Overview
Tool	Description
🌍 Language Translator	Real-time translation using AI Foundry
🎤 Voice-to-Text	Converts user speech input to text (Web Speech API)
🖼️ Image-to-Text (OCR)	Extracts readable text from uploaded images
✍️ Prompt Text Generator	Generates creative or informative content

🖼️ Screenshots
Add your screenshots here, for example:

Main chat interface

Voice input field

OCR image upload

Translated output preview

🧠 Powered By
Java Spring Boot – Robust backend framework

Thymeleaf – Seamless server-side HTML rendering

Microsoft AI Foundry – AI-based text generation, translation, and OCR

Web APIs – Voice recognition and image handling

📄 License
Distributed under the MIT License. See LICENSE for more information.
