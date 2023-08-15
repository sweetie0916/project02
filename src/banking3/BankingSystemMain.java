package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	
	/*
	원래 기능구현한 함수들 여기 있었음 -> AccountManager.java 이동
	*/
	public static void main(String[] args) {
		
		//인스턴스 생성
		AccountManager accMgr = new AccountManager();
		
		boolean run = true;
		
		// 사용자가 종료할때까지 프로그램은 실행이 유지되어야 한다.
		while(run) {
			// 메뉴 출력
			accMgr.showMenu(); 
			
			try {
				// 내가 입력하는 변수
				int keyInput = accMgr.scan.nextInt();
				// 버퍼 날림
				accMgr.scan.nextLine();
				
				// 조건식 - MAKE(1)을 선택했을때 (== 같다, = 대입)=> 계좌개설 함수 실행
				if(keyInput == ICustomDefine.MAKE) {
					System.out.println("***신규계좌개설***");
					//계좌개설 함수 실행
					accMgr.makeAccount();
					
				}
				// 조건식 - DEPOSIT(2)을 선택했을때 => 입금 함수 실행
				else if(keyInput == ICustomDefine.DEPOSIT) {
					System.out.println("***입   금***");
					//입금 함수 실행
					accMgr.depositMoney();
					
				}
				// 조건식 - WITHDRAW(3)을 선택했을때 => 출금 함수 실행
				else if(keyInput == ICustomDefine.WITHDRAW) {
					System.out.println("***출   금***");
					//출금 함수 실행
					accMgr.withdrawMoney();
					
				}
				// 조건식 - INQUIRE(4)을 선택했을때 => 계좌정보출력 함수 실행
				else if(keyInput == ICustomDefine.INQUIRE) {
					System.out.println("***계좌정보출력***");
					//계좌정보출력 함수 실행
					accMgr.showAccInfo();
				
				}
				// 조건식 - EXIT(5)을 선택했을때 => 프로그램 종료
				else if(keyInput == ICustomDefine.EXIT) {
					//프로그램 종료
					run = false; 
				}
				else {
					throw new MenuSelectException();
				}
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				// 숫자말고 문자를 입력할때 예외처리 해라 - InputMismatchException
				System.out.println("문자를 입력할 수 없습니다.");
				accMgr.scan.nextLine();
			}
			
			
			
			
			
		}
		System.out.println("프로그램 종료");
	}
}
