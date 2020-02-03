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
 * ���ݲ�ʵ����
 * @author 20519
 *
 */
@Repository(value="rentersDaoImpl")
public class RentersDaoImpl implements RentersDaoInter {
	
	//ͨ��springע��sessionFactory
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
	 * �û�ע��
	 * @return
	 */
	public int uesrsRegDao(Users users) {
		Session session = sessionFactory.openSession();
		
		session.save(users);
		
		return 0;
	}
	
	/**
	 * �û���¼
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogDao(String usName, String usPass) {
		Session session = sessionFactory.openSession();
		
		String hql = "from Users where usName = :n and usPass = :p";
		
		Query query = session.createQuery(hql);
		
		//����ռλ����ֵ
		query.setString("n", usName);
		query.setString("p", usPass);
		
		Users users = (Users)query.uniqueResult();
		
		return users;
	}
	
	/**
	 * ��ѯ�������ⷿ��Ϣ
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
	 * ����ⷿ��Ϣ
	 * @param renmess
	 * @return
	 */
	public int insertRenmessDao(Renmess renmess) {
		Session session = sessionFactory.openSession();
		
		session.save(renmess);
		
		return 0;
	}
	
	/**
	 * ɾ���ⷿ��Ϣ
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
	 * ��ѯ��һ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneDao(int rmid) {
		Session session = sessionFactory.openSession();
		
		Renmess renmess = (Renmess)session.load(Renmess.class, new Integer(rmid));

		return renmess;
	}
	
	
	/**
	 * �޸�
	 */
	public int updateRenmessDao(Renmess renmess) {
		Session session = sessionFactory.openSession();
		
		Renmess renmesss = (Renmess)session.load(Renmess.class, new Integer(renmess.getRmId()));
		
		//�޸�
		session.update(renmesss);
		
		session.getTransaction().commit();
		
		return 0;
	}
	
}
