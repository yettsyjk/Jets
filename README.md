# Jets
 - Jets Application created by Software Developer Yettsy Jo Knapp. Denver, CO.
## Application Overview
- I will create a fleet of jets with different capabilities.
- My application will be a menu to use your jets and access information about them.

## Structure for Jets is an Abstract Class
- model
- speed
- range
- price

## UML Diagram

## User Story #1
  - Create a JetsApplication with a main method to launch your program.
## User Story #2
  - Jets are found at an AirField. Create the AirField class, which has an empty List of Jets.
## User Story #3
  - On program startup, populate the AirField with at least 5 Jets of different types.

  - These jets must be read from a text file, where each line in the file contains data for a single Jet object.

  - This file exists at the root of your Eclipse project. It can be comma- or tab-separated; either implementation is acceptable.
  - The method to parse a file into Jet objects should return a List<Jet>. Its parameter can be a String file name.
  - Remember to use String.split(regex) to break each line in the file into data to create an individual jet.
## User Story #4
- There is a menu with these options:

1. List fleet
2. Fly all jets
3. View fastest jet
4. View jet with longest range
5. Load all Cargo Jets
6. Dogfight!
7. Add a jet to Fleet
8. Remove a jet from Fleet
9. Quit
## User Story #5
  - List fleet prints out the model, speed, range, and price of each jet. (There must be at least 5 jets stored when the program starts).
## User Story #6
 - Fly all Jets calls the fly() method on the entire fleet of jets. fly() prints out the jet details and the amount of time the jet can fly until it runs out of fuel (based on speed and range).
## User Story #7
- The view fastest jet and longest range options both print out all of the information about a jet.

    - Note: these methods must search the collection of jets to find the appropriate jet.
## User Story #8
- The user is presented with an option specific to the interfaces you created. For example, Load all Cargo Jets, above, finds all implementors of the CargoCarrier interface and calls loadCargo() on each. (Note that the menu text is italicized because your options may be different, depending on your interfaces.)
## User Story #9
  - A user can add custom jets to the fleet.

    - This can be a JetImpl.
    - Stretch Goal: This leads to a sub-menu where the user chooses the type of Jet.
- Users then enter information for the Jet, and it is added to the AirField.

## User Story #10
  - A user can remove a jet from the fleet.

    - The user is presented with a sub-menu to select a jet to delete by number.
    - Stretch Goal: a user can remove a jet (or jets) by name.
____________________________
# Stretch Goals
## User Story #11
    - Quit exits the program.

## User Story #12
  - Users see a menu item to fly an individual Jet, and then choose the Jet in a sub-menu.
## User Story #13
  - Each jet has a pilot.
## User Story #14
  - Assign a random pilot to each jet that is created.
## User Story #15
  - Users can hire pilots.
## User Story #16
  - Whenever a jet's information is displayed, that jet's pilot and his/her information should also be displayed.

## User Story #17
  - The user is given a menu option to save jets to a file. When selected the user enters the file name. The program then saves all jets to that file in the same format as the original input file. The code should first check that the file name isn't the same as the original input file, printing an error message if it is.

## Lesson Learned:
1. Text file that was created for initial list of Jets had whitespace upon creation. Which wasn't the problem until the FileReader had to be told to split the line with specific parameters. This took me a while to figure out.
``` String[] selections = line.split(",");
```
1. Overall the concept of abstract classes are still a weakness that I need to investigate further.
1. Java Collection Frameworks were introduced this week and implemented within Jets application.
1. Another fun weekend project to solidify the importance of coding along as well as labs within our 16 course work.
1. ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1

### Technologies Used:
1. Git
1. GitHub version control
1. Java
1. Eclipse IDE
1. Terminal CLI

## MVP
  - The initial list of Jets must be loaded from a text file.
  - When menu option 1 is pressed all Jets in the fleet are displayed to the user.
  - When menu option 2 is selected, fly() is executed on all Jets.
  - When menu option 3 is selected, the fastest jet from the list of Jets should be displayed to the user.
  - When menu option 4 is selected, the jet with the longest range should be displayed to the user.
  - Choosing type-specific behavior calls the interface method for those Jets.
  - When the user chooses to add a Jet, you are prompted to enter the model, speed (in MPH), range, and price. This Jet should be added to the list of Jets so that when the user again selects menu option 1, that custom jet is included.
  - When the user chooses to remove a Jet, the user is presented a menu for selecting the jet to remove.
  - The final menu option should exit the program.
## MVP+
 - Stretch Goal: This leads to a sub-menu where the user chooses the type of Jet.
 - Stretch Goal: a user can remove a jet (or jets) by name.
 - Try implementing these stories only when you have committed and pushed a working project.


## Copyright (c)2020 Yettsy Knapp
 - Let's Connect on [LinkedIn](https://www.linkedin.com/in/yettsy-jo-knapp)
