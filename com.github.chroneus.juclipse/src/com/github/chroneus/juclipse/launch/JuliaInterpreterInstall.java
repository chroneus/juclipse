package com.github.chroneus.juclipse.launch;

import org.eclipse.dltk.launching.AbstractInterpreterInstall;
import org.eclipse.dltk.launching.IInterpreterInstallType;

import com.github.chroneus.juclipse.JuliaNature;

public class JuliaInterpreterInstall extends AbstractInterpreterInstall {

	public JuliaInterpreterInstall(IInterpreterInstallType type, String id) {
		super(type, id);
	}

	public String getNatureId() {
		return JuliaNature.NATURE_ID;
	}
}
