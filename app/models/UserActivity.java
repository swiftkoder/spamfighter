package models;

public class UserActivity {

    private String sourceProfileId;
    private String targetProfileId;
    private long firstTimeStamp;
    private long lastTimeStamp;
    private String lastBody;
    private int counter; // message counter
    private long howLongRunning;
    
	public UserActivity(String sourceProfileId, String targetProfileId, Long lastTimeStamp, String lastBody, Integer counter, Long howLongRunning) {
   	 this.sourceProfileId = sourceProfileId;
   	 this.targetProfileId = targetProfileId;
   	 this.lastTimeStamp = lastTimeStamp;
   	 this.lastBody = lastBody;
   	 this.counter=counter;
    }
    
    public String getSourceProfileId() {
   	 return sourceProfileId;
    }
    public void setSourceProfileId(String sourceProfileId) {
   	 this.sourceProfileId = sourceProfileId;
    }
    
    public Long getLastTimeStamp() {
   	 return lastTimeStamp;
    }
    public void setLastTimeStamp(Long lastTimeStamp) {
   	 this.lastTimeStamp = lastTimeStamp;
    }
    public String getLastBody() {
   	 return lastBody;
    }
    public String getTargetProfileId() {
   	 return targetProfileId;
    }

    public void setTargetProfileId(String targetProfileId) {
   	 this.targetProfileId = targetProfileId;
    }

    public void setLastBody(String lastBody) {
   	 this.lastBody = lastBody;
    }
    
    public Integer getCounter() {
  		return counter;
  	}

  	public void setCounter(Integer counter) {
  		this.counter = counter;
  	}

	public long getHowLongRunning() {
		return howLongRunning;
	}

	public void setHowLongRunning(long howLongRunning) {
		this.howLongRunning = howLongRunning;
	}

	public long getFirstTimeStamp() {
		return firstTimeStamp;
	}

	public void setFirstTimeStamp(long firstTimeStamp) {
		this.firstTimeStamp = firstTimeStamp;
	}

}

