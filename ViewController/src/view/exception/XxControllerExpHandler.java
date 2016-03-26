package view.exception;

import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import javax.servlet.http.HttpServletRequest;

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
            //  throw throwable;

            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request =
                (HttpServletRequest)facesContext.getExternalContext().getRequest();
            String uri = request.getRequestURI();
            uri = uri.substring(0, uri.indexOf("faces") + 5);
            ExternalContext ectx = facesContext.getExternalContext();
            ectx.redirect(uri + "/error.jspx");
 // or we can use this too
//            FacesContext context = FacesContext.getCurrentInstance();
//            ExternalContext externalContext = context.getExternalContext();
//            UIViewRoot newPage =
//                context.getApplication().getViewHandler().createView(context,
//                                                                     "/error.jspx");
//            context.setViewRoot(newPage);

        }
    }


    //    public void handleException(FacesContext facesContext, Throwable throwable,
    //                                PhaseId phaseId) throws Throwable {
    //        String error_message;
    //        error_message = throwable.getMessage();
    //        if (error_message != null &&
    //            error_message.indexOf("ADF_FACES-30108") > -1) {
    //            ExternalContext ectx = facesContext.getExternalContext();
    //            ectx.redirect("faces/error.jspx");
    //        } else {
    //          //  super.handleException(facesContext, throwable, phaseId);
    //        }
    //    }
}
