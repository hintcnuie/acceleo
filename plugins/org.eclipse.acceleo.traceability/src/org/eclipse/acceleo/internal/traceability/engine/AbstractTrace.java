/*******************************************************************************
 * Copyright (c) 2009, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.internal.traceability.engine;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.acceleo.traceability.GeneratedText;
import org.eclipse.acceleo.traceability.InputElement;

/**
 * This will serve as the base class for traceability contexts.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public abstract class AbstractTrace {
	/** This will keep track of the current starting offset for added traces. */
	protected int currentOffset;

	/** maps input elements corresponding to this expression to the bits they were used to generate. */
	protected final LinkedHashMap<InputElement, Set<GeneratedText>> traces = new LinkedHashMap<InputElement, Set<GeneratedText>>();

	/**
	 * Adds the given trace to the list of traces corresponding to this expression, setting the offset as it
	 * goes.
	 * 
	 * @param input
	 *            Input element from which this region has been generated.
	 * @param trace
	 *            The actual trace that is to be recorded for this expression.
	 * @param value
	 *            Generated text value. This will be used to properly set the trace's offsets.
	 */
	public void addTrace(InputElement input, GeneratedText trace, Object value) {
		Set<GeneratedText> referredTraces = traces.get(input);
		if (referredTraces == null) {
			referredTraces = new LinkedHashSet<GeneratedText>();
			traces.put(input, referredTraces);
		}
		final String stringValue = value.toString();
		int startOffset = currentOffset;
		currentOffset = currentOffset + stringValue.length();
		trace.setSourceElement(input);
		trace.setStartOffset(startOffset);
		trace.setEndOffset(currentOffset);
		referredTraces.add(trace);
	}

	/**
	 * Disposes of this trace.
	 */
	public void dispose() {
		for (Map.Entry<InputElement, Set<GeneratedText>> entry : traces.entrySet()) {
			entry.getValue().clear();
		}
		traces.clear();
	}

	/**
	 * Returns this context's traces. Note that the returned Map will be a copy of the actual one. Use
	 * {@link #dispose()} afterwards to clean up this context.
	 * 
	 * @return A copy of this context's traces.
	 */
	public LinkedHashMap<InputElement, Set<GeneratedText>> getTraces() {
		return new LinkedHashMap<InputElement, Set<GeneratedText>>(traces);
	}

	/**
	 * We might need to reset the offset to a given value. This can be used to this end.
	 * 
	 * @param offset
	 *            Offset to reset to.
	 */
	public void setOffset(int offset) {
		currentOffset = offset;
	}
}