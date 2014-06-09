package com.github.chroneus.juclipse.editor;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;

import com.github.chroneus.juclipse.*;

public class JuliaEditor extends ScriptEditor {
	
	public IDLTKLanguageToolkit getLanguageToolkit() {
		return JuliaLanguageToolkit.getDefault();
	}

	public IPreferenceStore getScriptPreferenceStore() {
		return JuliaPlugin.getDefault().getPreferenceStore();
	}
	
	public String getEditorId() {
		return "com.github.chroneus.juclipse.editor.JuliaEditor";
	}
	
	public ScriptTextTools getTextTools() {
		return JuliaPlugin.getDefault().getTextTools();
	}
}
