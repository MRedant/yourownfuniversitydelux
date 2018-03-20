package be.cm.redant.professor;

import be.cm.redant.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody Professor professor){
        return professorMapper.toDto(professorService.createProfessor(professor));
    }

//    //get (read)
//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public List<ProfessorDto> getProfessor() {
//        return professorService.getProfessor().stream()
//                .map(professorMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    //get (read)
//    @GetMapping(path = "/{id}" , produces = APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public ProfessorDto getProfessor(@PathVariable("id") Integer professorId) {
//        return professorMapper.toDto(professorService.getProfessor(professorId));
//    }
//
//    //update
//    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public ProfessorDto updateProfessor(@PathVariable("id") Integer professorId,@RequestBody Professor updatedProfessor) {
//        return professorMapper.toDto(professorService.updateProfessor(professorId,updatedProfessor));
//    }
//
//    //delete
//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteProfessor(@PathVariable("id") Integer professorId){
//        professorService.deleteProfessor(professorId);
//    }
}
