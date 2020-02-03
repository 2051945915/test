package com.yd.renters.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yd.renters.dao.inter.RentersDaoInter;
import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
import com.yd.renters.service.inter.RentersServiceInter;
/**
 * �����ʵ����
 * @author 20519
 *
 */
@Service(value="rentersServiceImpl")
public class RentersServiceImpl implements RentersServiceInter {
	
	//ʵ�������ݷ��ʲ�
	@Autowired
	@Qualifier(value="rentersDaoImpl")
	private RentersDaoInter rentersDaoInter;
	public RentersDaoInter getRentersDaoInter() {
		return rentersDaoInter;
	}
	public void setRentersDaoInter(RentersDaoInter rentersDaoInter) {
		this.rentersDaoInter = rentersDaoInter;
	}

	/**
	 * �û�ע��
	 * @return
	 */
	//����
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int uesrsRegService(Users users) {
		return rentersDaoInter.uesrsRegDao(users);
	}
	
	/**
	 * �û���¼
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogBiz(String usName, String usPass) {
		return rentersDaoInter.usersLogDao(usName, usPass);
	}
	
	/**
	 * ��ѯ�������ⷿ��Ϣ
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessBiz(int usid) {
		return rentersDaoInter.selectAllRenmessDao(usid);
	}
	
	/**
	 * ����ⷿ��Ϣ
	 * @param renmess
	 * @return
	 */
	public int insertRenmessBiz(Renmess renmess) {
		return rentersDaoInter.insertRenmessDao(renmess);
	}
	
	/**
	 * ɾ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessBiz(int rmid) {
		return rentersDaoInter.deleteRenmessDao(rmid);
	}
	
	/**
	 * ��ѯ��һ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneBiz(int rmid) {
		return rentersDaoInter.selectRenmessOneDao(rmid);
	}
	
	/**
	 * �޸�
	 */
	public int updateRenmessBiz(Renmess renmess) {
		return rentersDaoInter.updateRenmessDao(renmess);
	}

}
