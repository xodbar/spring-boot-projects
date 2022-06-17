package kz.xodbar.springprojects.lectures.lecture1.task1.controllers;

import kz.xodbar.springprojects.lectures.lecture1.task1.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class L1T1Controller {
    @GetMapping(value = "/lecture1/task1")
    public ModelAndView getIndexPage() {
        return new ModelAndView("./lectures/lecture1/task1/index", "items",
                DBManager.MANAGER.getAllItems());
    }
}
