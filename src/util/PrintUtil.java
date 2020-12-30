package util;

public class PrintUtil {
	static public void title(){
		System.out.println("\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n");
		System.out.println("                                    🍽️ 오늘 뭐먹지? 🍽️\n");
	}
	static public void title2(){
		System.out.println("\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n");
		System.out.println("                                    🍽️ 오늘 뭐먹지? 🍽️");
	}
	static public void title3(){
		System.out.println("\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n");
		System.out.print("                                    🍽️ 오늘 뭐먹지? 🍽️");
	}

	static public void joystick(){
		System.out.print("\n                           (2)↓ (5)↑ (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
	}

	static public void joystick2(){
		System.out.print("     (2)↓ (5)↑ (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
	}

	static public void joystick3(){
		System.out.print(" (1,3)← → (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
	}
	
	static public void joystick4(){
		System.out.print("\n                           (1,3)← → (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
	}
	
	static public void joystick5(){
		System.out.print("                           (1,3)← → (⏎)확인 \n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n>");
	}

	static public void printBar(){
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n> ");
	}

	static public void printBar2(){
		System.out.println();
		printBar();
	}
	
	static public void printBar3(){
		System.out.print("                       \t\t       뒤로 가러면 [Enter] 키를 누르세요\n");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n> ");
	}

	public static void printBlank(int n){
		for(int i=0; i<n; i++)
			System.out.println();
	}

	public static void loading(int time){
		System.out.print(
						"□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n\n"
						+"                                    🍽️ 오늘 뭐먹지? 🍽️ \n"
						+" □ 평점기준                   \n"
						+" □ 리뷰수기준             1. \n"
						+" □ 거리기준                2. \n"
						+" □ 검색                      3.  \n"
						+" □ 도시락주문             4. \n"
						+" □ 로그인                   5. \n"
						+" □ 고객센터                                             (2)↓ (5)↑ (⏎)확인\n"
						+"□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■");

	}
	static public void boardbase1(){
		System.out.println("\n\n□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n");
		System.out.println("                                    🍽️ 오늘 뭐먹지? 🍽️");
		System.out.println("\n\n");
	}
	static public void boardbase2(){
		System.out.println("\n\n");
		System.out.println("                                     (⏎)확인 ");
		System.out.print("□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■\n> ");
	}
}
