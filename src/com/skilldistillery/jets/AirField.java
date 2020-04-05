package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	Scanner sc = new Scanner(System.in);
	//create ArrayList to hold empty field location for Jets to park
	private List<Jets> listOfJets = new ArrayList<>();
	
	//create a no arg constructor to avoid the default
	public void Airfield() {	
		listOfJets = new ArrayList<>();
		
	}
	
	public void addJet(Jets styleOfJet) {
		this.listOfJets.add(styleOfJet);
	}
	
	public void removeJet(int idx) {
		this.listOfJets.remove(idx);
	}
	
	//listOfJets is a private ArrayList, provide a get() to access ListOfJets in other classes
	public List<Jets> getListOfJets(){
		return listOfJets;
	}
	
	
}
