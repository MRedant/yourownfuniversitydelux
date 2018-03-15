package be.cm.redant;

import be.cm.redant.course.Course;
import be.cm.redant.course.CourseRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
public class CourseService {

    private final CourseRepository courseRepository;

    @Inject
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Map<Integer, Course> getCourse(String lastNameProfessor) {
        return courseRepository.getCourseMapForProfessor(lastNameProfessor);
    }

    public Map<Integer, Course> getCourse(Double studyPoints) {
        return courseRepository.getCourseMapForStudyPoints(studyPoints);
    }

    public Map<Integer, Course> getCourse(Double studyPoints, String studyDomain) {
        return courseRepository.getCourseMapForStudyPointsAndStudyDomain(studyPoints, studyDomain);
    }

    public Course createCourse(Course course) {
        return courseRepository.addCourseToList(course);
    }

    public Course updateCourse(Integer courseId, Course updatedCourse) {
        return courseRepository.updateCourse(courseId, updatedCourse);
    }

    public void deleteCourse(Integer courseId){
        courseRepository.removeCourseFromList(courseId);
    }

}
