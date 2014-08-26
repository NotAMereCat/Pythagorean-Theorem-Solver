package com.starkscode.pts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class PTSMF extends JFrame {

	private PTSMP Panel;

	protected void setLookAndFeel() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		setLookAndFeel();
		setTitle("Pythagorean Theorem Solver");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 307);
		setLocationRelativeTo(null);
		Panel = new PTSMP();
		setContentPane(Panel);
	}
}