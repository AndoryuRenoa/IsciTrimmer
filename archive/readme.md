# Archived IsciTrimmer

Java App that manipulates OS's clipboard. Removes spaces/dashes/periods etc and makes all characters uppercase

This is for copying and pasting ISCIs from multiple sources and formats into a unified output.

Moving threaded version to archive folder for now, updating to use button based function only. 

**V1.112 Complete**

Previous Build Notes V1.112:

Despite lowering refresh rate to 3x per second, and making sure the process runs after refreshing, there is still a high likelyhood of xrds interfering with pasting. Unable to get messages from cmd console when launching from windows cmd prompt. Not sure if there is anything that will stop xrds from locking up while running trimmer thread.


Previous Build Notes:

Keep off and use trim button as work around until solution is built for xrds clipboard issue.

Previous Build (1.11) notes:

It is possible using JNA to access which application currently has focus. I could simply have the program run and check whether XRDs has focus before running the rest of the thread

New build does not fix xrds issue. New version of xrds seems to have issue with pasting now while isci trimmer is running. 

Simple short term solution is to change from thread to button. 


Previous Build (1.1) Notes:

Copying from certain software(XRDS) causes said software to hang and the clipboard to be unusable until IsciTrimmer is closed, although the IsciTrimmer UI does not fail. (Possible Deadlock?)

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
  
Solution would be to have thread helper that reinstates thread if this exception occurs. 


Previous Build (1.0) Notes:

MS Outlook's copy/paste of email files is currently blocked by this app. In src/.../Trimmer.java there are notes that could fix this by including a string length limit prior to altering string.

Occassionally fails to manipulate clipboard, notes in src/.../Trimmer.java regarding solution. Currently solvable by switching off and on again.
