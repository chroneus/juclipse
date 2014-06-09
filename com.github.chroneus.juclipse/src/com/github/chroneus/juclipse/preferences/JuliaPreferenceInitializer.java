package com.github.chroneus.juclipse.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.github.chroneus.juclipse.JuliaPlugin;

public class JuliaPreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = JuliaPlugin.getDefault().getPreferenceStore();
		JuliaPreferenceConstants.initializeDefaultValues(store);
	}
}
