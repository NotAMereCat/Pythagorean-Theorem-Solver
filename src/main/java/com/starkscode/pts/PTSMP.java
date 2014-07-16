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

	private JButton btn;
	private JButton btn_1;
	private JButton btn_2;

	private JLabel lbl;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;

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

		btn = new JButton("SOLVE");
		btn.addActionListener(new ActionListener() {
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
		btn.setBounds(10, 57, 100, 23);
		add(btn);

		btn_1 = new JButton("RESET");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btn_1.setBounds(120, 59, 100, 23);
		add(btn_1);

		btn_2 = new JButton("GITHUB");
		btn_2.addActionListener(new ActionListener() {
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
		btn_2.setBounds(230, 59, 100, 23);
		add(btn_2);

		lbl = new JLabel("Leg (a)");
		lbl.setBounds(10, 3, 46, 14);
		add(lbl);

		lbl_1 = new JLabel("Leg (b)");
		lbl_1.setBounds(120, 3, 46, 14);
		add(lbl_1);

		lbl_2 = new JLabel("Hypotenuse (c)");
		lbl_2.setBounds(230, 3, 86, 14);
		add(lbl_2);

		lbl_3 = new JLabel(
				"Input zero in the box you are trying to solver for.");
		lbl_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_3.setBounds(20, 91, 302, 18);
		add(lbl_3);
	}
}