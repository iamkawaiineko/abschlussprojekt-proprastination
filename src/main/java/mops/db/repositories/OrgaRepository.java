package mops.db.repositories;

import mops.db.dto.EvaluationDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrgaRepository extends CrudRepository<EvaluationDTO, String> {
    /**
     * Get id for username,
     *
     * @param username username.
     * @return int id;
     */
    @Query("SELECT id FROM priorization where application ->> 'username' = :user")
    Optional<Integer> getIdByUsername(@Param("user") String username);

    /**
     * Returns all Applications matching @moduleName as JSON-String list.
     *
     * @param moduleName String of the modulename.
     * @return List<Application>
     */
    @Query("SELECT y.x FROM applicant, Lateral (SELECT json_array_elements(details -> 'applications')"
            + " AS x)AS y WHERE y.x->>'module' = :module;")
    List<String> findAllApplicationsByModuleName(@Param("module") String moduleName);

}
