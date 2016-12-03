package com.ctc.Dao;

import java.util.List;

import com.ctc.Model.Pager;
import com.ctc.Model.User;

/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
public interface UserDao {

	List<User> retrieve(String userName,String passWord);
	void add(User user);
	Pager<User> retrieveAll();
	User load(int id);
	void update(User user);
	void delete(int id);

}
