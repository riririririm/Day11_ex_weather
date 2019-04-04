package com.rim.member;

import java.util.HashMap;
import java.util.Scanner;

public class MemberController {

	private Scanner sc;
	MemberInit mi;
	MemberView mv;
	HashMap<String, Member> map;
	boolean login_status = false;

	public MemberController() {
		sc = new Scanner(System.in);
		mi = new MemberInit();
		mv = new MemberView();

	}

	public void start() {
		map = mi.setMember();

		while (true) {
			if (login_status == false) {//로그아웃 상태면 실행
				System.out.println("1.회원가입  2.로그인  3.종료");
				int select = sc.nextInt();

				if (select == 1) {
					Member m = mi.memberJoin();
					map.put(m.getId(), m);

				} else if (select == 2) {
					Member m = mi.memberLogin(map);
					if(m!=null)login_status=true; //로그인 했으니까 상태를  true로

				} else if (select == 3) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("1~3중에 선택하세요");
				}
			}else {//로그인 상태면 실행
				System.out.println("1.로그아웃  2.회원탈퇴  3.회원전체정보  4.종료");
				int select = sc.nextInt();

				if (select == 1) {
					System.out.println("로그아웃함");
					login_status=false; //로그아웃 했으니까 상태를 false로

				} else if (select == 2) {
					String result = mi.memberDelete(map);
					mv.view(result);

				} else if (select == 3) {
					if (map.size() > 0)
						mv.view(map);
					else
						System.out.println("등록된 회원이 아직 없습니다");

				} else if (select == 4) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("1~5중에 선택하세요");
				}
			}
		}
	}

}
