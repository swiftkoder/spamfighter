package services;

import java.io.IOException;
import opennlp.tools.util.InvalidFormatException;

public interface ClassifierService {

	public boolean containsSpam(String messageBody)
			throws InvalidFormatException, IOException;
	
	public void setTestMode(boolean mode);

}