import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.controller.ControllerContext;

public class PLBean2 {
    public PLBean2() {
    }

    public String cb1_action() {
        // Add event code here...
        int i =1/0;
        System.out.println("2222222222222222222222");
        return null;
    }

    public String actionMethod() {
        // Add event code here...
        System.out.println("action");
        return "";
    }

    public void mehtod1ActionListner(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("actionListner");
    }
    
    public String throwErrorss() {     
        
      
        System.out.println("----------------method2");
        String str = null;
        if(str.equals("")){
            
        }
        
        System.out.println("111111111111111111");
        return "hello";
    }

    public String handleError() {
        ControllerContext cc = ControllerContext.getInstance();

           Exception ex = cc.getCurrentViewPort().getExceptionData();
           String message = ex.getMessage();


           FacesContext fc = FacesContext.getCurrentInstance();
           FacesMessage facesMessage =
             new FacesMessage(FacesMessage.SEVERITY_ERROR, "UTF: " + message, null);
           fc.addMessage(null, facesMessage);

            cc.getCurrentRootViewPort().clearException();
            fc.renderResponse();
           return null;
    }
}
