package com.yd.renters.service.inter;

import java.util.List;

import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
/**
 * �����ӿ���
 * @author 20519
 *
 */
public interface RentersServiceInter {

	/**
	 * �û�ע��
	 * @return
	 */
	public int uesrsRegService(Users users);
	
	/**
	 * �û���¼
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogBiz(String usName,String usPass);
	
	/**
	 * ��ѯ�������ⷿ��Ϣ
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessBiz(int usid);
	
	/**
	 * ����ⷿ��Ϣ
	 * @param renmess
	 * @return
	 */
	public int insertRenmessBiz(Renmess renmess);
	
	/**
	 * ɾ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessBiz(int rmid);
	
	/**
	 * ��ѯ��һ���ⷿ��Ϣ
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneBiz(int rmid);
	
	/**
	 * �޸�
	 * @param renmess
	 * @return
	 */
	public int updateRenmessBiz(Renmess renmess);
}
