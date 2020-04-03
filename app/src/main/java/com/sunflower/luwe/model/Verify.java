package com.sunflower.luwe.model;

public class Verify{
	private String phone_number;
	private String verification_code;

	public Verify(String phoneNumber, String verificationCode) {
		this.phone_number = phoneNumber;
		this.verification_code = verificationCode;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phone_number = phoneNumber;
	}

	public String getPhoneNumber(){
		return phone_number;
	}

	public void setVerificationCode(String verificationCode){
		this.verification_code = verificationCode;
	}

	public String getVerificationCode(){
		return verification_code;
	}

	@Override
 	public String toString(){
		return 
			"Verify{" + 
			"phone_number = '" + phone_number + '\'' +
			",verification_code = '" + verification_code + '\'' +
			"}";
		}
}
