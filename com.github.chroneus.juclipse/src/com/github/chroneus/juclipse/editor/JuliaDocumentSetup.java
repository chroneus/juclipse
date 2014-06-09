package com.github.chroneus.juclipse.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;

import com.github.chroneus.juclipse.JuliaPlugin;
import com.github.chroneus.juclipse.text.*;

public class JuliaDocumentSetup implements IDocumentSetupParticipant {

	public void setup(IDocument document) {
		JuliaTextTools tools = JuliaPlugin.getDefault().getTextTools();
		tools.setupDocumentPartitioner(document, IJuliaPartitions.JULIA_PARTITIONING);
	}
}
