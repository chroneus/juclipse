package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.ui.preferences.AbstractConfigurationBlock;
import org.eclipse.dltk.ui.preferences.OverlayPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class JuliaMainConfigurationBlock extends AbstractConfigurationBlock {

	public JuliaMainConfigurationBlock(OverlayPreferenceStore store) {
		super(store);
	}

	public Control createControl(Composite parent) {
		return null;
	}

}
