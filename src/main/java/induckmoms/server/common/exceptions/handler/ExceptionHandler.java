package induckmoms.server.common.exceptions.handler;


import induckmoms.server.common.code.BaseErrorCode;
import induckmoms.server.common.exceptions.BaseException;

public class ExceptionHandler extends BaseException {
    public ExceptionHandler(BaseErrorCode errorCode) {super(errorCode);}
}
