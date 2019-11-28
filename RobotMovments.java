import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RobotMovments {// receiving the navigation and finding the new
							// position and direction after moving.

	public static ArrayList<String> currentPosionAndDirection(int wide,
			int deep, int robotWide, int robotDeep, String robotDirection,
			String navigation, ArrayList<String> lastPosAndDir) {

		while (navigation.length() > 0) {
			String currentNav = navigation.substring(0, 1);
			switch (robotDirection) {

			case "E":
				if (currentNav.equals("R")) {
					robotDirection = "S";
				} else if (currentNav.equals("L")) {
					robotDirection = "N";
				} else if (currentNav.equals("F")) {
					robotWide = robotWide + 1;
					if (robotWide >= wide || robotWide < 0){
						System.out
								.println("The movement is our of the zoom for the field, please try another navigation :)");
				/*	JOptionPane
							.showMessageDialog(
									null,
									"The movement is our of the zoom for the field, please try another navigation :)");*/
					break;
					}
				}
				break;

			case "W":
				if (currentNav.equals("R")) {
					robotDirection = "N";
				} else if (currentNav.equals("L")) {
					robotDirection = "S";
				} else if (currentNav.equals("F")) {
					robotWide = robotWide - 1;
					if (robotWide >= wide || robotWide < 0){
						System.out
								.println("the movement is our of the zoom for the field, please try another navigation :)");
			/*		JOptionPane
							.showMessageDialog(
									null,
									"The movement is our of the zoom for the field, please try another navigation :)");*/
					break;
					}
				}
				break;

			case "N":
				if (currentNav.equals("R")) {
					robotDirection = "E";
				} else if (currentNav.equals("L")) {
					robotDirection = "W";
				} else if (currentNav.equals("F")) {
					robotDeep = robotDeep - 1;
					if (robotDeep >= deep || robotDeep < 0){
						System.out
								.println("the movment is our of the zoom for the field, please try another navigation :)");
					/*JOptionPane
							.showMessageDialog(
									null,
									"The movement is our of the zoom for the field, please try another navigation :)");*/
					break;
					}
				}
				break;

			case "S":
				if (currentNav.equals("R")) {
					robotDirection = "W";
				} else if (currentNav.equals("L")) {
					robotDirection = "E";
				} else if (currentNav.equals("F")) {
					robotDeep = robotDeep + 1;
					if (robotDeep >= deep || robotDeep < 0)
						System.out
								.println("the movment is our of the zoom for the field, please try another navigation :)");
					/*JOptionPane
							.showMessageDialog(
									null,
									"The movement is our of the zoom for the field, please try another navigation :)");*/
					break;
				}
				break;
			default:
				System.out.println("No match");

			}

			navigation = navigation.substring(1);
			currentPosionAndDirection(wide, deep, robotWide, robotDeep,
					robotDirection, navigation, lastPosAndDir);
		}

		/*
		 * System.out.println("current robotdirection:" + robotDirection);
		 * System.out.println("current robotwide:" + robotWide);
		 * System.out.println("current robotDeep:" + robotDeep);
		 */

		lastPosAndDir.add(Integer.toString(robotWide));
		lastPosAndDir.add(Integer.toString(robotDeep));
		lastPosAndDir.add(robotDirection);

		return lastPosAndDir; // ArrayList including new position and new
								// direction after moving

	}

}
