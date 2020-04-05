package com.skilldistillery.jets;

public class JetFighter extends Jets implements FighterJet {
	public boolean hasMissiles;
	
	public JetFighter() {
	}
	
	public JetFighter(String _model, double _speed, long _price, int _range, boolean _hasMissiles) {
		super(_model, _speed, _price, _range);
		this.hasMissiles = _hasMissiles;
	}
	
	@Override 
	public void fight() {
		if(this.hasMissiles = true) {
			loadingMissiles();
			System.out.println(this.getModel() + " is ready to DOGFIGHT!");
			
		}
		
	}
	
	@Override
	public void loadingMissiles() {
		this.hasMissiles = true;
		System.out.println(this.getModel() +" missiles are loaded! ");
	}
	
	
}
