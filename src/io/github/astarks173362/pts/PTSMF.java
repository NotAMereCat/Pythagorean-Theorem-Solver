package io.github.astarks173362.pts;

import java.awt.*;
import javax.swing.*;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class PTSMF extends JFrame {
	
	private PTSMP Panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTSMF frame = new PTSMF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PTSMF() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PTSMF.class.getResource("/resources/IconImage.jpg")));
		setTitle("Pythagorean Theorem Solver - Andrew Starks");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 258);
		Panel = new PTSMP();
		setContentPane(Panel);
	}
}