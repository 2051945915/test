package com.yd.renters.javabean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ”√ªß
 * @author 20519
 *
 */
@Entity(name="Users")
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usid")
	private int usId;
	
	@Column(name="usname")
	private String usName;
	
	@Column(name="uspass")
	private String usPass;
	
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getUsPass() {
		return usPass;
	}
	public void setUsPass(String usPass) {
		this.usPass = usPass;
	}
	public Users(int usId, String usName, String usPass) {
		this.usId = usId;
		this.usName = usName;
		this.usPass = usPass;
	}
	public Users() {
	}
}
