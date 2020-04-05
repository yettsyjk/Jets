package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	
	public static void main(String[] args) {
		JetsApplication jsa = new JetsApplication();
		Scanner sc = new Scanner(System.in);	 
		
		CargoFreight cargoFreight;
		JetFighter fighterjet;
		JetsImpl anyOtherJet;
		
		jsa.launch(jsa, sc);
	}

	public void launch(JetsApplication jsa, Scanner sc) {
		AirField flightDeck = new AirField();
		setupAirField(flightDeck);
		
		boolean keepGoing = true;
		int choice = 0;
		System.out.println("Welcome to Air Ops: \nCurrently sky condition is clear and flight deck is hot.");
		System.out.println("Press Enter For Menu Options");
		sc.nextLine();
		
		while(keepGoing == true) {
			displayMenu();
			System.out.println();
			

			if (sc.hasNextLine()) {
				choice = sc.nextInt();
				keepGoing = true;
			} else {
				System.out.println("Invalid Entry.");
				keepGoing = false;
			}
			System.out.println();
		

			switch (choice) {
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
				AddJetToFleet(flightDeck, sc);
				break;
			case 8:
				RemoveAJetFromFleet(flightDeck, sc);
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
	
	public static void setupAirField(AirField flightDeck) {
		
		BufferedReader bufIn = null;
		// try catch block with resources will close the scanner
		try {
			
		bufIn = new BufferedReader(new FileReader("Test.txt"));
			String line;
			
			while ((line = bufIn.readLine()) != null) {
				
				String[] selections = line.split(",");
				
				//String type = selections[0];
				if (selections[0].equals("CargoFreight")) {
					String model = selections[1];

					double speed = Double.parseDouble(selections[2].trim());
					long price = Long.parseLong(selections[3].trim());
					int range = Integer.parseInt(selections[4].trim());
					boolean anotherField = Boolean.parseBoolean(selections[5].trim());
					
					
					CargoFreight cargoFreight = new CargoFreight(model, speed, price, range, anotherField);
					flightDeck.getListOfJets().add(cargoFreight);
					//flightDeck.addJet(cargoFreight);
				}
				else if (selections[0].equals("FighterJet")) {
					String model = selections[1];
					double speed = Double.parseDouble(selections[2].trim());
					long price = Long.parseLong(selections[3].trim());
					int range = Integer.parseInt(selections[4].trim());
					boolean anotherField = Boolean.parseBoolean(selections[5].trim());
					
					JetFighter fighterjet = new JetFighter(model, speed, price, range, anotherField);
					flightDeck.getListOfJets().add(fighterjet);
					//flightDeck.addJet(fighterjet);
				}
				else if(selections[0].equals("anyOtherJet")) {
					String model = selections[1];
					double speed = Double.parseDouble(selections[2].trim());
					long price = Long.parseLong(selections[3].trim());
					int range = Integer.parseInt(selections[4].trim());
					boolean anotherField = Boolean.parseBoolean(selections[5].trim());
					
					JetsImpl anyOtherJet = new JetsImpl();
					flightDeck.getListOfJets().add(anyOtherJet);
				}

			}
		} catch (FileNotFoundException e) {
			System.err.println("Invalid File Name "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Issue with File: "+e.getMessage());
		}
		finally {
			if(bufIn != null) {
				try {
					bufIn.close();
				} catch(IOException e)  {
					System.err.println(e);
				}
			}
		}
		
	}

	public static void displayMenu() {
		System.out.println("|----------------------------------------------|");
		System.out.println("|--------------- Air Operations ---------------|");
		System.out.println("|---------------- Pensacola, FL ---------------|");
		System.out.println("|------------------- MENU ---------------------|");
		System.out.println("|----------------------------------------------|");
		System.out.println("|1) Press 1 to List Fleet                      |");
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

	// menu option 1
	private static void listFleet(AirField flightDeck) {
	System.out.println("List Fleet: ");	
	System.out.println();
	System.out.println("Cargo Freight:");
		for (Jets jets : flightDeck.getListOfJets()) {
			System.out.println(jets.toString());
		}
		
		//three for each loops for three jet types Cargo Freight, Jet Fighter, Any Other Jet 
	}

	// menu option 2
	private static void FlyAllJets(AirField flightDeck) {
		for (Jets jets : flightDeck.getListOfJets()) {
			jets.fly();// println didn't compile
		}
	}

	// menu option 3
	private static void ViewFastestJet(AirField flightDeck) {
		Jets fastestJet = new JetFighter();
		fastestJet.setSpeed(52.0);
		for (Jets individualJet : flightDeck.getListOfJets()) {
			if (individualJet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = individualJet;
			}

		}
		System.out.println(fastestJet.toString() + "\n Converted to Mach Speed: " + fastestJet.getSpeedOfJetInMach());

	}

	// menu option 4
	private static void JetLongestRange(AirField flightDeck) {
		Jets longRangeJet = new JetFighter();
		
		longRangeJet.setRange(52);
		for (Jets individualJet : flightDeck.getListOfJets()) {
			if (individualJet.getRange() > longRangeJet.getRange()) {
				longRangeJet = individualJet;
			}
		}
		System.out.println(longRangeJet.toString());
	}

	// menu option 5
	private static void LoadAllCargoJets(AirField flightDeck) {
		for (Jets individualJet : flightDeck.getListOfJets()) {
			if (individualJet instanceof CargoFreight) {
				((CargoFreight) individualJet).loadCargo();
			}
		}
	}

	// menu option 6
	private static void DogFight(AirField flightDeck) {
		for (Jets individualJet : flightDeck.getListOfJets()) {
			if (individualJet instanceof JetFighter) {
				((JetFighter) individualJet).fight();
			}
		}
	}

	// menu option 7
	private static void AddJetToFleet(AirField flightDeck, Scanner sc) {
		System.out.println("Adding Jet to Flight Deck Roster   ");
		System.out.println("1) Press 1 for CargoFreight Jet    ");
		System.out.println("2) Press 2 for Fighter Jet         ");
		System.out.println("3) Press 3 for Any Other Jet       ");
		System.out.println("4) Press 4 to Quit                 ");
		int choice = sc.nextInt();

		if (choice == 1) {
			CargoFreight acf = new CargoFreight();
			flightDeck.addJet(jetAddSetOfJet(acf, sc));

		} else if (choice == 2) {
			JetFighter ajf = new JetFighter();
			flightDeck.addJet(jetAddSetOfJet(ajf, sc));

		} else if (choice == 3) {
			JetsImpl anyOtherJet = new JetsImpl();
			flightDeck.addJet(jetAddSetOfJet(anyOtherJet, sc));

		} else if (choice == 4) {
			System.out.println("See You Next Time");
		} else {
			System.out.println("Hmm, your choice seems to be invalid.");
		}

	}

	// menu option 8
	private static void RemoveAJetFromFleet(AirField flightDeck, Scanner sc) {
		System.out.println("Whoa! SEC is here and they want a list of all current flight deck visitors. \nWhich Jet will you remove from the flight deck roster? ");
		for (int individualJet = 0; individualJet < flightDeck.getListOfJets().size(); individualJet++) {
			System.out.println("Printed Roster: [ " + individualJet + "  "
					+ flightDeck.getListOfJets().get(individualJet).getModel() + " ] ");
			
		}
		int choice = sc.nextInt();

		switch (choice) {
		case 0:
			flightDeck.removeJet(choice);
			break;
		case 1:
			flightDeck.removeJet(choice);
			break;
		case 2:
			flightDeck.removeJet(choice);
			break;
		case 3:
			flightDeck.removeJet(choice);
			break;
		case 4:
			flightDeck.removeJet(choice);
			break;
		case 5:
			flightDeck.removeJet(choice);
			break;
		case 6:
			flightDeck.removeJet(choice);
			break;
		case 7:
			flightDeck.removeJet(choice);
			break;
		case 8:
			flightDeck.removeJet(choice);
			break;
		case 9:
			flightDeck.removeJet(choice);
			break;
		default:
			System.out.println("Invalid Choice");
		}

	}

	private static Jets jetAddSetOfJet(Jets lineUp, Scanner sc) {
//		System.out.println("Enter Type of Jet: \n(Cargo Freight, Fighter Jet, Hot Air Balloon, Drone, Private Jet etc) ");
//		lineUp.setType(sc.next());
		
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

//	private static void addJet(AirField flightDeck, Scanner sc) {
//		System.out.println("Let the Tower Know Jet Type Adding to Flight Deck.");
//		System.out.println("Select Style of Jet to Add to Flight Deck: ");
//		System.out.println("1) Press 1 for CargoFreight \n 2) Press 2 for Private Jet \n 3) Press 3 for Economy Jet  ");
//		int userInput = sc.nextInt();
//
//		if (userInput == 1) {
//			CargoFreight jetType = new CargoFreight();
//			flightDeck.addJet(jetAddSetOfJet(jetType, sc));
//
//		} else if (userInput == 2) {
//			JetFighter jetType = new JetFighter();
//			flightDeck.addJet(jetAddSetOfJet(jetType, sc));
//
//		} else if (userInput == 3) {
//			JetsImpl jetType = new JetsImpl();
//			flightDeck.addJet(jetAddSetOfJet(jetType, sc));
//
//		} else {
//			System.out.println("Invalid Entry on the Flight Deck");
//		}
//	}

	

}
