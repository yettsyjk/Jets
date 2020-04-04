package com.skilldistillery.jets;

public class CargoFreight extends Jets implements FreightAircraft{
	
	public boolean hasCargo;
		
	public CargoFreight() {
	}
	
	public CargoFreight(String _model, Integer _speed, long _price, int _range, boolean _hasCargo ) {
		super(_model, _speed, _price, _range);
		hasCargo = _hasCargo;
	}
	
	@Override
	public void loadCargo() {
		this.hasCargo = true;
		System.out.println("Status: [ "+ this.getModel()+ " is loading] ");
	}
	
	@Override
	public void emptyCargo() {
		this.hasCargo = false;
		System.out.println("Status: [ "+ this.getModel()+ " is empty] ");
	}
	
	public void setHasCargo(boolean _hasCargo) {
		this.hasCargo = _hasCargo;
	}
	
	
	
}
