package com.sunflower.luwe.model;

public class PhoneNumber{
	private String phone_number;

	public PhoneNumber(String phoneNumber) {
		this.phone_number = phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phone_number = phoneNumber;
	}

	public String getPhoneNumber(){
		return phone_number;
	}

	@Override
 	public String toString(){
		return 
			"PhoneNumber{" + 
			"phone_number = '" + phone_number + '\'' +
			"}";
		}
}
