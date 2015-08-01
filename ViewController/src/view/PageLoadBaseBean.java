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
    public void beforePhase(PagePhaseEvent event) {
        System.out.println("aaaaaaaaaaa");
        //        FacesPageLifecycleContext ctx =
        //            (FacesPageLifecycleContext)event.getLifecycleContext();
        //        if (event.getPhaseId() == Lifecycle.PREPARE_MODEL_ID) {
        //            bc = ctx.getBindingContainer();
        //            onPageLoad();
        //            bc = null;
        //        }
    }

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
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
