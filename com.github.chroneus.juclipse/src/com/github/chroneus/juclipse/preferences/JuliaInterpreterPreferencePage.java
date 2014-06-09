package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.internal.debug.ui.interpreters.InterpretersBlock;
import org.eclipse.dltk.internal.debug.ui.interpreters.ScriptInterpreterPreferencePage;

public class JuliaInterpreterPreferencePage extends 
	ScriptInterpreterPreferencePage {

	public InterpretersBlock createInterpretersBlock() {
		return new JuliaInterpretersBlock();
	}
}
