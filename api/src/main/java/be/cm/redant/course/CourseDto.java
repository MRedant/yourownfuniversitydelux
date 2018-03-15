package be.cm.redant.course;

import be.cm.redant.professor.Professor;

public class CourseDto {

    private String courseName;
    private Double studyPoints;
    private String courseDomain;
    private Professor professor;

    public static CourseDto CourseDto() {
        return new CourseDto();
    }

    public CourseDto withCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public CourseDto withStudyPoints(Double studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public CourseDto withCourseDomain(String courseDomain) {
        this.courseDomain = courseDomain;
        return this;
    }

    public CourseDto withProfessor(Professor professor) {
        this.professor = professor;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public Double getStudyPoints() {
        return studyPoints;
    }

    public String getCourseDomain() {
        return courseDomain;
    }

    public Professor getProfessor() {
        return professor;
    }
}
