package io.github.astarks173362.pts;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

@SuppressWarnings("serial")
public class PTSMP extends JPanel implements ActionListener {
	
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	
	private JLabel textLabel;
	private JLabel textLabel_1;
	private JLabel textLabel_2;
	private JLabel textLabel_3;
	
	private JButton btnSolveA;
	private JButton btnSolveB;
	private JButton btnSolveC;
	private JButton btnReset;
	private JButton btnGitHub;
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == btnSolveA) {
			double cValue = Double.parseDouble(textField_2.getText());
			double bValue = Double.parseDouble(textField_1.getText());
			double aValue = Math.sqrt(Math.pow(cValue, 2) - Math.pow(bValue, 2));
			NumberFormat nf = NumberFormat.getNumberInstance();
			textField.setText(nf.format(aValue));
			PTSAF frame = new PTSAF();
			frame.setVisible(true);
			
		}else if (source == btnSolveB) {
			double cValue = Double.parseDouble(textField_2.getText());
			double aValue = Double.parseDouble(textField.getText());
			double bValue = Math.sqrt(Math.pow(cValue, 2) - Math.pow(aValue, 2));
			NumberFormat nf = NumberFormat.getNumberInstance();
			textField_1.setText(nf.format(bValue));
			PTSBF frame = new PTSBF();
			frame.setVisible(true);
			
		}else if (source == btnSolveC) {
			double aValue = Double.parseDouble(textField.getText());
			double bValue = Double.parseDouble(textField_1.getText());
			double cValue = Math.sqrt(Math.pow(aValue, 2) + Math.pow(bValue, 2));
			NumberFormat nf = NumberFormat.getNumberInstance();
			textField_2.setText(nf.format(cValue));
			PTSCF frame = new PTSCF();
			frame.setVisible(true);
			
		}else if (source == btnReset) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			
		}else if (source == btnGitHub) {
			try {
				String[] cmd = new String[4];
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = "start";
				cmd[3] = "https://github.com/astarks173362/PythagoreanTheoremSolver";
				Runtime.getRuntime().exec(cmd);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public PTSMP() {
		setBackground(new Color(240, 230, 140));
		setLayout(null);
		
		textLabel = new JLabel("VALUE   A");
		textLabel.setBounds(20, 65, 70, 19);
		add(textLabel);
		
		textLabel_1 = new JLabel("VALUE   B");
		textLabel_1.setBounds(20, 124, 70, 19);
		add(textLabel_1);
		
		textLabel_2 = new JLabel("VALUE   C");
		textLabel_2.setBounds(20, 183, 70, 19);
		add(textLabel_2);
		
		textLabel_3 = new JLabel("Pythagorean Theorem Solver");
		textLabel_3.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		textLabel_3.setBounds(10, 11, 278, 31);
		add(textLabel_3);
		
		textField = new JTextField(15);
		textField.setToolTipText("Given value for side a.");
		textField.setActionCommand("");
		textField.setBounds(100, 62, 126, 24);
		add(textField);
		
		textField_1 = new JTextField(15);
		textField_1.setToolTipText("Given value for side b.");
		textField_1.setBounds(100, 121, 126, 24);
		add(textField_1);
		
		textField_2 = new JTextField(15);
		textField_2.setToolTipText("Given value for side c.");
		textField_2.setBounds(100, 180, 126, 24);
		add(textField_2);
				
		btnSolveA = new JButton("SOLVE A");
		btnSolveA.setToolTipText("Solve for side a.");
		btnSolveA.setBounds(292, 18, 89, 23);
		btnSolveA.addActionListener(this);
		add(btnSolveA);
		
		btnSolveB = new JButton("SOLVE B");
		btnSolveB.setToolTipText("Solve for side b.");
		btnSolveB.setBounds(292, 61, 89, 23);
		btnSolveB.addActionListener(this);
		add(btnSolveB);
				
		btnSolveC = new JButton("SOLVE C");
		btnSolveC.setToolTipText("Solve for side c.");
		btnSolveC.setBounds(292, 104, 89, 23);
		btnSolveC.addActionListener(this);
		add(btnSolveC);
		
		btnReset = new JButton("RESET");
		btnReset.setToolTipText("Reset value boxes.");
		btnReset.setBounds(292, 147, 89, 23);
		btnReset.addActionListener(this);
		add(btnReset);
		
		btnGitHub = new JButton("GITHUB");
		btnGitHub.setToolTipText("Open GitHub repository for project.");
		btnGitHub.setBounds(292, 190, 89, 23);
		btnGitHub.addActionListener(this);
		add(btnGitHub);
	}
}