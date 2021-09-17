package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.authorizeRequests()
		.mvcMatchers("/","/board/listBoard.do","/board/detalBoard.do","/lookbook/ListLookbook.do","/lookbook/ListWeightHeight.do","/lookbook/lookbook_detail.do","/dmTest.do", "listChat.do","/insertDM.do","/main.do","/users/join.do","/users/login.do","/lookbook/lookbook.do","/resources/**","/users/findID.do","/users/findOK.do","/users/findPW.do","/users/compareID.do","/users/compareNickname.do","/users/sendCode.do","/kakao.do").permitAll()
		.anyRequest().authenticated(); 
		
		http.formLogin().loginPage("/users/login.do").permitAll()
		.defaultSuccessUrl("/users/loginOK.do");
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/users/login.do");
		
		http.httpBasic();	
		
		
		
	}
	
}