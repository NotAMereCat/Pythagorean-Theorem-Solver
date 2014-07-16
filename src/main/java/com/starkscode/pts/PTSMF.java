package com.starkscode.pts;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

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
		setTheme();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PTSMF.class.getResource("/assets/pts/images/IconImage.png")));
		setTitle("Pythagorean Theorem Solver");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 148);
		Panel = new PTSMP();
		setContentPane(Panel);
	}

	public void setTheme() {
		try {
			UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}