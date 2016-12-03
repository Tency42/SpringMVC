package com.ctc.Service;

import java.util.List;

import com.ctc.Model.Pager;
import com.ctc.Model.User;


/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
public interface UserService {

	List<User> checkLogin(String userName,String passWord);
	void addUser(User user);
	User showUser(int id);
	void updateUser(User user);
	void deleteUser(int id);
	Pager<User> userList();
}
