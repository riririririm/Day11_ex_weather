package com.rim.weather;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.crypto.AEADBadTagException;

public class WeatherInit {

	private Scanner sc = new Scanner(System.in);
	static String info;

	public WeatherInit() {
		info = "seoul,맑음,10,20,0.3,daejon,비,-22,50,0.1," + "incheon,태풍,56,90,22.2,jeju,흐림,15,10,1.2";
	}

	public ArrayList<Weather> getWeathers() {
		ArrayList<Weather> weathers = new ArrayList<Weather>();
		
		StringTokenizer st = new StringTokenizer(info);
		while(st.hasMoreTokens()) {
			Weather weather = new Weather();
			weather.setCity(st.nextToken().trim());
			weather.setState(st.nextToken().trim());
			weather.setGion(Integer.parseInt(st.nextToken().trim()));
			weather.setHum(Integer.parseInt(st.nextToken().trim()));
			weather.setMise(Double.parseDouble(st.nextToken().trim()));
			weathers.add(weather);
			
		}
//		String[] str = info.split(",");
//		for (int i = 0; i < str.length; i++) {
//			Weather w = new Weather();
//			w.setCity(str[i]);
//			w.setState(str[++i]);
//			w.setHum(Integer.parseInt(str[++i]));
//			w.setGion(Integer.parseInt(str[++i]));
//			w.setMise(Double.parseDouble(str[++i]));
//			weathers.add(w);
//		}

		return weathers;

	}

	public Weather setWeather() {
		Weather w = new Weather();

		System.out.println("도시:");
		w.setCity(sc.next());
		System.out.println("날씨:");
		w.setState(sc.next());
		System.out.println("습도:");
		w.setHum(sc.nextInt());
		System.out.println("온도:");
		w.setGion(sc.nextInt());
		System.out.println("미세먼지:");
		w.setMise(sc.nextDouble());

		return w;
	}

	public Weather findWeather(ArrayList<Weather> weathers) {
		System.out.println("검색할 도시:");
		String city = sc.next();
		
		Weather w = null;
		for(int i=0;i<weathers.size();i++) {
			if(city.equals(weathers.get(i).getCity())){

				w=weathers.get(i);
			}
		}
				
		return w;
	}

	public String deleteWeather(ArrayList<Weather> weathers) {
		System.out.println("삭제할 도시:");
		String city = sc.next();
		String result ="없는 도시명";
		
		Weather w = new Weather();
		for(int i=0;i<weathers.size();i++) {
			if(city.equals(weathers.get(i).getCity())) {
				weathers.remove(i);
				result="삭제완료";
				break;
			}
		}
		
		return result;

	}
}
