package view.exception;

import oracle.jbo.JboException;

public class XxCustomException extends JboException {
    private String resourceBundleKey;
    private String error_type;
    private String client_id;
    //private MessageToken[] tokens;
    public XxCustomException(String message) {
        super(message);
        setAppendCodes(false);
    }

    public XxCustomException(Throwable throwable) {
        super(throwable);
        setAppendCodes(false);
    }
    //setters and getters with required constructors

    public void setResourceBundleKey(String resourceBundleKey) {
        this.resourceBundleKey = resourceBundleKey;
    }

    public String getResourceBundleKey() {
        return resourceBundleKey;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public String getError_type() {
        return error_type;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_id() {
        return client_id;
    }
}
