import javax.faces.event.ActionEvent;

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
}
