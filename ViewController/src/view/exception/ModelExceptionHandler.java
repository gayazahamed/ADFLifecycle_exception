package view.exception;

import oracle.adf.model.binding.DCErrorHandlerImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.jbo.JboException;

public class ModelExceptionHandler extends DCErrorHandlerImpl {
    public ModelExceptionHandler() {
        super(true);
    }

    /**
     * This method will report the exceptions to the caller
     * (The caller can be a Taskflow activity or a managed bean method)
     *
     * @param dCBindingContainer
     * @param exception
     */
    @Override
    public void reportException(DCBindingContainer dCBindingContainer,
                                Exception exception) {
        System.out.println("Entering Model Exception Handler:reportException");
        //ScgExceptionUtils.handleException(exception);
        super.reportException(dCBindingContainer, exception);
        System.out.println("Exiting Model Exception Handler:reportException");


        //get message to be displayed from resource bundle or hardcode the message when throwing exception
//        String msg = XxUtils.getMessageString((XxCustomException)ex);
//        JboException jex = new JboException(msg);
//        super.reportException(formBnd, jex);


    }

    /**
     * This method will return the exception message displayed to the user
     * We are suppressing the message by returning null since we want to handle
     * the display of message to the end user in the Caller (i.e ManagedBean or Taskflow)
     *
     * @param bindingContext
     * @param exception
     * @return
     */
    @Override
    public String getDisplayMessage(BindingContext bindingContext,
                                    Exception exception) {
        //return super.getDisplayMessage(bindingContext, exception);

        // Suppressing the default behaviour of displaying exception
        // message to the user.
        return super.getDisplayMessage(bindingContext, exception);
    }

    @Override
    protected boolean skipException(Exception exception) {
        return super.skipException(exception);
    }
}
