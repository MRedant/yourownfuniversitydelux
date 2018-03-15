package be.cm.redant.professor;

public class ProfessorDto {

    private Integer id;
    private String firstName;
    private String lastName;

    public static ProfessorDto ProfessorDto() {
        return new ProfessorDto();
    }

    public ProfessorDto withId(Integer id){
        this.id = id;
        return this;
    }
    public ProfessorDto withFirstName(String firstName){
        this.firstName= firstName;
        return this;
    }
    public ProfessorDto withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
