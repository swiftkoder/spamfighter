package strategies;

import java.util.List;

import models.Message;
import models.Messages;

public interface SpamDetectionStrategy
{
	List<Message> scan(Messages messages);
}
