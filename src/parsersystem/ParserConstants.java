/* Generated By:JavaCC: Do not edit this line. ParserConstants.java */
package parsersystem;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int T_testName = 4;
  /** RegularExpression Id. */
  int T_baseDirectory = 5;
  /** RegularExpression Id. */
  int T_dirGraph = 6;
  /** RegularExpression Id. */
  int T_dirLog = 7;
  /** RegularExpression Id. */
  int T_dirConceptMap = 8;
  /** RegularExpression Id. */
  int T_nameUserTermsFile = 9;
  /** RegularExpression Id. */
  int T_minIterationToVerifyUniqueConnectedComponent = 10;
  /** RegularExpression Id. */
  int T_minIterationToVerifyRelationshipBetweenOriginalConcepts = 11;
  /** RegularExpression Id. */
  int T_maxIteration = 12;
  /** RegularExpression Id. */
  int T_additionNewConceptWithoutCategory = 13;
  /** RegularExpression Id. */
  int T_kCoreFilter = 14;
  /** RegularExpression Id. */
  int T_quantityNodesToApplyKcoreFilter = 15;
  /** RegularExpression Id. */
  int T_nDegreeFilter = 16;
  /** RegularExpression Id. */
  int T_iterationTriggerApplyNDegreeFilterAlgorithm = 17;
  /** RegularExpression Id. */
  int T_quantityNodesToApplyNdegreeFilter = 18;
  /** RegularExpression Id. */
  int T_conceptsQuantityCalculationFactor = 19;
  /** RegularExpression Id. */
  int T_conceptsMinMaxRange = 20;
  /** RegularExpression Id. */
  int T_proporcionBetweennessOnly = 21;
  /** RegularExpression Id. */
  int T_proporcionBetweennessCloseness = 22;
  /** RegularExpression Id. */
  int T_precisionBetweennessCloseness = 23;
  /** RegularExpression Id. */
  int T_maxBetweennessCloseness = 24;
  /** RegularExpression Id. */
  int T_proporcionEigenvector = 25;
  /** RegularExpression Id. */
  int T_precisionEigenvector = 26;
  /** RegularExpression Id. */
  int T_maxEigenvector = 27;
  /** RegularExpression Id. */
  int T_isBetweennessCloseness = 28;
  /** RegularExpression Id. */
  int T_isEigenvector = 29;
  /** RegularExpression Id. */
  int T_isSelected = 30;
  /** RegularExpression Id. */
  int T_isKeepNeighborsOfOriginalConcepts = 31;
  /** RegularExpression Id. */
  int T_quantityNodesShortReport = 32;
  /** RegularExpression Id. */
  int T_backGroundcolorOriginalConcept = 33;
  /** RegularExpression Id. */
  int T_borderThicknessConceptWithHint = 34;
  /** RegularExpression Id. */
  int T_nameGexfGraphFile = 35;
  /** RegularExpression Id. */
  int T_nameQueryDefaultFile = 36;
  /** RegularExpression Id. */
  int T_nameVocabularyFile = 37;
  /** RegularExpression Id. */
  int T_nameUselessConceptsFile = 38;
  /** RegularExpression Id. */
  int T_nameTxtConceptMapFile = 39;
  /** RegularExpression Id. */
  int T_nameCxlConceptMapFile = 40;
  /** RegularExpression Id. */
  int T_nameCompleteReportFile = 41;
  /** RegularExpression Id. */
  int T_nameShortReportFile = 42;
  /** RegularExpression Id. */
  int T_nameConsoleReportFile = 43;
  /** RegularExpression Id. */
  int T_nameConsoleErrorFile = 44;
  /** RegularExpression Id. */
  int T_dirRdfsPersistenceFiles = 45;
  /** RegularExpression Id. */
  int T_dbpediaServer = 46;
  /** RegularExpression Id. */
  int T_gephiVisualization = 47;
  /** RegularExpression Id. */
  int T_graphStreamVisualization = 48;
  /** RegularExpression Id. */
  int T_isFixBugInGephiToolKit = 49;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug0 = 50;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug1 = 51;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug2 = 52;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug3 = 53;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug4 = 54;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug5 = 55;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug6 = 56;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug7 = 57;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug8 = 58;
  /** RegularExpression Id. */
  int T_originalConceptWithGephiToolKitBug9 = 59;
  /** RegularExpression Id. */
  int T_isEnableUselessTable = 60;
  /** RegularExpression Id. */
  int T_isUniqueConnectedComponentToApplyNdegreeFilter = 61;
  /** RegularExpression Id. */
  int T_nameMyKnowledgeBaseFile = 62;
  /** RegularExpression Id. */
  int T_knowledgeBasePlace = 63;
  /** RegularExpression Id. */
  int T_maxLineLengthConcept = 64;
  /** RegularExpression Id. */
  int T_maxLineLengthLinkPhrase = 65;
  /** RegularExpression Id. */
  int EQUALS = 66;
  /** RegularExpression Id. */
  int NEW_LINE = 67;
  /** RegularExpression Id. */
  int TAB = 68;
  /** RegularExpression Id. */
  int BLANK = 69;
  /** RegularExpression Id. */
  int ARROW = 70;
  /** RegularExpression Id. */
  int COMMON_CHARACTER = 71;
  /** RegularExpression Id. */
  int SPECIAL_CHARACTER = 72;
  /** RegularExpression Id. */
  int TERM = 73;
  /** RegularExpression Id. */
  int SEPARATORS = 74;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int comentario_final = 1;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"//\"",
    "\"\\n\"",
    "<token of kind 3>",
    "\"testName\"",
    "\"baseDirectory\"",
    "\"dirGraph\"",
    "\"dirLog\"",
    "\"dirConceptMap\"",
    "\"nameUserTermsFile\"",
    "\"minIterationToVerifyUniqueConnectedComponent\"",
    "\"minIterationToVerifyRelationshipBetweenOriginalConcepts\"",
    "\"maxIteration\"",
    "\"additionNewConceptWithoutCategory\"",
    "\"kCoreFilter\"",
    "\"quantityNodesToApplyKcoreFilter\"",
    "\"nDegreeFilter\"",
    "\"iterationTriggerApplyNDegreeFilterAlgorithm\"",
    "\"quantityNodesToApplyNdegreeFilter\"",
    "\"conceptsQuantityCalculationFactor\"",
    "\"conceptsMinMaxRange\"",
    "\"proporcionBetweennessOnly\"",
    "\"proporcionBetweennessCloseness\"",
    "\"precisionBetweennessCloseness\"",
    "\"maxBetweennessCloseness\"",
    "\"proporcionEigenvector\"",
    "\"precisionEigenvector\"",
    "\"maxEigenvector\"",
    "\"isBetweennessCloseness\"",
    "\"isEigenvector\"",
    "\"isSelected\"",
    "\"isKeepNeighborsOfOriginalConcepts\"",
    "\"quantityNodesShortReport\"",
    "\"backGroundcolorOriginalConcept\"",
    "\"borderThicknessConceptWithHint\"",
    "\"nameGexfGraphFile\"",
    "\"nameQueryDefaultFile\"",
    "\"nameVocabularyFile\"",
    "\"nameUselessConceptsFile\"",
    "\"nameTxtConceptMapFile\"",
    "\"nameCxlConceptMapFile\"",
    "\"nameCompleteReportFile\"",
    "\"nameShortReportFile\"",
    "\"nameConsoleReportFile\"",
    "\"nameConsoleErrorFile\"",
    "\"dirRdfsPersistenceFiles\"",
    "\"dbpediaServer\"",
    "\"gephiVisualization\"",
    "\"graphStreamVisualization\"",
    "\"isFixBugInGephiToolKit\"",
    "\"originalConceptWithGephiToolKitBug0\"",
    "\"originalConceptWithGephiToolKitBug1\"",
    "\"originalConceptWithGephiToolKitBug2\"",
    "\"originalConceptWithGephiToolKitBug3\"",
    "\"originalConceptWithGephiToolKitBug4\"",
    "\"originalConceptWithGephiToolKitBug5\"",
    "\"originalConceptWithGephiToolKitBug6\"",
    "\"originalConceptWithGephiToolKitBug7\"",
    "\"originalConceptWithGephiToolKitBug8\"",
    "\"originalConceptWithGephiToolKitBug9\"",
    "\"isEnableUselessTable\"",
    "\"isUniqueConnectedComponentToApplyNdegreeFilter\"",
    "\"nameMyKnowledgeBaseFile\"",
    "\"knowledgeBasePlace\"",
    "\"maxLineLengthConcept\"",
    "\"maxLineLengthLinkPhrase\"",
    "<EQUALS>",
    "<NEW_LINE>",
    "<TAB>",
    "\" \"",
    "\"->\"",
    "<COMMON_CHARACTER>",
    "<SPECIAL_CHARACTER>",
    "<TERM>",
    "<SEPARATORS>",
  };

}