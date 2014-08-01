package com.starkscode.pts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PTSMP extends JPanel {

	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	NumberFormat nf = NumberFormat.getNumberInstance();

	public PTSMP() {
		setLayout(null);

		label = new JLabel("Leg (a)");
		label.setBounds(42, 5, 40, 14);
		add(label);

		label_1 = new JLabel("Leg (b)");
		label_1.setBounds(152, 5, 41, 14);
		add(label_1);

		label_2 = new JLabel("Hypotenuse (c)");
		label_2.setBounds(240, 5, 86, 14);
		add(label_2);

		textField = new JTextField(15);
		textField.setBounds(10, 25, 105, 24);
		add(textField);

		textField_1 = new JTextField(15);
		textField_1.setBounds(120, 25, 105, 24);
		add(textField_1);

		textField_2 = new JTextField(15);
		textField_2.setBounds(230, 25, 105, 24);
		add(textField_2);

		button = new JButton("SOLVE");
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/solve.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					double hypoC = Double.parseDouble(textField_2.getText());
					double legB = Double.parseDouble(textField_1.getText());
					double legA = Math.sqrt(Math.pow(hypoC, 2)
							- Math.pow(legB, 2));
					textField.setText(nf.format(legA));
					JOptionPane.showMessageDialog(null,
							"Leg (a) equals " + nf.format(legA));

				}
				if (textField_1.getText().equals("")) {
					double hypoC = Double.parseDouble(textField_2.getText());
					double legA = Double.parseDouble(textField.getText());
					double legB = Math.sqrt(Math.pow(hypoC, 2)
							- Math.pow(legA, 2));
					textField_1.setText(nf.format(legB));
					JOptionPane.showMessageDialog(null,
							"Leg (b) equals " + nf.format(legB));

				}
				if (textField_2.getText().equals("")) {
					double legA = Double.parseDouble(textField.getText());
					double legB = Double.parseDouble(textField_1.getText());
					double hypoC = Math.sqrt(Math.pow(legA, 2)
							+ Math.pow(legB, 2));
					textField_2.setText(nf.format(hypoC));
					JOptionPane.showMessageDialog(null,
							"Hypotenuse (c) equals " + nf.format(hypoC));
				}
			}
		});
		button.setBounds(10, 60, 105, 24);
		add(button);

		button_1 = new JButton("RESET");
		button_1.setFont(new Font("Arial", Font.BOLD, 14));
		button_1.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/reset.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		button_1.setBounds(120, 60, 105, 24);
		add(button_1);

		button_2 = new JButton("GITHUB");
		button_2.setFont(new Font("Arial", Font.BOLD, 14));
		button_2.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/GitHub.png")));
		button_2.addActionListener(new ActionListener() {
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
		button_2.setBounds(230, 60, 105, 24);
		add(button_2);

		button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String html = "<html><body width=";
				String message = "<h1>Help</h1>"

						+ "<h2>How to solve for Leg (a)</h2>"
						+ "<p>If you are trying to solve for leg (a) then you need to have the lengths of the hypotenuse (c) and leg (b). Put those lengths in the boxes marked 'Hypotenuse (c)' and 'Leg (b)' then hit solve. Make sure the hypotenuse is the larger number or you will receive 'NaN' for an answer.<br><br>"
						+ "<h2>How to solve for Leg (b)</h2>"
						+ "<p>If you are trying to solve for leg (b) then you need to have the lengths of the hypotenuse (c) and leg (a). Put those lengths in the boxes marked 'Hypotenuse (c)' and 'Leg (a)' then hit solve. Make sure the hypotenuse is the larger number or you will receive 'NaN' for an answer.<br><br>"
						+ "<h2>How to solve for Hypotenuse (c)</h2>"
						+ "<p>If you are trying to solve for the hypotenuse (c) then you need to have the lengths of leg (a) and leg (b). Put those lengths in the boxes marked 'Leg (a)' and 'Leg (b)' then hit solve.<br><br>";

				int width = 400;
				String popup = html + width + message;

				JOptionPane.showMessageDialog(null, popup);
			}
		});
		button_3.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/help.png")));
		button_3.setBounds(340, 60, 23, 24);
		add(button_3);
	}
}