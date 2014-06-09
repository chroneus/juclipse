package com.github.chroneus.juclipse.text;

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * A simple implementation of the IWordDetector interface
 */
public class JuliaWordDetector implements IWordDetector {

	public boolean isWordPart(char character) {
		return Character.isJavaIdentifierPart(character);
	}
	
	public boolean isWordStart(char character) {
		return Character.isJavaIdentifierPart(character);
	}
}
