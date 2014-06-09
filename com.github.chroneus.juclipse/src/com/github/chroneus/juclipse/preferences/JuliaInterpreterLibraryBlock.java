package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.internal.debug.ui.interpreters.AbstractInterpreterLibraryBlock;
import org.eclipse.dltk.internal.debug.ui.interpreters.AddScriptInterpreterDialog;
import org.eclipse.dltk.internal.debug.ui.interpreters.LibraryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IBaseLabelProvider;

import com.github.chroneus.juclipse.JuliaPlugin;

public class JuliaInterpreterLibraryBlock extends AbstractInterpreterLibraryBlock {

	public JuliaInterpreterLibraryBlock(AddScriptInterpreterDialog d) {
		super(d);
	}

	protected IBaseLabelProvider getLabelProvider() {
		return new LibraryLabelProvider();
	}
	
	protected IDialogSettings getDialogSettions() {
		return JuliaPlugin.getDefault().getDialogSettings();
	}
}
