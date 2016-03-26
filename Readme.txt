create a java class that extends 
and register in below path
\ADFLifecycle_exception\ViewController\adfmsrc\META-INF\adf-settings.xml

for the controller level exception handling create a custom class that extends 
oracle.adf.view.rich.context.ExceptionHandler and then override 
public void handleException(FacesContext facesContext, Throwable throwable,
PhaseId phaseId) throws Throwable {

and add a text file in folder .adf\META-INF\services in application
with name oracle.adf.view.rich.context.ExceptionHandler
and put view.exception.XxControllerExpHandler in that file 
C:\JDeveloper\mywork\ADFLifecycle_exception\.adf\META-INF\services