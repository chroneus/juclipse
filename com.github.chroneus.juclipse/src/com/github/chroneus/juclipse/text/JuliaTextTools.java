package com.github.chroneus.juclipse.text;

import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.ui.texteditor.ITextEditor;

public class JuliaTextTools extends ScriptTextTools {

	private IPartitionTokenScanner scanner;
	private final static String[] LEGAL_CONTENT_TYPES = IJuliaPartitions.JULIA_PARTITION_TYPES;
	
	public JuliaTextTools(boolean autoDisposeOnDisplayDispose) {
		super(IJuliaPartitions.JULIA_PARTITIONING, LEGAL_CONTENT_TYPES, autoDisposeOnDisplayDispose);
		scanner = new JuliaPartitionScanner();
	}

	public ScriptSourceViewerConfiguration createSourceViewerConfiguraton(
			IPreferenceStore preferenceStore, ITextEditor editor,
			String partitioning) {
		return new JuliaSourceViewerConfiguration(getColorManager(), 
				preferenceStore, editor, partitioning);
	}
	
	public IPartitionTokenScanner getPartitionScanner() {
		return scanner;
	}
	
	public void setupDocumentPartitioner(IDocument document, String partitioning) {
		IDocumentPartitioner partitioner = createDocumentPartitioner();
		if (partitioner != null) {
			partitioner.connect(document);
			if (document instanceof IDocumentExtension3) {
				IDocumentExtension3 extension3 = (IDocumentExtension3) document;
				extension3.setDocumentPartitioner(partitioning, partitioner);
			} else {
				document.setDocumentPartitioner(partitioner);
			}
		}
	}
}
