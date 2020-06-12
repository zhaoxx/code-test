public class Event {

    /**
     * eventName
     */
    private String eventName;

    private TimeInterval timeInterval;

    /**
     * 1：One time events
     * 2：Recurring events
     */
    private int type;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
