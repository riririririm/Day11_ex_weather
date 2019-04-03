package com.rim.weather;

public class Weather {

	// 맑음, 온도, 습도, 미세먼지, 도시명
		private String state;
		private int gion;
		private int hum;
		private double mise;
		private String city;
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getGion() {
			return gion;
		}
		public void setGion(int gion) {
			this.gion = gion;
		}
		public int getHum() {
			return hum;
		}
		public void setHum(int hum) {
			this.hum = hum;
		}
		public double getMise() {
			return mise;
		}
		public void setMise(double mise) {
			this.mise = mise;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		
		
		
}
