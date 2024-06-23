package scheduler;

public class Event {

	private int time;
	
	private String description;
	
	public void setTime(int time) {
		this.time = time;
	}
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public int getTime() {
		return time;
	}
	public String getDesc() {
		return description;
	}
	
	
	public Event(int time, String description) {
		this.description = description;
		this.time = time;
	}
	
	
	
}
