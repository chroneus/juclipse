package com.github.chroneus.juclipse;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.IDLTKUILanguageToolkit;
import org.eclipse.dltk.ui.ScriptElementLabels;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.templates.ITemplateAccess;
import org.eclipse.dltk.ui.viewsupport.ScriptUILabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;

import com.github.chroneus.juclipse.text.IJuliaPartitions;
import com.github.chroneus.juclipse.text.JuliaSourceViewerConfiguration;

public class JuliaUILanguageToolkit implements IDLTKUILanguageToolkit {

	private static final String INTERPRETERS_PREFERENCE_PAGE_ID = "net.sf.ui.preferences.interpreters";
	private static final String DEBUG_PREFERENCE_PAGE_ID = "net.sf.octclipse.preferences.debug";
	private static final String[] EDITOR_PREFERENCE_PAGES_IDS = {
		"com.github.chroneus.juliaide.preferences.editor", 
		"com.github.chroneus.juliaide.preferences.editor.templates", 
		"com.github.chroneus.juliaide.preferences.editor.syntaxcoloring", 
		"com.github.chroneus.juliaide.preferences.editor.hovers", 
		"com.github.chroneus.juliaide.preferences.editor.smarttyping", 
		"com.github.chroneus.juliaide.preferences.editor.folding", 
	};
	
	private static IDLTKUILanguageToolkit instance = new JuliaUILanguageToolkit();

	public static IDLTKUILanguageToolkit getInstance() {
		if( instance == null ) {
			instance = new JuliaUILanguageToolkit();
		}
		return instance;
	}
	
	/**
	 * Identify the Octave editor
	 */
	public String getEditorId(Object inputElement) {
		return "com.github.chroneus.juliaide.editor.JuliaEditor";
	}
	
	/**
	 * Provide the OctaveTextTool object
	 */
	public ScriptTextTools getTextTools() {
		return JuliaPlugin.getDefault().getTextTools();
	}
	
	/**
	 * Return the SourceViewerConfiguration object
	 */
	public ScriptSourceViewerConfiguration createSourceViewerConfiguration() {
		return new JuliaSourceViewerConfiguration(getTextTools().getColorManager(), 
			getPreferenceStore(), null,	getPartitioningId());
	}
	
	/**
	 * Identify the Octave partitioning
	 */
	public String getPartitioningId() {
		return IJuliaPartitions.JULIA_PARTITIONING;
	}
	
	/**
	 * Return the Octave preference store
	 */
	public IPreferenceStore getPreferenceStore() {
		return null;
		// OctclipseUIPlugin.getDefault().getPreferenceStore();
	}
	
	/**
	 * Identify the preference pages for the Octave editor
	 */
	public String[] getEditorPreferencePages() {
		return EDITOR_PREFERENCE_PAGES_IDS;
	}
	
	/**
	 * Identify the preference page for the Octave interpreter
	 */
	public String getInterpreterPreferencePage() {
		return INTERPRETERS_PREFERENCE_PAGE_ID;
	}
	
	/**
	 * Identify the container for the Octave interpreter
	 */
	public String getInterpreterContainerId() {
		return "com.chroneus.github.juclipse.INTERPRETER_CONTAINER";
	}
	
	public String getDebugPreferencePage() {
		return DEBUG_PREFERENCE_PAGE_ID;
	}
	
	public ScriptUILabelProvider createScripUILabelProvider() {
		return null;
	}

	public IDLTKLanguageToolkit getCoreToolkit() {
		return null;
	}

	public IDialogSettings getDialogSettings() {
		return JuliaPlugin.getDefault().getDialogSettings();
	}

	public boolean getProvideMembers(ISourceModule element) {
		return true;
	}
	
	private static class OctaveScriptElementLabels extends ScriptElementLabels {
		public OctaveScriptElementLabels() {
			super();
		}
	}
	
	public ScriptElementLabels getScriptElementLabels() {
		return new OctaveScriptElementLabels();
	}

	public ScriptUILabelProvider createScriptUILabelProvider() {
		return null;
	}

	@Override
	public boolean getBoolean(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IPreferenceStore getCombinedPreferenceStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITemplateAccess getEditorTemplates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEditorTemplatesPreferencePageId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInt(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getString(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
