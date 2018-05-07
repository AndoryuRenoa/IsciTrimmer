package iscitrimmer;

import java.awt.Toolkit; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.StringSelection; 
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Trimmer extends JPanel implements ActionListener{
 int refreshRate = 10;
 boolean isOn = true;
 JButton on, off;
 
 
 public Trimmer (){
 	JPanel pane = new JPanel();
 	on = new JButton("On");
	on.setActionCommand("on");
	off = new JButton("Off");
	off.setActionCommand("off");
	 
	on.setEnabled(false); 
        off.setEnabled(true);
        
	on.addActionListener(this);
	off.addActionListener(this);
        
	pane.add(on);
	pane.add(off);
 	add(pane);
        startTrim();
 }
	
public void actionPerformed(ActionEvent e) {
    if ("on".equals(e.getActionCommand())) {
        isOn = true;
	on.setEnabled(false);
        off.setEnabled(true);
        startTrim();
    } else {
        isOn = false;
	on.setEnabled(true);
        off.setEnabled(false);
        startTrim();
    }
} 
	
 
 	public void startTrim() {
		Thread startThread = new Thread() {
			public void run() {
				while (isOn) {
					trimAttempt();
					try {
						Thread.sleep(1000/refreshRate);
					}catch (InterruptedException e) {
						System.out.println("An error occured in startTrim");
						//^ change to popup window?
						// resetThread()
						// ^ in this method turn everything to off have it wait for 3/10s of a second
						// giving this thread time to stop running while loop
						// then turn everything on again
					}
				}
			
			}
		}; 
		startThread.start();
	}


private void trimAttempt(){
     Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null); 
        try { if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) { 
	        String text = (String)t.getTransferData(DataFlavor.stringFlavor);
                    if(text.length()<25) { 
                       text=text.toUpperCase(); 
                        String s = text;
                        s= s.replace("//s","");
			//^ does not remove whitespace, needs to be replaced:
			// s=s.replace("\\s","");
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
                	s=s.replace(":","");
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

