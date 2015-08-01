package view.exception;

import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import oracle.adf.view.rich.context.ExceptionHandler;

public class XxControllerExpHandler extends ExceptionHandler {
    public void handleException(FacesContext facesContext, Throwable throwable,
                                PhaseId phaseId) throws Throwable {

        boolean isCustomExp = false;
        for (int i = 0; i < 10; i++) {
            if (throwable instanceof XxCustomException) {
                isCustomExp = true;
                break;
            }
            if (throwable != null) {
                throwable = throwable.getCause();
            }
        }

        if (isCustomExp) {
            if (throwable != null) {
                // The below method will show a Faces Message.
                // If client id of xxCustomException is not null then it will show a faces message on that component. 
                // It will try to get the message from resource bundle based on resourceBundleKey attribute. Error_type will decide if it is info, warning, severe
               // XxUtils.showMessage((XxCustomException)throwable);
            }
        } else {
            //this will be handled at taskflow level
            throw throwable;
        }
    }
}
