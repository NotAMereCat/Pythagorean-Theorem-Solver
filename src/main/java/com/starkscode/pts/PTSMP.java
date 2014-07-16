package com.starkscode.pts;

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

	private JLabel lbl;
	private JLabel lbl_1;
	private JLabel lbl_2;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JButton btn;
	private JButton btn_1;
	private JButton btn_2;

	NumberFormat nf = NumberFormat.getNumberInstance();

	public PTSMP() {
		setLayout(null);

		lbl = new JLabel("Leg (a)");
		lbl.setBounds(40, 5, 46, 14);
		add(lbl);

		lbl_1 = new JLabel("Leg (b)");
		lbl_1.setBounds(150, 5, 46, 14);
		add(lbl_1);

		lbl_2 = new JLabel("Hypotenuse (c)");
		lbl_2.setBounds(237, 5, 86, 14);
		add(lbl_2);

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
				if (textField.getText().equals("")) {
					double cValue = Double.parseDouble(textField_2.getText());
					double bValue = Double.parseDouble(textField_1.getText());
					double aValue = Math.sqrt(Math.pow(cValue, 2)
							- Math.pow(bValue, 2));
					textField.setText(nf.format(aValue));
					JOptionPane.showMessageDialog(null,
							"Leg (a) equals " + nf.format(aValue));

				} else if (textField_1.getText().equals("")) {
					double cValue = Double.parseDouble(textField_2.getText());
					double aValue = Double.parseDouble(textField.getText());
					double bValue = Math.sqrt(Math.pow(cValue, 2)
							- Math.pow(aValue, 2));
					textField_1.setText(nf.format(bValue));
					JOptionPane.showMessageDialog(null,
							"Leg (b) equals " + nf.format(bValue));

				} else if (textField_2.getText().equals("")) {
					double aValue = Double.parseDouble(textField.getText());
					double bValue = Double.parseDouble(textField_1.getText());
					double cValue = Math.sqrt(Math.pow(aValue, 2)
							+ Math.pow(bValue, 2));
					textField_2.setText(nf.format(cValue));
					JOptionPane.showMessageDialog(null,
							"Hypotenuse (c) equals " + nf.format(cValue));
				}
			}
		});
		btn.setBounds(10, 59, 100, 23);
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
	}
}