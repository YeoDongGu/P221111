package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean eq;
		int[] ar = new int[3];
		int stCount = 0;		
		int ballCount = 0;
		
		
		// 난수를 입력하는 for 문
		for (int i = 0; i < ar.length; i++) { 		// ar[0] , ar[1] ,ar[2] 에 랜덤한 난수를 입력하는 for문
			ar[i] = (int) (Math.random() * 10); 	//
			for (int j = 0; j < i; j++) { 			// 중복된 난수가 입력되는것을 피하기위해서 for문 안에 for문을 넣어
				if (ar[i] == ar[j]) { 				// ar[i] 와 ar[j] 를 비교해본다 ->> ar[0] 과 ar[0] 을비교 ,ar[1] 과 ar[0] ,ar[1] 을비교, ar[2]와
													// ar[0], ar[1] , ar[2] 를 비교
					i--; 							// 같은값이 있다는 사실이 발견되면 i를 감소 시켜서 break 해준다
					break; 							// -> i를 1감소시켜서 for문으로 돌아가기 때문에 중복된 값이 들어간 배열의 공간에 다른 수를 다시 입력한다.
				}
			}
		} // 난수 입력 for문 끝

//		
//		do {
//			eq = false;
//			for(int i =0; i < ar.length; i++) {
//				ar[i] = (int)(Math.random()*10);						//난수 설정하는 다른방법
//			}															//
//			
//			if(ar[0] ==ar[1] || ar[1] == ar[2] || ar[2] == ar[0]) {
//				eq = true;
//			}
//		}while(eq);
//		
//		
		
		while (true) {

			System.out.print(Arrays.toString(ar)); // 프로그램이 잘 돌아가는지 확인하기 위해 테스트용으로 정답을 출력
			System.out.println("숫자 3개를 입력하세요:");

			//for 문을 통해 숫자를 입력했을떄 Strike가 몆번이고 ball 이 몆번인지 정하는 부분
			for (int i = 0; i < ar.length; i++) {						
				int inp = sc.nextInt();			//스캐너 nextInt로 숫자를 입력						
				if (inp == ar[0] || inp == ar[1] || inp == ar[2]) {	//if 문을 사용해서 만약 입력한 숫자가 배열 ar[] 에 있는 숫자중 하나라도 같다면	
					if (inp == ar[i]) {								// ballCount를 후치증가해준다 하지만 그전에 if문을 통해	
						stCount++;									// 내가 입력한 inp 값이 ar[i] 와 같다면 숫자도 같고 내가 입력한 순번과 배열
						continue;									// ar[] 에 있는 숫자의 위치도 같기 때문에 stCount 를 올려주고 continue 구문을 통해	
					}												// 밑에있는 ballCount++ 부분을 넘기고 다시 for문 으로 돌아간다.
					ballCount++;
				}
			}

			if (ballCount == 0 && stCount == 0) {				//BallCount 와 stCount 가 둘다 0이라면 스트라이크와 볼이 하나도 없기때문에 OUT 출력
				System.out.println("OUT");						
			}
			if ((stCount >= 1 || ballCount >= 1) && stCount !=3) {				//둘중 하나라도 1이상이라면 스트라이크와 볼 갯수 출력
				System.out.printf("%d Strike %d Ball\n", stCount, ballCount);
			}
			if (stCount == 3) {									//stCount 가 3이라면 3스트라이크 이므로 정답을 출력
				System.out.print("정답입니다!");
				break;											//정답을 맞췄기 때문에 다시 while 시작점으로 가면 안돼기 때문에 break; 문으로 종료
			}
			stCount = 0;					//정답을 못맞출시 다시 while문 첫번째로 돌아가야 하기때문에 
			ballCount = 0;					//이미 올라간 stCount 와 ballCount를 0으로 초기화 해주어야한다
		}
		sc.close();
	}
}