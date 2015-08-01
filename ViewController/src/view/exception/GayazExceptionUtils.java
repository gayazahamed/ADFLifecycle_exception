package view.exception;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GayazExceptionUtils {
   // private static MyAccountLogger logger = new MyAccountLogger(GayazExceptionUtils.class);
    
    public GayazExceptionUtils() {
        super();
    }

    /**
     * This method will log the exception 
     * @param exception
     */
    public static void handleException(Exception exception) {
        Gayaz_JBOException scgex = null;
        if( exception != null ) {
            Throwable exCause = exception.getCause();
    
            if (exception instanceof Gayaz_JBOException) {
                scgex = (Gayaz_JBOException)exception;
            } else {
                scgex = new Gayaz_JBOException(exception);
            }
    
            GayazExceptionUtils.logException(scgex);
        }

        // TODO
        // How to handle different exception types,
        // eg: NullpointerException, MalformedURLException, ClasscastException
        
        // How to handle SystemExceptions and BusinessExceptions
        // should be modified as per the consuming application
        
    }

    /**
     * This method will add a Error FacesMessage to be displayed to the user based on the exception
     * @param e
     */
    public static void displayErrorMessage(Gayaz_JBOException e) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage facesMessage =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                             e.getMessage());
        fc.addMessage(null, facesMessage);
    }


    /**
     * This method will add a Error FacesMessage to be displayed to the user based on the input String
     * @param msg
     */
    public static void displayErrorMessage(String msg) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, null, msg);
        fc.addMessage(null, facesMessage);
    }

    /**
     * This method will add a FacesMessage to be displayed to the user based on the exception and severity
     * @param e
     * @param severity 
     */
    public static void displayMessage(Gayaz_JBOException e,
                                      FacesMessage.Severity severity) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage facesMessage =
            new FacesMessage(severity, null, e.getMessage());
        fc.addMessage(null, facesMessage);
    }

    /**
     * This method will add a FacesMessage to be displayed to the user based on the message and severity
     * @param msg
     * @param severity
     */
    public static void displayMessage(String msg,
                                      FacesMessage.Severity severity) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(severity, null, msg);
        fc.addMessage(null, facesMessage);
    }

    /**
     * This method will log the exception in the specified log level
     * @param exception
     */
    public static void logException(Gayaz_JBOException exception) {
        String message = exception.getMessage();
        String logLevel = exception.getLogLevel();

        if (logLevel.equals(exception.LOG_NONE)) {
            // Do nothing
        } else if (logLevel.equals(exception.LOG_FATAL))
            System.out.println(message+ exception.getCause());
        else if (logLevel.equals(exception.LOG_ERROR))
            System.out.println(message+exception.getCause());
        else if (logLevel.equals(exception.LOG_WARN))
            System.out.println(message);
        else if (logLevel.equals(exception.LOG_INFO))
            System.out.println(message);
        else if (logLevel.equals(exception.LOG_DEBUG))
           System.out.println(message);
        else if (logLevel.equals(exception.LOG_TRACE))
           System.out.println(message);
    }


    }
