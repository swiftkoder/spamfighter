package models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sourceProfileId", "targetProfileId", "sourceClientId",
		"messageId", "type", "timestamp", "body" })
public class Message {

	@JsonProperty("sourceProfileId")
	private String sourceProfileId;
	@JsonProperty("targetProfileId")
	private String targetProfileId;
	@JsonProperty("sourceClientId")
	private String sourceClientId;
	@JsonProperty("messageId")
	private String messageId;
	@JsonProperty("type")
	private String type;
	@JsonProperty("timestamp")
	private Long timestamp;
	@JsonProperty("body")
	private String body;
	
	/**
	 * 
	 * @return The sourceProfileId
	 */
	@JsonProperty("sourceProfileId")
	public String getSourceProfileId() {
		return sourceProfileId;
	}

	/**
	 * 
	 * @param sourceProfileId
	 *            The sourceProfileId
	 */
	@JsonProperty("sourceProfileId")
	public void setSourceProfileId(String sourceProfileId) {
		this.sourceProfileId = sourceProfileId;
	}

	/**
	 * 
	 * @return The targetProfileId
	 */
	@JsonProperty("targetProfileId")
	public String getTargetProfileId() {
		return targetProfileId;
	}

	/**
	 * 
	 * @param targetProfileId
	 *            The targetProfileId
	 */
	@JsonProperty("targetProfileId")
	public void setTargetProfileId(String targetProfileId) {
		this.targetProfileId = targetProfileId;
	}

	/**
	 * 
	 * @return The sourceClientId
	 */
	@JsonProperty("sourceClientId")
	public String getSourceClientId() {
		return sourceClientId;
	}

	/**
	 * 
	 * @param sourceClientId
	 *            The sourceClientId
	 */
	@JsonProperty("sourceClientId")
	public void setSourceClientId(String sourceClientId) {
		this.sourceClientId = sourceClientId;
	}

	/**
	 * 
	 * @return The messageId
	 */
	@JsonProperty("messageId")
	public String getMessageId() {
		return messageId;
	}

	/**
	 * 
	 * @param messageId
	 *            The messageId
	 */
	@JsonProperty("messageId")
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * 
	 * @return The type
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The timestamp
	 */
	@JsonProperty("timestamp")
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * 
	 * @param timestamp
	 *            The timestamp
	 */
	@JsonProperty("timestamp")
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 
	 * @return The body
	 */
	@JsonProperty("body")
	public String getBody() {
		return body;
	}

	/**
	 * 
	 * @param body
	 *            The body
	 */
	@JsonProperty("body")
	public void setBody(String body) {
		this.body = body;
	}
}
