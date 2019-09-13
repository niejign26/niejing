package com.nj.didi.vo;

public class ReturnVo<T> {

	private int returnCode;
	private String returnMsg;
	private T t;
	
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	
}
