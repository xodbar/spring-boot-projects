package kz.xodbar.springprojects.test.controllers;

import kz.xodbar.springprojects.test.entities.FirstBean;
import kz.xodbar.springprojects.test.entities.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @Autowired
    FirstBean firstBean;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String getTest1(Model model) {
        return "./test/test1";
    }
}
