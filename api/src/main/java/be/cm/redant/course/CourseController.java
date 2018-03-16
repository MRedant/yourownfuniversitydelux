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
        Map<Integer, Course> originalMap = new HashMap<>(courseService.getCourse(lastNameProfessor));
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Course item:originalMap.values()) {
            returnMap.put(courseMapper.toDto(item));
        }
    }

    //read

    //update

    //delete
}
