package com.rim.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberView {

	public void view(HashMap<String, Member> map) {
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			Member m= map.get(it.next());
			view(m);
		}
	}
	
	public void view(Member m) {
		System.out.println("[ID]"+m.getId());
		System.out.println("PW:"+m.getPw());
		System.out.println("이름:"+m.getName());
		System.out.println("나이:"+m.getAge());
		System.out.println("level:"+m.getLevel());
		System.out.println("===========================");
	}
	
	public void view(String str) {
		System.out.println(str);
	}
}
