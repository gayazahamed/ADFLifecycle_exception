package view;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import oracle.adf.controller.faces.context.FacesPageLifecycleContext;
import oracle.adf.controller.faces.lifecycle.JSFLifecycle;
import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

import oracle.binding.BindingContainer;

public class PageLoadBaseBean implements PagePhaseListener {

    private BindingContainer bc = null;


    /**
 *
Lifecycle INIT_CONTEXT_ID : 0
Lifecycle PREPARE_MODEL_ID : 1
Lifecycle APPLY_INPUT_VALUES_ID : 2
Lifecycle VALIDATE_INPUT_VALUES_ID : 3
Lifecycle PROCESS_UPDATE_MODEL_ID : 4
Lifecycle VALIDATE_MODEL_UPDATES_ID : 5
Lifecycle PROCESS_COMPONENT_EVENTS_ID : 6
Lifecycle METADATA_COMMIT_ID : 7
Lifecycle PREPARE_RENDER_ID : 8

PhaseId RESTORE_VIEW : RESTORE_VIEW 1
PhaseId APPLY_REQUEST_VALUES : APPLY_REQUEST_VALUES 2
PhaseId PROCESS_VALIDATIONS : PROCESS_VALIDATIONS 3
PhaseId UPDATE_MODEL_VALUES : UPDATE_MODEL_VALUES 4
PhaseId INVOKE_APPLICATION : INVOKE_APPLICATION 5
PhaseId RENDER_RESPONSE : RENDER_RESPONSE 6
 *
 */

    /**
     * Before the ADF page lifecycle's prepareModel phase, invoke a
     * custom onPageLoad() method. Subclasses override the onPageLoad()
     * to do something interesting during the
     * @param event
     */
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {

        //        System.out.println("Lifecycle INIT_CONTEXT_ID : " +Lifecycle.INIT_CONTEXT_ID);
        //        System.out.println("Lifecycle PREPARE_MODEL_ID : " +Lifecycle.PREPARE_MODEL_ID);
        //        System.out.println("Lifecycle APPLY_INPUT_VALUES_ID : " +Lifecycle.APPLY_INPUT_VALUES_ID);
        //        System.out.println("Lifecycle VALIDATE_INPUT_VALUES_ID : " +Lifecycle.VALIDATE_INPUT_VALUES_ID);
        //        System.out.println("Lifecycle PROCESS_UPDATE_MODEL_ID : " +Lifecycle.PROCESS_UPDATE_MODEL_ID);
        //        System.out.println("Lifecycle VALIDATE_MODEL_UPDATES_ID : " +Lifecycle.VALIDATE_MODEL_UPDATES_ID);
        //        System.out.println("Lifecycle PROCESS_COMPONENT_EVENTS_ID : " +Lifecycle.PROCESS_COMPONENT_EVENTS_ID);
        //        System.out.println("Lifecycle METADATA_COMMIT_ID : " +Lifecycle.METADATA_COMMIT_ID);
        //        System.out.println("Lifecycle PREPARE_RENDER_ID : " +Lifecycle.PREPARE_RENDER_ID);
        //        System.out.println("    ");
        //       // System.out.println("PhaseId ANY_PHASE : " +PhaseId.ANY_PHASE);
        //        System.out.println("PhaseId RESTORE_VIEW : " +PhaseId.RESTORE_VIEW);
        //        System.out.println("PhaseId APPLY_REQUEST_VALUES : " +PhaseId.APPLY_REQUEST_VALUES);
        //        System.out.println("PhaseId PROCESS_VALIDATIONS : " +PhaseId.PROCESS_VALIDATIONS);
        //        System.out.println("PhaseId UPDATE_MODEL_VALUES : " +PhaseId.UPDATE_MODEL_VALUES);
        //        System.out.println("PhaseId INVOKE_APPLICATION : " +PhaseId.INVOKE_APPLICATION);
        //        System.out.println("PhaseId RENDER_RESPONSE : " +PhaseId.RENDER_RESPONSE);
        //
        //        //System.out.println("PhaseId VALUES : " +PhaseId.VALUES);


        System.out.println("");
        System.out.println("------Before Phase id    : " +
                           pagePhaseEvent.getPhaseId());
        System.out.println("Before The Phase: " +
                           this.getPhaseName(pagePhaseEvent.getPhaseId()));
        //        FacesPageLifecycleContext ctx =
        //            (FacesPageLifecycleContext)event.getLifecycleContext();
        //        if (event.getPhaseId() == Lifecycle.PREPARE_MODEL_ID) {
        //            bc = ctx.getBindingContainer();
        //            onPageLoad();
        //            bc = null;
        //        }
    }

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        System.out.println("-----After Phase id    : " +
                           pagePhaseEvent.getPhaseId());
        System.out.println("After The Phase: " +
                           this.getPhaseName(pagePhaseEvent.getPhaseId()));
        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
            FacesContext facesCtx = FacesContext.getCurrentInstance();
            ExternalContext extCtx = facesCtx.getExternalContext();
            // Get HttpSession instance
            HttpSession session = (HttpSession)extCtx.getSession(false);
            // Get HttpServletRequest instance
            HttpServletRequest req = (HttpServletRequest)extCtx.getRequest();
        }
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }


    public void onPageLoad() {


        // Subclasses can override this.
    }

    public void onPagePreRender() {

        // Subclasses can override this.
    }

    protected boolean isPostback() {
        return Boolean.TRUE.equals(ADFUtils.invokeEL("#{adfFacesContext.postback}"));
    }
    /*  protected EWarrantyAdminModule getEWarrantyAdminModule() {
          return (EWarrantyAdminModule)getApplicationModuleForDataControl("EWarrantyAdminModuleDataControl");
        }
        protected ApplicationModule getApplicationModuleForDataControl(String name) {
          return (ApplicationModule)ADFUtil.resolveExpression("#{data."+name+".dataProvider}");
        }
        protected BindingContainer getBindingContainer() {
          return bc != null ? bc :(BindingContainer)ADFUtil.resolveExpression("#{bindings}");
        }
        protected DCIteratorBinding getIteratorBinding(String name) {
          return ((DCBindingContainer)getBindingContainer()).findIteratorBinding(name);
        }*/


    public String getPhaseName(int phaseId) {
        if (phaseId == JSFLifecycle.INIT_CONTEXT_ID) {
            return "INIT_CONTEXT";
        } else if (phaseId == JSFLifecycle.PREPARE_MODEL_ID) {
            return "PREPARE_MODEL";
        } else if (phaseId == JSFLifecycle.APPLY_INPUT_VALUES_ID) {
            return "APPLY_INPUT_VALUES";
        } else if (phaseId == JSFLifecycle.VALIDATE_INPUT_VALUES_ID) {
            return "VALIDATE_INPUT_VALUES";
        } else if (phaseId == JSFLifecycle.PROCESS_UPDATE_MODEL_ID) {
            return "PROCESS_UPDATE_MODEL";
        } else if (phaseId == JSFLifecycle.VALIDATE_MODEL_UPDATES_ID) {
            return "VALIDATE_MODEL_UPDATES";
        } else if (phaseId == JSFLifecycle.PROCESS_COMPONENT_EVENTS_ID) {
            return "PROCESS_COMPONENT_EVENTS";
        } else if (phaseId == JSFLifecycle.METADATA_COMMIT_ID) {
            return "METADATA_COMMIT";
        } else if (phaseId == JSFLifecycle.PREPARE_RENDER_ID) {
            return "PREPARE_RENDER";
        } else if (phaseId == JSFLifecycle.JSF_RESTORE_VIEW_ID) {
            return "RESTORE_VIEW";
        } else if (phaseId == JSFLifecycle.JSF_APPLY_REQUEST_VALUES_ID) {
            return "JSF_APPLY_REQUEST_VALUES";
        } else if (phaseId == JSFLifecycle.JSF_PROCESS_VALIDATIONS_ID) {
            return "JSF_PROCESS_VALIDATIONS";
        } else if (phaseId == JSFLifecycle.JSF_UPDATE_MODEL_VALUES_ID) {
            return "JSF_UPDATE_MODEL_VALUES";
        } else if (phaseId == JSFLifecycle.JSF_INVOKE_APPLICATION_ID) {
            return "JSF_INVOKE_APPLICATION";
        } else {
            return "JSF_RENDER_RESPONSE";
        }
    }

}
