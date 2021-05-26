/**
 * 
 */
package com.ss.sbank.controller.cards;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Parker W.
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CardControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAllCardTest() throws Exception {
		mockMvc.perform(get("/api/cards/TEST-PLATFORM")
				.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.length()").value(3));
	}
	
	@Test
	public void createCardTest() throws Exception {
		//Test submitting invalid form
		mockMvc.perform(post("/api/cards")
				.contentType(MediaType.APPLICATION_JSON)
				.content("\"{\"accountNumber\":\"00123456780\", \"cardType\":\"\", \"holderName\":\"Holden Cards\"}\"")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isBadRequest());
		
		//Test submitting valid form
				mockMvc.perform(post("/api/cards")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"accountNumber\":\"00123456780\", \"cardType\":\"1\", \"holderName\":\"Holden Cards\"}")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(43210001234567804l));
				
		//Test submitting duplicate data
				mockMvc.perform(post("/api/cards")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"accountNumber\":\"00876543210\", \"cardType\":\"1\", \"holderName\":\"Cate Dupli\"}")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().string(""));
	}

}
