package com.github.chroneus.juclipse.text;

import org.eclipse.dltk.ui.text.ScriptOutlineInformationControl;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;

import com.github.chroneus.juclipse.JuliaPlugin;

public class JuliaOutlineInformationControl extends ScriptOutlineInformationControl {

	public JuliaOutlineInformationControl(Shell parent, int shellStyle,
			int treeStyle, String commandId) {
		super(parent, shellStyle, treeStyle, commandId);
	}

	protected IPreferenceStore getPreferenceStore() {
		return JuliaPlugin.getDefault().getPreferenceStore();
	}
	
}
