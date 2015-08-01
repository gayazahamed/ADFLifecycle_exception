package view.exception;

import oracle.jbo.JboException;
import oracle.jbo.common.ResourceBundleDef;

public class Gayaz_JBOException  extends JboException {

    
 
    @SuppressWarnings("compatibility:3411983019741029400")
    private static final long serialVersionUID = 532601415674542175L;
    
    public static final String LOG_FATAL = "FATAL";
    public static final String LOG_ERROR = "ERROR";
    public static final String LOG_WARN = "WARN";
    public static final String LOG_INFO = "INFO";
    public static final String LOG_DEBUG = "DEBUG";
    public static final String LOG_TRACE = "TRACE";
    public static final String LOG_NONE = "NONE";
    
    private String logLevel = LOG_ERROR;
        
    public Gayaz_JBOException(String message) {
        super(message);
        setAppendCodes(false);
    }

    public Gayaz_JBOException(Throwable throwable) {
        super(throwable);
        setAppendCodes(false);
    }

    public Gayaz_JBOException(Class resBundleClass, String errorCode,
                                  Object[] params) {
        super(resBundleClass, errorCode, params);
        setAppendCodes(false);
    }

    public Gayaz_JBOException(Class resBundleClass, String errorCode,
                                  Object[] params, Exception[] exceptions) {
        super(resBundleClass, errorCode, params, exceptions);
        setAppendCodes(false);
    }

    public Gayaz_JBOException(String message, String errorCode,
                                  Object[] params) {
        super(message, errorCode, params);
        setAppendCodes(false);
    }

    public Gayaz_JBOException(ResourceBundleDef resourceBundleDef,
                                  String errorCode, Object[] params) {
        super(resourceBundleDef, errorCode, params);
        setAppendCodes(false);
    }

    public Gayaz_JBOException(Class resBundleClass, String errorCode,
                                  Object[] params,
                                  JboException[] jboExceptions) {
        super(resBundleClass, errorCode, params, jboExceptions);
        setAppendCodes(false);
    }
    
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogLevel() {
        return logLevel;
    }

}

