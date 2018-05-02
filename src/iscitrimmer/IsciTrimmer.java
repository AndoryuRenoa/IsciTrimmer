/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iscitrimmer;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author andrew
 */
public class IsciTrimmer {

    /**
     * @param args the command line arguments
     */
  	 public static void main(String[] args) {
                 Trimmer trimmer = new Trimmer();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    JFrame frame = new JFrame ("ISCI Trimmer");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(trimmer, BorderLayout.CENTER);
                    frame.setVisible(true);
                    frame.pack();
					 
			  }
	
		 		});
	 }
}
