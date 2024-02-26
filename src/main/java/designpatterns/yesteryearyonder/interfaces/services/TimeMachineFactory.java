package designpatterns.yesteryearyonder.interfaces.services;
import designpatterns.yesteryearyonder.models.TimeMachine;

public interface TimeMachineFactory {
    TimeMachine createTimeMachine(String type, String name);
}