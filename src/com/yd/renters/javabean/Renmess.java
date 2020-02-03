package com.yd.renters.javabean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 租房信息表
 * @author 20519
 *
 */
@Entity(name="Renmess")
@Table(name="renmess")
public class Renmess {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rmid")
	private int rmId;
	
	@Column(name="title")
	private String tiTle;
	
	@Column(name="county")
	private String coUnty;
	
	@Column(name="street")
	private String stReet;
	
	@Column(name="rental")
	private String reNtal;
	
	@Column(name="rtid")
	private int rtId;
	
	@Column(name="phone")
	private String phOne;
	
	@Column(name="names")
	private String naMes;
	
	@Column(name="message")
	private String meSsage;
	
	@Column(name="cretime")
	private String creTime;
	
	@Column(name="usid")
	private int usId;
	
	public int getRmId() {
		return rmId;
	}
	public void setRmId(int rmId) {
		this.rmId = rmId;
	}
	public String getTiTle() {
		return tiTle;
	}
	public void setTiTle(String tiTle) {
		this.tiTle = tiTle;
	}
	public String getCoUnty() {
		return coUnty;
	}
	public void setCoUnty(String coUnty) {
		this.coUnty = coUnty;
	}
	public String getStReet() {
		return stReet;
	}
	public void setStReet(String stReet) {
		this.stReet = stReet;
	}
	public String getReNtal() {
		return reNtal;
	}
	public void setReNtal(String reNtal) {
		this.reNtal = reNtal;
	}
	public int getRtId() {
		return rtId;
	}
	public void setRtId(int rtId) {
		this.rtId = rtId;
	}
	public String getPhOne() {
		return phOne;
	}
	public void setPhOne(String phOne) {
		this.phOne = phOne;
	}
	public String getNaMes() {
		return naMes;
	}
	public void setNaMes(String naMes) {
		this.naMes = naMes;
	}
	public String getMeSsage() {
		return meSsage;
	}
	public void setMeSsage(String meSsage) {
		this.meSsage = meSsage;
	}
	public String getCreTime() {
		return creTime;
	}
	public void setCreTime(String creTime) {
		this.creTime = creTime;
	}
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public Renmess(int rmId, String tiTle, String coUnty, String stReet, String reNtal, int rtId, String phOne,
			String naMes, String meSsage, String creTime, int usId) {
		this.rmId = rmId;
		this.tiTle = tiTle;
		this.coUnty = coUnty;
		this.stReet = stReet;
		this.reNtal = reNtal;
		this.rtId = rtId;
		this.phOne = phOne;
		this.naMes = naMes;
		this.meSsage = meSsage;
		this.creTime = creTime;
		this.usId = usId;
	}
	public Renmess() {
	}
}
