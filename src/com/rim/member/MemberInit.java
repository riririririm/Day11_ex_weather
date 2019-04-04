package com.rim.member;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberInit {
	private String members;
	private Scanner sc;

	public MemberInit() {
		sc = new Scanner(System.in);

		StringBuffer sb = new StringBuffer();
		sb.append("ru, ru, ru, 26, 1,");
		sb.append("su, su, su, 26, 2,");
		sb.append("to, to, to, 26, 2,");
		sb.append("na, na, na, 26, 0");

		members = sb.toString();
	}

	// 키 id value member.
	// 리턴은 멤버들 Map
	public HashMap<String, Member> setMember() {
		HashMap<String, Member> map = new HashMap<String, Member>();

		StringTokenizer st = new StringTokenizer(members, ",");
		while (st.hasMoreTokens()) {
			Member m = new Member();
			m.setId(st.nextToken().trim());
			m.setPw(st.nextToken().trim());
			m.setName(st.nextToken().trim());
			m.setAge(Integer.parseInt(st.nextToken().trim()));
			m.setLevel(Integer.parseInt(st.nextToken().trim()));
			map.put(m.getId(), m);
		}
		return map;

	}

	public Member memberJoin() {
		Member m = new Member();

		System.out.println("****회원가입****");
		System.out.println("ID:");
		m.setId(sc.next());
		System.out.println("PW:");
		m.setPw(sc.next());
		System.out.println("이름:");
		m.setName(sc.next());
		System.out.println("나이:");
		m.setAge(Integer.parseInt(sc.next()));
		System.out.println("LEVEL:");
		m.setLevel(Integer.parseInt(sc.next()));

		return m;
	}

	public Member memberLogin(HashMap<String, Member> map) {
		String id = null;
		String pw = null;
		Member m = null;

		System.out.println("****로그인****");
		System.out.println("ID:");
		id = sc.next();
		System.out.println("PW:");
		pw = sc.next();

		if (map.size() > 0 && map.containsKey(id)) { 
			//등록된 회원이 존재하고 입력한 id가 등록된 회원들중에 존재하는 경우
			if (id.equals(map.get(id).getId()) && pw.equals(map.get(id).getPw())) {
				//아이디와 비밀번호가 등록되어있는 정보와 일치하면
				m = map.get(id);
				System.out.println("로그인 성공!!");
			} else
				//아이디 혹은 비밀번호가 일치하지 않으면
				System.out.println("회원정보가 다름");
		} else //등록된 회원이 한명도 없거나 입력한 id가 등록된 회원정보맵에 존재하지 않는 경우
			System.out.println("등록된 회원 없음");

		return m;
	}

	public String memberDelete(HashMap<String, Member> map) {
		String result = "회원정보 불일치로 탈퇴할 수 없음";

		System.out.println("****회원탈퇴****");
		System.out.println("탈퇴할 회원 ID:");
		String id = sc.next();
		System.out.println("탈퇴할 회원 PW:");
		String pw = sc.next();

		if (map.containsKey(id)) { //등록된 회원정보에 입력한 id회원이 존재하면
			if (id.equals(map.get(id).getId()) && pw.equals(map.get(id).getPw())) {
				//아이디와 비밀번호가 등록정보와 일치하면 탈퇴
				result = "탈퇴했습니다.";
				map.remove(id);
			}//일치하지 않으면 "불일치로 탈퇴 불가" 안내
		}else {//입력한 아이디의 회원이 등록된 회원에 없다면
			result="존재하지 않는 회원입니다.";
		}

		return result;
	}
}
