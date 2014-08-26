package com.starkscode.pts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PTSMP extends JPanel {

	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private static NumberFormat nf = NumberFormat.getNumberInstance();

	public PTSMP() {
		setLayout(null);

		JLabel label = new JLabel("Leg (a)");
		label.setFont(new Font("Arial", Font.BOLD, 12));
		label.setBounds(32, 185, 40, 14);
		add(label);

		JLabel label_1 = new JLabel("Leg (b)");
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		label_1.setBounds(128, 185, 41, 14);
		add(label_1);

		JLabel label_2 = new JLabel("Hypotenuse (c)");
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		label_2.setBounds(202, 185, 86, 14);
		add(label_2);

		label_3 = new JLabel(new ImageIcon(
				PTSMP.class.getResource("/assets/pts/images/triangle.png")));
		label_3.setBounds(84, 11, 134, 134);
		add(label_3);

		label_4 = new JLabel();
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(0, 74, 79, 14);
		add(label_4);

		label_5 = new JLabel();
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 147, 282, 14);
		add(label_5);

		label_6 = new JLabel();
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(168, 74, 268, 14);
		add(label_6);

		textField = new JTextField(15);
		textField.setFocusable(false);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setFocusable(true);
				textField.requestFocusInWindow();
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label_3.setIcon(new ImageIcon(PTSMP.class
						.getResource("/assets/pts/images/legA.png")));
			}
		});
		label.setLabelFor(textField);
		textField.setBounds(10, 210, 86, 24);
		add(textField);

		textField_1 = new JTextField(15);
		textField_1.setFocusable(false);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setFocusable(true);
				textField_1.requestFocusInWindow();
			}
		});
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label_3.setIcon(new ImageIcon(PTSMP.class
						.getResource("/assets/pts/images/legB.png")));
			}
		});
		label_1.setLabelFor(textField_1);
		textField_1.setBounds(106, 210, 86, 24);
		add(textField_1);

		textField_2 = new JTextField(15);
		textField_2.setFocusable(false);
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setFocusable(true);
				textField_2.requestFocusInWindow();
			}
		});
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label_3.setIcon(new ImageIcon(PTSMP.class
						.getResource("/assets/pts/images/hypoC.png")));
			}
		});
		label_2.setLabelFor(textField_2);
		textField_2.setBounds(202, 210, 86, 24);
		add(textField_2);

		JButton button = new JButton("SOLVE");
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
					label_3.setIcon(new ImageIcon(PTSMP.class
							.getResource("/assets/pts/images/legA.png")));
					label_4.setText(nf.format(legA));
					label_5.setText(nf.format(legB));
					label_6.setText(nf.format(hypoC));

				}
				if (textField_1.getText().equals("")) {
					double hypoC = Double.parseDouble(textField_2.getText());
					double legA = Double.parseDouble(textField.getText());
					double legB = Math.sqrt(Math.pow(hypoC, 2)
							- Math.pow(legA, 2));
					textField_1.setText(nf.format(legB));
					label_3.setIcon(new ImageIcon(PTSMP.class
							.getResource("/assets/pts/images/legB.png")));
					label_4.setText(nf.format(legA));
					label_5.setText(nf.format(legB));
					label_6.setText(nf.format(hypoC));

				}
				if (textField_2.getText().equals("")) {
					double legA = Double.parseDouble(textField.getText());
					double legB = Double.parseDouble(textField_1.getText());
					double hypoC = Math.sqrt(Math.pow(legA, 2)
							+ Math.pow(legB, 2));
					textField_2.setText(nf.format(hypoC));
					label_3.setIcon(new ImageIcon(PTSMP.class
							.getResource("/assets/pts/images/hypoC.png")));
					label_4.setText(nf.format(legA));
					label_5.setText(nf.format(legB));
					label_6.setText(nf.format(hypoC));
				}
			}
		});
		button.setBounds(10, 245, 107, 24);
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
				label_4.setText("");
				label_5.setText("");
				label_6.setText("");
				label_3.setIcon(new ImageIcon(PTSMP.class
						.getResource("/assets/pts/images/triangle.png")));
			}
		});
		button_1.setBounds(123, 245, 107, 24);
		add(button_1);

		JButton button_2 = new JButton();
		button_2.setToolTipText("GitHub Repository");
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
		button_2.setBounds(236, 245, 23, 24);
		add(button_2);

		JButton button_3 = new JButton();
		button_3.setToolTipText("Pythagorean Theorem and Program Help");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop
							.getDesktop()
							.browse(java.net.URI
									.create("https://en.wikipedia.org/wiki/Pythagorean_theorem"));
				} catch (Exception exception) {
					exception.printStackTrace();
				}
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
		button_3.setBounds(265, 245, 23, 24);
		add(button_3);
	}
}