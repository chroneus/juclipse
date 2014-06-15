package com.github.chroneus.juclipse.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.DLTKColorConstants;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.WordRule;

public class JuliaCodeScanner extends AbstractScriptScanner {

	private static String fgTokenProperties[] = new String[] {
		DLTKColorConstants.DLTK_DEFAULT,
		DLTKColorConstants.DLTK_KEYWORD,
		DLTKColorConstants.DLTK_NUMBER
	};
	
	public JuliaCodeScanner(IColorManager manager, IPreferenceStore store) {
		super(manager, store);
		initialize();
	}

	protected List<IRule> createRules() {
		
		// Create tokens
		IToken keywordToken = getToken(DLTKColorConstants.DLTK_KEYWORD);
		IToken numberToken = getToken(DLTKColorConstants.DLTK_NUMBER);
		IToken defaultToken = getToken(DLTKColorConstants.DLTK_DEFAULT);
		
		// Create and populate list
		List<IRule> ruleList = new ArrayList<IRule>();
		
		// Create number rule to detect numbers
		NumberRule numberRule = new NumberRule(numberToken);
		ruleList.add(numberRule);
		
		// Create word rule to detect keywords
		WordRule wordRule = new WordRule(new JuliaWordDetector(), defaultToken);
		for (int i = 0; i < IJuliaKeywords.keywords.length; i++)
			wordRule.addWord(IJuliaKeywords.keywords[i], keywordToken);
		ruleList.add(wordRule);
		
		// Set the token returned for default text
		setDefaultReturnToken(defaultToken);
		return ruleList;
	}

	protected String[] getTokenProperties() {
		return fgTokenProperties;
	}
}