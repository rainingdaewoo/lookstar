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
		
		http.authorizeRequests()

		.mvcMatchers("/","/lookbook/ListLookbook.do","/dmTest.do","insertDM.do","/board/listBoard.do","/board/detalBoard.do","/lookbook/lookbook_detail.do","/dmTest.do", "listChat.do","/insertDM.do","/main.do","/join.do","/login.do","/lookbook/lookbook.do","/resources/**","/findID.do","/findOK.do","/findPW.do","/compareID.do","/compareNickname.do","/sendCode.do","/kakao.do").permitAll()
		.anyRequest().authenticated(); 

		
		http.formLogin().loginPage("/login.do").permitAll()
		.defaultSuccessUrl("/loginOK.do");
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/login.do");
		
		http.httpBasic();	

	}
}