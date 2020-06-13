package com.lingo.lingo;

import com.lingo.lingo.controller.restController;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Checks if the controller makes a word")
	public void checkInputWord() throws Exception {
		this.mockMvc.perform(get("/inputword/5")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
		}

	@Test
	@DisplayName("Checks if the controller can check the input with the API")
	public void checkInputChecker() throws Exception {
		this.mockMvc.perform(get("/inputword/5")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));

		this.mockMvc.perform(get("/wordplay/vlees")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	@DisplayName("Checks if the controller can parse highscores")
	public void checkSetHighscore() throws Exception {
		this.mockMvc.perform(get("/setHighscore/test/10/10/8"))
				.andExpect(status().isOk());
	}

	@Test
	@DisplayName("Checks if the controller can get highscores")
	public void checkGetHighscore() throws Exception {
		this.mockMvc.perform(get("/highscore/5")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

}
