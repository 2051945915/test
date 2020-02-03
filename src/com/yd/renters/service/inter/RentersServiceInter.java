package com.yd.renters.service.inter;

import java.util.List;

import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
/**
 * 服务层接口类
 * @author 20519
 *
 */
public interface RentersServiceInter {

	/**
	 * 用户注册
	 * @return
	 */
	public int uesrsRegService(Users users);
	
	/**
	 * 用户登录
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogBiz(String usName,String usPass);
	
	/**
	 * 查询出所有租房信息
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessBiz(int usid);
	
	/**
	 * 添加租房信息
	 * @param renmess
	 * @return
	 */
	public int insertRenmessBiz(Renmess renmess);
	
	/**
	 * 删除租房信息
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessBiz(int rmid);
	
	/**
	 * 查询出一条租房信息
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneBiz(int rmid);
	
	/**
	 * 修改
	 * @param renmess
	 * @return
	 */
	public int updateRenmessBiz(Renmess renmess);
}
