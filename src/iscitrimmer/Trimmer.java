package iscitrimmer;

//stripping out the threading, so it's just a button.

import java.awt.BorderLayout;
import java.awt.Toolkit; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.StringSelection; 
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Trimmer extends JPanel implements ActionListener{
 // changing below to false until determining problem with xrds
 JButton trim;
 
 public Trimmer (){
 	JPanel pane = new JPanel();
         trim = new JButton("Trim");
	 trim.setActionCommand("trim");
	
	 //flip the two below for now so it starts in off position
	trim.addActionListener(this);
        
	pane.add(trim);
        this.setLayout(new BorderLayout());
 	add(pane);
  }
	
public void actionPerformed(ActionEvent e) {
    if ("trim".equals(e.getActionCommand())) {
        trimAttempt();
    }
} 
	
 


private void trimAttempt(){
    // can move Transferable initailization back to above try statement 
        try {    
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
	          String text = (String)t.getTransferData(DataFlavor.stringFlavor);
		// V limits attempt to trim to only when copying less than 25 characters
                    if(text.length()<25) { 
                       text=text.toUpperCase(); 
                        String s = text;
                        s= s.replace(" ","");
                        s= s.replace("  ","");
        	        s= s.replace("-","");
                        s= s.replace("(","");
                        s= s.replace(")","");
        	        s= s.replace("_","");
                        s= s.replace("[","");
                        s= s.replace("]","");
        	        s= s.replace("{","");
                        s= s.replace("}","");
                        s= s.replace("/","");
                        s= s.replace(".","");
                        s= s.replace(",","");
        		s=s.replace("*","");
                	s=s.replace(";","");

                        StringSelection ss = new StringSelection(s);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                    }
                } 
            } catch (Exception e) {
                System.out.println("Problem occured in trimAttempt");
		// popup window displaying "Failure in string manipulation"?
        } 
 }
}
