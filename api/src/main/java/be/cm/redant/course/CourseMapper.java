package be.cm.redant.course;

import javax.inject.Named;

@Named
public class CourseMapper {

    CourseDto toDto(Course course) {
        return new CourseDto()
                .withCourseName(course.getCourseName())
                .withCourseDomain(course.getCourseDomain())
                .withStudyPoints(course.getStudyPoints())
                .withProfessor(course.getProfessor());
    }

    Course toDomain(CourseDto courseDto) {
        return new Course(
                courseDto.getCourseName()
                , courseDto.getStudyPoints()
                , courseDto.getCourseDomain())
                .assignProfessor(courseDto.getProfessor());
    }
}
