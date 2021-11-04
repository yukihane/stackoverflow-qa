package com.example.so69834330;

public class MyServiceImpl {
    @Override
    public void addNewCourse(CourseCreateDto courseCreateDto) {
        Teacher teacher = teacherRepository.findById(courseCreateDto.getTeacherId()).orElseThrow(() -> new CustomServiceException(NO_TEACHER_FOUND));
        Course course = modelMapper.map(courseCreateDto, Course.class);
        course.setCourseStatus(CourseStatus.ACTIVE);
        course.setTeacher(teacher);
        course.setUniqueCode(generateCourseUniqueCode());

      
        if(courseCreateDto.getKeywords().isEmpty()) throw new CustomServiceException("Course keyword list is empty!");

        course.getKeywords().addAll((courseCreateDto.getKeywords()
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


        courseRepository.save(course);

    }

}
