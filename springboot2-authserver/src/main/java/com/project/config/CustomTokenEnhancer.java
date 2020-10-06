package com.project.config;

import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.project.Entity.User;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {
@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,OAuth2Authentication authentication)
	{
		User user=(User)authentication.getPrincipal();
		Map<String,Object> info=new LinkedHashMap<String,Object>(accessToken.getAdditionalInformation());
		info.put("email", user.getEmail());
		info.put("username", user.getUsername());
		info.put("authorities",user.getAuthorities());
		info.put("technologies", user.getTech());
		System.out.println(user.getAuthorities());
	//	System.out.println( user.getTech());
		//user.getAuthorities();
		DefaultOAuth2AccessToken customAccessToken=new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		return super.enhance(customAccessToken, authentication);
	}
}
