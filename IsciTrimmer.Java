// isci trimmer/stripper for clipboard
//  Inspired by: http://mrbool.com/manipulating-clipboard-content-with-java/24758

import javax.swing.*;

public class IsciTrimmer {
  	 public static void main(String[] args) {
        Trimmer trimmer = new Trimmer();
		 		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			         public void run() {
				 JFrame frame = new JFrame ("ISCI Trimmer");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.getContentPane().add(trimmer, BorderLayout.CENTER);
				 frame.pack();
					 
			         }
	
		 		});
	 }
}

// yeah you can get this to run on a thread in the background perpetually trying to strip contents of clipboard to acceptable
// parameters
