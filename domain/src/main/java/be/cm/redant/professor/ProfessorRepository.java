package be.cm.redant.professor;

import be.cm.redant.DatabaseExeption;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class ProfessorRepository {

    private List<Professor> professorList;

    public ProfessorRepository() {
        this.professorList = new ArrayList<>();
    }

    public Professor addProfessorToList(Professor professor) throws DatabaseExeption {
        assertProfessorIsPresent(professor);
        professorList.add(professor);
        return professor;
}

    public void removeProfessorFromList(Integer professorId) throws DatabaseExeption {
        assertProfessorIdIsNotPresent(professorFoundInList(professorId));
        professorList.remove(professorFoundInList(professorId));
    }

    public List<Professor> getProfessor() {
        return Collections.unmodifiableList(professorList);
    }

    public Professor getProfessor(Integer professorId) {
        assertProfessorIdIsNotPresent(professorFoundInList(professorId));
        return professorList.get(professorId);
    }

    public Professor updateProfessor(Integer professorId, Professor updatedProfessor) {
        assertProfessorIsPresent(professorFoundInList(professorId));
        professorList.set(professorList.indexOf(professorFoundInList(professorId)),updatedProfessor);
        return updatedProfessor;
    }

    private void assertProfessorIsPresent(Professor queriedProfessor) {
        if (queriedProfessor == null) {
            throw new DatabaseExeption("No duplicate entries allowed");
        }
    }

    private void assertProfessorIdIsNotPresent(Professor queriedProfessor) {
        if (queriedProfessor != null) {
            throw new DatabaseExeption("Professor not found");
        }
    }

    private Professor professorFoundInList(Integer professorId) {
        Professor professorFound = null;
        for (Professor item : professorList) {
            if (item.getId() == professorId) professorFound = item;
        }
        return professorFound;
    }
}
