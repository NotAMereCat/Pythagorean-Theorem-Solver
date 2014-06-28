package com.starkscode.pts;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JLabel lblStarkscode;

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == btnSolveA) {
			double cValue = Double.parseDouble(textField_2.getText());
			double bValue = Double.parseDouble(textField_1.getText());
			double aValue = Math
					.sqrt(Math.pow(cValue, 2) - Math.pow(bValue, 2));
			NumberFormat nf = NumberFormat.getNumberInstance();
			textField.setText(nf.format(aValue));

		} else if (source == btnSolveB) {
			double cValue = Double.parseDouble(textField_2.getText());
			double aValue = Double.parseDouble(textField.getText());
			double bValue = Math
					.sqrt(Math.pow(cValue, 2) - Math.pow(aValue, 2));
			NumberFormat nf = NumberFormat.getNumberInstance();
			textField_1.setText(nf.format(bValue));

		} else if (source == btnSolveC) {
			double aValue = Double.parseDouble(textField.getText());
			double bValue = Double.parseDouble(textField_1.getText());
			double cValue = Math
					.sqrt(Math.pow(aValue, 2) + Math.pow(bValue, 2));
			NumberFormat nf = NumberFormat.getNumberInstance();
			textField_2.setText(nf.format(cValue));

		} else if (source == btnReset) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");

		} else if (source == btnGitHub) {
			try {
				String[] cmd = new String[4];
				cmd[0] = "cmd.exe";
				cmd[1] = "/C";
				cmd[2] = "start";
				cmd[3] = "https://github.com/astarks173362/Pythagorean-Theorem-Solver";
				Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public PTSMP() {
		setBackground(Color.ORANGE);
		setLayout(null);

		textLabel = new JLabel("VALUE   A");
		textLabel.setBounds(20, 80, 70, 19);
		add(textLabel);

		textLabel_1 = new JLabel("VALUE   B");
		textLabel_1.setBounds(20, 136, 70, 19);
		add(textLabel_1);

		textLabel_2 = new JLabel("VALUE   C");
		textLabel_2.setBounds(20, 192, 70, 19);
		add(textLabel_2);

		textLabel_3 = new JLabel("Pythagorean Theorem Solver");
		textLabel_3.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		textLabel_3.setBounds(10, 41, 196, 19);
		add(textLabel_3);

		textField = new JTextField(15);
		textField.setActionCommand("");
		textField.setBounds(100, 77, 126, 24);
		add(textField);

		textField_1 = new JTextField(15);
		textField_1.setBounds(100, 133, 126, 24);
		add(textField_1);

		textField_2 = new JTextField(15);
		textField_2.setBounds(100, 189, 126, 24);
		add(textField_2);

		btnSolveA = new JButton("SOLVE A");
		btnSolveA.setBounds(255, 18, 89, 23);
		btnSolveA.addActionListener(this);
		add(btnSolveA);

		btnSolveB = new JButton("SOLVE B");
		btnSolveB.setBounds(255, 61, 89, 23);
		btnSolveB.addActionListener(this);
		add(btnSolveB);

		btnSolveC = new JButton("SOLVE C");
		btnSolveC.setBounds(255, 104, 89, 23);
		btnSolveC.addActionListener(this);
		add(btnSolveC);

		btnReset = new JButton("RESET");
		btnReset.setBounds(255, 147, 89, 23);
		btnReset.addActionListener(this);
		add(btnReset);

		btnGitHub = new JButton("GITHUB");
		btnGitHub.setBounds(255, 190, 89, 23);
		btnGitHub.addActionListener(this);
		add(btnGitHub);

		lblStarkscode = new JLabel("StarksCode");
		lblStarkscode.setForeground(Color.WHITE);
		lblStarkscode.setFont(new Font("Source Code Pro", Font.PLAIN, 22));
		lblStarkscode.setBounds(10, 0, 130, 30);
		add(lblStarkscode);
	}
}