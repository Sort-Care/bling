package bling;

import java.util.*;
import bling.exception.InvalidStateLookupException;

/**
 * Keeps track of program state
 * @author ben
 *
 */
public class State {
	Map<String, Value> state = new HashMap<>();
	
	/**
	 * Get the value associated with {@code id} if available
	 * @param id
	 * @return the value associated with id
	 * @throws InvalidStateLookupException if id has no value associated
	 */
	public Value get(Id id) {
		Value v = state.get(id.name);
		if (v == null) {
			throw new InvalidStateLookupException(id);
		}
		return v;
	}
	
	/**
	 * Set the value associated with {@code id}
	 * @param id
	 * @param v
	 * @return
	 */
	public Value set(Id id, Value v) {
		return state.put(id.name, v);
	}
}
