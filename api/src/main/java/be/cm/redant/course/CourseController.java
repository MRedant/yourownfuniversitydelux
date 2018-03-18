package be.cm.redant.course;

import be.cm.redant.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    @PostMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(@PathVariable("id") Course course) {
        return courseMapper.toDto(courseService.createCourse(course));
    }

    //read
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, CourseDto> getCourse(@PathVariable("id") String lastNameProfessor) {
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Map.Entry<Integer, Course> item : courseService.getCourse(lastNameProfessor).entrySet()) {
            returnMap.put(item.getKey(), courseMapper.toDto(item.getValue()));
        }
        return returnMap;
    }

    //read
    @GetMapping(consumes =APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, CourseDto> getCourse(@RequestBody Double studyPoints, String studyDomain) {
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Map.Entry<Integer, Course> item : courseService.getCourse(studyPoints, studyDomain).entrySet()) {
            returnMap.put(item.getKey(), courseMapper.toDto(item.getValue()));
        }
        return returnMap;
    }

    //read
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, CourseDto> getCourse(@PathVariable("id") Double studyPoints) {
        Map<Integer, CourseDto> returnMap = new HashMap<>();

        for (Map.Entry<Integer, Course> item : courseService.getCourse(studyPoints).entrySet()) {
            returnMap.put(item.getKey(), courseMapper.toDto(item.getValue()));
        }
        return returnMap;
    }

    //update
    @PutMapping(path = "/{id}" , consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CourseDto updateCourse(@PathVariable("id") Integer courseId,@RequestBody Course updatedCourse) {
        return courseMapper.toDto(courseService.updateCourse(courseId, updatedCourse));
    }

    //delete
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable("id") Integer courseId) {
        courseService.deleteCourse(courseId);
    }
}
