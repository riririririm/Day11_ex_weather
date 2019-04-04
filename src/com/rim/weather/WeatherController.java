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
		weathers = init.getWeathers();

		while (true) {
			System.out.println("1.날씨입력 2.날씨출력 3.날씨검색 4.날씨삭제 5.종료");
			int select = sc.nextInt();

			if (select == 1) {
				weathers.add(init.setWeather());
			} else if (select == 2) {
				view.view(weathers);
			} else if (select == 3) {
				Weather w = init.findWeather(weathers);
				if(w!=null)
					view.view(w);
				else
					System.out.println("찾는 도시가 없음");
			} else if (select == 4) {
				String result =init.deleteWeather(weathers);
				view.view(result);
			}
			else if (select == 5)
				break;
		}

	}

}
