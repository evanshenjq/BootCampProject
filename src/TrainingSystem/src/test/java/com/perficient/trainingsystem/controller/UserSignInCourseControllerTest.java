package com.perficient.trainingsystem.controller;

import java.awt.print.Printable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class UserSignInCourseControllerTest {
	
	   protected Log logger = LogFactory.getLog(UserSignInCourseControllerTest.class);
	   
	   private MockMvc mvc;
	   @Autowired
	   private WebApplicationContext context ;
		
	   @Before
	   public void setUp() {
		  mvc = MockMvcBuilders.webAppContextSetup(context).build();
	   }
	   
		@Test
	   public void testNotReserved() throws Exception {
		  logger.info("==========");
		  mvc.perform(MockMvcRequestBuilders.get("/signInCourse")
				   .param("userId","5a4d9b1886e4181c459603b1")
				   .param("courseId","5a55762ec9e77c0001de3667")
				   .param("courseTime","2018-01-31 Tue 09:00")
				   .accept(MediaType.APPLICATION_JSON))
				   .andDo(MockMvcResultHandlers.print())
				   .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("not reserved")))
				   .andReturn();		 
		}

		@Test
		
		public void testSignInSuccessfully() throws Exception {
			logger.info("==========");
			mvc.perform(MockMvcRequestBuilders.get("/signInCourse")
					.param("userId","5a4d9b1886e4181c459603b1")
			        .param("courseId","5a5577a1c9e77c0001de367d")
			        .param("courseTime","2018-01-19 Sat 09:00")
			        .accept(MediaType.APPLICATION_JSON))
			        .andDo(MockMvcResultHandlers.print())
			        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("successfully")))
			        .andReturn();		
		}
		
		
		@Test
		public void testSignedBefore() throws Exception {
			logger.info("==========");
			mvc.perform(MockMvcRequestBuilders.get("/signInCourse")
					.param("userId","5a4d9b1886e4181c459603b1")
			        .param("courseId","5a557622c9e77c0001de3661")
			        .param("courseTime","2018-02-02 Fri 08:45")
			        .accept(MediaType.APPLICATION_JSON))
			        .andDo(MockMvcResultHandlers.print())
			        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("signed")))
			        .andReturn();	            
		}
	
}
