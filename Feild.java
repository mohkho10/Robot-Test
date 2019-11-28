import java.util.Scanner;

import javax.swing.JOptionPane;

public class Feild {

	static int wide; // wide for field.
	static int deep; // deep for field.
	static int robotWide; // wide for robot position.
	static int robotDeep; // deep for robot position.
	static String robotDirection;
	static int lastWide; // wide position after movement.
	static int lastDeep;// deep position after movement.
	static String robotNavigation;

	public Feild() {
		Scanner input = new Scanner(System.in);

		wide = Integer
				.parseInt(JOptionPane
						.showInputDialog("Enter a number for the width of the feild: "));
		System.out.println("wide : " + wide);

		deep = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter a number for the depth of the feild: "));
		System.out.println("deep : " + deep);
		if (wide <= 0 || deep <= 0) { // conditions for field and robot.
			System.out.println("Width and depth can not be negative or ziro");
			JOptionPane.showMessageDialog(null,
					"Width and depth can not be negative or ziro");
		} else {

			robotWide = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Enter a number for the width position of the robot: "));
			System.out.println("robotWide : " + robotWide);

			robotDeep = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Enter a number for the depth position of the robot: "));
			System.out.println("robotDeep : " + robotDeep);

			if (robotWide >= wide || robotDeep >= deep || robotWide < 0
					|| robotDeep < 0) {
				System.out.println("The robot position is out of the feild");
				JOptionPane.showMessageDialog(null,
						"The robot position is out of the feild");
			} else {

				robotDirection = JOptionPane.showInputDialog(null,
						"Enter a direction for the robot from E, W, N, S :  ");
				System.out.println("robotDirection : " + robotDirection);
				if (!robotDirection.equals("E") && !robotDirection.equals("W")
						&& !robotDirection.equals("N")
						&& !robotDirection.equals("S")) {
					System.out
							.println("Please choose a letter from E, W, N, S ");
					JOptionPane.showMessageDialog(null,
							"Please choose a letter from E, W, N, S");
				} else {
					new CreateFeild(wide, deep, robotWide, robotDeep,
							robotDirection); // create a field with the robot
												// position and direction.

					robotNavigation = JOptionPane
							.showInputDialog(null,
									"Enter a navigation for the robot from L, R, F for example LLFFRRR: ");
					System.out.println("robotNavigation : " + robotNavigation);

					new CreateFeild(wide, deep, robotWide, robotDeep, lastWide,
							lastDeep, robotNavigation, robotDirection);// create a field with the robot
                                                                       //position and direction after moving.

				}
			}

		}

	}
}
