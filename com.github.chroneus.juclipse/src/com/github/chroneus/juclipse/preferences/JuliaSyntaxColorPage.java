package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.ui.preferences.AbstractConfigurationBlockPreferencePage;
import org.eclipse.dltk.ui.preferences.IPreferenceConfigurationBlock;
import org.eclipse.dltk.ui.preferences.OverlayPreferenceStore;

import com.github.chroneus.juclipse.JuliaPlugin;

public class JuliaSyntaxColorPage extends
		AbstractConfigurationBlockPreferencePage {

	protected IPreferenceConfigurationBlock createConfigurationBlock(
			OverlayPreferenceStore overlayPreferenceStore) {
		return new JuliaSyntaxColorConfigurationBlock(overlayPreferenceStore);
	}

	protected String getHelpId() {
		return "";
	}

	protected void setDescription() {
		setDescription("Syntax Coloring Preference Page");
	}

	protected void setPreferenceStore() {
		setPreferenceStore(JuliaPlugin.getDefault().getPreferenceStore());
	}
}
