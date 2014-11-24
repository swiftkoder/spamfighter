package strategies.factory;

import strategies.FiftyMessagePerMinuteStrategy;
import strategies.MultipleUserSameMessageStrategy;
import strategies.SpamDetectionStrategy;

public class StrategyFactory {
	
	public static SpamDetectionStrategy getStrategy(String strategyName)
	{
		if ("fifty".equals(strategyName))
		{
			return new FiftyMessagePerMinuteStrategy();
		}
		else
	    if ("multiuser".equals(strategyName))
	    {
	    	return new MultipleUserSameMessageStrategy();
	    }
		
		return null;
	}

}
