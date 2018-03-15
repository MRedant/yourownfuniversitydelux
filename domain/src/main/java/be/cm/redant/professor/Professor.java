package be.cm.redant.professor;

public class Professor {

    private static Integer counter = 0;

    private Integer id;
    private String firstName;
    private String lastName;

    private Professor() {
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static class ProfessorBuilder {
        private String firstname;
        private String lastname;

        public static ProfessorBuilder professor() {
            return new ProfessorBuilder();
        }

        public ProfessorBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public ProfessorBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Professor build() {
            Professor professor = new Professor();
            professor.setFirstName(firstname);
            professor.setLastName(lastname);
            return professor;
        }
    }


}
