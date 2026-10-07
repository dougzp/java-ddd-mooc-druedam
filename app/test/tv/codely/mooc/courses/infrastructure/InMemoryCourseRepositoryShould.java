package tv.codely.mooc.courses.infrastructure;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryCourseRepositoryShould {

    @Test
    void save_a_valid_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        repository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void search_an_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Course course = new Course("some-id", "some-name", "some-duration");

        repository.save(course);

        assertEquals(Optional.of(course), repository.search(course.getId()));
    }

    @Test
    void not_infd_a_non_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        assertFalse(repository.search("non-existing_id").isPresent());
    }

}
