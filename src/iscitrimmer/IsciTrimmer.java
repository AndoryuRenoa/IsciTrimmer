/*
 * first build complete in under 2 hours.
 */
package iscitrimmer;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author andrew
 */
public class IsciTrimmer {


  	 public static void main(String[] args) {
                 Trimmer trimmer = new Trimmer();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    JFrame frame = new JFrame ("ISCI Trimmer");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(trimmer, BorderLayout.CENTER);
                    frame.setVisible(true);
		    //^ could set perferred horizontal size to 245 px
                    frame.pack();
					 
			  }
	
		 		});
	 }
}
