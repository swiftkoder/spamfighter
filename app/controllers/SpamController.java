package controllers;

import models.Messages;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;

import play.*;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.RequestBody;
import services.ClassifierService;
import services.ClassifierServiceImpl;
import services.SpamFilterService;
import views.html.*;

@org.springframework.stereotype.Controller
public class SpamController extends Controller 
{
	@Autowired
	ClassifierService classifierService;
	
	@Autowired
	SpamFilterService spamFilterService;
	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    @BodyParser.Of(BodyParser.Json.class)
    public Result spamFilter(String strategyName)
    {
    	JsonNode json = request().body().asJson();
		
		Messages messages = Json.fromJson(json, Messages.class);
    	
    	return ok(Json.toJson(spamFilterService.analyze(messages, strategyName)));
    }
    
    public Result checkSpam()
    {
    	RequestBody body = request().body();
    	String textBody = body.asText();
    	
    	try
    	{
    		boolean spamFound = classifierService.containsSpam(textBody);
    		if (spamFound)
    		{
    			return ok("Spam Found");
    		}
    		else
    		{
    			return notFound("No spam found");
    		}
    	}
    	catch(Exception ex)
    	{
    		return internalServerError(ex.getMessage());
    	}
    }

}
