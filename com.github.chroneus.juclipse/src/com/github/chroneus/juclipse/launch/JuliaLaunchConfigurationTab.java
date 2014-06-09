package com.github.chroneus.juclipse.launch;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.dltk.core.PreferencesLookupDelegate;
import org.eclipse.dltk.debug.ui.launchConfigurations.MainLaunchConfigurationTab;

import com.github.chroneus.juclipse.JuliaNature;

public class JuliaLaunchConfigurationTab extends MainLaunchConfigurationTab {

	public JuliaLaunchConfigurationTab(String mode) {
		super(mode);
		if (ILaunchManager.RUN_MODE.equals(mode)) {
			enableInteractiveConsoleGroup();
		}
	}

	protected boolean breakOnFirstLinePrefEnabled(
			PreferencesLookupDelegate delegate) {
		return false;
	}

	protected boolean dbpgLoggingPrefEnabled(PreferencesLookupDelegate delegate) {
		return false;
	}

	public String getNatureID() {
		return JuliaNature.NATURE_ID;
	}
}
