package org.coody.reduce.common.exception;

import org.coody.framework.core.exception.base.CoodyException;

@SuppressWarnings("serial")
public class ReduceException extends CoodyException {

	public ReduceException(String msg) {
		super(msg);
	}

	public ReduceException(String msg, Exception e) {
		super(msg, e);
	}

}
