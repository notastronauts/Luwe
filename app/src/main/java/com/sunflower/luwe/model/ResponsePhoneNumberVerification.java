package com.sunflower.luwe.model;

public class ResponsePhoneNumberVerification{
	private int jsonMember0;
	private boolean isVerified;
	private String phoneNumber;

	public void setJsonMember0(int jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public int getJsonMember0(){
		return jsonMember0;
	}

	public void setIsVerified(boolean isVerified){
		this.isVerified = isVerified;
	}

	public boolean isIsVerified(){
		return isVerified;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePhoneNumberVerification{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",isVerified = '" + isVerified + '\'' + 
			",phone_number = '" + phoneNumber + '\'' + 
			"}";
		}
}
