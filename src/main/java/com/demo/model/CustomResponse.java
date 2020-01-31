package com.demo.model;

public class CustomResponse<T> {
	private int status;

	/** The data. */
	private T data;
	
	private int requestId;

	public int getRequestId() {
		return requestId;
	}



	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public void setRequestId(int requestId2) {
		// TODO Auto-generated method stub
		this.requestId = requestId2;
		
	}

}
