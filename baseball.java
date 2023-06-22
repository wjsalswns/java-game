package chap07;

import java.util.Scanner;

public class BaseBall1 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			// 변수
			// 랜덤으로 뽑은 3자리의 수를 저장하기 위한 배열 randimNum 생성
			int[] randomNum = new int[3];
			
			// 유저가 입력한 수를 저장하기 위한 배열 userNum 생성
			int[] userNum = new int[3];
			
			// 스트라이크와 볼의 갯수를 저장하기 위한 변수
			int strike = 0;
			int ball = 0;
			
			// 시도 횟수를 알려주는 변수
			int cnt = 0;
			
			// 1단계 : randomNum에 반복문을 이용하여 3개의 수를 할당 (1~9)
			// 2단계 : 입력받은 수 3개가 서로 다른 정수여야 한다
			for (int i=0; i<randomNum.length; i++) {
				randomNum[i] = (int)(Math.random() * 9) + 1;
				for (int j=0; j<i; j++) {
					if (randomNum[j] == randomNum[i]) {
						i--;
						break;
					}
				}
			}
			
			while (true) {
				cnt++;
			
//				for (int num : randomNum) {
//					System.out.print(num + " ");
//				}
//				System.out.println();
				
				// user의 입력값 처리
				for (int i=0; i<userNum.length; i++) {
					System.out.print((i+1) + "번째 수를 입력하세요. >> ");
					userNum[i] = sc.nextInt();
					for (int j=0; j<i; j++) {
						if (userNum[j] == userNum[i]) {
							i--;
							break;
						}
					}
				}
			
				// randimNum와 userNum를 비교하는 코드
				// 3칸짜피 배열 randomNum와 userNum를 비교하는데
				// 전체를 비교하면서 같은 숫자가 있는지 확인
				// 같은 숫자가 있다 -> 인덱스 값도 같은지 확인
				// 인덱스 값까지 같으면 -> 스트라이크
				// 같은 숫자는 있는데 인덱스 값이 다르면 -> 볼
				for (int k=0; k<3; k++) {
					for (int j=0; j<3; j++) {
						if (randomNum[k] == userNum[j]) {
							if (k == j) {
								strike++;
								break;
							} else {
								ball++;
								break;
							}
						}
						
					}
				}

				// 비교한 결과를 안내해주는 문구
				System.out.println(strike + "스트라이크, " + ball + "볼");
				System.out.println();
				
				// 정답을 맞추었울 때 무한루프를 벗어나는 코드
				if (strike == 3) {
					System.out.println(cnt + "회 시도하고 정답.");
					break;
				} else {
					System.out.println(cnt + "회 시도. 다시 맞춰보세요.");
					strike = 0;
					ball = 0;
				}
					
				

			}
																							
																																						
																								
	}
}

