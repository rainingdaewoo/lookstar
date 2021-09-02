package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDao;
import com.example.demo.vo.UsersVO;

@Service
public class UsersService implements UserDetailsService {
	@Autowired
	private UsersDao dao;
	public void setDao(UsersDao dao) {
		this.dao = dao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername 동작함:" + username);

		UsersVO u = dao.getUsers(username);
		if (u == null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println("회원정보: " + u);

		return User.builder().username(username).password(u.getUsers_pw()).roles(u.getUsers_grant()).build();
	}
}