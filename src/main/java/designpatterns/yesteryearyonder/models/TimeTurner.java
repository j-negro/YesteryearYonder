package designpatterns.yesteryearyonder.models;

public class TimeTurner extends TimeMachine {
    private String name;
    private int maxTimeTravelDays;
    private int capacity;

    public TimeTurner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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