package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.apache.bcel.classfile.Module.Uses;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.ChatVO;
import com.example.demo.vo.InsertUsersCommandVO;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.UsersVO;
import com.example.demo.vo.Users_like_styleVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		System.out.println("static block 동작함.");
		try {
			Reader reader = 
			Resources.getResourceAsReader("com/example/demo/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("mybatis 설정파일 생성함: " + factory);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	// style 없는
	/*public static int insertUsers(UsersVO u) {
		System.out.println("insertUsers 세션 작동함:" + u);
		SqlSession session = factory.openSession(true);
		int re = session.insert("users.insert", u);
		System.out.println("re:"+re);
		session.close();
		
		return re;
	}*/

	
	
	public static int insertUsersWithStyle(InsertUsersCommandVO insertUsers) {
		int re = 0;
		SqlSession session = factory.openSession(true);
		
		//유저넘버 
		int r = session.selectOne("users.getNext_users_no");
		//유저라이크스타일넘버 
		int u = session.selectOne("users_like_style.getNext_users_like_no");
		System.out.println("-----------------");
		System.out.println("새로운 users_no:" + r);
		UsersVO users = insertUsers.getUsers();
		users.setUsers_no(r);
		System.out.println("users의 객체: "+ users);
		int re1 = session.insert("users.insert",users);
		
		List<Integer> list = insertUsers.getStyle_no();
		int re2 = 0;
		for(int i: list) {
			Users_like_styleVO users_style = new Users_like_styleVO(u,r,i);
			re2+=session.insert("users_like_style.insert", users_style);
		}
		
		if(re1==1 && re2 ==list.size()) {
			session.commit();
			re = 1;
		}else {
			session.rollback();
		}
		session.close();
		return re;
	}
	
	
	public static int updateInfo(UsersVO u) {
		SqlSession session = factory.openSession(true);
		int re = session.update("look.updateMyInfo",u);
		session.close();
		return re;
	}
	
	public static List<BoardVO> listMyBoard(){
		SqlSession session = factory.openSession();
		List<BoardVO> list = session.selectList("board.listMyBoard");
		session.close();
		return list;
	}
	
	
	
	public static int deleteUser(int users_no, String users_pw) {
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("users_no", users_no);
		map.put("users_pw", users_pw);
		int re = session.delete("look.deleteUser",map);
		session.close();
		return re;
	}
	public static UsersVO getUsers(String username) {
		SqlSession session = factory.openSession();
		UsersVO u = session.selectOne("users.getUsers",username);
		session.close();
		return u;
	}
	public static UsersVO getUsers(int users_no) {
		SqlSession session = factory.openSession();
		UsersVO u = session.selectOne("look.getUser",users_no);
		session.close();
		return u;
	}

	public static List<LookbookVO> listLookbook(String sortField) {
		SqlSession session = factory.openSession();
		List<com.example.demo.vo.LookbookVO> list = session.selectList("lookbook.findAll",sortField);
		session.close();
		return list;
	}

	public static int insert(LookbookVO l) {
		SqlSession session = factory.openSession();
		int re = session.insert("lookbook.insert",l);
		session.commit();
		session.close();
		return re;
	}
	
	public static int insertDM(ChatVO c) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("chat.insertDM",c);
		session.close();
		return re;
	}
	
	public static List<ChatVO> listDM(String from_id) {
		SqlSession session = factory.openSession();
		List<ChatVO> c = session.selectList("chat.listDM",from_id);
		session.close();
		return c;
	}
	//board 관련 DBManager
	
		public static List<BoardVO> listBoard(HashMap map){
			SqlSession session = factory.openSession();
			List<BoardVO> list = session.selectList("board.findAll", map);
			session.close();
			return list;
		}
		
		public static int getNextNo() {
			SqlSession session = factory.openSession();
			int no = session.selectOne("board.getNextNo");
			session.close();
			return no;
		}
		
		public static int insertBoard(BoardVO b) {
			SqlSession session = factory.openSession(true);
			int re = session.insert("board.insertBoard", b);
			session.close();
			return re;
		}
		
		public static BoardVO getBoard(int no) {
			SqlSession session = factory.openSession();
			BoardVO b = session.selectOne("board.getBoard", no);
			session.close();
			return b;
		}
		
		public static void updateViews(int no) {
			SqlSession session = factory.openSession(true);
			session.update("board.updateViews", no);
			session.close();
		}

		public static void updateStep(int b_ref, int b_step) {
			// TODO Auto-generated method stub
			SqlSession session = factory.openSession();
			HashMap map = new HashMap();
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);
			
			session.update("board.updateStep", map);
			session.commit();
			session.close();
		}
		
		public static int updateBoard(BoardVO b) {
			SqlSession session = factory.openSession(true);
			int re = session.update("board.updateBoard", b);
			session.close();
			return re;
		}
		
		public static int deleteBoard(int board_no) {
			SqlSession session = factory.openSession(true);
			/*
			 * HashMap map = new HashMap(); map.put("no", board_no);
			 * System.out.println("map:"+map);
			 */
			int re = session.delete("board.deleteBoard", board_no);
			
			session.commit();
			session.close();
			return re;
		}
			
		public static int getTotalRecord() {
			SqlSession session = factory.openSession();
			int n = session.selectOne("board.totalRecord");
			session.close();
			return n;
		}
		
		public static String findID(String users_email){	
			System.out.println("DBManager findID동작함" + users_email);
			SqlSession session = factory.openSession();
			String users_id = session.selectOne("users.findID",users_email);
			session.close();
			return users_id;
		}
		
		public static String findPW(String users_id, String users_email) {
			System.out.println("DBManager findPW동작함" + users_id+","+users_email);
			SqlSession session = factory.openSession();
			HashMap map = new HashMap();
			map.put("users_id", users_id);
			map.put("users_email", users_email);
			String users_pw = session.selectOne("users.findPW", map);
			session.close();
			return users_pw;		
		} 
		
		public static int updatePW(String code, String users_id,String users_email) {
			System.out.println("DBManager updatePW동작함" + code);
			SqlSession session = factory.openSession(true);
			HashMap map = new HashMap();
			map.put("users_pw", code);
			map.put("users_id", users_id);
			map.put("users_email", users_email);
			int re = session.update("users.updatePW",map); 
			session.close();
			return re;
		}
		
		public static String compareID(String compare_id) {
			System.out.println("DBManager compareID동작함");
			SqlSession session = factory.openSession();
			String users_id = session.selectOne("users.compareID", compare_id);
			session.close();
			return users_id;
		}
		
		public static String compareNickname(String compare_nickname) {
			SqlSession session = factory.openSession();
			String users_nickname = session.selectOne("users.compareNickname",compare_nickname);
			System.out.println("DBManager compareNickname동작함" + users_nickname);
			session.close();
			return users_nickname;
		}
		
		
		
		
}