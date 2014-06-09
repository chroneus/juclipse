package com.github.chroneus.juclipse.launch;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.dltk.launching.AbstractScriptLaunchConfigurationDelegate;
import org.eclipse.dltk.launching.InterpreterConfig;

import com.github.chroneus.juclipse.JuliaNature;

public class JuliaLaunchConfigurationDelegate extends 
	AbstractScriptLaunchConfigurationDelegate {

	private static final String JULIAPATH_ENV_VAR = "JULIA_PATH";
	
	public String getLanguageId() {
		return JuliaNature.NATURE_ID;
	}
	
	protected void checkEnvVars(InterpreterConfig config,
			ILaunchConfiguration configuration) {
	}

	protected InterpreterConfig createInterpreterConfig(
			ILaunchConfiguration configuration, ILaunch launch)
			throws CoreException {
		InterpreterConfig config = super.createInterpreterConfig(
				configuration, launch);

		addLibpathEnvVar(config, configuration);
		checkEnvVars(config, configuration);

		return config;
	}
	
	protected void addLibpathEnvVar(InterpreterConfig config,
			ILaunchConfiguration configuration) throws CoreException {
		config.removeEnvVar(JULIAPATH_ENV_VAR);
		IPath[] paths = createBuildPath(configuration);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < paths.length; ++i) {
			sb.append(paths[i].toOSString());
			if (i < paths.length - 1) {
				sb.append(File.pathSeparator);
			}
		}
		config.addEnvVar(JULIAPATH_ENV_VAR, sb.toString());
	}
}
