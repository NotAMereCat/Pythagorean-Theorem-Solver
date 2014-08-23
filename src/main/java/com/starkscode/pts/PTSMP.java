package com.starkscode.pts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PTSMP extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JCheckBox checkBox;

	private static NumberFormat nf = NumberFormat.getNumberInstance();

	public PTSMP() {
		setLayout(null);

		JLabel label = new JLabel("Leg (a)");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(43, 5, 40, 14);
		add(label);

		JLabel label_1 = new JLabel("Leg (b)");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(163, 5, 41, 14);
		add(label_1);

		JLabel label_2 = new JLabel("Hypotenuse (c)");
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		label_2.setBounds(260, 5, 86, 14);
		add(label_2);

		textField = new JTextField(15);
		textField.setBounds(10, 25, 107, 24);
		add(textField);

		textField_1 = new JTextField(15);
		textField_1.setBounds(130, 25, 107, 24);
		add(textField_1);

		textField_2 = new JTextField(15);
		textField_2.setBounds(250, 25, 107, 24);
		add(textField_2);

		JButton button = new JButton("SOLVE");
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/solve.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					if (textField.getText().equals("")) {
						Icon icon = new ImageIcon(PTSMP.class
								.getResource("/assets/pts/images/legA.png"));
						double hypoC = Double.parseDouble(textField_2.getText());
						double legB = Double.parseDouble(textField_1.getText());
						double legA = Math.sqrt(Math.pow(hypoC, 2)
								- Math.pow(legB, 2));
						textField.setText(nf.format(legA));
						JOptionPane.showMessageDialog(null, "Leg (a) equals "
								+ nf.format(legA), "Leg (a)",
								JOptionPane.PLAIN_MESSAGE, icon);

					}
					if (textField_1.getText().equals("")) {
						Icon icon = new ImageIcon(PTSMP.class
								.getResource("/assets/pts/images/legB.png"));
						double hypoC = Double.parseDouble(textField_2.getText());
						double legA = Double.parseDouble(textField.getText());
						double legB = Math.sqrt(Math.pow(hypoC, 2)
								- Math.pow(legA, 2));
						textField_1.setText(nf.format(legB));
						JOptionPane.showMessageDialog(null, "Leg (b) equals "
								+ nf.format(legB), "Leg (b)",
								JOptionPane.PLAIN_MESSAGE, icon);

					}
					if (textField_2.getText().equals("")) {
						Icon icon = new ImageIcon(PTSMP.class
								.getResource("/assets/pts/images/hypoC.png"));
						double legA = Double.parseDouble(textField.getText());
						double legB = Double.parseDouble(textField_1.getText());
						double hypoC = Math.sqrt(Math.pow(legA, 2)
								+ Math.pow(legB, 2));
						textField_2.setText(nf.format(hypoC));
						JOptionPane.showMessageDialog(null,
								"Hypotenuse (c) equals " + nf.format(hypoC),
								"Hypotenuse (c)", JOptionPane.PLAIN_MESSAGE,
								icon);
					}
				} else {
					if (textField.getText().equals("")) {
						double hypoC = Double.parseDouble(textField_2.getText());
						double legB = Double.parseDouble(textField_1.getText());
						double legA = Math.sqrt(Math.pow(hypoC, 2)
								- Math.pow(legB, 2));
						textField.setText(nf.format(legA));
					}
					if (textField_1.getText().equals("")) {
						double hypoC = Double.parseDouble(textField_2.getText());
						double legA = Double.parseDouble(textField.getText());
						double legB = Math.sqrt(Math.pow(hypoC, 2)
								- Math.pow(legA, 2));
						textField_1.setText(nf.format(legB));
					}
					if (textField_2.getText().equals("")) {
						double legA = Double.parseDouble(textField.getText());
						double legB = Double.parseDouble(textField_1.getText());
						double hypoC = Math.sqrt(Math.pow(legA, 2)
								+ Math.pow(legB, 2));
						textField_2.setText(nf.format(hypoC));
					}
				}
			}
		});
		button.setBounds(10, 60, 107, 24);
		add(button);

		JButton button_1 = new JButton("RESET");
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
		button_1.setBounds(130, 60, 107, 24);
		add(button_1);

		JButton button_2 = new JButton("GITHUB");
		button_2.setFont(new Font("Arial", Font.BOLD, 14));
		button_2.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/github.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop
							.getDesktop()
							.browse(java.net.URI
									.create("https://github.com/astarks173362/Pythagorean-Theorem-Solver"));
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		button_2.setBounds(250, 60, 107, 24);
		add(button_2);

		JButton button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"<html><h3>How to solve for Leg (a)</h3>"
										+ "<p>If you are trying to solve for leg (a) then you need to have the lengths<br>of the hypotenuse (c) and leg (b). Put those lengths in the boxes<br>marked 'Hypotenuse (c)' and 'Leg (b)' then hit solve. Make sure<br>the hypotenuse is the larger number or you will receive 'NaN' for an answer."
										+ "<h3>How to solve for Leg (b)</h3>"
										+ "<p>If you are trying to solve for leg (b) then you need to have the lengths<br>of the hypotenuse (c) and leg (a). Put those lengths in the boxes<br>marked 'Hypotenuse (c)' and 'Leg (a)' then hit solve. Make sure<br>the hypotenuse is the larger number or you will receive 'NaN' for an answer."
										+ "<h3>How to solve for Hypotenuse (c)</h3>"
										+ "<p>If you are trying to solve for the hypotenuse (c) then you need to have the lengths<br>of leg (a) and leg (b). Put those lengths in the boxes<br>marked 'Leg (a)' and 'Leg (b)' then hit solve.</html>",
								"Pythagorean Theorem Solver: Help",
								JOptionPane.PLAIN_MESSAGE, null);
			}
		});
		button_3.setIcon(new ImageIcon(PTSMP.class
				.getResource("/assets/pts/images/help.png")));
		button_3.setBounds(368, 60, 23, 24);
		add(button_3);

		checkBox = new JCheckBox("Show answer popups");
		checkBox.setBounds(10, 90, 142, 23);
		checkBox.setSelected(true);
		add(checkBox);
	}
}