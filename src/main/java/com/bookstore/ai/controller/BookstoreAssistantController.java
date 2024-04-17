package com.bookstore.ai.controller;

import org.springframework.ai.chat.prompt.PromptTemplate;
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

//	@GetMapping(value = "/informations")
//	public ChatResponse bookstoreChatEx2(
//			@RequestParam(value = "message", defaultValue = "Quais são considerados os best sellers nestes últimos anos?") 
//			String message) {
//		return chatClient.call(new Prompt(message));
//	}
	
	@GetMapping(value = "/reviews")
	public String bookstoreReview(@RequestParam(
			value = "book", 
			defaultValue = "Dom Quixote")
			String book) {
		PromptTemplate promptTemplate = new PromptTemplate("""
				Por favor, me forneça
				um breve resumo do livro {book}
				e também a biografia de seu autor.
				""");
		promptTemplate.add("book", book);
		return this.chatClient.call(promptTemplate.create()).getResult().getOutput().getContent();
	}

}
