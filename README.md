# IsciTrimmer

Java App that manipulates OS's clipboard. Removes spaces/dashes/periods etc and makes all characters uppercase

This is for copying and pasting ISCIs from multiple sources and formats into a unified output. 

V1.1 Complete

Current Build Notes:

For easy of use no popup dialog appear indicating where failure occures if one happens. Code still uses System.out.println().

Trimmer is currently limited to 25 characters prior to trimming, or no attempt is made to trim it.


Previous Build (1.0) Notes:

MS Outlook's copy/paste of email files is currently blocked by this app. In src/.../Trimmer.java there are notes that could fix this by including a string length limit prior to altering string.

Occassionally fails to manipulate clipboard, notes in src/.../Trimmer.java regarding solution. Currently solvable by switching off and on again.
