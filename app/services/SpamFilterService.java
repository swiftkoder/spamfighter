package services;

import java.util.List;

import models.Message;
import models.Messages;

public interface SpamFilterService {

	public List<Message> analyze(Messages messages, String strategyName);
}
