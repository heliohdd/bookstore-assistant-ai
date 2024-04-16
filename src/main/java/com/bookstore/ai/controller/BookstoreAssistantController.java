package com.bookstore.ai.controller;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookstore")
public class BookstoreAssistantController {

	private OpenAiChatClient chatClient;

	public BookstoreAssistantController(OpenAiChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping(value = "/informations")
	public String bookstoreChat(
			@RequestParam(value = "message", defaultValue = "Quais são considerados os best sellers nestes últimos anos?") 
			String message) {
		return chatClient.call(message);
	}

}
