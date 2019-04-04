package com.rim.weather;

import java.util.ArrayList;

public class WeatherView {

	public void view(ArrayList<Weather> weathers) {
		
		for(int i=0;i<weathers.size();i++) {
			Weather w = weathers.get(i);
			System.out.println("[도시:"+w.getCity()+"]");
			System.out.println("날씨:"+w.getState());
			System.out.println("습도:"+w.getHum());
			System.out.println("온도:"+w.getGion());
			System.out.println("미세먼지:"+w.getMise());
			System.out.println("---------------------");
		}
		
	}
	
	public void view(Weather w) {
		System.out.println("[도시:"+w.getCity()+"]");
		System.out.println("날씨:"+w.getState());
		System.out.println("습도:"+w.getHum());
		System.out.println("온도:"+w.getGion());
		System.out.println("미세먼지:"+w.getMise());
		System.out.println("---------------------");
	}
	
	public void view(String str) {
		System.out.println(str);
	}
}
