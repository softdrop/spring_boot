package com.wang.project;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wang.project.controller.UserController;
import com.wang.project.entity.User;
import com.wang.project.repository.UserRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {

	private MockMvc mockMvc;
	
	@Autowired
	private UserRepository userrepository;
	
	@Before
	public void init() {
		if(null==mockMvc) {
			mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
		}
	}
	
	@Test
	public void testGetUserInfo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/info").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print());
	}
	
//	@Test
	public void save() {
		System.out.println(userrepository.getClass().getName());
		userrepository.save(new User() {{setAccount("wang");setName("WangYaWei");setPassword("PrayWang");}});
		List<User> users = userrepository.findAll();
		if(users!=null&&users.size()>0) {
			users.forEach(user->{System.out.println("===="+user.toString());});
		}
	}
}
