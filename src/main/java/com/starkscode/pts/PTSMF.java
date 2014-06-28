package com.starkscode.pts;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PTSMF.class.getResource("/assets/pts/images/IconImage.png")));
		setTitle("Pythagorean Theorem Solver - StarksCode");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 258);
		Panel = new PTSMP();
		setContentPane(Panel);
	}
}