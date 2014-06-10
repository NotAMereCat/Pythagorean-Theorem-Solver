package io.github.astarks173362.pts;

import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PTSAF extends JFrame {
	
	private PTSAP Panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTSAF frame = new PTSAF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PTSAF() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PTSMF.class.getResource("/resources/IconImage.jpg")));
		setTitle("Pythagorean Theorem Solver - Andrew Starks");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 360);
		Panel = new PTSAP();
		setContentPane(Panel);
	}
}