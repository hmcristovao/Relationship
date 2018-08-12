History (dd/mm/yy)

18/11/2015 - xx/04/2016 - 1.5.33
- put the hyperlinks on JTB output back in place;
- fixed missing JTB (1.4.10) jar;
- fixed loss of last blank line when commenting;
- moved the JavaCC Compile button to the tools bar (in order to not change the arrows location between the
   Java and the JavaCC editors);
- formating does not transform anymore tokens string characters in "\uxxxx" notation (into their representation)
   but keeps them;
- formating a Java code selection does not loose anymore the comments, and handles correctly the lines and the
   platform end of line characters;
- syntax coloring handles correctly the case of a comment after the options keyword and the case of 2 single
   line comments on 2 contiguous lines with code at the beginning of the second line;
- syntax coloring does not show the problem when there are spelling errors;
- matching characters pair does not anymore take in account the characters in the comments;
- modified automatic indentation for '<' and '{';
- added classes, methods, ..., of PARSER_BEGIN section in the Call Hierarchy View (callers & callees);
- fixed and homogeneized the callers and callees contents in the Call Hierarchy View followin a double click
   in the editor and a click on the context menu command;
- fixed configuration information for the jjdoc command;
- added a automatically format code on save option;
- fixed indentation problems in regular expressions (around '|' and '>') and in JJTee nodes conditions;
- removed the potential remaining ending '>' in token labels when using completion proposal inside;
- added value variables (for names and versions default values) and dynamic variables (for plugin and jars paths);
- added a space before the ending '>>' in regular expressions < RE1 : < RE2 > >;
- fixed first children in CHV callees when a bnf production has a node identifier;
- removed the potential remaining ending '()' in bnf productions when using completion proposal inside;

13/11/2015 - 1.5.32
- added spaces between < > and token when inserting through completion proposal;
- after formating the cursors stays on the line it was, no more goes to end of file;
- suppressed extra option in JJTree options proposal;
- added / improved @SuppressWarnings annotations in derived classes;
- put the hovers (on code and comments) back in place;

??/??/2015 - 1.5.31
- fixed a problem when navigating to private labels;

27/01/2015 - 1.5.30
- fixed a regression problem on the compile commands;
- fixed a jar path problem on the wizard (bug #88);

18/01/15 - 1.5.29
- fixed a problem on the compile commands (see discussion / help
   https://sourceforge.net/p/eclipse-javacc/discussion/190562/thread/7c7af63b/?limit=25#2e3d);
- configured now to use a JavaSE 1.7 and no more a 1.6 (as 1.6 became obsolete);
- updated with JTB 1.4.9;

08/11/12-30/12/14 - 1.5.28
- updated with JTB 1.4.8;
- added the "JVM Options" option and the "Keep deleted files in history" option (default set
  to false) in the Global Options Tab of the project preferences;
- added (JavaCC) parsing problems in JTB hyperlink reporting;
- fixed problems markers not showing in derived .jj file issue;
- fixed cursor position issue in content assist;
- sorted and revised (to be much more accurate and context dependent) the content assist proposals list;
- revised the outline view (added nodes and the no node creation flags, added synchronization with the editor,
- added node highlighting in the outline when double-clicking and modifying in the editor);
- revised the call hierarchy view, added synchronization with the editor;
- revised the icons transparency;
- internal refactoring on file names and package contents; removed JTBEditor subclasse; switched from actions,
   actionSets, actionSetPartAssociations, editorActions, viewActions and popupMenus to expressions, handlers
   and menus; added a JavaCC menu in the menu bar and in the toolbar;
- made the annotation markers summarizable ; fixed markers deletion;
- added the PARSER_BEGIN node to and removed the JAVACODE node from the foldable nodes set;
- fixed nature and builder ids (seen in .project);
- added next/previous navigation for annotations;
- rewrote logs, produced them in the Error Log, added the plugin's version, the stacktrace and context data;
- added the generated file filter in the Project Explorer view and removed it from the Outline view;
- added in Package and Project Explorer view a button to suppress all generated files in the selected package;
- fixed some issues on clearing the JavaCC console after file deletions on automatic builds;
- improved displays in the JavaCC console (timestamp, messages);
- fixed issues in the JavaCC "options" section (display in the Outline, completion proposals);
- added comments folding and fixed the other foldings in one line instead of two;
- fixed the templates to reflect the change of the parser name;
- fixed some icons in the Outline and the Call Hierarchy views;
- fixed some synchronization and display issues (highlight, background color) around selections in the
   JJEditor, Outline and Call Hierarchy views;
- changed the action (from double-click to single-click) in the JJEditor to display a node in the Outline view;
- fixed bug #56 "NPE dragging a jj/jjt/jtb file in Eclipse plugin" by adding the drag and drop capability
   (opening of JJEditor, proper interaction with the Call Hierarchy view, and disabling of compile commands;)
- added the OUTPUT_LANGUAGE option (form JavaCC 6.0+; but not yet the ability for JTB to generate C++ classes);
- improved displaying the line in error in the JJEditor when clicking on the error in the Outline view;
- fixed issues in the completion proposals computation when the grammar file is empty or almost empty;
- refactored some packages and classes to simplify the common and different code from the normal and the
   headless plugin

25/09/12 - version 1.5.27
- Localized Call Hierarchy view tooltip texts and removed related compatibility issue with Eclipse 3.5
- updated with JTB 1.4.7
- managed new column numbers in JTB messages
- managed multiple messages on the same line in editors
- upgraded the internal JTB grammar and the syntax coloring to handle the JTB 1.4.7 new '!' syntax
  for not generating a node creation

29/06/12 - version 1.5.26
- New contributor Bill Fenlason ; added Bill's syntax coloring rewritten code
- Updated javadoc (- in @param & @throws, {@inheritdoc} instead of @see, ...)
- Fixed some properties issues

03/02/11 + 31/08/11 + 03/05/12 - version 1.5.25
- 03/12 : Added in JJReconcilingStrategy Bill Fenlason's hack proposal for syntax coloring problems
- 02/11 : Updated with JTB 1.4.6 (Marc Mazas / Francis Andre)
- 02/11 : Fixed bug 3157017 (incorrect package handling)
- 08/11 : Fixed property error in JJNewPage
- 08/11 : Fixed NPE in CallHierarchy
- 08/11 : Enhanced Outline view to display identifiers and JJTree Nodes RFE 2968192
- 08/11 : Added "mark generated files as derived" option RFE 3314103
- 08/11 : Enhanced display / navigation in Outline & Call Hierarchy views
- 08/11 : Enhanced hyperlink detection / navigation
- 08/11 : Added default options display in JavaCC Plugin Preferences
- 08/11 : Fixed empty default options display in JavaCC Project Options ; changed default JDK version to 1.6
- 08/11 : Changed plugin dependencies to at least version 3.6.0.

02/12/10 - version 1.5.24
- Fixed NPE in JJDecorator
- Updated with JTB 1.4.4 (Marc Mazas)

31/04/10 - version 1.5.23
- Added spelling problems hover

31/03/10 - version 1.5.22
- Fixed spell checking issues (non reported bugs + SR 2904433)
- Fixed tab issue (bugs 2961174 & 2958124)
- Fixed wizard template files issue (bug 2962672)
- Fixed comments highlighting issue (bug 2961174 + non reported bug)
- Fixed files regeneration warnings issue(bug 2903612)
- Fixed folding structure update issue (bug 1975872)
- Refactored layouts of Preferences and Project Properties pages (added groups and tooltips)
- Updated with JTB 1.4.3 (Marc Mazas)

26/02/10 - version 1.5.21
- Fixed Wizard not closing on error (bug RK and SR 2956977)

25/02/10 - version 1.5.20
- Fixed JTB preferences issue (for options defaulting to true)
- Fixed extra quote in command line (bug RK and SR 2956977)

19/02/10 - version 1.5.19
- Fixed project preferences issues with resulting command line options field / specific options fields
  / enclosing quotes for paths and files

17/02/10 - version 1.5.18
- Fixed /**/ syntax coloring issue (bug 2946447), missing french JTB preferences issue,
  JTB preferences not stored issue
- Fixed compile annotations and hyperlink issues in JTB Editor / Console
- Splitted templates for static = true and static = false (bug 2951454)
- Added spell checking (but not spell correction...)
- Updated with JTB 1.4.1 (bug 2945965) (Marc Mazas)

13/11/09 - version 1.5.17
- Fixed formatting / syntax coloring / outline / autoindent / call hierarchy / context menus
  / messages issues
- Updated with JTB 1.4.0 and new options (Marc Mazas)

26/09/09 - version 1.5.16
- Support Variables in Builder, and Options
- Click in call hierarchy view reopen Editor if it was closed
- Keep jtb jar in preferences

07/09/09 - version 1.5.15
- Bug 2848368 support Galileo 
- Bug 2848673 support Mac OS X Leopard (compiled with java 1.5 instead of 1.6)
- Change the zip to be a zipped update site.
- Added JavaCC 5.0 new options

23/05/09 - version 1.5.14
- RfE 2589910 added call hierarchy

25/04/09 - modifications on version 1.5.12 (Marc Mazas)
- Updated / cleaned list of JavaCC / JJTree options in JavaCCOptions & JJTreeOptions
  according to JavaCC v4.2
- Fix in ParentMatcher to take in account '\"' characters in strings
- Added new preferences and a listener in JJPreferences, JJPreferencesPage, JJCodeScanner,
  messages.properties and messages_fr.properties
- Rewrote and enhanced formatting and indentation in Format, JJTokenRule and JJAutoIndentStrategy
- Modified Option, OptionSet, JJAbstractTab and JTBOption to improve JTB preferences tab readability

22/06/08 - version 1.5.12
- Folding RFE 1786801 Collapse/Expand
- Hovering RFE 1888744 Quick Outline
- AutoCompletion RFE 1769382 Auto-Completion for both the defined tokens and nodes ignoring case
- bug 1986438 JavaCC options don't save state in the project directory
  now saved in \.settings\sf.eclipse.javacc.prefs
- bug 1986443  Project->Clean doesn't clean the generated files
  the generated files are now deleted, except if they are marked as not derived in their properties
- bug 1990463  jjtree option TRACK_TOKENS is not functional 
  keyword added
- bug 1891111  Alt + left arrow should jump back to correct position
- bug 1816600  Outline lists return type instead of method name
- bug 1889637  Incorrect pair matching with Strings
- correcting navigation which took the last opened grammar
- correcting javacode which allows node descriptor (#)
- correcting return type from rules which broke outline
- keep last good parsing for folding, hover and Completion proposals

08/07/07 - version 1.5.11
- bug 1682259 JJTREE_OUTPUT_DIRECTORY
- bug 1745835 NullPointerException thrown for files with no extension

08/07/07 - version 1.5.10
- bug 1682259 JJTREE_OUTPUT_DIRECTORY
- bug 1745835 NullPointerException thrown for files with no extension

10/06/2007 - version 1.5.9 
Bug correction
- bug 1726419 Unicode Problem uppercase were not accepted
- bug 1720584 Not enough install space: 2.8G required
- bug 1702922 JTBEditor popup menu
- bug 1702893 xxx.jj.jtb Compile with JTB in popup menu.
- bug 1702776 error with JTB generated code JTB generates < < javacc corrected to allow << 

18/03/07 - version 1.5.8
- correct JJDoc bug (was not called on selected editor) 
- correct Console report (inverted JJTree and JavaCC)
- correct JJTREE_OUTPUT_DIRECTORY highlight and option setting
- correct new file wizard to check if options are set before setting defaults
- replace javacc.jar with last CVS version 2007/03/18 
- add new JJDoc options in javacc.jar (modified sources in javacc.jar)

10/03/07 - version 1.5.7
- correct double suppress warning 
- preserve unicode escape in characters and strings when formatting
- correct JJTree grammar to handle >> in outline

26/11/06 - version 1.5.6
- restore compatibility with Eclipse 3.1
- handle case with no src/bin dir defined

05/11/06 - version 1.5.5
- add feature 1584400 Better recognition of error/warning messages in console 
  hyperlinks (Warning / Error on two lines where not parsed)
- correct bug 1585822 Plug-in not working with Eclipse 3.2.1
- correct bug 1588477 Option 'suppress warnings' works only for public classes
- added a (basic) Ctrl+space content assistant for options keywords
- suppress warnings in sf.eclipse.javacc.wizards @SuppressWarnings("restriction") Java1.5
- switch the source to Java 1.5

01/10/06 - version 1.5.4
- suppress warnings in generated files thanks to Peter Murray and Ben Wake
- added global preferences for colors

24/05/06 - version 1.5.3
- corrected plugin key conflict F3 is now defined only for JavaCCPlugin
- corrected bug in automatic format

27/03/06 - version 1.5.2
- removed "exclude from build" and adopted Eclipse way, ie Build Path.
- added a French translation in a plugin fragment / feature patch
- corrected bug in outline alphabetic sort
- corrected bug in JTB wizard when default or no package is selected

24/02/06 - version 1.5.1
- added property to exclude a jj file from build
- packaged plug-in as Eclipse feature with update site
- packaged plug-in as a Directory (no more as a single jar) to use self contained javacc.jar 
- added automatic format

13/11/05 - version 1.5.0
- java 1.4 .class files compatibility
- bug correction (double compilation for .jtb in some case)
- icons for jtb files
- context help F1

31/10/05 - version 1.3
- support JTB
- Ctrl+ click to open definition
- corrected bug in outline now showing up the first time
- removed self-history (now use the Workbench history)

28/08/05 - version 1.2 
- support Eclipse 3.1
- support Java 1.5
- matching bracket highlight
- keyboard shortcuts, all actions are in plugin.xml
- comment lines Ctrl+/ 
- shortcut “F3” to open declaration and "F2" to go back
- launch JavaCC and JJTree from where are the .jj or .jjt file
- http://www.cecill.info/ instead of http://www.gnu.org/licenses/gpl.txt
- removed TabFolderLayout (was copied from
  org.eclipse.jdt.internal.ui.util.TabFolderLayout
  Odd to see that it was defined in JDT not SWT !)
- removed button on the toolbar (replaced with popup menu)
- added Class and Method icons in outline

26/10/04 - version 1.1 
- support Eclipse 3.0
- added syntax highlight for private productions <# token>
- added use of java instead of javaw on Window's systems to call javacc
- added marker hover 
- correct outline, was showing '.' when rule returns a class or Object[]

28/07/05 - version 1.2 
- hyperlinks in Console
- bug correction in Builder, Console

25/07/03 - 1.0 First release for Eclipse 2.1

