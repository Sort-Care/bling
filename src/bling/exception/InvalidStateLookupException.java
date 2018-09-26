package bling.exception;

import bling.Id;

public class InvalidStateLookupException extends RuntimeException {
	public InvalidStateLookupException(Id id) {
		this(id, "");
	}

	public InvalidStateLookupException(Id id, String message) {
		super("Couldn't find Id \"" + id.name + "\". " + message);
	}
}
