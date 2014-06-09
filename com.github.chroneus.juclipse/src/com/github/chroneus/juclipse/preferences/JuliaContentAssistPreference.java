package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;

import com.github.chroneus.juclipse.JuliaPlugin;

public class JuliaContentAssistPreference extends ContentAssistPreference {

	static JuliaContentAssistPreference instance;
	
	protected ScriptTextTools getTextTools() {
		return JuliaPlugin.getDefault().getTextTools();
	}

	public static ContentAssistPreference getDefault() {
		if(instance == null) {
			instance = new JuliaContentAssistPreference();
		}
		return instance;
	}
}
