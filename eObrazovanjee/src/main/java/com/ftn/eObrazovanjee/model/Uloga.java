package com.ftn.eObrazovanjee.model;

import org.springframework.security.core.GrantedAuthority;

public enum Uloga implements GrantedAuthority{
	ADMIN,
	PROFESOR,
	STUDENT;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name();
	}
}
