package com.example.so69834330;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
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

        List<String> keys = List.of("key1","key2");

        course.getKeywords().addAll((keys
            .stream()
            .map(key -> {
                Keyword keyword = keywordRepository.findKeywordsByKeyword(key.toLowerCase()).orElseThrow(() -> new CustomServiceException(""));
                CourseKeyword courseKeyword = new CourseKeyword();
                courseKeyword.setCourse(course);
                courseKeyword.setKeyword(keyword);
                return courseKeyword;
            })
            .collect(Collectors.toList())
    ));


    return courseRepository.save(course);

    }
}
