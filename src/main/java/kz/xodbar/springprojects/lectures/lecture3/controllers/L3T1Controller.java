package kz.xodbar.springprojects.lectures.lecture3.controllers;

import kz.xodbar.springprojects.lectures.lecture3.dao.TaskDAO;
import kz.xodbar.springprojects.lectures.lecture3.entities.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;

@Controller
public class L3T1Controller {
    @RequestMapping(value = "/lecture3/task1", method = RequestMethod.GET)
    public ModelAndView getTasksPage() {
        return new ModelAndView("./lectures/lecture3/task1/index", "tasks",
                TaskDAO.getInstance().getTasks());
    }

    @RequestMapping(value = "/lecture3/task1/{id}", method = RequestMethod.GET)
    public ModelAndView getDetailsPage(@PathVariable Long id) {
        return new ModelAndView("./lectures/lecture3/task1/details", "task",
                TaskDAO.getInstance().getTaskById(id));
    }

    @RequestMapping(value = "/lecture3/task1/add", method = RequestMethod.POST)
    public String addStudent(@RequestParam String name,
                             @RequestParam String date,
                             @RequestParam Boolean isCompleted) {
        try {
            TaskDAO.getInstance().addNewTask(new Task(
                    null, name, new SimpleDateFormat("yyyy-MM-dd").parse(date), isCompleted
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/lecture3/task1";
    }

    @RequestMapping(value = "/lecture3/task1/{id}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable Long id,
                                @RequestParam String name,
                                @RequestParam String date,
                                @RequestParam Boolean isCompleted,
                                @RequestParam String command) {
        try {
            if (command.equals("update"))
                TaskDAO.getInstance().updateTask(new Task(
                        id, name, new SimpleDateFormat("yyyy-MM-dd").parse(date), isCompleted
                ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/lecture3/task1";
    }

    @RequestMapping(value = "/lecture3/task1/{id}/del", method = RequestMethod.POST)
    public String deleteTask(@PathVariable Long id,
                             @RequestParam String command) {
        try {
            if (command.equals("delete"))
                TaskDAO.getInstance().deleteTask(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/lecture3/task1";
    }
}
