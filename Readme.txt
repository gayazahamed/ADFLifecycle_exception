How to configure an ADF Phase Listener
MyAdfListener implements PagePhaseListener{ 
In \src\META-INF\adf-settings.xml

<?xml version="1.0" encoding="windows-1252" ?>
<adf-settings xmlns="http://xmlns.oracle.com/adf/settings">
<adfc-controller-config 
xmlns="http://xmlns.oracle.com/adf/controller/config">
<lifecycle>
<phase-listener>
<listener-id>MyAdfListener</listener-id>
<class>adf.sample.MyAdfListener </class>
</phase-listener>
</lifecycle>
</adfc-controller-config> 
</adf-settings>



to override for one page not for all
MyAdfListener implements PagePhaseListener{ 
Extends oracle.adf.controller.v2.PageController class 
Implements oracle.adf.controller.v2.PagePhaseListener interface 
value of the page definition's ControllerClass attribute can either be value or expression lang 
<pageDefinition xmlns="http://xmlns.oracle.com/adfm/uimodel" version="11.1.1.64.93" id="Page1PageDef" Package="view.pageDefs" ControllerClass="view.PageLoadBaseBean">  for now run page1.jspx
in to override for all put this in adf-settings.xml at ADFLifecycle_exception\ViewController\adfmsrc\META-INF
<?xml version="1.0" encoding="windows-1252" ?>
<adf-settings xmlns="http://xmlns.oracle.com/adf/settings">
<adfc-controller-config 
xmlns="http://xmlns.oracle.com/adf/controller/config">
<lifecycle>
<phase-listener>
<listener-id>MyAdfListener</listener-id>
<class>adf.sample. MyAdfListener </class>
</phase-listener>
</lifecycle>
</adfc-controller-config> 
</adf-settings>






for the controller level exception handling create a custom class that extends 
oracle.adf.view.rich.context.ExceptionHandler and then override 
public void handleException(FacesContext facesContext, Throwable throwable,
PhaseId phaseId) throws Throwable {

and add a text file in folder .adf\META-INF\services in application
with name oracle.adf.view.rich.context.ExceptionHandler
and put view.exception.XxControllerExpHandler in that file 
C:\JDeveloper\mywork\ADFLifecycle_exception\.adf\META-INF\services


ignore

create a java class that extends  oracle.adf.view.rich.context.ExceptionHandler
and register in below path
\ADFLifecycle_exception\ViewController\adfmsrc\META-INF\adf-settings.xml

ignore