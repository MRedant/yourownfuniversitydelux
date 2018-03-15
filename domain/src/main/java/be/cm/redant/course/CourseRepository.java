package be.cm.redant.course;

import be.cm.redant.DatabaseExeption;

import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class CourseRepository {

    private static Integer counter = 0;

    private Map<Integer, Course> courseList;

    public CourseRepository() {
        this.courseList = new HashMap<Integer, Course>();
    }

    public Map<Integer, Course> getCourseMapForProfessor(String lastName) {
        return Collections.unmodifiableMap(findCoursesForProfessor(lastName));
    }

    private Map<Integer, Course> findCoursesForProfessor(String lastName) {
        return courseList.entrySet().stream()
                .filter(e -> e.getValue().getProfessor().getLastName().equals(lastName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, Course> getCourseMapForStudyPoints(Double studyPoints) {
        return Collections.unmodifiableMap(findCoursesForStudyPoints(studyPoints));
    }

    private Map<Integer, Course> findCoursesForStudyPoints(Double studyPoints) {
        return courseList.entrySet().stream()
                .filter(e -> e.getValue().getStudyPoints().equals(studyPoints))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, Course> getCourseMapForStudyPointsAndStudyDomain(Double studyPoints, String studyDomain) {
        return Collections.unmodifiableMap(findCourseMapForStudyPointsAndStudyDomain(studyPoints, studyDomain));
    }

    private Map<Integer, Course> findCourseMapForStudyPointsAndStudyDomain(Double studyPoints, String studyDomain) {
        return courseList.entrySet().stream()
                .filter(e -> e.getValue().getStudyPoints().equals(studyPoints))
                .filter(e -> e.getValue().getCourseDomain().equals(studyDomain))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Course addCourseToList(Course course) throws DatabaseExeption {
        if (courseList.values().contains(course)) {
            throw new DatabaseExeption("Course already enlisted");
        } else {
            if (course.getProfessor() == null) {
                throw new DatabaseExeption("No professor assigned to course");
            } else {
                courseList.put(counter++, course);
            }
        }
        return course;
    }

    public void removeCourseFromList(Integer courseId) throws DatabaseExeption {
        if (courseList.keySet().contains(courseId)) {
            courseList.remove(courseId);
        } else {
            throw new DatabaseExeption("Course with courseId:" + courseId + " not found");
        }
    }

    public Course updateCourse(Integer courseId, Course updatedCourse) {
        if (courseList.keySet().contains(courseId)) {
            courseList.replace(courseId, updatedCourse);
        }else{
            throw new DatabaseExeption("Course with courseId:" + courseId + " not found");
        }
        return updatedCourse;
    }
}
