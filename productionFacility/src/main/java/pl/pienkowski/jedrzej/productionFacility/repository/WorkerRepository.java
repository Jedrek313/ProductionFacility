package pl.pienkowski.jedrzej.productionFacility.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pienkowski.jedrzej.productionFacility.model.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

    Optional<Worker> findById(Long id);
    List<Worker> findAll();

}
