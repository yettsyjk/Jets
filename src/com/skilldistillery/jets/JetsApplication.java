package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication jsa = new JetsApplication();
		Scanner sc = new Scanner(System.in);

		launch(jsa, sc);
	}

	private static void launch(JetsApplication jsa, Scanner sc) {
		AirField flightDeck = new AirField();
		boolean keepGoing = true;
		int choice = 0;
		System.out.println("Welcome to Air Ops, sky condition is clear and flight deck is hot.");
		
		
		while(keepGoing == true) {
			System.out.println();
			displayUserMenu();
			
			if(sc.hasNextLine()) {
				choice = sc.nextInt();
				keepGoing = true;
			} else {
				System.out.println("Invalid Entry.");
				keepGoing = false;
			}
			System.out.println();
		
		
		switch(choice) {
		case 1: 
			listFleet(flightDeck);
			break;
		case 2: 
			FlyAllJets(flightDeck);
			break;
		case 3: 
			ViewFastestJet(flightDeck);
			break;
		case 4: 
			JetLongestRange(flightDeck);
			break;
		case 5: 
			LoadAllCargoJets(flightDeck);
			break;
		case 6: 
			DogFight(flightDeck);
			break;
		case 7: 
			AddJetToFleet(flightDeck);
			break;
		case 8: 
			RemoveAJetFromFleet(flightDeck);
			break;
		case 9: 
			keepGoing = false;
			break;
		default: 
			keepGoing = false;
			break;
		}
	}
		
	}
	
	public static void displayUserMenu() {
		System.out.println("|----------------------------------------------|");
		System.out.println("|---------------- Air Operations --------------|");
		System.out.println("|------------------ Pensacola, FL -------------|");
		System.out.println("|--------------------- MENU -------------------|");
		System.out.println("|1) Press 1 for List Fleet                     |");
		System.out.println("|2) Press 2 to Fly All Jets                    |");
		System.out.println("|3) Press 3 to View Fastest Jet                |");
		System.out.println("|4) Press 4 to View Jet with Longest Range     |");
		System.out.println("|5) Press 5 to Load All Cargo Jets             |");
		System.out.println("|6) Press 6 to Dogfight!                       |");
		System.out.println("|7) Press 7 to Add A Jet to Fleet              |");
		System.out.println("|8) Press 8 to Remove a Jet from Fleet         |");
		System.out.println("|9) Press 9 to Quit                            |");
		System.out.println("|----------------------------------------------|");
	}
	

	private static Jets jetAddSetOfJet(Jets lineUp, Scanner sc) {
		System.out.println("Enter Model of Jet: ");
		lineUp.setModel(sc.next());

		System.out.println("Enter Speed of Jet (in Mph): ");
		lineUp.setSpeed(sc.nextDouble());

		System.out.println("Enter Purchase Price of Jet: ");
		lineUp.setPrice(sc.nextLong());

		System.out.println("Enter Flight Range of Jet: ");
		lineUp.setRange(sc.nextInt());

		System.out.println(lineUp.toString());
		
		return lineUp;
	}

	private static void addJet(AirField flightDeck, Scanner sc) {
		System.out.println("Let the Tower Know Jet Type Adding to Flight Deck.");
		System.out.println("Select Style of Jet to Add to Flight Deck: ");
		System.out.println("1) Press 1 for CargoFreight \n 2) Press 2 for Private Jet \n 3) Press 3 for Economy Jet  ");
		int userInput = sc.nextInt();

		if (userInput == 1) {
			CargoFreight jetType = new CargoFreight();
			flightDeck.addJet(jetAddSetOfJet(jetType, sc));
		
		} else if (userInput == 2) {
			JetFighter jetType = new JetFighter();
			flightDeck.addJet(jetAddSetOfJet(jetType, sc));
		
		} else if (userInput == 3) {
			JetsImpl jetType = new JetsImpl();
			flightDeck.addJet(jetAddSetOfJet(jetType, sc));
		
		} else {
			System.out.println("Invalid Entry on the Flight Deck");
		}
	}

	private static void setupAirField(AirField flightDeck) {
		// try catch block with resources will close the scanner
		try (BufferedReader br = new BufferedReader(new FileReader("manifest.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] selections = line.split(",");
				if (selections[0].equals("CargoFreight")) {
					String model = selections[1];

					double speed = Double.parseDouble(selections[2].trim());
					long price = Long.parseLong(selections[3].trim());
					int range = Integer.parseInt(selections[4].trim());
					boolean anotherField = Boolean.parseBoolean(selections[5].trim());
					CargoFreight anotherCargoFreight = new CargoFreight(model, speed, price, range, anotherField);
					flightDeck.addJet(anotherCargoFreight);
				}
				if (selections[0].equals("FighterJet")) {
					String model = selections[1];

					double speed = Double.parseDouble(selections[2].trim());
					long price = Long.parseLong(selections[3].trim());
					int range = Integer.parseInt(selections[4].trim());
					boolean anotherField = Boolean.parseBoolean(selections[5].trim());
					JetFighter anotherFighterJet = new JetFighter(model, speed, price, range, anotherField);
					flightDeck.addJet(anotherFighterJet);
				}
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
