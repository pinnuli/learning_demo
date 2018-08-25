package com.pinnuli.mvcdemo.service;

import com.pinnuli.mvcdemo.model.Course;
import org.springframework.stereotype.Service;

/**
 * @author: pinnuli
 * @date: 18-8-25
 */

@Service
public interface CourseService {

    Course getCourseById(Integer courseId);

}
