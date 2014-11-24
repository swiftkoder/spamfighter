package services;
import java.util.List;

import org.springframework.stereotype.Service;

import models.Message;
import models.Messages;
import services.SpamFilterService;
import strategies.SpamDetectionStrategy;
import strategies.factory.StrategyFactory;

@Service
public class SpamFilterServiceImpl implements SpamFilterService
{    
	private SpamDetectionStrategy strategy;
	
    @Override
    public List<Message> analyze(Messages messages, String strategyName)
    {	
    	strategy = StrategyFactory.getStrategy(strategyName);
    	return strategy.scan(messages);
    }
}


