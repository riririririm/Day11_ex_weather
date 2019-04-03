package com.rim.weather;

import java.util.ArrayList;
import java.util.Scanner;

public class WeatherController {
	private Scanner sc;
	private ArrayList<Weather> weathers;
	WeatherInit init;
	WeatherView view;
	
	public WeatherController() {
		sc = new Scanner(System.in);
		weathers = new ArrayList<Weather>();
		init = new WeatherInit();
		view = new WeatherView();
	}
	
	public void start() {
		 weathers=init.getWeathers();
		
		while(true) {
			System.out.println("1.날씨입력 2.날씨출력 3.end");
			int select = sc.nextInt();
			
			if(select==1) {
				weathers.add(init.setWeather());
				
			}else if(select==2) {
				view.view(weathers);
				
			}else if(select==3)
				break;
		}
		
	
		
	}
	

}
