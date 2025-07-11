package com.example.oauth2client.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.oauth2client.dto.CustomOAuth2User;

@Service
public class CustomOAuth2Service extends DefaultOAuth2UserService{
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// 인증서버 아이디값 디버깅
		System.out.println("CustomOAuth2Service 인증서버 : " + userRequest.getClientRegistration().getRegistrationId());	// naver
		CustomOAuth2User customOAuth2User = null;
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		// 분기
		if(userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			customOAuth2User = new CustomOAuth2User(oAuth2User.getAttributes(), "NAVER");
		}
		else if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			customOAuth2User = new CustomOAuth2User(oAuth2User.getAttributes(), "GOOGLE");
		}
		else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
			customOAuth2User = new CustomOAuth2User(oAuth2User.getAttributes(), "KAKAO");
		}
		else {
			System.out.println("인증 서버 오류 !");
		}
		
		System.out.println("CustomOAuth2Service : " + oAuth2User.getAttributes());
		return customOAuth2User;	
	}
}
