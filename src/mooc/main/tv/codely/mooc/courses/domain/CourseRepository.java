package tv.codely.mooc.courses.domain;

import java.util.Optional;

public interface CourseRepository {
    public void save(Course course);

       Optional<Course> search(String id);
}
