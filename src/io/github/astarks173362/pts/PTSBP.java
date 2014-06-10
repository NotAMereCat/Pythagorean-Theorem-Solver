package io.github.astarks173362.pts;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PTSBP extends JPanel {
	
	public PTSBP() {
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setText("Step 1: Draw a right triangle and then read through the problems again to\r\ndetermine the length of the legs and the hypotenuse.\r\n\r\nStep 2: Use the Pythagorean Theorem (" + PTSMP.textField_2.getText() + "^2 - " + PTSMP.textField.getText() + "^2 = b^2) to write an \r\nequation to be solved. Remember that a and b are the legs and\r\nc is the hypotenuse (the longest side or the side opposite the 90\u00BA angle).\r\n\r\nStep 3: Simplify the equation by distributing and combining like terms as needed.\r\n\r\nStep 4: Solve the equation. If the equation contains x2, set the\r\nequation equal to zero and solve the equation by factoring.\r\nIf the equation does not contain x2, then solve the equation\r\nby getting the variables on one side and the numbers on the\r\nother side.\r\n\r\nStep 5: Answer the question asked in the original question and\r\nmake sure that the answer makes sense. Do not forget to include\r\nunits in your final answer.\r\n\r\nIn your case, " + PTSMP.textField_2.getText() + "^2 - " + PTSMP.textField.getText() + "^2 = " + PTSMP.textField_1.getText() + "^2");
		textArea.setLineWrap(true);
		textArea.setBounds(-3, -3, 761, 450);
		add(textArea);
	}
}