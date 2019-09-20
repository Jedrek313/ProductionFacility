package pl.pienkowski.jedrzej.productionFacility.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pienkowski.jedrzej.productionFacility.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionRepository  extends CrudRepository<Position, Long> {
    Optional<Position> findById(Long id);
    List<Position> findAll();
}
