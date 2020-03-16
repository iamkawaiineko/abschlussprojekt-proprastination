package mops.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mops.db.dto.EvaluationDTO;
import mops.db.repositories.OrgaRepository;
import mops.model.classes.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * Saves all evaluations by organizer
     * @param applications List of applications.
     * @param priorities List of priorities.
     */
    public void saveAll(final List<Application> applications, final List<Integer> priorities) {
        for (int i = 0; i < applications.size(); i++) {
            save(applications.get(i), priorities.get(i));
        }
    }


    /**
     * Gets all applications of a module
     * @param module Name of the module
     * @return List<Application> List of all applications for a module
     */
    public List<Application> getModuleApplications(final String module) {
        ObjectMapper mapper = new ObjectMapper();
        List<Application> result = new ArrayList<>();
        for (String s : repo.findAllApplicationsByModuleName(module)) {
            try {
                result.add(mapper.readValue(s, Application.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return result;
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
