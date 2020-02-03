package com.yd.renters.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yd.renters.dao.inter.RentersDaoInter;
import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
/**
 * 数据层实现类
 * @author 20519
 *
 */
@Repository(value="rentersDaoImpl")
public class RentersDaoImpl implements RentersDaoInter {
	
	//通过spring注入sessionFactory
	@Autowired
	@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 用户注册
	 * @return
	 */
	public int uesrsRegDao(Users users) {
		Session session = sessionFactory.openSession();
		
		session.save(users);
		
		return 0;
	}
	
	/**
	 * 用户登录
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogDao(String usName, String usPass) {
		Session session = sessionFactory.openSession();
		
		String hql = "from Users where usName = :n and usPass = :p";
		
		Query query = session.createQuery(hql);
		
		//设置占位符的值
		query.setString("n", usName);
		query.setString("p", usPass);
		
		Users users = (Users)query.uniqueResult();
		
		return users;
	}
	
	/**
	 * 查询出所有租房信息
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessDao(int usid) {
		Session session = sessionFactory.openSession();
		
		String hql = "from Renmess where usId = ?";
		
		Query query = session.createQuery(hql);
		
		query.setInteger(0, usid);
		
		List<Renmess> renmesses = query.list();
		
		return renmesses;
	}
	
	/**
	 * 添加租房信息
	 * @param renmess
	 * @return
	 */
	public int insertRenmessDao(Renmess renmess) {
		Session session = sessionFactory.openSession();
		
		session.save(renmess);
		
		return 0;
	}
	
	/**
	 * 删除租房信息
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessDao(int rmid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Renmess renmess = (Renmess)session.load(Renmess.class, new Integer(rmid));
		
		session.delete(renmess);
		
		session.getTransaction().commit();
		
		return 0;
	}
	
	/**
	 * 查询出一条租房信息
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneDao(int rmid) {
		Session session = sessionFactory.openSession();
		
		Renmess renmess = (Renmess)session.load(Renmess.class, new Integer(rmid));

		return renmess;
	}
	
	
	/**
	 * 修改
	 */
	public int updateRenmessDao(Renmess renmess) {
		Session session = sessionFactory.openSession();
		
		Renmess renmesss = (Renmess)session.load(Renmess.class, new Integer(renmess.getRmId()));
		
		//修改
		session.update(renmesss);
		
		session.getTransaction().commit();
		
		return 0;
	}
	
}
