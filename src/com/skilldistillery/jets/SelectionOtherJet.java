package com.skilldistillery.jets;

public class SelectionOtherJet extends Jets implements anotherJetType {
	public SelectionOtherJet(String _model, double _speed, long _price, int _range) {
		super(_model, _speed, _price, _range);
	}
	
	public void welcomeAboard() {
		System.out.println("Great Selection. WELCOME ABOARD!");
	}
}
