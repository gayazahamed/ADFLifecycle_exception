package view;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import oracle.adf.controller.faces.context.FacesPageLifecycleContext;
import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

import oracle.binding.BindingContainer;

public class PageLoadBaseBean implements PagePhaseListener {

    private BindingContainer bc = null;

    /**
     * Before the ADF page lifecycle's prepareModel phase, invoke a
     * custom onPageLoad() method. Subclasses override the onPageLoad()
     * to do something interesting during the
     * @param event
     */
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
     
        System.out.println("Lifecycle INIT_CONTEXT_ID : " +Lifecycle.INIT_CONTEXT_ID);
        System.out.println("Lifecycle PREPARE_MODEL_ID : " +Lifecycle.PREPARE_MODEL_ID);
        System.out.println("Lifecycle APPLY_INPUT_VALUES_ID : " +Lifecycle.APPLY_INPUT_VALUES_ID);
        System.out.println("Lifecycle VALIDATE_INPUT_VALUES_ID : " +Lifecycle.VALIDATE_INPUT_VALUES_ID);
        System.out.println("Lifecycle PROCESS_UPDATE_MODEL_ID : " +Lifecycle.PROCESS_UPDATE_MODEL_ID);
        System.out.println("Lifecycle VALIDATE_MODEL_UPDATES_ID : " +Lifecycle.VALIDATE_MODEL_UPDATES_ID);
        System.out.println("Lifecycle PROCESS_COMPONENT_EVENTS_ID : " +Lifecycle.PROCESS_COMPONENT_EVENTS_ID);
        System.out.println("Lifecycle METADATA_COMMIT_ID : " +Lifecycle.METADATA_COMMIT_ID);
        System.out.println("Lifecycle PREPARE_RENDER_ID : " +Lifecycle.PREPARE_RENDER_ID);
        System.out.println("    ");
        System.out.println("PhaseId ANY_PHASE : " +PhaseId.ANY_PHASE);
        System.out.println("PhaseId RESTORE_VIEW : " +PhaseId.RESTORE_VIEW);
        System.out.println("PhaseId APPLY_REQUEST_VALUES : " +PhaseId.APPLY_REQUEST_VALUES);
        System.out.println("PhaseId PROCESS_VALIDATIONS : " +PhaseId.PROCESS_VALIDATIONS);
        System.out.println("PhaseId UPDATE_MODEL_VALUES : " +PhaseId.UPDATE_MODEL_VALUES);
        System.out.println("PhaseId INVOKE_APPLICATION : " +PhaseId.INVOKE_APPLICATION);
        System.out.println("PhaseId RENDER_RESPONSE : " +PhaseId.RENDER_RESPONSE);
        
        System.out.println("PhaseId VALUES : " +PhaseId.VALUES);
            
        System.out.println("    ");
        System.out.println("    ");
        System.out.println("------Before Phase id    : "+pagePhaseEvent.getPhaseId());
        //        FacesPageLifecycleContext ctx =
        //            (FacesPageLifecycleContext)event.getLifecycleContext();
        //        if (event.getPhaseId() == Lifecycle.PREPARE_MODEL_ID) {
        //            bc = ctx.getBindingContainer();
        //            onPageLoad();
        //            bc = null;
        //        }
    }

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
    System.out.println("-----After Phase id    : "+pagePhaseEvent.getPhaseId());
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
}
