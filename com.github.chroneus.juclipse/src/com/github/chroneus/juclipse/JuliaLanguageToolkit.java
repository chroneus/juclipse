package com.github.chroneus.juclipse;

import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

public class JuliaLanguageToolkit extends AbstractLanguageToolkit {

	private static final String JULIA_CONTENT_TYPE = "com.github.chroneus.juclipse.juliaContentType";
	private static final String JULIA_LANGUAGE_NAME = "Julia";
	private static final String JULIA_NATURE_ID = JuliaNature.NATURE_ID;
	
	protected static IDLTKLanguageToolkit instance = new JuliaLanguageToolkit();
	
	public static IDLTKLanguageToolkit getDefault() {
		return instance;
	}
	
	public String getLanguageContentType() {
		return JULIA_CONTENT_TYPE;
	}

	public String getLanguageName() {
		return JULIA_LANGUAGE_NAME;
	}

	public String getNatureId() {
		return JULIA_NATURE_ID;
	}
}
