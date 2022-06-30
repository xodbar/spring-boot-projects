package kz.xodbar.springprojects.lectures.lecture4.controllers;

import kz.xodbar.springprojects.lectures.lecture4.entities.ApplicationRequest;
import kz.xodbar.springprojects.lectures.lecture4.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationRequestController {
    @Autowired
    private ApplicationRequestService requestService;

    @Autowired
    private List<String> courses() {
        List<String> courses = new ArrayList<>();

        courses.add("Java PRO");
        courses.add("Java Standard Edition");
        courses.add("Web Technologies");
        courses.add("Django Framework");
        courses.add("UX/UI Design");

        return courses;
    }

    @RequestMapping(value = "/lecture4/task1", method = RequestMethod.GET)
    public ModelAndView getAllRequestsPage(ModelMap model) {
        model.addAttribute("requests", requestService.getAllRequests());
        return new ModelAndView("./lectures/lecture4/task1/index", model);
    }

    @RequestMapping(value = "/lecture4/task1/unhandled", method = RequestMethod.GET)
    public ModelAndView getUnhandledRequestsPage(ModelMap model) {
        model.addAttribute("requests", requestService.getUnhandledRequests());
        return new ModelAndView("./lectures/lecture4/task1/index", model);
    }

    @RequestMapping(value = "/lecture4/task1/handled", method = RequestMethod.GET)
    public ModelAndView getHandledRequestsPage(ModelMap model) {
        model.addAttribute("requests", requestService.getHandledRequests());
        return new ModelAndView("./lectures/lecture4/task1/index", model);
    }

    @RequestMapping(value = "/lecture4/task1/search", method = RequestMethod.GET)
    public ModelAndView getSearchResults(ModelMap model, @RequestParam String query) {
        model.addAttribute("requests", requestService.searchRequestByComment(query));
        return new ModelAndView("./lectures/lecture4/task1/index", model);
    }

    @RequestMapping(value = "/lecture4/task1/add", method = RequestMethod.GET)
    public ModelAndView getAddingPage(ModelMap model) {
        model.addAttribute("courses", courses());
        return new ModelAndView("./lectures/lecture4/task1/add", model);
    }

    @RequestMapping(value = "/lecture4/task1/add", method = RequestMethod.POST)
    public String addNewRequestHandler(@RequestParam String requestUsername,
                                       @RequestParam String requestCommentary,
                                       @RequestParam String requestCourse,
                                       @RequestParam String requestPhone) {
        try {
            requestService.addRequest(new ApplicationRequest(null,
                    requestUsername,
                    requestCourse,
                    requestCommentary,
                    requestPhone,
                    false));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/lecture4/task1";
    }

    @RequestMapping(value = "/lecture4/task1/{id}", method = RequestMethod.GET)
    public ModelAndView getRequestDetailsPage(@PathVariable Long id, ModelMap model) {
        model.addAttribute("request", requestService.getRequestById(id));
        model.addAttribute("courses", courses());
        return new ModelAndView("./lectures/lecture4/task1/details", model);
    }

    @RequestMapping(value = "/lecture4/task1/{id}/update", method = RequestMethod.POST)
    public String updateRequest(@PathVariable Long id,
                                      @RequestParam String requestUsername,
                                      @RequestParam String requestCommentary,
                                      @RequestParam String requestCourse,
                                      @RequestParam String requestPhone) {
        requestService.updateRequest(new ApplicationRequest(id,
                requestUsername,
                requestCourse,
                requestCommentary,
                requestPhone,
                false));
        return "redirect:/lecture4/task1";
    }

    @RequestMapping(value = "/lecture4/task1/{id}/handle", method = RequestMethod.POST)
    public String markRequestAsHandled(@PathVariable Long id) {
        requestService.handleRequest(id);
        return "redirect:/lecture4/task1";
    }

    @RequestMapping(value = "/lecture4/task1/{id}/delete", method = RequestMethod.POST)
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return "redirect:/lecture4/task1";
    }
}
