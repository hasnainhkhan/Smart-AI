package com.chat.ai.controller;

import com.chat.ai.DTO.TranslationRequest;
import com.chat.ai.entities.LanguageTranslation;
import com.chat.ai.service.LanguageService;
import com.chat.ai.service.TranslatorService;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/translate")
public class TranslatorController {

    private final TranslatorService service;
    
    @Autowired
    private LanguageService languageService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("request", new TranslationRequest());

        Map<String, Map<String, Object>> languages = languageService.getSupportedLanguages();
        model.addAttribute("languages", languages);

        return "trindex";
    }

    @GetMapping("/languages")
    public String getLanguages(Model model) {
        // Correct way: call method on instance
        Map<String, Map<String, Object>> languages = languageService.getSupportedLanguages();

        model.addAttribute("languages", languages);
        return "languageList"; // your view page
    }

    /**
     * Handles POST requests to /translate
     * Processes the translation request, adds the result to the model,
     * and forwards to the result view.
     */
    @PostMapping("/translate")
    public String translateText(@ModelAttribute TranslationRequest request, Model model) {
        try {
            LanguageTranslation translatedResult = service.translate(request);
            model.addAttribute("result", translatedResult);
        } catch (Exception e) {
            // Add an error attribute to display in the view
            model.addAttribute("error", "Translation failed: " + e.getMessage());
            // Return the form view so user can try again
            model.addAttribute("request", request);
            return "trindex";
        }
        return "trresult";  // Thymeleaf result page
    }
}
