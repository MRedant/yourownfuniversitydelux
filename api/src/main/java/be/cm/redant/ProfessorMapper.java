package be.cm.redant;

import be.cm.redant.professor.Professor;

public class ProfessorMapper {

    public static ProfessorDto mapProfessor(Professor professor){
        return new ProfessorDto(professor.getId(),professor.getFirstName(),professor.getLastName());
    }

}
