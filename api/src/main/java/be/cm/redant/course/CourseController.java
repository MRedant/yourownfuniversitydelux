package be.cm.redant.course;

import be.cm.redant.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private CourseService courseService;
    private CourseMapper courseMapper;

    @Inject
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    //create
    public CourseDto createCourse(Course course) {
        return courseMapper.toDto(courseService.createCourse(course));
    }

    //read
    public Map<Integer, CourseDto> getCourse(String lastNameProfessor) {
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Map.Entry<Integer, Course> item : courseService.getCourse(lastNameProfessor).entrySet()) {
            returnMap.put(item.getKey(), courseMapper.toDto(item.getValue()));
        }
        return returnMap;
    }
    //read
    public Map<Integer, CourseDto> getCourse(Double studyPoints, String studyDomain) {
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Map.Entry<Integer, Course> item : courseService.getCourse(studyPoints,studyDomain).entrySet()) {
            returnMap.put(item.getKey(), courseMapper.toDto(item.getValue()));
        }
        return returnMap;
    }
    //read
    public Map<Integer, CourseDto> getCourse(Double studyPoints) {
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Map.Entry<Integer, Course> item : courseService.getCourse(studyPoints).entrySet()) {
            returnMap.put(item.getKey(), courseMapper.toDto(item.getValue()));
        }
        return returnMap;
    }
    //update
    public CourseDto updateCourse(Integer courseId, Course updatedCourse){
        return courseMapper.toDto(courseService.updateCourse(courseId,updatedCourse));
    }
    //delete
    public void deleteCourse(Integer courseId){
        courseService.deleteCourse(courseId);
    }
}
