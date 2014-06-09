package com.github.chroneus.juclipse.launch;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.dltk.console.ConsoleRequest;
import org.eclipse.dltk.console.IScriptConsoleIO;
import org.eclipse.dltk.console.IScriptExecResult;
import org.eclipse.dltk.console.IScriptInterpreter;

public class JuliaInterpreter implements ConsoleRequest, IScriptInterpreter {

	public void consoleConnected(IScriptConsoleIO protocol) {
		System.out.println("Connecting the console!");
	}

	public void addInitialListenerOperation(Runnable runnable) {
		// TODO Auto-generated method stub
		
	}

	public InputStream getInitialOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public List getCompletions(String commandLine, int position)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription(String commandLine, int position)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getNames(String type) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public IScriptExecResult exec(String command) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}
