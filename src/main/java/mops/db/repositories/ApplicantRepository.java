package mops.db.repositories;

import mops.db.dto.ApplicantDTO;
import mops.model.classes.Application;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Repository
public interface ApplicantRepository extends CrudRepository<ApplicantDTO, String> {

    /**
     * Search by Username.
     *
     * @param username username.
     * @return JSON String.
     */
    @Query("SELECT * FROM applicant where username = :username;")
    ApplicantDTO findDistinctByUsername(@Param("username") String username);

    /**
     * Get id for username,
     *
     * @param username username.
     * @return int id;
     */
    @Query("SELECT id FROM applicant where username = :user")
    Optional<Integer> getIdByUsername(@Param("user") String username);

    @Query("SELECT * from applicant where (details ->> applications like %:application%) and username = :username")
    ApplicantDTO findByApplication(@Param("application") String application, @Param("username") String username);

    @Query("SELECT details ->> 'applications' from applicant")
    List<String> findAllApplications();


}