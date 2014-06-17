package com.github.chroneus.juclipse.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.DLTKColorConstants;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.*;

public class JuliaCodeScanner extends AbstractScriptScanner {

	
	public JuliaCodeScanner(IColorManager manager, IPreferenceStore store) {
		super(manager, store);
		initialize();
	}

	protected List<IRule> createRules() {
		
		// Create and populate list
		List<IRule> ruleList = new ArrayList<IRule>();
		
		//single line comment rule
		
		EndOfLineRule commentRule = new EndOfLineRule("#",   getToken(DLTKColorConstants.DLTK_SINGLE_LINE_COMMENT));//does not work with #'
		ruleList.add(commentRule);
		
		// Create number rule to detect numbers
		NumberRule numberRule = new NumberRule(getToken(DLTKColorConstants.DLTK_NUMBER));
		ruleList.add(numberRule);
		
		// Create word rule to detect keywords
		WordRule wordRule = new WordRule(new JuliaWordDetector(),  getToken(DLTKColorConstants.DLTK_DEFAULT));
		for (int i = 0; i < IJuliaKeywords.keywords.length; i++)
			wordRule.addWord(IJuliaKeywords.keywords[i], getToken(DLTKColorConstants.DLTK_KEYWORD));
		ruleList.add(wordRule);
	  	
		PatternRule stringRule = new PatternRule("\"","\"", getToken(DLTKColorConstants.DLTK_STRING), '\\', false);
		ruleList.add(stringRule);
		// Set the token returned for default text
		setDefaultReturnToken(getToken(DLTKColorConstants.DLTK_DEFAULT));
		return ruleList;
	}

	protected String[] getTokenProperties() {
		return new String[] {
				DLTKColorConstants.DLTK_DEFAULT,
				DLTKColorConstants.DLTK_KEYWORD,
				DLTKColorConstants.DLTK_NUMBER,
				DLTKColorConstants.DLTK_SINGLE_LINE_COMMENT,
				DLTKColorConstants.DLTK_STRING
			};
	}
}