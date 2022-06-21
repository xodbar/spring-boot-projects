package kz.xodbar.springprojects.lectures.lecture2.task1.controllers;

import kz.xodbar.springprojects.lectures.lecture2.task1.db.StaticDBManager;
import kz.xodbar.springprojects.lectures.lecture2.task1.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class L2T1Controller {
    @RequestMapping(value = "/lecture2/task1", method = RequestMethod.GET)
    public ModelAndView getStudentsPage() {
        return new ModelAndView("./lectures/lecture2/task1/index", "students",
                StaticDBManager.MANAGER.getSTUDENTS());
    }

    @RequestMapping(value = "/lecture2/task1/addStudent", method = RequestMethod.GET)
    public String getAddStudentPage() {
        return "./lectures/lecture2/task1/add";
    }

    @RequestMapping(value = "/lecture2/task1/addStudent", method = RequestMethod.POST)
    public String addStudent(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam Integer numEquivMark) {
        StaticDBManager.MANAGER.addStudent(new Student(
                null,
                name,
                surname,
                numEquivMark
        ));

        return "redirect:/lecture2/task1";
    }
}
