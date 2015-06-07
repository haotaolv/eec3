package com.eec.controller;

import com.eec.model.Course;
import com.eec.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 智康 on 2015/2/10 0010.
 */
@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String courseManage(ModelMap model) {

        model.addAttribute("courses", courseRepository.findAll());
        return "course/manage";
        //return "redirect:chat/consult";
    }



    @RequestMapping(value = "/course/add", method = RequestMethod.GET)
    public String addCourse(@ModelAttribute("course") Course course) {
        return "course/add";
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") Course course, BindingResult result) {
        if(course.getCourseName() != null) {
            courseRepository.save(course);
        }
        return "redirect:/course";
    }

    @RequestMapping(value = "/course/delete/{courseId}", method = RequestMethod.GET)
    public String delete(@PathVariable("courseId") Long courseId) {
        courseRepository.delete(courseRepository.findOne(courseId));
        return "redirect:/course";
    }

    @RequestMapping(value = "/course/add2", method = RequestMethod.GET)
    public String add2() {
        return "course/add2";
    }
}
