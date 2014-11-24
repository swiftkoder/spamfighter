
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configs.AppConfig;

import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings 
{
    private AnnotationConfigApplicationContext ctx; 
 
    @Override
    public void onStart(final Application app) {
    	
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Override
    public <A> A getControllerInstance(Class<A> aClass) {

        return ctx.getBean(aClass);
    }
}
