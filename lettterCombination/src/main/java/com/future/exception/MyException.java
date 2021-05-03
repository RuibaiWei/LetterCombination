package com.future.exception;

/**
 * swrap my old exception
 */
public class MyException extends Exception {

  /** given a default value */
  private int errorCode = 10;

  /** the error message */
  private String errorMessage;

  public MyException() {
    super();
  }

  public MyException(int errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public MyException(String errorMessage) {
    super();
    this.errorMessage = errorMessage;
  }

  public MyException(int errorCode, String errorMessage) {
    super();
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}
