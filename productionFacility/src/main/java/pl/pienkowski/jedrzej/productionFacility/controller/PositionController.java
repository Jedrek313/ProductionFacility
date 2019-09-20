package pl.pienkowski.jedrzej.productionFacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pienkowski.jedrzej.productionFacility.model.Position;
import pl.pienkowski.jedrzej.productionFacility.model.Worker;
import pl.pienkowski.jedrzej.productionFacility.repository.PositionRepository;
import pl.pienkowski.jedrzej.productionFacility.repository.WorkerRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/positions")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping(path = "/", produces = "application/json")
    public List<Position> getWorkers(){
        return positionRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Position getPosition(@PathVariable Long id){
        return  positionRepository.findById(id).get();
    }

    @PostMapping(path = "/", produces = "application/json")
    public Position addWorker(@RequestBody Position newPosition){
        return positionRepository.save(newPosition);
    }
}
