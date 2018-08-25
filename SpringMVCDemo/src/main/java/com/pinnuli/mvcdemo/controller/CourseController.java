package com.pinnuli.mvcdemo.controller;

import com.pinnuli.mvcdemo.model.Course;
import com.pinnuli.mvcdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-8-25
 */

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    //本方法将处理 /courses/view?courseId=123 形式的URL
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {

        Course course = courseService.getCourseById(courseId);
        System.out.println(course.getCourseId());
        model.addAttribute(course);
        return "course_overview";
    }

    //本方法将处理 /courses/view2/123 形式的URL
    @RequestMapping("/view2/{courseId}")
    public String viewCourse2(@PathVariable("courseId") Integer courseId,
                              Map<String, Object> model) {

        Course course = courseService.getCourseById(courseId);
        model.put("course",course);
        return "course_overview";
    }

}
