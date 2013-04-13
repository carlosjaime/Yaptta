package edu.ece.ncsu.unofficial.yaptta.core.conduits;

public class ConduitException extends Exception {
	private static final long serialVersionUID = 6260933869825061968L;

	public ConduitException() {
		super();
	}

//	public ConduitException(String message, Throwable cause,
//			boolean enableSuppression, boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//	}

	public ConduitException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConduitException(String message) {
		super(message);
	}

	public ConduitException(Throwable cause) {
		super(cause);
	}
	
}
