package com.github.chroneus.juclipse.text;

import org.eclipse.jface.text.IDocument;

/**
 * This class identifies the partitions recognized within Julia scripts. There
 * are only two: JULIA_COMMENT is the partition for script comments and 
 * JULIA_STRING is the partition for Octave strings. Regular script code is
 * not placed in a partition.
 */
public interface IJuliaPartitions {

	// This name uniquely identifies the Julia partitioning process
	public static final String JULIA_PARTITIONING = "__julia_partitioning__";
	
	public static final String JULIA_COMMENT = "__julia_comment__";
	public static final String JULIA_STRING = "__julia_string__";
	
    public final static String[] JULIA_PARTITION_TYPES = new String[] {
        IDocument.DEFAULT_CONTENT_TYPE, JULIA_STRING, JULIA_COMMENT
    };
}
