package com.yd.renters.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yd.renters.javabean.Renmess;
import com.yd.renters.javabean.Users;
import com.yd.renters.service.inter.RentersServiceInter;

@Controller("rentersAction")
@Namespace("/")
@Scope("prototype")
public class RentersAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("rentersServiceImpl")
	private RentersServiceInter rentersServiceInter;
	public RentersServiceInter getRentersServiceInter() {
		return rentersServiceInter;
	}
	public void setRentersServiceInter(RentersServiceInter rentersServiceInter) {
		this.rentersServiceInter = rentersServiceInter;
	}

	private Users users;
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * 用户注册
	 * @return
	 */
	@Action(value="uesrsRega",
			results={@Result(type="redirect",name="regsuccess",location="pages/index.jsp")})
	public String uesrsReg(){
		//调用服务层
		rentersServiceInter.uesrsRegService(users);
		return "regsuccess";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@Action(value="usersLoga",
			results={@Result(type="redirect",name="logsuccess",location="/selectAllRenmessa.action"),
					 @Result(type="redirect",name="logerror",location="pages/login_form.jsp")})
	public String usersLog(){
		//调用服务层
		Users users2 = rentersServiceInter.usersLogBiz(users.getUsName(), users.getUsPass());
		if(users2 != null){
			//将登录人员数据保存至session作用域
			ActionContext.getContext().getSession().put("USERS_DATA", users2);
			return "logsuccess";
		}else{
			return "logerror";
		}
	}
	
	/**
	 * 查询出所有租房信息
	 * @return
	 */
	@Action(value="selectAllRenmessa",
			results={@Result(type="redirect",name="success",location="pages/login.jsp")})
	public String selectAllRenmess(){
		Users users = (Users)ActionContext.getContext().getSession().get("USERS_DATA");
		//调用服务层
		List<Renmess> renmess = rentersServiceInter.selectAllRenmessBiz(users.getUsId());

		ActionContext.getContext().getSession().put("RENMESS_DATA", renmess);
		return "success";
	}
	
	private Renmess renmess;
	public Renmess getRenmess() {
		return renmess;
	}
	public void setRenmess(Renmess renmess) {
		this.renmess = renmess;
	}
	
	/**
	 * 添加租房信息
	 * @return
	 */
	@Action(value="insertRenmessa",
			results={@Result(type="redirect",name="insertsuccess",location="/selectAllRenmessa.action")})
	public String insertRenmess(){
		Users users = (Users)ActionContext.getContext().getSession().get("USERS_DATA");
		
		renmess.setUsId(users.getUsId());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		
		String dateTime = df.format(new Date());
		
		renmess.setCreTime(dateTime);
		
		//调用服务层
		rentersServiceInter.insertRenmessBiz(renmess);
		
		return "insertsuccess";
	}
	
	/**
	 * 删除租房信息
	 * @return
	 */
	@Action(value="deleteRenmessa",
			results={@Result(type="redirect",name="deletesuccess",location="/selectAllRenmessa.action")})
	public String deleteRenmess(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int rmid = Integer.parseInt(request.getParameter("rmid"));
		
		rentersServiceInter.deleteRenmessBiz(rmid);
		
		return "deletesuccess";
	}
	
	/**
	 * 查询出一条租房信息
	 * @param rmid
	 * @return
	 */
	@Action(value="selectRenmessOnea",
			results={@Result(type="redirect",name="selectsuccess",location="pages/detail.jsp")})
	public String selectRenmessOne(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int rmid = Integer.parseInt(request.getParameter("rmid"));
		
		Renmess renmess = rentersServiceInter.selectRenmessOneBiz(rmid);
		
		ActionContext.getContext().getSession().put("RENMESS_ONE", renmess);
		
		return "selectsuccess";
	}
	
	/**
	 * 查询出要修改的租房信息
	 * @param rmid
	 * @return
	 */
	@Action(value="selectRenmessOneas",
			results={@Result(type="redirect",name="selectsuccess",location="pages/posts.jsp")})
	public String selectRenmessOnes(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int rmid = Integer.parseInt(request.getParameter("rmid"));
		
		Renmess renmess = rentersServiceInter.selectRenmessOneBiz(rmid);
		
		ActionContext.getContext().getSession().put("RENMESS_ONE", renmess);
		
		return "selectsuccess";
	}
	
}
