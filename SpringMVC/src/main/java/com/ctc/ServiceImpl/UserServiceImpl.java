package com.ctc.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ctc.Dao.UserDao;
import com.ctc.Model.Pager;
import com.ctc.Model.User;
import com.ctc.Service.UserService;

/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDaoImpl;
	HttpSession session;
	HttpServletRequest request;
	@Override
	public List<User> checkLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		List<User> list= userDaoImpl.retrieve(userName, passWord);
		 request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		 session=request.getSession();
		if(!list.isEmpty())
		{
			session.setAttribute("userName", list.get(0).getUserName());
		}
		
		return list;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userDaoImpl.add(user);
	}

	@Override
	public User showUser(int id) {
		// TODO Auto-generated method stub
		return userDaoImpl.load(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDaoImpl.update(user);
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		session=request.getSession();
		session.setAttribute("userName", user.getUserName());
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		this.userDaoImpl.delete(id);
	}

	@Override
	public Pager<User> userList() {
		// TODO Auto-generated method stub
		return userDaoImpl.retrieveAll();
	}




	
}
