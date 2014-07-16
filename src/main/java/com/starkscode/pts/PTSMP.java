package com.starkscode.pts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PTSMP extends JPanel {

	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;

	private JButton btnSolve;
	private JButton btnReset;
	private JButton btnGitHub;

	private JLabel lblLegA;
	private JLabel lblLegB;
	private JLabel lblHypoC;
	private JLabel lblInputZeroInto;

	public PTSMP() {
		setLayout(null);

		textField = new JTextField(15);
		textField.setBounds(10, 25, 100, 23);
		add(textField);

		textField_1 = new JTextField(15);
		textField_1.setBounds(120, 25, 100, 23);
		add(textField_1);

		textField_2 = new JTextField(15);
		textField_2.setBounds(230, 25, 100, 23);
		add(textField_2);

		btnSolve = new JButton("SOLVE");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double sideA = Double.parseDouble(textField.getText());
				double sideB = Double.parseDouble(textField_1.getText());
				double sideC = Double.parseDouble(textField_2.getText());

				if (sideA == 0) {
					double cValue = sideC;
					double bValue = sideB;
					double aValue = Math.sqrt(Math.pow(cValue, 2)
							- Math.pow(bValue, 2));
					NumberFormat nf = NumberFormat.getNumberInstance();
					textField.setText(nf.format(aValue));
					JOptionPane.showMessageDialog(null, "Leg (a) equals "
							+ textField.getText());

				} else if (sideB == 0) {
					double cValue = sideC;
					double aValue = sideA;
					double bValue = Math.sqrt(Math.pow(cValue, 2)
							- Math.pow(aValue, 2));
					NumberFormat nf = NumberFormat.getNumberInstance();
					textField_1.setText(nf.format(bValue));
					JOptionPane.showMessageDialog(null, "Leg (b) equals "
							+ textField_1.getText());

				} else if (sideC == 0) {
					double aValue = sideA;
					double bValue = sideB;
					double cValue = Math.sqrt(Math.pow(aValue, 2)
							+ Math.pow(bValue, 2));
					NumberFormat nf = NumberFormat.getNumberInstance();
					textField_2.setText(nf.format(cValue));
					JOptionPane.showMessageDialog(null,
							"Hypotenuse (c) equals " + textField_2.getText());
				}
			}
		});
		btnSolve.setBounds(10, 57, 100, 23);
		add(btnSolve);

		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnReset.setBounds(120, 59, 100, 23);
		add(btnReset);

		btnGitHub = new JButton("GITHUB");
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] cmd = new String[4];
					cmd[0] = "cmd.exe";
					cmd[1] = "/C";
					cmd[2] = "start";
					cmd[3] = "https://github.com/astarks173362/Pythagorean-Theorem-Solver";
					Runtime.getRuntime().exec(cmd);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnGitHub.setBounds(230, 59, 100, 23);
		add(btnGitHub);

		lblLegA = new JLabel("Leg (a)");
		lblLegA.setBounds(10, 3, 46, 14);
		add(lblLegA);

		lblLegB = new JLabel("Leg (b)");
		lblLegB.setBounds(120, 3, 46, 14);
		add(lblLegB);

		lblHypoC = new JLabel("Hypotenuse (c)");
		lblHypoC.setBounds(230, 3, 86, 14);
		add(lblHypoC);

		lblInputZeroInto = new JLabel(
				"Input zero in the box you are trying to solver for.");
		lblInputZeroInto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInputZeroInto.setBounds(20, 91, 320, 23);
		add(lblInputZeroInto);
	}
}