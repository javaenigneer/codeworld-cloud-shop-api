package com.codeworld.fc.common.exception;

/**
 *异常Exception
 * @author 16924
 */
public class FCException extends RuntimeException {

    private static final long serialVersionUID = -7140424953329380195L;

    public FCException(){
        super();
    }

    public FCException(String message){

        super(message);
    }
}
