package com.github.chroneus.juclipse.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

/**
 * This scanner checks for comment and string partitions. Everything else
 * is considered part of the default partition.
 */
public class JuliaPartitionScanner extends RuleBasedPartitionScanner {

	public JuliaPartitionScanner() {
		super();

		// Declare the different tokens
		IToken string = new Token(IJuliaPartitions.JULIA_STRING);
		IToken comment = new Token(IJuliaPartitions.JULIA_COMMENT);

		// Create the list of rules that produce tokens
		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();
		rules.add(new SingleLineRule("%", "\n", comment));
		rules.add(new SingleLineRule("'", "'", string));
		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);
	}
}
