package util;

public class LodingUtil {
	static public void mainUi(int select){
		final int max = 1;
		int count = 0;
		String grade ="□" ,review = "□",distance ="□", serch ="□", order ="□",mypage ="□",board ="□";
		
		String a = "■";
		switch(select)
		{
		case 1 : grade =a;break;
		case 2 : review =a;break; 
		case 3 : distance =a;break;
		case 4 : serch =a;break;
		case 5 : order =a;break;
		case 6 : mypage =a;break;
		case 7 : board  =a;break;
		default : break;
		}
		
		
		for(int i = 1; i <6;i++){
			Util.wait(120);
			if(count == max){break;}
			
			if(i == 5){count++;i = 1;}
		if(i == 1){
			System.out.println("\n\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n\n"
					+ "                                    🍽️ 오늘 뭐먹지? 🍽️                       (으)로 접속중\n"
					+ " "+grade+" 평점기준                   🥘 [   ] BEST 5 🍝\n"
					+ " "+review+" 리뷰수기준\n"
					+ " "+distance+" 거리기준                	           ■ □\n"
					+ " "+serch+" 검색                     	           □ □\n"
					+ " "+order+" 도시락주문     \n"
					+ " "+mypage+" 마이페이지             \n"
					+ " "+board+" 고객센터                                             (2)↓ (5)↑ (⏎)확인\n"
					+ "□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");}
			
			if(i == 2){
				System.out.println("\n\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n\n"
						+ "                                    🍽️ 오늘 뭐먹지? 🍽️                       (으)로 접속중\n"
						+ " "+grade+" 평점기준                   🥘 [   ] BEST 5 🍝\n"
						+ " "+review+" 리뷰수기준\n"
						+ " "+distance+" 거리기준                	           □ □\n"
						+ " "+serch+" 검색                     	           ■ □\n"
						+ " "+order+" 도시락주문     \n"
						+ " "+mypage+" 마이페이지             \n"
						+ " "+board+" 고객센터                                             (2)↓ (5)↑ (⏎)확인\n"
						+ "□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");}
		
			if(i == 3){
				System.out.println("\n\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n\n"
						+ "                                    🍽️ 오늘 뭐먹지? 🍽️                       (으)로 접속중\n"
						+ " "+grade+" 평점기준                   🥘 [   ] BEST 5 🍝\n"
						+ " "+review+" 리뷰수기준\n"
						+ " "+distance+" 거리기준                	           □ □\n"
						+ " "+serch+" 검색                     	           □ ■\n"
						+ " "+order+" 도시락주문     \n"
						+ " "+mypage+" 마이페이지             \n"
						+ " "+board+" 고객센터                                             (2)↓ (5)↑ (⏎)확인\n"
						+ "□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");}
			
			if(i == 4){
				System.out.println("\n\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n\n"
						+ "                                    🍽️ 오늘 뭐먹지? 🍽️                       (으)로 접속중\n"
						+ " "+grade+" 평점기준                   🥘 [   ] BEST 5 🍝\n"
						+ " "+review+" 리뷰수기준\n"
						+ " "+distance+" 거리기준                	           □ ■\n"
						+ " "+serch+" 검색                     	           □ □\n"
						+ " "+order+" 도시락주문     \n"
						+ " "+mypage+" 마이페이지             \n"
						+ " "+board+" 고객센터                                             (2)↓ (5)↑ (⏎)확인\n"
						+ "□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");}
	}
}
	
	
	
}
