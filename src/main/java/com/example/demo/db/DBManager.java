package com.example.demo.db;

import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
import com.example.demo.vo.LooklikeVO;
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

	   public static int updatePWD(HashMap map) {
		   int re = -1;
		   SqlSession session = factory.openSession();
		   re = session.update("users.updatePwd", map);
		   session.commit();
		   session.close();
		   return re;
	   }
	   
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

	  public static List<LookbookVO> listLikes(HashMap map){
		  SqlSession session = factory.openSession();
		  List<LookbookVO> list = session.selectList("looklike.listLikes",map);
		  
		  session.close();
		  return list;
	  }


	  public static List<UsersVO> listFollw(HashMap map) {
	      SqlSession session = factory.openSession();
	      List<UsersVO> flist = session.selectList("follow.listFollow",map);
	      session.close();
	      return flist;
	   }
	  
	   public static int updateInfo(UsersVO u) {
	      SqlSession session = factory.openSession(true);
	      int re = session.update("look.updateMyInfo", u);
	      session.close();
	      return re;
	   }


	   public static List<BoardVO> listMyBoard(HashMap map) {
	      SqlSession session = factory.openSession();
	      List<BoardVO> list = session.selectList("board.listMyBoard",map);
	      session.close();
	      return list;
	   }
	   
	   public static List<LookbookVO> listMyLook(HashMap map){
		   
		   SqlSession session = factory.openSession();
		   List<LookbookVO> list = session.selectList("lookbook.listMyLook",map);
		   System.out.println("listMyLookbook:"+list);
		  // System.out.println("users_no:"+users_no);
		   session.close();
		   return list;
	   }
	   
	   public static List<LookbookVO> listFLook(HashMap map) {
		   System.out.println("map:"+map);
			SqlSession session = factory.openSession();
			List<LookbookVO> list = session.selectList("follow.listFLook",map);
			System.out.println("list:"+list);
			session.close();
			return list;
		}
	   
	   public static int getTotalMyLook(int users_no) {
		   SqlSession session = factory.openSession();
		   int n = session.selectOne("lookbook.totalMyLook",users_no);
		   session.close();
		   return n;
	   }
	   
	   public static int getTotalMyBoard(int users_no) {
		   SqlSession session = factory.openSession();
		   int n = session.selectOne("board.totalMyBoard",users_no);
		   session.close();
		   return n;
	   }
	   
	   public static int getTotalMyLikes(int users_no) {
		   SqlSession session = factory.openSession();
		   int n = session.selectOne("looklike.totalRecord",users_no);
		   session.close();
		   return n;
	   }
	   
	   public static int getTotalMyFollow(String users_id) {
		   SqlSession session = factory.openSession();
		   int n = session.selectOne("follow.totalRecord",users_id);
		   session.close();
		   return n;
	   }
	   
	   public static int getTotalFRecord(int users_no) {
		   System.out.println("bbb users_no 81 dbmanager:"+users_no);
			SqlSession session = factory.openSession();
			int n = session.selectOne("follow.totalFRecord",users_no);
			session.close();
			return n;
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
	      UsersVO u = session.selectOne("users.getUsers",users_no);
	      session.close();
	      return u;
	   }

	   
	   
	   
	   
	   
	   //lookbook
	   public static List<LookbookVO> listlookbook() {
			SqlSession session = factory.openSession();
			List<LookbookVO> list = session.selectList("lookbook.listlookbook");
			return list;
		}

		// 필터
		public static List<LookbookVO> listLookbookFilter(HashMap map) {

			String sortField = (String) map.get("sortField");
			String[] arr_Style = (String[]) map.get("arr_Style");
			RangeWeightHeightVO rw = (RangeWeightHeightVO) map.get("rw");
			int start = (int)map.get("start");
			int end = (int)map.get("end");

			System.out.println("Map 정보/ sortField: " + sortField);
			System.out.println("Map 정보/ arr: " + Arrays.toString(arr_Style));
			System.out.println("Map 정보/ RangeWH: " + rw);
			System.out.println("Map 정보/ start: " + start);
			System.out.println("Map 정보/ end: " + end);
			

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

		public static int deleteLookbook(int lookbook_no) {
			SqlSession session = factory.openSession(true);
			int re = session.delete("lookbook.deleteLookbook", lookbook_no);

			session.commit();
			session.close();
			return re;
		}
		
		public static int getTotalRecordLookbook() {
			SqlSession session = factory.openSession();
			int re = session.selectOne("lookbook.totalRecordLookbook");
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

		public static int updateLookbook(InsertLookbookCommandVO updatelook) {
			int re = 0;

			SqlSession session = factory.openSession(true);

			System.out.println("--------------------------");

			LookbookVO lookbook = updatelook.getLookbook();
			System.out.println("loobook객체: " + lookbook);
			int no = lookbook.getLookbook_no();
			int re1 = session.update("lookbook.update", lookbook); // 1 - 룩북 업데이트

			int re2 = session.delete("lookinfo.delete", no); // 일단 룩북의 모든 정보 삭제
			List<LookInfoVO> list = updatelook.getList_info();
			int re3 = 0;
			for (LookInfoVO l : list) {
				l.setLookbook_no(no);
				System.out.println("lookinfo 객체:" + l);
				re3 += session.insert("lookinfo.insert", l);
			} // list 사이즈 만큼 lookinfo 추가

			int re4 = session.delete("lookbook_style.delete", no); // 일단 룩북의 모든 스타일 삭제
			List<Integer> list2 = updatelook.getStyle_no();
			int re5 = 0;
			for (int i : list2) {
				Lookbook_styleVO style = new Lookbook_styleVO(no, i);
				System.out.println("lookbook_style 객체:" + style);
				re5 += session.insert("lookbook_style.insert", style);
			}
			if (re1 == 1 && re3 == list.size() && re5 == list2.size()) {
				session.commit();
			} else {
				session.rollback();
			}

			session.close();
			System.out.println("--------------------------");
			return re;
		}

		public static void updateLookbookViews(int no) {
			SqlSession session = factory.openSession(true);
			session.update("lookbook.updateViews", no);
			session.close();
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

	   public static int getTotalRecord(String searchType, String keyword, int board_category_no) {

	      SqlSession session = factory.openSession();

	      HashMap data = new HashMap();

	      data.put("searchType", searchType);
	      data.put("keyword", keyword);
	      data.put("board_category_no", board_category_no);

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
	      System.out.println("DBManger insertComments 작동함");
	      session.close();
	      return re;
	   }
	   
	   public static void plusCommentsCount(int no) {
		      SqlSession session = factory.openSession(true);
		      session.update("board.plusCommentsCount", no);
		      session.close();
		   }
	   
	   public static void minusCommentsCount(int no) {
		      SqlSession session = factory.openSession(true);
		      session.update("board.minusCommentsCount", no);
		      session.close();
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
	      System.out.println("DBManger deleteComments 작동함");
	      session.commit();
	      session.close();
	      return re;
	   }

	   public static int updateComments(CommentsVO co) {
	      SqlSession session = factory.openSession(true);
	      int re = session.update("comments.updateComments", co);
	      session.close();
	      System.out.println("updateComments 작동함");
	      return re;
	   }
	   
	   public static int updateProfile(UsersVO u) {
		   System.out.println("디비매니저 프로필변경 작동");
	         SqlSession session = factory.openSession(true);
	         int re = session.update("users.updateProfile",u);
	         session.close();
	         return re;
	      }

	   
	 //dbmanager/db
	   //가연
	      public static List<DMVO> listDM(HashMap map) {   //룩북에서 dm select
	        SqlSession session = factory.openSession();
	        List<DMVO> dlist = session.selectList("dm.findAll2",map);
	        session.close();
	        return dlist;
	      }
	         
	      
	      public static int insertDM(DMVO d) {   //디엠아이콘, 룩북에서의 insert
	         SqlSession session = factory.openSession(true);
	         String dm_no = session.selectOne("dm.findDM_no",d);
	         d.setDm_no(Integer.toString(Integer.parseInt(dm_no)+1));
	         System.out.println("번호갖고와    "+d.getDm_no());
	         System.out.println("dm_no: "+dm_no);
	         
	         String room_no = session.selectOne("dm.existRoom",d);
	         System.out.println("room_no: "+room_no);

	         int re = 0;
	         //방번호 불러와줘
	         if (Integer.parseInt(room_no)!=0) {
	            //기존방 있으면 그 번호 불러와줘
	            String room_old = session.selectOne("dm.findRoom_no",d);
	            d.setRoom_no(Integer.toString(Integer.parseInt(room_old)));
	            System.out.println("d의 값: " + d);
	            
	         }
	         else {
	            String room_new = session.selectOne("dm.findNextRoom_no",d);
	            System.out.println("새로운방 번호: "+room_new);
	            d.setRoom_no(Integer.toString(Integer.parseInt(room_new)));
	            System.out.println("d의 값: " + d);
	         }

	         re = session.insert("dm.InsertDM",d);
	         session.close();
	         return re;
	      }
	      
	      
	      //여기서부터 디엠아이콘
	      //채팅리스트 불러오기
	     public static List<DMVO> iconListPeople(String users_id){
	        SqlSession session = factory.openSession();
	        System.out.println("users_id가 무엇일까: "+users_id);
	        List<DMVO> list = session.selectList("dm.findRecentDM",users_id);        
	             
	        //내가 to_id이더라도 상대방 닉네임과 상대방 프로필 갖고와야해        
	        for(DMVO dvo: list) {
	          if(dvo.getTo_id().equals(users_id)) {
	             
	             //내가 to_id면 상대방 아이디 from_id로 저장
	             String other_id = dvo.getFrom_id();
	             dvo.setOther_id(other_id);
	             
	             String to_id = dvo.getFrom_id();
	             System.out.println("to_id: "+to_id);
	             String to_nickname=session.selectOne("dm.getToNickname",to_id);
	             dvo.setTo_nickname(to_nickname);
	             String to_profile = session.selectOne("dm.getToProfile",to_id);
	             dvo.setTo_profile(to_profile);
	             System.out.println("/////////////////////////////////////");
	             System.out.println("닉네임이밍미: "+to_nickname);
	             System.out.println("프로필이이ㅣ이일: "+to_profile);
	             System.out.println("ddddd의정보오오오: "+dvo);
	             System.out.println("종료");             
	         }
	              
	         else {
	            //내가 from_id라면 상대방 아이디 to_id로 저장
	            String other_id = dvo.getTo_id();
	            dvo.setOther_id(other_id);
	            
	            String to_id = dvo.getTo_id();
	            System.out.println("to_id: "+to_id);
	            String to_nickname=session.selectOne("dm.getFromNickname",to_id);
	            dvo.setTo_nickname(to_nickname);
	            String to_profile = session.selectOne("dm.getFromProfile",to_id);
	            dvo.setTo_profile(to_profile);
	            System.out.println("/////////////////////////////////////");
	            System.out.println("닉네임이밍미: "+to_nickname);
	            System.out.println("프로필이이ㅣ이일: "+to_profile);
	            System.out.println("ddddd의정보오오오: "+dvo);
	            System.out.println("종료");
	          }      
	        }           
	        return list;
	     }
	      
	      
	     public static List<DMVO> iconListDM(String room_no) {
	        SqlSession session = factory.openSession();
	        System.out.println();
	        
	        List<DMVO> dlist = session.selectList("dm.findAll3",room_no);
	        System.out.println("room_no의 메세지정보: "+room_no);
	        
	        System.out.println("ddddd의정보: "+dlist);
	        session.close();
	        return dlist;        
	     }
	     
	     
	     
	     
	     public static int iconInsertDM(DMVO d) {
	         SqlSession session = factory.openSession(true);
	         String dm_no = session.selectOne("dm.findDM_no",d);
	         d.setDm_no(Integer.toString(Integer.parseInt(dm_no)+1));
	         System.out.println("번호갖고와    "+d.getDm_no());
	         System.out.println("dm_no: "+dm_no);
	         
	         String room_no = session.selectOne("dm.existRoom",d);
	         System.out.println("room_no: "+room_no);

	         int re = 0;
	         //방번호 불러와줘
	         if (Integer.parseInt(room_no)!=0) {
	            //기존방 있으면 그 번호 불러와줘
	            String room_old = session.selectOne("dm.findRoom_no",d);
	            d.setRoom_no(Integer.toString(Integer.parseInt(room_old)));
	            System.out.println("d의 값: " + d);
	            
	         }
	         else {
	            String room_new = session.selectOne("dm.findNextRoom_no",d);
	            System.out.println("새로운방 번호: "+room_new);
	            d.setRoom_no(Integer.toString(Integer.parseInt(room_new)));
	            System.out.println("d의 값: " + d);
	         }

	         re = session.insert("dm.InsertDM",d);
	         session.close();
	         return re;
	      }
	     
	     
	     
	     
	     
	      /* 
	      //dm아이콘의 사용자 ->수신자 아이디, 닉네임, 사진 정보 리스트갖고오기
	      public static List<ToDMListVO> iconListDM(String users_id) {
	         SqlSession session = factory.openSession(true);
	         
	         List<ToDMListVO> list= session.selectList("dm.findToAll",users_id);
	         System.out.println("list의 정보들: "+list);
	         session.close();
	         return list;
	  
	      }
	      
	      //닉네임으로 사용자정보불러오기 (from_id, to_id로 하면서 안씀)
	      public static UsersVO getUsersByNickname(String users_nickname) {
	         SqlSession session = factory.openSession();
	         UsersVO u = session.selectOne("users.getUsersByNickname",users_nickname);
	         session.close();
	         return u;
	      }

	      //수신자를 직접 입력했을때 사용 (룩북디엠한 유저만 디엠하기로 하면서 안씀)
	      public static List<DMVO> listPeople(String users_nickname){
	         SqlSession session = factory.openSession();
	         List<DMVO> list = session.selectList("dm.findAll",users_nickname);
	         session.close();
	         return list;         
	      }
	         
	      //룩북디엠리스트 불러올때 
	      //lookbook_no, users_id가 필요해 nickname->map으로 매개변수 변경
	      public static List<DMVO> listDM(String users_nickname){
	         SqlSession session = factory.openSession();
	         List<DMVO> dmList = session.selectList("dm.findAll2",users_nickname);
	         session.close();
	         return dmList;            
	      }
	      
	      //dm_no로 불러올일이없었음
	      public static DMVO getDM(int dm_no) {
	         SqlSession session = factory.openSession();
	         DMVO d = session.selectOne("dm.getDM",dm_no);
	         session.close();
	         return d;
	      }
	      */             
	//여기까지가 디엠
	   
	   
	   
		
		
		
		public static int insertFollow(FollowVO f) { // 팔로우
			SqlSession session = factory.openSession(true);
			//
			int follow_no = session.selectOne("follow.getNext_follow_no");
			// 위에서 선언한 변수 follow_no는 무엇을 위한
			f.setFollow_no(follow_no);
			int re = session.insert("follow.insertFollow", f);
			session.close();
			return re;
		}
		/*
		public void deleteByFollowingIdAndFollowerId(int following_id) { // 언팔로우
			SqlSession session = factory.openSession();
			int re = session.delete("follow.insertFollow",following_id);
			session.close();
			return re;
		}
		*/


		public static int isFollow(String follower_id, String following_id) {
			SqlSession session = factory.openSession();
			HashMap map = new HashMap();
			map.put("follower_id", follower_id);
			map.put("following_id", following_id);
			int r = session.selectOne("follow.isFollow",map);
			session.close();
			return r;
		}

		public static int deleteFollow(String follower_id, String following_id) {
			SqlSession session = factory.openSession(true);
			HashMap map = new HashMap();
			map.put("follower_id", follower_id);
			map.put("following_id", following_id);
			int r = session.delete("follow.deleteFollow",map);
			session.close();
			return r;
		}
		
		// 좋아요 수 세기
		public static int countLooklike(int lookbook_no) {
			SqlSession session = factory.openSession();
			int r = session.selectOne("looklike.countLooklike",lookbook_no);
			session.close();
			return r;
		}
		
		// 좋아요 누른 사람인지 판별
		public static int isLooklike(int users_no, int lookbook_no) {
			SqlSession session = factory.openSession();
			HashMap map = new HashMap();
			map.put("users_no", users_no);
			map.put("lookbook_no", lookbook_no);
			int r = session.selectOne("looklike.isLooklike",map);
			session.close();
			return r;
		}

		public static int insertLooklike(LooklikeVO looklike) {
			SqlSession session = factory.openSession(true);
			//
			int like_no = session.selectOne("looklike.getNext_like_no");
			// 위에서 선언한 변수 follow_no는 무엇을 위한
			looklike.setLike_no(like_no);
			int re = session.insert("looklike.insertLooklike", looklike);
			session.close();
			return re;
		}

		public static int deleteLooklike(int users_no, int lookbook_no) {
			SqlSession session = factory.openSession(true);
			HashMap map = new HashMap();
			map.put("users_no", users_no);
			map.put("lookbook_no", lookbook_no);
			int r = session.delete("looklike.deleteLooklike",map);
			session.close();
			return r;
		}

		

		


	}