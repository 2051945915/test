package com.yd.renters.dao.inter;

import java.util.List;

import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
/**
 * ���ݲ�ӿ���
 * @author 20519
 *
 */
public interface RentersDaoInter {

	/**
	 * �û�ע��
	 * @return
	 */
	public int uesrsRegDao(Users users);
	
	/**
	 * �û���¼
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogDao(String usName,String usPass);
	
	/**
	 * ��ѯ�������ⷿ��Ϣ
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessDao(int usid);
	
	/**
	 * ����ⷿ��Ϣ
	 * @param renmess
	 * @return
	 */
	public int insertRenmessDao(Renmess renmess);
	
	/**
	 * ɾ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessDao(int rmid);
	
	/**
	 * ��ѯ��һ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneDao(int rmid);
	
	/**
	 * �޸�
	 * @param renmess
	 * @return
	 */
	public int updateRenmessDao(Renmess renmess);
}
