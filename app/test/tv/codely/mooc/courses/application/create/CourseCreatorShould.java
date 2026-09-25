package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseCreatorShould {

    @Test
    void save_a_valid_course() {
        CourseRepository courseRepository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(courseRepository);

        Course course = new Course("some-id", "some-name", "some-duration");

        creator.create(course.getId(), course.getName(), course.getDuration());

        verify(courseRepository, atLeastOnce()).save(course);
    }

}
