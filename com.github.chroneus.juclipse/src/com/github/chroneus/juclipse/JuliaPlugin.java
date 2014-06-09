package com.github.chroneus.juclipse;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.github.chroneus.juclipse.text.JuliaTextTools;

/**
 * The activator class controls the plug-in life cycle
 */
public class JuliaPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.dworks.octaveide";

	// The shared instance
	private static JuliaPlugin plugin;
	
	// The IDE text tools instance
	private JuliaTextTools fTextTools;
	
	/**
	 * The constructor
	 */
	public JuliaPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static JuliaPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the ScriptTextTools instance
	 *
	 * @return the text tools instance
	 */
	public JuliaTextTools getTextTools() {
		if(fTextTools == null) 
			fTextTools = new JuliaTextTools(true);
		return fTextTools;
	}
	
	public static void log(String msg) {
		getDefault().getLog().log(new Status(IStatus.OK, PLUGIN_ID, msg));
	}

}
