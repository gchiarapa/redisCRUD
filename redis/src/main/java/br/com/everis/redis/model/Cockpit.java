package br.com.everis.redis.model;

import java.io.Serializable;
import java.util.Set;

public class Cockpit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	private String value;
	private Set<String> keys;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the keys
	 */
	public Set<String> getKeys() {
		return keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(Set<String> keys) {
		this.keys = keys;

	}

}
