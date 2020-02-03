package com.yd.renters.dao.inter;

import java.util.List;

import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
/**
 * 数据层接口类
 * @author 20519
 *
 */
public interface RentersDaoInter {

	/**
	 * 用户注册
	 * @return
	 */
	public int uesrsRegDao(Users users);
	
	/**
	 * 用户登录
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogDao(String usName,String usPass);
	
	/**
	 * 查询出所有租房信息
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessDao(int usid);
	
	/**
	 * 添加租房信息
	 * @param renmess
	 * @return
	 */
	public int insertRenmessDao(Renmess renmess);
	
	/**
	 * 删除租房信息
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessDao(int rmid);
	
	/**
	 * 查询出一条租房信息
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneDao(int rmid);
	
	/**
	 * 修改
	 * @param renmess
	 * @return
	 */
	public int updateRenmessDao(Renmess renmess);
}
