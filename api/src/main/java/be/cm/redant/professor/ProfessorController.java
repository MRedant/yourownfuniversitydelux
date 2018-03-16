package be.cm.redant.professor;

import be.cm.redant.ProfessorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {"/professors"})
public class ProfessorController {

    private ProfessorService professorService;
    private ProfessorMapper professorMapper;

    @Inject
    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    //create
    public ProfessorDto createProfessor(Professor professor){
        return professorMapper.toDto(professorService.createProfessor(professor));
    }

    //get (read)
    public List<ProfessorDto> getProfessor() {
        return professorService.getProfessor().stream()
                .map(professorMapper::toDto)
                .collect(Collectors.toList());
    }

    //get (read)
    public ProfessorDto getProfessor(Integer professorId) {
        return professorMapper.toDto(professorService.getProfessor(professorId));
    }

    //update
    public ProfessorDto updateProfessor(Integer professorId, Professor updatedProfessor) {
        return professorMapper.toDto(professorService.updateProfessor(professorId,updatedProfessor));
    }

    //delete
    public void deleteProfessor(Integer professorId){
        professorService.deleteProfessor(professorId);
    }
}
