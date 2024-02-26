package designpatterns.yesteryearyonder.controllers;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import designpatterns.yesteryearyonder.interfaces.services.TimeMachineService;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.dtos.TimeMachineRequest;

@RestController
public class TimeMachineController {

    @Autowired
    private TimeMachineService timeMachineService;

    @GetMapping("/time-machine")
    public ResponseEntity<Set<TimeMachine>> getTimeMachines(@RequestParam int limit, @RequestParam int offset) {

        if (limit < 0 || offset < 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(timeMachineService.getTimeMachines(limit, offset));

    }

    @PostMapping("/time-machine")
    public ResponseEntity<TimeMachine> createTimeMachine(@RequestBody TimeMachineRequest request) {

        if (request == null) {
            return ResponseEntity.badRequest().build();
        }

        TimeMachine timeMachine = timeMachineService.create(request.getName());

        if (timeMachine == null) {
            return ResponseEntity.badRequest().build();
        }

        URI location = URI.create("/time-machine/" + timeMachine.getTimeMachineId());

        if (location == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.created(location).body(timeMachine);

    }

}
