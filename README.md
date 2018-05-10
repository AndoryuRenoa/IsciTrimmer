# IsciTrimmer

Java App that manipulates OS's clipboard. Removes spaces/dashes/periods etc and makes all characters uppercase

This is for copying and pasting ISCIs from multiple sources and formats into a unified output. 

V1.1 Complete

Current Build Notes:

Copying from certain software(XRDS) causes the software to hang and the iscitrimmer to stop functioning although the UI does not fail.

**Currently does not work with Trigger iscis due to ":" currently being stripped**

For some reason //s does not actually call whitespace when used in this code. Research what is happening here

For easy of use no popup dialog appear indicating where failure occures if one happens. Code still uses System.out.println().

Trimmer is currently limited to 25 characters prior to trimming, or no attempt is made to trim it.

Running Debugger this error can occasionally occur:
Exception in thread "Thread-24" java.lang.IllegalStateException: cannot open system clipboard
	at sun.awt.windows.WClipboard.openClipboard(Native Method)
	at sun.awt.datatransfer.ClipboardTransferable.<init>(ClipboardTransferable.java:78)
	at sun.awt.datatransfer.SunClipboard.getContents(SunClipboard.java:143)
	at iscitrimmer.Trimmer.trimAttempt(Trimmer.java:71)
	at iscitrimmer.Trimmer.access$000(Trimmer.java:11)
	at iscitrimmer.Trimmer$1.run(Trimmer.java:55)
  
Solution would be to have thread helper that reinstates thread if this exception occurs. This is likely a problem with the awt clipboard API


Previous Build (1.0) Notes:

MS Outlook's copy/paste of email files is currently blocked by this app. In src/.../Trimmer.java there are notes that could fix this by including a string length limit prior to altering string.

Occassionally fails to manipulate clipboard, notes in src/.../Trimmer.java regarding solution. Currently solvable by switching off and on again.
