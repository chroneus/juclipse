package com.github.chroneus.juclipse.text;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.DLTKColorConstants;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.dltk.ui.text.ScriptPresentationReconciler;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.SingleTokenScriptScanner;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.ITextEditor;

import com.github.chroneus.juclipse.preferences.JuliaContentAssistPreference;

public class JuliaSourceViewerConfiguration extends
		ScriptSourceViewerConfiguration {

	// The scanners used to reconcile the script
	private AbstractScriptScanner codeScanner, stringScanner, commentScanner;
	
	public JuliaSourceViewerConfiguration(IColorManager colorManager,
			IPreferenceStore preferenceStore, ITextEditor editor,
			String partitioning) {
		super(colorManager, preferenceStore, editor, partitioning);
	}

	protected ContentAssistPreference getContentAssistPreference() {
		return JuliaContentAssistPreference.getDefault();
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		
		// Create a presentation reconciler
		PresentationReconciler reconciler = new ScriptPresentationReconciler();
		reconciler
			.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		// Create a DefaultDamagerRepairer for the default partition (code)
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(codeScanner);
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		// Create a DefaultDamagerRepairer for string partitions
		dr = new DefaultDamagerRepairer(stringScanner);
		reconciler.setDamager(dr, IJuliaPartitions.JULIA_STRING);
		reconciler.setRepairer(dr, IJuliaPartitions.JULIA_STRING);

		// Create a DefaultDamagerRepairer for comment partitions
		dr = new DefaultDamagerRepairer(commentScanner);
		reconciler.setDamager(dr, IJuliaPartitions.JULIA_COMMENT);
		reconciler.setRepairer(dr, IJuliaPartitions.JULIA_COMMENT);

		return reconciler;
	}

	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return IJuliaPartitions.JULIA_PARTITION_TYPES;
	}
	
	/**
	 * Create scanners to analyze text inside partitions
	 */
	protected void initializeScanners() {

	   // Create a scanner for the script code
	   codeScanner = new JuliaCodeScanner(getColorManager(), fPreferenceStore);
	   
	   // Create a scanner for string partitions
	   stringScanner = new SingleTokenScriptScanner(getColorManager(), 
					fPreferenceStore, DLTKColorConstants.DLTK_STRING);
	   
	   // Create a scanner for comment partitions
	   commentScanner = new SingleTokenScriptScanner(getColorManager(), 
					fPreferenceStore, DLTKColorConstants.DLTK_SINGLE_LINE_COMMENT);
	}
	
	protected IInformationControlCreator getOutlinePresenterControlCreator(
			ISourceViewer sourceViewer, final String commandId) {
		return new IInformationControlCreator() {
			public IInformationControl createInformationControl(Shell parent) {
				int shellStyle = SWT.RESIZE;
				int treeStyle = SWT.V_SCROLL | SWT.H_SCROLL;
				return new JuliaOutlineInformationControl(parent, shellStyle,
						treeStyle, commandId);
			}
		};
	}
}
