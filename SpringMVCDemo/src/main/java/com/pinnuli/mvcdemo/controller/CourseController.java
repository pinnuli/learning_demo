package com.pinnuli.mvcdemo.controller;

import com.pinnuli.mvcdemo.model.Course;
import com.pinnuli.mvcdemo.service.CourseService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
    public String createCourse() {
        return "course_admin/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String doSave(@ModelAttribute Course course) {
        System.out.println(course.getDuration());
        course.setCourseId(123);
        return "redirect:view2/" + course.getCourseId();
    }

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String showUploadPage(){

        return "course_admin/file";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("../resources/imgs/", System.currentTimeMillis()+file.getOriginalFilename()));

        }
        return "success";
    }

    @RequestMapping(value="/{courseId}",method=RequestMethod.GET)
    public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId){
        return  courseService.getCourseById(courseId);
    }


    @RequestMapping(value="/jsontype/{courseId}",method=RequestMethod.GET)
    public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId){
        Course course =   courseService.getCourseById(courseId);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}
