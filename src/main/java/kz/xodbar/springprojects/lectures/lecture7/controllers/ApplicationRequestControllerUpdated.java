package kz.xodbar.springprojects.lectures.lecture7.controllers;

import kz.xodbar.springprojects.lectures.lecture7.entities.ApplicationRequestUpdated;
import kz.xodbar.springprojects.lectures.lecture7.entities.Course;
import kz.xodbar.springprojects.lectures.lecture7.services.ApplicationRequestServiceUpdated;
import kz.xodbar.springprojects.lectures.lecture7.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ApplicationRequestControllerUpdated {
    @Autowired
    private ApplicationRequestServiceUpdated requestService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private List<Course> courses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(value = "/lecture7/task1", method = RequestMethod.GET)
    public ModelAndView getAllRequestsPage(ModelMap model) {
        model.addAttribute("requests", requestService.getAllRequests());
        return new ModelAndView("./lectures/lecture7/task1/index", model);
    }

    @RequestMapping(value = "/lecture7/task1/unhandled", method = RequestMethod.GET)
    public ModelAndView getUnhandledRequestsPage(ModelMap model) {
        model.addAttribute("requests", requestService.getUnhandledRequests());
        return new ModelAndView("./lectures/lecture7/task1/index", model);
    }

    @RequestMapping(value = "/lecture7/task1/handled", method = RequestMethod.GET)
    public ModelAndView getHandledRequestsPage(ModelMap model) {
        model.addAttribute("requests", requestService.getHandledRequests());
        return new ModelAndView("./lectures/lecture7/task1/index", model);
    }

    @RequestMapping(value = "/lecture7/task1/search", method = RequestMethod.GET)
    public ModelAndView getSearchResults(ModelMap model, @RequestParam String query) {
        model.addAttribute("requests", requestService.searchRequestByComment(query));
        return new ModelAndView("./lectures/lecture7/task1/index", model);
    }

    @RequestMapping(value = "/lecture7/task1/add", method = RequestMethod.GET)
    public ModelAndView getAddingPage(ModelMap model) {
        model.addAttribute("courses", courses());
        return new ModelAndView("./lectures/lecture7/task1/add", model);
    }

    @RequestMapping(value = "/lecture7/task1/add", method = RequestMethod.POST)
    public String addNewRequestHandler(@RequestParam String requestUsername,
                                       @RequestParam String requestCommentary,
                                       @RequestParam String requestPhone,
                                       @RequestParam Long requestCourse) {
        try {
            requestService.addRequest(new ApplicationRequestUpdated(null,
                    requestUsername,
                    requestCommentary,
                    requestPhone,
                    false,
                    courseService.getCourseById(requestCourse)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/lecture7/task1";
    }

    @RequestMapping(value = "/lecture7/task1/{id}", method = RequestMethod.GET)
    public ModelAndView getRequestDetailsPage(@PathVariable Long id, ModelMap model) {
        model.addAttribute("request", requestService.getRequestById(id));
        model.addAttribute("courses", courses());
        return new ModelAndView("./lectures/lecture7/task1/details", model);
    }

    @RequestMapping(value = "/lecture7/task1/{id}/update", method = RequestMethod.POST)
    public String updateRequest(@PathVariable Long id,
                                      @RequestParam String requestUsername,
                                      @RequestParam String requestCommentary,
                                      @RequestParam Long requestCourse,
                                      @RequestParam String requestPhone) {
        requestService.updateRequest(new ApplicationRequestUpdated(id,
                requestUsername,
                requestCommentary,
                requestPhone,
                false,
                courseService.getCourseById(requestCourse)));
        return "redirect:/lecture7/task1";
    }

    @RequestMapping(value = "/lecture7/task1/{id}/handle", method = RequestMethod.POST)
    public String markRequestAsHandled(@PathVariable Long id) {
        requestService.handleRequest(id);
        return "redirect:/lecture7/task1";
    }

    @RequestMapping(value = "/lecture7/task1/{id}/delete", method = RequestMethod.POST)
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return "redirect:/lecture7/task1";
    }
}
