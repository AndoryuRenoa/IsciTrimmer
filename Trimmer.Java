import java.awt.Toolkit; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.StringSelection; 
import java.awt.datatransfer.Transferable;
import java.awt.BorderLayout;
import javax.swing.*;

public class Trimmer extends JPanel{
 int refreshRate = 10;
 String sOn = "Turn on"
 String sOff = "Turn off"
 
 
 public Trimmer (){
 	JPanel pane = new JPanel();
 	JRadioButton on = JRadioButton(String sOn, boolean selected);
	 JRadioButton off = JRadioButton(String sOff, boolean selected);
	 pane.add(on);
	 pane.add(off);
 	add(pane);
 }
 
 	public void startTrim() {
		Thread startThread = new Thread() {
			public void run() {
				while (on) {
					trimAttempt();
					try {
						Thread.sleep(1000/refreshRate);
					}catch (InterruptedException e) {
						System.out.println("An error occured in startTrim");
					}
				}
			
			}
		}; 
		startThread.start();
	}


private void trimAttempt(){
    Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null); 
     try { 
      if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) { 
        String text = (String)t.getTransferData(DataFlavor.stringFlavor); 
        text=text.toUpperCase(); 
        StringBuffer sb = new StringBuffer(text);
        sb.replace(" ","");
        sb.replace("-","");
        sb.replace("(","");
        sb.replace(")","");
        sb.replace("_","");
        sb.replace("[","");
        sb.replace("]","");
        sb.replace("{","");
        sb.replace("}","");
        sb.replace("/","");
        sb.replace("\","");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sb, null); 
      } 
    }catch (Exception e) {
     // maybe put an output here?
   } 
 }

