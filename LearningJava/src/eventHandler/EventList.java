package eventHandler;

import java.util.Stack;

public class EventList {
	
	private Stack<Event> events;

	public EventList() {
		events = new Stack<Event>();
	}
	
	public void add(Event event){
		events.push(event);
	}
	
	public void nextEvent(){
		try{
			events.get(0).run();
			events.remove(0);
		} catch (Exception e){
			// Do nothing
		}
	}
	
	public boolean hasNextEvent(){
		if(events.size() != 0) return true;
		else return false;
	}
	
	public Event getNextEvent(){
		return events.get(0);
	}
	
	public int getSize(){
		return events.size();
	}
}
