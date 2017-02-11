package innterClasses;

public abstract class Event {

	public Event(EventList list){
		list.add(this);
	}
	
	public abstract void run();

}
