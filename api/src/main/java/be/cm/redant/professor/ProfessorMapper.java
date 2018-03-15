package be.cm.redant.professor;

import javax.inject.Named;

@Named
public class ProfessorMapper {

    public static ProfessorDto toDto (Professor professor){
        return new ProfessorDto()
                .withId(professor.getId())
                .withFirstName(professor.getFirstName())
                .withLastName(professor.getLastName());
    }

    public static Professor toDomain (ProfessorDto professorDto){
        return Professor.ProfessorBuilder.professor()
                .withFirstname(professorDto.getFirstName())
                .withLastname(professorDto.getLastName())
                .build();
    }

}
