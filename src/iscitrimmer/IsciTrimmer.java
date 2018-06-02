
package iscitrimmer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class IsciTrimmer {


  	 public static void main(String[] args) {
                 Trimmer trimmer = new Trimmer();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    JFrame frame = new JFrame ("ISCI Trimmer");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(trimmer);
                    frame.setVisible(true);
		    frame.setPreferredSize(new Dimension(250, 80));
		    frame.setAlwaysOnTop(true); 
                    frame.pack();
					 
			  }
	
		 		});
	 }
}
