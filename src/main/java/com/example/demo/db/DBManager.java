package com.example.demo.db;

import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.apache.bcel.classfile.Module.Uses;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.DMVO;
import com.example.demo.vo.InsertLookbookCommandVO;
import com.example.demo.vo.LookInfoVO;
import com.example.demo.vo.CommentsVO;
import com.example.demo.vo.InsertUsersCommandVO;
import com.example.demo.vo.LookbookVO;
import com.example.demo.vo.Lookbook_styleVO;
import com.example.demo.vo.RangeWeightHeightVO;
import com.example.demo.vo.SelectLookbookCommandVO;
import com.example.demo.vo.UpdateUsersCommandVO;
import com.example.demo.vo.UsersVO;
import com.example.demo.vo.Users_like_styleVO;
import com.example.demo.vo.Users_outVO;
import com.example.demo.vo.FollowVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		System.out.println("static block 동작함.");
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("mybatis 설정파일 생성함: " + factory);
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}

	public static int insertUsersWithStyle(InsertUsersCommandVO insertUsers) {
		int re = 0;
		SqlSession session = factory.openSession(true);

		// 유저넘버
		int r = session.selectOne("users.getNext_users_no");
		// 유저라이크스타일넘버
		int u = session.selectOne("users_like_style.getNext_users_like_no");
		System.out.println("-----------------");
		System.out.println("새로운 users_no:" + r);
		UsersVO users = insertUsers.getUsers();
		users.setUsers_no(r);
		System.out.println("users의 객체: " + users);
		int re1 = session.insert("users.insert", users);

		List<Integer> list = insertUsers.getStyle_no();
		int re2 = 0;
		for (int i : list) {
			Users_like_styleVO users_style = new Users_like_styleVO(u, r, i);
			re2 += session.insert("users_like_style.insert", users_style);
		}

		if (re1 == 1 && re2 == list.size()) {
			session.commit();
			re = 1;
		} else {
			session.rollback();
		}
		session.close();
		return re;
	}
	// 김보민

	// 회원탈퇴시 users테이블 속성 업데이트
	public static int updateUsersDel(int users_no) {
		SqlSession session = factory.openSession(true);
		int re = session.update("users.updateUsersDel", users_no);
		session.close();
		return re;
	}
	// 회원탈퇴시 탈퇴테이블에 insert

	public static int insertUsers_out(Users_outVO uo) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("users.insertUsers_out", uo);
		session.close();
		return re;
	}

	public static int updateUsersWithStyle(UpdateUsersCommandVO updateUsers) {
		int re = 0;
		SqlSession session = factory.openSession(true);

		// 유저라이크스타일넘버
		int u = session.selectOne("users_like_style.getNext_users_like_no");
		System.out.println("-----------------");

		UsersVO users = updateUsers.getUsers();
		System.out.println("users의 객체: " + users);
		int re1 = session.update("users.updateMyInfo", users);

		int users_no = users.getUsers_no();
		System.out.println("users_no:" + users_no);
		// users_no=1 인 users_like_style 삭제
		int re3 = session.delete("users_like_style.deleteStyle", users_no);

		List<Integer> list = updateUsers.getStyle_no();
		int re2 = 0;
		for (int i : list) {
			Users_like_styleVO users_style = new Users_like_styleVO(u, users_no, i);
			re2 += session.insert("users_like_style.insert", users_style);
		}

		if (re1 == 1 && re2 == list.size()) {
			session.commit();
			re = 1;
		} else {
			session.rollback();
		}
		session.close();
		return re;

	}

	public static int updateStyle(int users_no) {
		System.out.println("dbmanager updatestyle 동작함");
		SqlSession session = factory.openSession(true);
		int re = session.update("Users_like_Style.updateUsers_like_Style", users_no);
		session.close();
		return re;
	}

	public static int updateInfo(UsersVO u) {
		SqlSession session = factory.openSession(true);
		int re = session.update("look.updateMyInfo", u);
		session.close();
		return re;
	}

	public static List<BoardVO> listMyBoard() {
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
		int re = session.delete("look.deleteUser", map);
		session.close();
		return re;
	}

	public static UsersVO getUsers(String username) {
		SqlSession session = factory.openSession();
		UsersVO u = session.selectOne("users.getUsers", username);
		session.close();
		return u;
	}

	public static UsersVO getUser(int users_no) {
		SqlSession session = factory.openSession();
		UsersVO u = session.selectOne("users.getUsers", users_no);
		session.close();
		return u;
	}
	
	// 전체 룩북
	/*
	public static List<LookbookVO> listLookbook(HashMap map) {
		String[] arr = (String[]) map.get("arr_Style");
		System.out.println("Map 정보: " + Arrays.toString(arr));

		SqlSession session = factory.openSession();

		List<LookbookVO> list = session.selectList("lookbook.findAllField", map);
		// System.out.println("list: " + list);
		for (LookbookVO l : list) {
			System.out.println(l.getLookbook_no());
		}
		session.close();
		return list;
	}
	*/

	// 필터
	public static List<LookbookVO> listLookbookFilter(HashMap map) {

		String sortField = (String) map.get("sortField");
		String[] arr_Style = (String[]) map.get("arr_Style");
		RangeWeightHeightVO rw = (RangeWeightHeightVO) map.get("rw");
		
		
		System.out.println("Map 정보/ sortField: " + sortField);
		System.out.println("Map 정보/ arr: " + Arrays.toString(arr_Style));
		System.out.println("Map 정보/ RangeWH: " + rw);

		SqlSession session = factory.openSession();
		

		List<LookbookVO> list = session.selectList("lookbook.findAllFilter", map);
		// System.out.println("list: " + list);
		for (LookbookVO l : list) {
			System.out.println(l.getLookbook_no());
		}
		session.close();
		return list;
	}

	public static LookbookVO getDelLookbook(int no) {
		SqlSession session = factory.openSession();
		LookbookVO l = session.selectOne("lookbook.getDelBoard", no);
		session.close();
		return l;
	}

	public static int deleteLookbook(int no) {
		SqlSession session = factory.openSession(true);
		int re = session.delete("lookbook.deleteLookbook", no);

		session.commit();
		session.close();
		return re;
	}

	// 룩북 클릭시 룩북의 정보
	public static SelectLookbookCommandVO getLookbook(int no) {

		SqlSession session = factory.openSession();
		LookbookVO lookbook = session.selectOne("lookbook.getLookbook", no);
		UsersVO write_u = session.selectOne("users.getUsersbyNo", lookbook.getUsers_no());
		List<LookInfoVO> list_info = session.selectList("lookinfo.getLookinfo", no);
		List<Lookbook_styleVO> list_style = session.selectList("lookbook_style.getLookStyle", no);
		System.out.println("============================");
		System.out.println("lookbook의 users 정보: " + write_u);
		System.out.println("lookbook 정보: " + lookbook);
		System.out.println("list_info 정보: " + list_info);
		System.out.println("list_style 정보: " + list_style);
		System.out.println("============================");
		session.close();
		SelectLookbookCommandVO look = new SelectLookbookCommandVO(lookbook, write_u, list_info, list_style);
		return look;

	}

	public static int insertLookbook(InsertLookbookCommandVO insertlook) {
		int re = 0;
		SqlSession session = factory.openSession(true);
		int r = session.selectOne("lookinfo.getNext_lookbook_no");
		System.out.println("--------------------------");
		System.out.println("새로운 lookbook_no:" + r);
		LookbookVO lookbook = insertlook.getLookbook();
		lookbook.setLookbook_no(r);
		System.out.println("loobook객체: " + lookbook);
		int re1 = session.insert("lookbook.insert", lookbook); // 1

		List<LookInfoVO> list = insertlook.getList_info();
		int re2 = 0;
		for (LookInfoVO l : list) {
			l.setLookbook_no(r);
			System.out.println("lookinfo 객체:" + l);
			re2 += session.insert("lookinfo.insert", l);
		} // list 사이즈

		List<Integer> list2 = insertlook.getStyle_no();
		int re3 = 0;
		for (int i : list2) {
			Lookbook_styleVO style = new Lookbook_styleVO(r, i);
			System.out.println("lookbook_style 객체:" + style);
			re3 += session.insert("lookbook_style.insert", style);
		}
		if (re1 == 1 && re2 == list.size() && re3 == list2.size()) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		System.out.println("--------------------------");
		return re;
	}
	
	

	// board 관련 DBManager

	public static List<BoardVO> listBoard(HashMap map) {
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
		System.out.println("DBManager 작동함");
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

	public static int getTotalRecord(String searchType, String keyword) {

		SqlSession session = factory.openSession();

		HashMap data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		int n = session.selectOne("board.totalRecord", data);
		session.close();
		return n;
	}

	// 댓글 관련 DBManager
	public static List<CommentsVO> listComments(int board_no) {
		SqlSession session = factory.openSession();
		List<CommentsVO> list = session.selectList("comments.listComments", board_no);
		System.out.println(list);
		session.close();
		return list;
	}

	public static List<UsersVO> listFollw(String users_id) {
		System.out.println("매니저에서의 users_id:" + users_id);
		SqlSession session = factory.openSession();
		List<UsersVO> flist = session.selectList("users.listFollow", users_id);
		session.close();
		return flist;
	}

	public static String findID(String users_email) {
		System.out.println("DBManager findID동작함" + users_email);
		SqlSession session = factory.openSession();
		String users_id = session.selectOne("users.findID", users_email);
		session.close();
		return users_id;
	}

	public static String findPW(String users_id, String users_email) {
		System.out.println("DBManager findPW동작함" + users_id + "," + users_email);
		SqlSession session = factory.openSession();
		HashMap map = new HashMap();
		map.put("users_id", users_id);
		map.put("users_email", users_email);
		String users_pw = session.selectOne("users.findPW", map);
		session.close();
		return users_pw;
	}

	public static int updatePW(String code, String users_id, String users_email) {
		System.out.println("DBManager updatePW동작함" + code);
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("users_pw", code);
		map.put("users_id", users_id);
		map.put("users_email", users_email);
		int re = session.update("users.updatePW", map);
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
		String users_nickname = session.selectOne("users.compareNickname", compare_nickname);
		System.out.println("DBManager compareNickname동작함" + users_nickname);
		session.close();
		return users_nickname;
	}

	public static int insertComments(CommentsVO c) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("comments.insertComments", c);
		session.close();
		return re;
	}

	public static CommentsVO getComments(int comments_no) {
		SqlSession session = factory.openSession();
		CommentsVO c = session.selectOne("comments.getComments", comments_no);
		session.close();
		return c;
	}

	public static int deleteComments(int comments_no) {
		SqlSession session = factory.openSession(true);
		/*
		 * HashMap map = new HashMap(); map.put("no", board_no);
		 * System.out.println("map:"+map);
		 */
		int re = session.delete("comments.deleteComments", comments_no);
		session.commit();
		session.close();
		return re;
	}

	public static int updateComments(CommentsVO comments_no) {
		SqlSession session = factory.openSession(true);
		int re = session.update("comments.updateComments", comments_no);
		session.close();
		return re;
	}

	public static int updateProfile(UsersVO u) {
		System.out.println("디비매니저 프로필변경 작동");
		SqlSession session = factory.openSession(true);
		int re = session.update("users.updateProfile", u);
		session.close();
		return re;
	}

	// dbmanager/db
	// 가연
	public static UsersVO getUsersByNickname(String users_nickname) {
		SqlSession session = factory.openSession();
		UsersVO u = session.selectOne("users.getUsersByNickname", users_nickname);
		session.close();
		return u;
	}

	public static int insertDM(DMVO d) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("dm.insertDM", d);
		session.close();
		return re;
	}

	public static List<DMVO> listPeople(String users_nickname) {
		SqlSession session = factory.openSession();
		List<DMVO> list = session.selectList("dm.findAll", users_nickname);
		session.close();
		return list;

	}

	public static List<DMVO> listDM(String users_nickname) {
		SqlSession session = factory.openSession();
		List<DMVO> dmList = session.selectList("dm.findAll2", users_nickname);
		session.close();
		return dmList;

	}

	public static DMVO getDM(int dm_no) {
		SqlSession session = factory.openSession();
		DMVO d = session.selectOne("dm.getDM", dm_no);
		session.close();
		return d;
	}


}