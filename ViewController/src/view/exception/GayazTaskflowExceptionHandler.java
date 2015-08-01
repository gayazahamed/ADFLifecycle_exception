package view.exception;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.ViewPortContext;

public class GayazTaskflowExceptionHandler {
    public GayazTaskflowExceptionHandler() {
        super();
    }


    /**
     * This method handles exceptions in any taskflow activities.
     * We will get the exceptions from ControllerContext and delegate the handling part to
     * ScgExceptionUtils.handleException method.
     * This method should be configured as an exception handler activity in the Unbounded/Bounded Taskflow.
     */
    public static void handleException() {
        System.out.println("Entering Taskflow exception handler");

        ControllerContext cc = ControllerContext.getInstance();

        System.out.println("current view port viewid: " +
                           cc.getCurrentViewPort().getViewId());

        ViewPortContext viewport = cc.getCurrentViewPort();

        if (viewport.isExceptionPresent()) {
            cc.getCurrentViewPort().clearException();
            GayazExceptionUtils.handleException(viewport.getExceptionData());
        }
        System.out.println("Exiting Taskflow exception handler");
    }

}
