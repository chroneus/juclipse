package com.github.chroneus.juclipse.preferences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.dltk.internal.ui.editor.ScriptSourceViewer;
import org.eclipse.dltk.ui.preferences.AbstractScriptEditorColoringConfigurationBlock;
import org.eclipse.dltk.ui.preferences.IPreferenceConfigurationBlock;
import org.eclipse.dltk.ui.preferences.OverlayPreferenceStore;
import org.eclipse.dltk.ui.text.DLTKColorConstants;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.ITextEditor;

import com.github.chroneus.juclipse.editor.*;
import com.github.chroneus.juclipse.text.IJuliaPartitions;
import com.github.chroneus.juclipse.text.JuliaSourceViewerConfiguration;

public class JuliaSyntaxColorConfigurationBlock extends
		AbstractScriptEditorColoringConfigurationBlock implements
		IPreferenceConfigurationBlock {

	private static final String PREVIEW_FILE_NAME = "testfile.txt";
	
	public JuliaSyntaxColorConfigurationBlock(OverlayPreferenceStore store) {
		super(store);
	}

	protected ProjectionViewer createPreviewViewer(Composite parent,
			IVerticalRuler verticalRuler, IOverviewRuler overviewRuler,
			boolean showAnnotationsOverview, int styles, IPreferenceStore store) {
		return new ScriptSourceViewer(parent, verticalRuler, overviewRuler,
				showAnnotationsOverview, styles, store);
	}

	protected ScriptSourceViewerConfiguration createSimpleSourceViewerConfiguration(
			IColorManager colorManager, IPreferenceStore preferenceStore,
			ITextEditor editor, boolean configureFormatter) {
		return new JuliaSourceViewerConfiguration(colorManager, preferenceStore, 
				editor, IJuliaPartitions.JULIA_PARTITIONING);
	}

	protected String[][] getSyntaxColorListModel() {
		return new String[][] {	
			{ "Single-Line Comments", DLTKColorConstants.DLTK_SINGLE_LINE_COMMENT, sCommentsCategory },			
			{ "Keywords", DLTKColorConstants.DLTK_KEYWORD, sCoreCategory },
			{ "Strings", DLTKColorConstants.DLTK_STRING, sCoreCategory },
			{ "Numbers", DLTKColorConstants.DLTK_NUMBER, sCoreCategory }};
	}

	protected void setDocumentPartitioning(IDocument document) {
		JuliaDocumentSetup participant = new JuliaDocumentSetup();
		participant.setup(document);
	}
	
	protected String getPreviewContent() {
		String line;
		String separator = System.getProperty("line.separator"); //$NON-NLS-1$
		StringBuffer buffer = new StringBuffer(512);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(getClass()
					.getResourceAsStream(PREVIEW_FILE_NAME)));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(separator);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		return buffer.toString();

	}
}
