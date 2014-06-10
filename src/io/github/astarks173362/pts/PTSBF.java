package io.github.astarks173362.pts;

import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PTSBF extends JFrame {
	
	private PTSBP Panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTSBF frame = new PTSBF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PTSBF() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PTSMF.class.getResource("/resources/IconImage.jpg")));
		setTitle("Pythagorean Theorem Solver - Andrew Starks");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 360);
		Panel = new PTSBP();
		setContentPane(Panel);
	}
}