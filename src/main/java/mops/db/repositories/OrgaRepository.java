package mops.db.repositories;

import mops.db.dto.EvaluationDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaRepository extends CrudRepository<EvaluationDTO, String> {
}
