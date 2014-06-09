package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.dltk.ui.text.DLTKColorConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;

public class JuliaPreferenceConstants extends PreferenceConstants {
	
	public static void initializeDefaultValues(IPreferenceStore store) {
		
		// Set default preferences for the editor
		PreferenceConstants.initializeDefaultValues(store);

		// Make keywords blue and bold
		PreferenceConverter.setDefault(store, DLTKColorConstants.DLTK_KEYWORD, new RGB(40, 0, 200));
		store.setDefault(DLTKColorConstants.DLTK_KEYWORD + PreferenceConstants.EDITOR_BOLD_SUFFIX, true);

		// Set default values for other preferences
		PreferenceConverter.setDefault(store, DLTKColorConstants.DLTK_SINGLE_LINE_COMMENT, new RGB(25, 200, 25));
		PreferenceConverter.setDefault(store, DLTKColorConstants.DLTK_NUMBER, new RGB(255, 25, 25));
		PreferenceConverter.setDefault(store, DLTKColorConstants.DLTK_STRING, new RGB(50, 100, 100));
	}
}