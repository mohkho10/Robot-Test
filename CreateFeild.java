import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CreateFeild extends JFrame {

	JButton[][] btnNumbers;
	JButton[][] lastBtnNumbers;
	static ArrayList<String> lastPosAndDir = new ArrayList<String>();

	// Constructor to setup GUI components and event handlers
	public CreateFeild(int wide, int deep, int robotWide, int robotDeep,
			String robotDirection) {

		ArrayList<String> navigation = new ArrayList<String>();
		RobotPosAndDir position = new RobotPosAndDir();
		int[][] dimentions = new int[wide][deep];
		// Set up display panel
		JPanel panelDisplay = new JPanel(new FlowLayout());
		// Set up button panel
		JPanel panelButtons = new JPanel(new GridLayout(deep, wide));
		btnNumbers = new JButton[deep][wide];
        // check for the position of the robot on the field.
		for (int i = 0; i < deep; i++) {
			for (int j = 0; j < wide; j++) {
				if (i == robotDeep && j == robotWide) {
					position.RobotPos(i, j, robotDirection, btnNumbers,
							panelButtons);
				} else {
					btnNumbers[i][j] = new JButton("");
					panelButtons.add(btnNumbers[i][j]);
				}// The Panel adds this Button
			}
		}
		setLayout(new BorderLayout()); // "super" Frame sets to BorderLayout
		add(panelDisplay, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);
		setTitle("ROBOTS GAME"); // "super" Frame sets title
		setSize(200, 200); // "super" Frame sets initial size
		setVisible(true); // "super" Frame shows

	}

	public CreateFeild(int wide, int deep, int robotWide, int robotDeep,
			int lastWide, int lastDeep, String robotNavigation,
			String robotDirection) {
		// TODO Auto-generated constructor stub
		RobotPosAndDir lastPosition = new RobotPosAndDir();
		Scanner input = new Scanner(System.in);
		ArrayList<String> lastDirection = null;
		JPanel lastPanelDisplay = new JPanel(new FlowLayout());
		JPanel lastPanelButtons = new JPanel(new GridLayout(deep, wide));
		lastBtnNumbers = new JButton[deep][wide];
		if (robotNavigation.contains("L") || robotNavigation.contains("R")
				|| robotNavigation.contains("F")) {
			// location and position of the robot followed by navigation
			RobotMovments currentMovAndDirection = new RobotMovments();
			lastDirection = currentMovAndDirection.currentPosionAndDirection(
					wide, deep, robotWide, robotDeep, robotDirection,
					robotNavigation, lastPosAndDir);
			lastWide = Integer.parseInt(lastDirection.get(0));
			lastDeep = Integer.parseInt(lastDirection.get(1));
			System.out.println("robot direction after movement: "
					+ lastDirection.get(2));
			System.out.println("robot width position after movement: "
					+ lastWide);
			System.out.println("robot depth position after movement: "
					+ lastDeep);
			JOptionPane.showMessageDialog(null, "Robot direction :  "
					+ lastDirection.get(2) + "\n" + "Robot width position :  "
					+ lastWide + "\n" + "Robot depth position :  " + lastDeep);
		} else {
			System.out.println("Unknown navigation");
		}
		 // check for the position of the robot on the field after moving.
		for (int i = 0; i < deep; i++) {
			for (int j = 0; j < wide; j++) {
				if (i == lastDeep && j == lastWide) {
					lastPosition.LastRobotPos(i, j, lastDirection.get(2),
							lastBtnNumbers, lastPanelButtons);
				} else {
					lastBtnNumbers[i][j] = new JButton(""); // Construct Button
					lastPanelButtons.add(lastBtnNumbers[i][j]);
				}// The Panel adds this Button
			}
		}

		setLayout(new BorderLayout()); // "super" Frame sets to BorderLayout
		add(lastPanelDisplay, BorderLayout.NORTH);
		add(lastPanelButtons, BorderLayout.CENTER);
		setTitle("ROBOTS GAME"); // "super" Frame sets title
		setSize(200, 200); // "super" Frame sets initial size
		setVisible(true); // "super" Frame shows
	}

}