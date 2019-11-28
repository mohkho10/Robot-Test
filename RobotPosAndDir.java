import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RobotPosAndDir {// finding the position and direction of the
	                         // robot.

	public static void RobotPos(int i, int j, String robotDirection,
			JButton[][] btnNumbers, JPanel panelButtons) {

		btnNumbers[i][j] = new JButton("ROBOT :" + robotDirection);// Construct the robot position with direction. 	
		panelButtons.add(btnNumbers[i][j]);                        //ROBOT =the robot position.

	}
	
	public static void LastRobotPos(int i, int j, String robotDirection,
			JButton[][] btnNumbers, JPanel panelButtons) {

		btnNumbers[i][j] = new JButton("ROBOT* :" + robotDirection);// Construct the robot position after movement with direction. 	
		panelButtons.add(btnNumbers[i][j]);                         //ROBOT* =the robot after moving.			

	}
	
	
	


}
