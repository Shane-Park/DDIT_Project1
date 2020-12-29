package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.PrintUtil;
import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.BoardDao;

public class BoardService {
	
	private static BoardService instance;
	private BoardService(){}
	public static BoardService getInstance()
	{
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	private int currentBoardNo;
	
	private int page = 1;
	
	private int select = 1;
	private int boardNum;
	public int boardList()
	{
		
		boardDao.BoardArray();
		List<Map<String,Object>> boardList = boardDao.selectBoardList(page);
		boar:while(true)
		{
			
		PrintUtil.title2();
		System.out.println("번호     말머리 \t제목\t작성자\t작성일");
		System.out.println("----------------------------------------");
		if(boardList.size()%3 == 2)
		{
			System.out.println();
		}
		
		for(int i=0; i< boardList.size(); i++)
		{
			Map<String, Object> board = boardList.get(i);
			String title = (String)board.get("TITLE");
			if(title.length()>3)
			{
				title = title.substring(0, 3) + "..";
			}
			System.out.println( board.get("BOARD_NO")+ "     "
					+board.get("CATEGORY") + " \t"
					+title + "\t"
					+board.get("NICKNAME") + "\t"
					+board.get("SUBSTR(A.B_DATE,1,10)"));
			
		
		}
		 if(boardList.size()%3 == 1&&boardList.size()%3 != 2)
		{
			System.out.println();
			System.out.println();
		}
		

		
		if( select == 1|| select == 7)
		{
			System.out.print( "◀ "+page);
			System.out.print( "page▷    ");			
			System.out.print( "□게시글 조회  ");
			System.out.print( "□게시글 작성  ");
			System.out.print( "□식당문의  ");			
			System.out.print( "□뒤로가기");
		}
		if( select == 2)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▶    ");		
			System.out.print( "□게시글 조회  ");
			System.out.print( "□게시글 작성  ");
			System.out.print( "□식당문의  ");			
			System.out.print( "□뒤로가기");
		}
		if(select == 3)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▷    ");	
			System.out.print( "■게시글 조회  ");
			System.out.print( "□게시글 작성  ");
			System.out.print( "□식당문의  ");			
			System.out.print( "□뒤로가기");
			
		}
		if(select == 4)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▷    ");	
			System.out.print( "□게시글 조회  ");
			System.out.print( "■게시글 작성  ");
			System.out.print( "□식당문의  ");	
			System.out.print( "□뒤로가기");
			
		}
		if(select == 5)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▷    ");	
			System.out.print( "□게시글 조회  ");
			System.out.print( "□게시글 작성  ");
			System.out.print( "■식당문의  ");	
			System.out.print( "□뒤로가기");
		
		}
		if(select == 6||select == 0)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▷    ");	
			System.out.print( "□게시글 조회  ");
			System.out.print( "□게시글 작성  ");
			System.out.print( "□식당문의  ");	
			System.out.print( "■뒤로가기");
			
		}
		if(select ==7){select = 1;}
		if(select ==0){select = 6;}
		System.out.print("\n                           (1,3)← → (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
		String input = ScanUtil.nextLine();
		
		switch(input)
		{
		case "3" : select++;break;
		case "1" : select--;break;
		case "" : break boar;
		}
		
		}
		switch(select)
		{
		case 1: if(page != 1){page--;}
				break;
		case 2: long size = boardList.size();
				if(page <= size){page++;}
				select = 2;
				break;
		case 3:System.out.print("게시글 번호 입력 >");
				return View.BOARD_MANAGE2;
		case 4:if(Controller.user.get("USER_ID").toString().equals("guest"))
					{  PrintUtil.boardbase1();
					System.out.println("로그인이 필요한 서비스입니다");
				    PrintUtil.boardbase2();
					String temp = ScanUtil.nextLine();
					return View.SIGNUP;}
				return View.BOARD_ADD;
		case 5:
			if(Controller.user.get("USER_ID").toString().equals("guest"))
					{  
						PrintUtil.boardbase1();
						System.out.println("로그인이 필요한 서비스입니다");
					    PrintUtil.boardbase2();
						String temp = ScanUtil.nextLine();
						return View.SIGNUP;
					}
			else if(Controller.user.get("USER_ID").toString().equals("admin"))
					{
						return View.BOARD_ADMIN;
					}
			else 
					{ 
						return View.BOARD_USER;
					}
		case 6:return View.USER_MAIN;
			default : return View.BOARD_MAIN;
		}
		 return View.BOARD_MAIN;
		
		}
	
		
	
	
		//게시판 글쓰기
	public int boardAdd()
	{
		String userId=Controller.user.get("USER_ID").toString();
		String nickName = Controller.user.get("NICKNAME").toString();
		
		String cateGory = null ;  String tiTle = "___" ; String conTent = "___" ;
		if(userId == "admin") {cateGory = "공지사항";}
		else {cateGory = "건의사항";}
		
		
		Add:while(true)
		{
		
		check:while(true)
		{
			
		
		PrintUtil.title();
		System.out.println("  📄건의사항✏️\n");
		System.out.print("제목\t: " + tiTle + "\n");
		System.out.print("내용\t: " + conTent + "\n\n");
		System.out.println("\t\t   뒤로 가러면 [Enter] 키를 누르세요");
		PrintUtil.printBar();
		
		
		
		if(tiTle != "___"){
			System.out.print("내용 : ");
				conTent = ScanUtil.nextLine();
				if(conTent.equals(""))
				{
					return View.BOARD_MAIN;	
				}
					break check;
			}
		if (tiTle == "___"){
			System.out.print("제목 : ");
			tiTle = ScanUtil.nextLine();
			if(tiTle.equals(""))
			{
				return View.BOARD_MAIN;	
			}
		}
		
		
		
		}
		
		
		    
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("TITLE", tiTle);
			param.put("USER_ID",userId);
			param.put("CONTENT", conTent);
			param.put("CATEGORY", cateGory);
			int result = boardDao.centerBoardAdd(param);
			
			if(0 < result){
				System.out.println("글 등록 성공");
				return View.BOARD_MAIN;	
			}else{
				System.out.println("글 등록 실패");
				return View.BOARD_MAIN;	
				}
			}
		
	
		}
	
	
	//게시글 상세하게불러오기
	public int boardSelect()
	{

		boardNum = ScanUtil.nextInt();

		int select = 1;
		Map<String, Object> board = boardDao.selectBoardOne(boardNum);
		boardone:while(true)
		{
			if(select == 0){select =3;}
			if(select == 4){select =1;}
			String category = board.get("CATEGORY").toString();
			String nickname = board.get("NICKNAME").toString();
			String title = board.get("TITLE").toString();
			String content = board.get("CONTENT").toString();
			String userID = board.get("USER_ID").toString();
			PrintUtil.title2();
			System.out.println("말머리 : "+category);
			System.out.println("닉네임 : "+nickname);
			System.out.println("제목 : "+title);
			System.out.println("내용 : "+content);

			if(select == 1){System.out.println("■게시글 수정	□게시글 삭제	□뒤로가기");}
			if(select == 2){System.out.println("□게시글 수정	■게시글 삭제	□뒤로가기");}
			if(select == 3){System.out.println("□게시글 수정	□게시글 삭제	■뒤로가기");}
			System.out.print("\n                           (1,3)← → (⏎)확인 \n");
			System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
			String tes = ScanUtil.nextLine();
			switch(tes)
			{
			case "1" :select--;break;
			case "3" :select++;break;
			}
			if(tes.equals("")){
			switch(select)
			{
			case 1 : if(!Controller.user.get("USER_ID").toString().equals(userID))
					{
						PrintUtil.boardbase1();
						System.out.println("본인계정이 아닙니다.");
					    PrintUtil.boardbase2();
						String temp = ScanUtil.nextLine();
						break;
					}else if(Controller.user.get("USER_ID").toString().equals("guest"))
					{
						
						PrintUtil.boardbase1();
						System.out.println("로그인이 필요한 서비스입니다");
					    PrintUtil.boardbase2();
						String temp = ScanUtil.nextLine();
						return View.SIGNUP;
					} return View.BOARD_ALTER;
			case 2 : if(!Controller.user.get("USER_ID").toString().equals(userID))
					{
						PrintUtil.boardbase1();
						System.out.println("본인계정이 아닙니다.");
					    PrintUtil.boardbase2();
						String temp = ScanUtil.nextLine();
						break;
					}else if(Controller.user.get("USER_ID").toString().equals("guest"))
					{
						PrintUtil.boardbase1();
						System.out.println("로그인이 필요한 서비스입니다");
					    PrintUtil.boardbase2();
						String temp = ScanUtil.nextLine();
						return View.SIGNUP;
					}return View.BOARD_DELETE;
			case 3 :break boardone;
			}
			}
		}
		return View.BOARD_MAIN;	
	}

	
	
	//건의사항 글 수정
	public int boardAlter()
	{
		Map<String, Object> board = boardDao.selectBoardOne(boardNum);
		int select =0;
		String category = board.get("CATEGORY").toString();
		String nickname = board.get("NICKNAME").toString();
		String title = board.get("TITLE").toString();
		String content = board.get("CONTENT").toString();
		String userID = board.get("USER_ID").toString();
		boardone:while(true)
		{
			if(select == 0){select =3;}
			if(select == 4){select =1;}
			
			PrintUtil.title2();
			System.out.println("말머리 : "+category);
			System.out.println("닉네임 : "+nickname);
			System.out.println("제목 : "+title);
			System.out.println("내용 : "+content);

			if(select == 1){System.out.println("\t■제목     □내용     □확인     □취소");}
			if(select == 2){System.out.println("\t□제목     ■내용     □확인     □취소");}
			if(select == 3){System.out.println("\t□제목     □내용     ■확인     □취소");}
			if(select == 4){System.out.println("\t□제목     □내용     □확인     ■취소");}
			System.out.print("\n                           (1,3)← → (⏎)확인 \n");
			System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
			String tes = ScanUtil.nextLine();
			switch(tes)
			{
			case "1" :select--;break;
			case "3" :select++;break;
			}
			if(tes.equals(""))
			switch(select)
			{
			case 1 :
					PrintUtil.boardbase1();
					System.out.println("제목을 입력하시오...");
					PrintUtil.boardbase2();
					System.out.print("제목 : ");
					title = ScanUtil.nextLine();
					break;
			case 2 :
					PrintUtil.boardbase1();
					System.out.println("제목을 입력하시오...");
					PrintUtil.boardbase2();
					System.out.print("내용 : ");
					content = ScanUtil.nextLine();
					break;
			case 3 :
					
				    boardDao.selectBoardAlter(title,content,boardNum);
				    PrintUtil.boardbase1();
				    System.out.println("수정되었습니다.");
				    PrintUtil.boardbase2();
				    tes =ScanUtil.nextLine();
					return View.BOARD_MAIN;
			case 4 :return View.BOARD_MAIN;
			}
		}
		
		
	}
	
	
	//건의사항 글 삭제
	public int boardDelete()
	{
		int select = 1;
		delete: while(true){
		PrintUtil.boardbase1();
	    System.out.println("정말 삭제하시겠습니까?");
	    System.out.println("\n");
	    if(select%2 == 1){System.out.println("                  ■예     □아니오");}
		if(select%2 == 0){System.out.println("                  □예     ■아니오");}
		System.out.print("\n                           (1,3)← → (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n> ");
		String tes =ScanUtil.nextLine();
		switch(tes)
		{
		case "1" : select++;break;
		case "3" : select--;break;
		case "" : if(select%2 == 1)
					{
					boardDao.BoardDelete(boardNum);
					PrintUtil.boardbase1();
				    System.out.println("삭제되었습니다.");
				    PrintUtil.boardbase2();
				    tes =ScanUtil.nextLine();
				    return View.BOARD_MAIN;
					}
				  if(select%2 == 0){return View.BOARD_MAIN;}
				  
		}
		
		}
		
		
	}
	
	//식당문의 확인(관리자)
	public int boardRes_admin()
	{
		page = 1;
		List<Map<String,Object>> boardList = boardDao.selectBoardRes(page);
		boar:while(true)
		{
			
		PrintUtil.title2();
		System.out.println("번호\t승인여부\t식당이름\t음식종류\t작성자");
		System.out.println("----------------------------------------");
		if(boardList.size()%3 == 2)
		{
			System.out.println();
		}
		
		for(int i=0; i< boardList.size(); i++)
		{
			Map<String, Object> board = boardList.get(i);
			String resNAME = (String)board.get("RES_NAME");
			if(resNAME.length()>3)
			{
				resNAME = resNAME.substring(0, 3) + "..";
			}
			System.out.println( board.get("RES_BOARD_NO")+ "\t"
					+board.get("AVAIL") + "\t"
					+board.get("RES_NAME") + "\t"
					+resNAME + "\t"
					+board.get("COUSINE") + "\t"
					+board.get("USER_ID"));
			
		
		}
		 if(boardList.size()%3 == 1&&boardList.size()%3 != 2)
		{
			System.out.println();
			System.out.println();
		}
		

		
		if( select == 1|| select == 5)
		{
			System.out.print( "◀ "+page);
			System.out.print( "page▷\t");			
			System.out.print( "□게시글 조회  ");
			System.out.print( "□뒤로가기");
		}
		if( select == 2)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▶\t");		
			System.out.print( "□게시글 조회  ");	
			System.out.print( "□뒤로가기");
		}
		if(select == 3)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▷\t");	
			System.out.print( "■게시글 조회  ");		
			System.out.print( "□뒤로가기");
			
		}
		
		
		if(select == 4||select == 0)
		{
			System.out.print( "◁ "+page);
			System.out.print( "page▷\t");	
			System.out.print( "□게시글 조회  ");
			System.out.print( "■뒤로가기");
			
		}
		if(select ==4){select = 1;}
		if(select ==0){select = 3;}
		System.out.print("\n                           (1,3)← → (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
		String input = ScanUtil.nextLine();
		
		switch(input)
		{
		case "3" : select++;break;
		case "1" : select--;break;
		case "" : break boar;
		}
		
		}
		switch(select)
		{
		case 1: if(page != 1){page--;}
				break;
		case 2: long size = boardList.size();
				if(page <= size){page++;}
				select = 2;
				break;
		case 3:System.out.print("게시글 번호 입력 >");
				return View.BOARD_MANAGE2;
		case 4:if(Controller.user.get("USER_ID").toString().equals("guest"))
					{  PrintUtil.boardbase1();
					System.out.println("로그인이 필요한 서비스입니다");
				    PrintUtil.boardbase2();
					String temp = ScanUtil.nextLine();
					return View.SIGNUP;}
				return View.BOARD_ADD;
		case 5:
			if(Controller.user.get("USER_ID").toString().equals("guest"))
					{  
						PrintUtil.boardbase1();
						System.out.println("로그인이 필요한 서비스입니다");
					    PrintUtil.boardbase2();
						String temp = ScanUtil.nextLine();
						return View.SIGNUP;
					}
			else if(Controller.user.get("USER_ID").toString().equals("admin"))
					{
						return View.BOARD_ADMIN;
					}
			else 
					{ 
						return View.BOARD_USER;
					}
		case 6:return View.USER_MAIN;
			default : return View.BOARD_MAIN;
		}
		 return View.BOARD_MAIN;
		
		}
		
	
	
	
	
	//유저 식당문의
	public int boardRes_user()
	{
		int select = 1;
		int[] complete = {0,0,0}; 
		String resName="",cousine="",add1="",openTime="",closeTime="",userID = Controller.user.get("USER_ID").toString(),avail = "대기";
		int distance=0;

		addRes:while(true){
			input:while(true){
				int max = 4;
				if(complete[0]==1 && complete[1]==1 && complete[2]==1)
					max = 5;
				PrintUtil.title();
				System.out.println("  📄건의사항✏️\n");
				if(select ==1)		System.out.print("           ■");
				else				System.out.print("           □");
				if(complete[0]==0)
					System.out.print(" 가게명 음식스타일  입력하기 \n");
				else
					System.out.printf(" 가게명: %s [%s] \n",resName,cousine);
				if(select ==2)		System.out.print("           ■");
				else				System.out.print("           □");
				if(complete[1]==0)
					System.out.print(" 주소,거리  입력하기 \n");
				else
					System.out.printf(" 주소: %s [거리 %dm] \n",add1,distance);
				if(select ==3)		System.out.print("           ■");
				else				System.out.print("           □");
				if(complete[2]==0)
					System.out.print(" 영업시간  입력하기\n");
				else
					System.out.printf(" 영업시간  [%s - %s]\n",openTime,closeTime);
				if(select ==4)		System.out.print("           ■");
				else				System.out.print("           □");
					System.out.print(" 뒤로가기 ");
				if(complete[0]==1 && complete[1]==1 && complete[2]==1){
					if(select ==5)		System.out.print("\n           ■");
					else				System.out.print("\n           □");
					System.out.print(" 입력 완료! 식당 등록하기 ");
				}else System.out.println();
				System.out.print("\t\t");
				if(!(complete[0]==1 && complete[1]==1 && complete[2]==1))
					PrintUtil.joystick2();
				else
					PrintUtil.printBar2();

				switch(ScanUtil.nextLine()){
				case "5":
					if(select==1)
						select=max;
					else select--;
					break;
				case "2":
					if(select==max)
						select=1;
					else select++;
					break;
				case "":
					break input;
				default:
					break;
				}
			}
		switch(select){
		case 1: if(complete[0]==1){break;}
		else{
			PrintUtil.title();
			System.out.println("  📄건의사항✏️\n");
			System.out.println("                      식당 이름을 입력해주세요\n\n");
			PrintUtil.printBar();
			resName = ScanUtil.nextLine();

			PrintUtil.title();
			System.out.println("  📄건의사항✏️\n");
			System.out.println("                       식당 이름 : " + resName);
			System.out.println("                      음식스타일을 입력해주세요\n");
			PrintUtil.printBar();
			cousine = ScanUtil.nextLine();

			complete[0] = 1;

		}
		break;
		case 2:if(complete[1]==1){break;}
		else{
			PrintUtil.title();
			System.out.println("  📄건의사항✏️\n");
			System.out.println("                        주소를 입력해주세요\n\n");
			PrintUtil.printBar();
			add1 = ScanUtil.nextLine();

			PrintUtil.title();
			System.out.println("  📄건의사항✏️\n");
			System.out.println("                       주소 : " + add1);
			System.out.println("               학원으로부터 거리(m)를 숫자로 입력해주세요\n");
			PrintUtil.printBar();
			distance = Integer.parseInt(ScanUtil.nextLine());

			complete[1] = 1;

		}
		break;
		case 3:if(complete[2]==1){break;}
		else{
			PrintUtil.title();
			System.out.println("  📄건의사항✏️\n");
			System.out.println("                    오픈시간을 입력해주세요 (예)12:00\n\n");
			PrintUtil.printBar();
			openTime = ScanUtil.nextLine();

			PrintUtil.title();
			System.out.println("  📄건의사항✏️\n");
			System.out.println("                       오픈시간 " + openTime);
			System.out.println("                    마감시간을 입력해주세요 (예)12:00\n");
			PrintUtil.printBar();
			closeTime = ScanUtil.nextLine();

			complete[2] = 1;
		}
		break;
		case 4:
			return View.BOARD_MAIN;
		case 5:
			break addRes;
		}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RES_NAME", resName);
		param.put("COUSINE", cousine);
		param.put("OPEN_TIME", openTime);
		param.put("CLOSE_TIME", closeTime);
		param.put("ADD1", add1);
		param.put("DISTANCE", distance);
		param.put("USER_ID", userID);
		param.put("AVAIL", avail);
		
		int result = boardDao.BoardresAdd(param);
		
		if(0 < result){
			
			PrintUtil.boardbase1();
			System.out.println("글 등록 성공");
		    PrintUtil.boardbase2();
		    String tes =ScanUtil.nextLine();
			return View.BOARD_MAIN;	
		}else{
			PrintUtil.boardbase1();
			System.out.println("글 등록 실패");
		    PrintUtil.boardbase2();
		    String tes =ScanUtil.nextLine();
			return View.BOARD_MAIN;	
			}
		
	}
	
}