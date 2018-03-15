package be.cm.redant;

import be.cm.redant.professor.Professor;
import be.cm.redant.professor.ProfessorRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Inject
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessor() {
        return professorRepository.getProfessor();
    }

    public Professor getProfessor(Integer professorId) {
        return professorRepository.getProfessor(professorId);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.addProfessorToList(professor);
    }

    public Professor updateProfessor(Integer professorId, Professor updatedProfessor) {
        return professorRepository.updateProfessor(professorId, updatedProfessor);
    }

    public void deleteProfessor(Integer professorId){
        professorRepository.removeProfessorFromList(professorId);
    }

}
