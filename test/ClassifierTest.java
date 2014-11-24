import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import opennlp.tools.util.InvalidFormatException;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import services.ClassifierService;
import services.ClassifierServiceImpl;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ClassifierTest {

    @Test
    public void testSpamMessage() throws InvalidFormatException, IOException
    {
    	ClassifierService classiferService = new ClassifierServiceImpl();
    	classiferService.setTestMode(true); // unit test, we want to load model from conf directory
    	
    	boolean isSpam =classiferService.containsSpam("check me out");
    	
    	assertTrue("(check me out) is a spam message", isSpam);
    }

    @Test
    public void testNonSpamMessage() throws InvalidFormatException, IOException
    {
    	ClassifierService classiferService = new ClassifierServiceImpl();
    	classiferService.setTestMode(true); // unit test, we want to load model from conf directory
    	
    	boolean isSpam =classiferService.containsSpam("go to office");
    	
    	assertFalse("(go to office) is not a spam message", isSpam);
    	
    }

}
