package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	//create ArrayList to hold empty field location for Jets to park
	private List<Jets> listOfJets = new ArrayList<>();
	
	//create a no arg constructor to avoid the default
	public void Airfield() {
		
	}
	
	//listOfJets is a private ArrayList, provide a get() to access ListOfJets in other classes
	public List<Jets> getListOfJets(){
		return listOfJets;
	}
	
	//TODO populate airfield with at least 5 different Jets
}
