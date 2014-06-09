package com.github.chroneus.juclipse.launch;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.dltk.console.IScriptInterpreter;
import org.eclipse.dltk.console.ui.IScriptConsole;
import org.eclipse.dltk.console.ui.IScriptConsoleFactory;
import org.eclipse.dltk.console.ui.ScriptConsole;
import org.eclipse.dltk.console.ui.ScriptConsoleFactoryBase;

public class JuliaConsoleFactory extends ScriptConsoleFactoryBase implements IScriptConsoleFactory {

	public IScriptConsole openConsole(IScriptInterpreter interpreter, String id,
			ILaunch launch) {return createConsoleInstance();
	}

	protected ScriptConsole createConsoleInstance() {
		return null;
	}
}
