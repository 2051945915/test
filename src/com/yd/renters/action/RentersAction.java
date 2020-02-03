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
	 * �û�ע��
	 * @return
	 */
	@Action(value="uesrsRega",
			results={@Result(type="redirect",name="regsuccess",location="pages/index.jsp")})
	public String uesrsReg(){
		//���÷����
		rentersServiceInter.uesrsRegService(users);
		return "regsuccess";
	}
	
	/**
	 * �û���¼
	 * @return
	 */
	@Action(value="usersLoga",
			results={@Result(type="redirect",name="logsuccess",location="/selectAllRenmessa.action"),
					 @Result(type="redirect",name="logerror",location="pages/login_form.jsp")})
	public String usersLog(){
		//���÷����
		Users users2 = rentersServiceInter.usersLogBiz(users.getUsName(), users.getUsPass());
		if(users2 != null){
			//����¼��Ա���ݱ�����session������
			ActionContext.getContext().getSession().put("USERS_DATA", users2);
			return "logsuccess";
		}else{
			return "logerror";
		}
	}
	
	/**
	 * ��ѯ�������ⷿ��Ϣ
	 * @return
	 */
	@Action(value="selectAllRenmessa",
			results={@Result(type="redirect",name="success",location="pages/login.jsp")})
	public String selectAllRenmess(){
		Users users = (Users)ActionContext.getContext().getSession().get("USERS_DATA");
		//���÷����
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
	 * ����ⷿ��Ϣ
	 * @return
	 */
	@Action(value="insertRenmessa",
			results={@Result(type="redirect",name="insertsuccess",location="/selectAllRenmessa.action")})
	public String insertRenmess(){
		Users users = (Users)ActionContext.getContext().getSession().get("USERS_DATA");
		
		renmess.setUsId(users.getUsId());
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		
		String dateTime = df.format(new Date());
		
		renmess.setCreTime(dateTime);
		
		//���÷����
		rentersServiceInter.insertRenmessBiz(renmess);
		
		return "insertsuccess";
	}
	
	/**
	 * ɾ���ⷿ��Ϣ
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
	 * ��ѯ��һ���ⷿ��Ϣ
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
	 * ��ѯ��Ҫ�޸ĵ��ⷿ��Ϣ
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
