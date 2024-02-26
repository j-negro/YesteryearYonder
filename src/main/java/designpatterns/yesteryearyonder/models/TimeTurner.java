package designpatterns.yesteryearyonder.models;

public class TimeTurner extends TimeMachine {
    private int maxTimeTravelDays;
    private int capacity;

    public TimeTurner(String name) {
        super(name);
    }

    public int getMaxTimeTravelDays() {
        return maxTimeTravelDays;
    }

    public void setMaxTimeTravelDays(int maxTimeTravelDays) {
        this.maxTimeTravelDays = maxTimeTravelDays;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int i) {
    }

}