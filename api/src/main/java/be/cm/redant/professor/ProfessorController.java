package be.cm.redant.professor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(path = {"/professors"})
public class ProfessorController {

    private ProfessorDto professorDto;
    private ProfessorMapper professorMapper;

    @Inject
    public ProfessorController(ProfessorDto professorDto, ProfessorMapper professorMapper) {
        this.professorDto = professorDto;
        this.professorMapper = professorMapper;
    }


}
