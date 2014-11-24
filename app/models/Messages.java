package models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "messages" })
public class Messages {

	@JsonProperty("messages")
	private List<Message> messages = new ArrayList<Message>();
	

	/**
	 *
	 * @return The messages
	 */
	@JsonProperty("messages")
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 *
	 * @param messages
	 *            The messages
	 */
	@JsonProperty("messages")
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}