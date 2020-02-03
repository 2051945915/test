package com.yd.renters.javabean;
/**
 * ∑øŒ›¿‡–Õ
 * @author 20519
 *
 */
public class Rentype {

	private int rtId;
	private String rtName;
	
	public int getRtId() {
		return rtId;
	}
	public void setRtId(int rtId) {
		this.rtId = rtId;
	}
	public String getRtName() {
		return rtName;
	}
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	public Rentype(int rtId, String rtName) {
		this.rtId = rtId;
		this.rtName = rtName;
	}
	public Rentype() {
	}
}
