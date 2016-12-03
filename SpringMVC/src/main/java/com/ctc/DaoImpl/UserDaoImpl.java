package com.ctc.DaoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ctc.Dao.UserDao;
import com.ctc.Model.Pager;
import com.ctc.Model.PageConstants;
import com.ctc.Model.User;


/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Resource
	HibernateTemplate hibernateTemplate;
	
	@Override
	public List<User> retrieve(String userName, String passWord) {
		// TODO Auto-generated method stub
		
		List<User> list=new ArrayList<>();
		list=(List<User>) hibernateTemplate.find("from User as u where u.userName='"+userName+"' and u.passWord='"+passWord+"'");
		
		if(list.size()>0 && list!=null)
			return list;
		return Collections.emptyList();
	}

	@Override
	public void add(User user) {
		
		hibernateTemplate.save(user);
		
	}

	@Override
	public Pager<User> retrieveAll() {
		// TODO Auto-generated method stub
		int size = PageConstants.getSize();
		int offset = PageConstants.getOffset();
		Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		List<User> datas = query.list();
		Pager<User> pager = new Pager<User>();
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(size);
		long total = (Long)this.hibernateTemplate.getSessionFactory().getCurrentSession()
					.createQuery("select count(*) from User")
					.uniqueResult();
		pager.setTotal(total);
		return pager;
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.load(User.class, id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		 hibernateTemplate.update(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		User user=this.load(id);
		hibernateTemplate.delete(user);
	}


	
}
