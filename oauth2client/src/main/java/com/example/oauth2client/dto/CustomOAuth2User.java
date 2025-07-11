package com.example.oauth2client.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;

@Data
public class CustomOAuth2User implements OAuth2User{	// OAuth2UserService 반환할 D
	
	private Map<String, Object> attributes;	// service attributes 값을 주입 (setter, constructor, ...)
	private String role;
	
	public CustomOAuth2User(Map<String, Object> attributes, String role) {
		this.attributes = attributes;
		this.role = role;
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		return this.attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		roleList.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return CustomOAuth2User.this.role;
			}
		});
		return roleList;
	}

	@Override
	public String getName() {	// attributes 속성중에 유니크한(email or mobile) 값을 반환
		if(this.role.equals("NAVER")){
			return (String)((Map<String, Object>)this.attributes.get("response")).get("mobile");
		}
		else if(this.role.equals("GOOGLE")) {
			return (String)((Map<String, Object>)this.attributes).get("email");
		}
		else if(this.role.equals("KAKAO")) {
			return (String)((Map<String, Object>)this.attributes.get("properties")).get("profile_image");
		}
		else {
			return "오류";
		}
	}
	
	public String getProfile() {
		if(this.role.equals("NAVER")){			
			return (String)((Map<String, Object>)this.attributes.get("response")).get("profile_image");
		}
		else if(this.role.equals("GOOGLE")) {
			return (String)((Map<String, Object>)this.attributes).get("email");
		}
		else if(this.role.equals("KAKAO")) {
			return (String)((Map<String, Object>)this.attributes.get("properties")).get("profile_image");
		}
		else {
			return "오류";
		}
	}
}