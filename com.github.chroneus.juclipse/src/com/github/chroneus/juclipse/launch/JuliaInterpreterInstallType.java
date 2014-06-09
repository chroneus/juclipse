package com.github.chroneus.juclipse.launch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.environment.IDeployment;
import org.eclipse.dltk.core.environment.IFileHandle;
import org.eclipse.dltk.internal.launching.AbstractInterpreterInstallType;
import org.eclipse.dltk.launching.IInterpreterInstall;

import com.github.chroneus.juclipse.JuliaNature;
import com.github.chroneus.juclipse.JuliaPlugin;

public class JuliaInterpreterInstallType extends AbstractInterpreterInstallType {

	protected String getBuildPathDelimeter() {
		return File.pathSeparator;
	}
	
	protected String[] readPathsFromProcess(IProgressMonitor monitor, Process p) {
		final BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		final List result = new ArrayList();
		final Object lock = new Object();
		Thread tReading = new Thread(new Runnable() {
			public void run() {
				try {
					result.add(dataIn.readLine());
					synchronized (lock) {
						lock.notifyAll();
					}
				} catch (IOException e) {
				}
			}
		});
		tReading.start();
		synchronized (lock) {
			try {
				lock.wait(5000);
			} catch (InterruptedException e) {
			}
			p.destroy();
		}
		return (String[]) result.toArray(new String[result.size()]);
	}
	
	protected String[] buildCommandLine(IFileHandle installLocation,
			IFileHandle pathFile) {
		return new String[] { installLocation.getCanonicalPath(), "-q", pathFile.getCanonicalPath() };
	}
	
	protected IPath createPathFile(IDeployment deployment) throws IOException {
		return null;
	}

	protected IInterpreterInstall doCreateInterpreterInstall(String id) {
		return new JuliaInterpreterInstall(this, id);
	}

	protected ILog getLog() {
		return JuliaPlugin.getDefault().getLog();
	}

	protected String getPluginId() {
		return JuliaPlugin.PLUGIN_ID;
	}

	protected String[] getPossibleInterpreterNames() {
		return new String[]{"julia","julia-debug"};
	}

	public String getName() {
		return "Julia Installation Type";
	}

	public String getNatureId() {
		return JuliaNature.NATURE_ID;
	}
}
