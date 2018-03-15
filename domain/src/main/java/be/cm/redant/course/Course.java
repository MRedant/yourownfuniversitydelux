package be.cm.redant.course;

import be.cm.redant.professor.Professor;

public class Course {

    private String courseName;
    private Double studyPoints;
    private String courseDomain;
    private Professor professor;

    public Course(String courseName, Double studyPoints, String courseDomain) {
        this.courseName = courseName;
        this.studyPoints = studyPoints;
        this.courseDomain = courseDomain;
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

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudyPoints(Double studyPoints) {
        this.studyPoints = studyPoints;
    }

    public void setCourseDomain(String courseDomain) {
        this.courseDomain = courseDomain;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }


}
