package pl.pienkowski.jedrzej.productionFacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pienkowski.jedrzej.productionFacility.model.Worker;
import pl.pienkowski.jedrzej.productionFacility.repository.WorkerRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(path = "/", produces = "application/json")
    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Worker getWorker(@PathVariable Long id){
        return  workerRepository.findById(id).get();
    }

    @PostMapping(path = "/", produces = "application/json")
    public Worker addWorker(@RequestBody Worker newWorker){
        return workerRepository.save(newWorker);
    }


    @PutMapping("/employees/{id}")
    Worker replaceWorker(@RequestBody Worker newWorker, @PathVariable Long id) {

        return workerRepository.findById(id)
                .map(worker -> {
                    worker.setName(newWorker.getName());
                    worker.setAddress(newWorker.getAddress());
                    worker.setLastName(newWorker.getLastName());
                    worker.setPhoneNumber(newWorker.getPhoneNumber());
                    worker.setPosition(newWorker.getPosition());
                    worker.setTeam(newWorker.getTeam());
                    return workerRepository.save(worker);
                })
                .orElseGet(() -> {
                    return workerRepository.save(newWorker);
                });
    }
}
