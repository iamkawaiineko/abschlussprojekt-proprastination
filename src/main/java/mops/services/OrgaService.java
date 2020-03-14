package mops.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mops.db.dto.EvaluationDTO;
import mops.db.repositories.OrgaRepository;
import mops.model.classes.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrgaService {
    @Autowired
    private OrgaRepository repo;

    @SuppressWarnings("checkstyle:HiddenField")
    private void setRepo(final OrgaRepository repo) {
        this.repo = repo;
    }

    /**
     * Saves evaluation by organizer
     * @param application single application
     * @param priority priority of professor.
     */
    public void save(final Application application, final int priority) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(application);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        EvaluationDTO dto = new EvaluationDTO();
        dto.setApplication(jsonString);
        dto.setPriority(priority);
        //dto.setId(001);
        //Add findByApplicantUsername if already exists
        Optional<Integer> opt = repo.getIdByUsername(application.getApplicantusername());
        opt.ifPresent(dto::setId);

        try {
            repo.save(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String objectToJsonString(final Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String output = "";
        try {
            output = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return output;
    }
}
