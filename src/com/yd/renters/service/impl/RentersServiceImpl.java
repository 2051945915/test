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
 * 服务层实现类
 * @author 20519
 *
 */
@Service(value="rentersServiceImpl")
public class RentersServiceImpl implements RentersServiceInter {
	
	//实例化数据访问层
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
	 * 用户注册
	 * @return
	 */
	//事务
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int uesrsRegService(Users users) {
		return rentersDaoInter.uesrsRegDao(users);
	}
	
	/**
	 * 用户登录
	 * @param usName
	 * @param usPass
	 * @return
	 */
	public Users usersLogBiz(String usName, String usPass) {
		return rentersDaoInter.usersLogDao(usName, usPass);
	}
	
	/**
	 * 查询出所有租房信息
	 * @param usid
	 * @return
	 */
	public List<Renmess> selectAllRenmessBiz(int usid) {
		return rentersDaoInter.selectAllRenmessDao(usid);
	}
	
	/**
	 * 添加租房信息
	 * @param renmess
	 * @return
	 */
	public int insertRenmessBiz(Renmess renmess) {
		return rentersDaoInter.insertRenmessDao(renmess);
	}
	
	/**
	 * 删除租房信息
	 * @param rmid
	 * @return
	 */
	public int deleteRenmessBiz(int rmid) {
		return rentersDaoInter.deleteRenmessDao(rmid);
	}
	
	/**
	 * 查询出一条租房信息
	 * @param rmid
	 * @return
	 */
	public Renmess selectRenmessOneBiz(int rmid) {
		return rentersDaoInter.selectRenmessOneDao(rmid);
	}
	
	/**
	 * 修改
	 */
	public int updateRenmessBiz(Renmess renmess) {
		return rentersDaoInter.updateRenmessDao(renmess);
	}

}
