package com.github.chroneus.juclipse.preferences;

import org.eclipse.dltk.internal.debug.ui.interpreters.AddScriptInterpreterDialog;
import org.eclipse.dltk.internal.debug.ui.interpreters.InterpretersBlock;
import org.eclipse.dltk.launching.IInterpreterInstall;
import org.eclipse.dltk.launching.ScriptRuntime;

import com.github.chroneus.juclipse.JuliaNature;

public class JuliaInterpretersBlock extends InterpretersBlock {

	protected String getCurrentNature() {
		return JuliaNature.NATURE_ID;
	}

	protected AddScriptInterpreterDialog createInterpreterDialog(
			IInterpreterInstall install) {
		return new JuliaAddInterpreterDialog(this, 
				getShell(), ScriptRuntime.getInterpreterInstallTypes(getCurrentNature()), install);
	}
}
