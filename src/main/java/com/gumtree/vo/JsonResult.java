package com.gumtree.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * JsonResult
 *  
 * @author rpayal
 *
 * @param <T>
 * 
 */
public class JsonResult<T> {

	private T data;
	private boolean success;
	private String message;
	private String code;
	private Map<String, String> errors = new HashMap<String, String>();

	/**
	 * 
	 * @param data
	 */
	public JsonResult(T data) {
		this.data = data;
		this.success = true;
	}

	/**
	 * 
	 * @param data
	 * @param success
	 * @param message
	 * @param code
	 */
	public JsonResult(T data, boolean success, String message, String code) {
		this.data = data;
		this.success = success;
		this.message = message;
		this.code = code;
	}

	/**
	 * Failed with errors.
	 * 
	 * @param data
	 * @param errors
	 */
	public JsonResult(final T data, final Map<String, String> errors) {
		this.data = data;
		this.errors = errors;
		if (!errors.isEmpty()) {
			this.success = false;
			this.message = "Data errors found";
			this.code = "500";
		}
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the errors
	 */
	public Map<String, String> getErrors() {
		return errors;
	}

}
