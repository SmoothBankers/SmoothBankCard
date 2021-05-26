/**
 * 
 */
package com.ss.sbank.controller.loans;

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
public class LoanControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllLoansTest() throws Exception {
		mockMvc.perform(get("/api/loans/TEST-PLATFORM").contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.length()").value(3));	//Three because of the original plus the 2 created during other tests
	}
	

	@Test
	public void createLoanTest() throws Exception {
		// Test submitting invalid form
		mockMvc.perform(post("/api/loans").contentType(MediaType.APPLICATION_JSON)
				.content("\"{\"accountNumber\":\"111222333456\", \"loanType\":\"\", \"holderName\":\"Invalid form\"}\"")
				.accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isBadRequest());

		// Test submitting valid form with non-ascii characters
		mockMvc.perform(post("/api/loans").contentType(MediaType.APPLICATION_JSON)
				.content("{\"accountNumber\":\"00432156780\", \"loanType\":\"1\", \"holderName\":\"方森　きょうろ\"}")
				.accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(43210004321567804l));

		// Test submitting valid form with ascii characters
		mockMvc.perform(post("/api/loans").contentType(MediaType.APPLICATION_JSON).content(
				"{\"accountNumber\":\"00123456780\", \"loanType\":\"1\", \"holderName\":\"FirstName LastName\"}")
				.accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(43210001234567804l));

		// Test submitting duplicate data
		mockMvc.perform(post("/api/loans").contentType(MediaType.APPLICATION_JSON)
				.content("{\"accountNumber\":\"00876543210\", \"loanType\":\"1\", \"holderName\":\"Cate Dupli\"}")
				.accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isCreated()).andExpect(content().string(""));
	}

}
