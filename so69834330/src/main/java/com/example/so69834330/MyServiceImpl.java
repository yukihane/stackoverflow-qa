package com.example.so69834330;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyServiceImpl implements MyService {

    private final KeywordRepository keywordRepository;
    private final CourseRepository courseRepository;

    @Transactional
    @Override
    public Course addNewCourse() {
        Course course = new Course();
        course.setName("new course");
        course.setDescription("" + LocalDateTime.now());

        keywordRepository.findAll().stream()
            .forEach(key -> {
                CourseKeyword ret = new CourseKeyword();
                ret.setKeyword(key);
                course.addKey(ret);
            });

        return courseRepository.save(course);
    }
}
