package com.ctc.ServiceImpl;

import static org.junit.Assert.fail;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.ctc.Model.User;
import com.ctc.Service.UserService;


/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class UserServiceImplTest  {

	@Autowired
	UserService userServiceImpl;
	@Test
	public void testCheckLogin() {
		fail("Not yet implemented");
	}

	@Test	
	@Repeat(30)
	public void testAddUser() {
		
		User user =new User();
		user.setUserName("Test");
		user.setPassWord("123");
		userServiceImpl.addUser(user);
		
	}


	@Test
	public void testUserList() {
		
		
	}
	
	@Test
	public void testUpdate()
	{
		User user =new User();
		user.setId(1);
		user.setUserName("Tency1");
		user.setPassWord("123");
		userServiceImpl.updateUser(user);
	}
	
	public void testFind()
	{
		
	}
}
