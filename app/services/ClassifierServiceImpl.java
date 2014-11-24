package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.util.InvalidFormatException;

@Service
public class ClassifierServiceImpl implements ClassifierService {
	
	public static final String classificationModelFilePath = "en-doccat.bin";
	private DocumentCategorizerME categorizer;
	private boolean TEST=false;
	
	// used for testing as we don't have running application
	public void setTestMode(boolean mode)
	{
		this.TEST=mode;
	}
	
	private DocumentCategorizerME getCategorizer() throws InvalidFormatException, IOException
	{
		if (categorizer == null)
		{
			InputStream is = null;
			if (!TEST)
				is = play.Play.application().resourceAsStream(classificationModelFilePath);
			else
				is = new FileInputStream("conf/"+classificationModelFilePath);
			DoccatModel classificationModel = new DoccatModel(is);
			categorizer = new DocumentCategorizerME(classificationModel);
		}
		
		return categorizer;
	}
	
	@Override
	public boolean containsSpam(String messageBody) throws InvalidFormatException, IOException
	{
		double[] classDistribution = getCategorizer().categorize(messageBody);
		String predictedCategory = getCategorizer().getBestCategory(classDistribution);

		if ("SPAM".equals(predictedCategory))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
