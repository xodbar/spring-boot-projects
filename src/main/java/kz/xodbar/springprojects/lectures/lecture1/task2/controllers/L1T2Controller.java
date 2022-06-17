package kz.xodbar.springprojects.lectures.lecture1.task2.controllers;

import kz.xodbar.springprojects.lectures.lecture1.task2.db.DBManager;
import kz.xodbar.springprojects.lectures.lecture1.task2.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class L1T2Controller {
    @GetMapping(value = "/lecture1/task2")
    public ModelAndView getIndexPage() {
        return new ModelAndView("./lectures/lecture1/task2/index", "items",
                DBManager.MANAGER.getAllItems());
    }

    @GetMapping(value = "/lecture1/task2/list")
    public ModelAndView getListPage() {
        return new ModelAndView("./lectures/lecture1/task2/list", "items",
                DBManager.MANAGER.getAllItems());
    }

    @GetMapping(value = "/lecture1/task2/{id}")
    public ModelAndView getDetailsPage(@PathVariable Integer id) {
        return new ModelAndView("./lectures/lecture1/task2/details", "item",
                DBManager.MANAGER.getItemById((long)id));
    }

    @PostMapping(value = "/lecture1/task2/add")
    public String addNewItem(@RequestParam("name") String name, @RequestParam("description") String description,
                             @RequestParam("price") Double price, @RequestParam("amount") Integer amount) {
        DBManager.MANAGER.addItem(new Item(null, name, description, price, amount));
        return "redirect:/lecture1/task2";
    }

    @PostMapping(value = "/lecture1/task2/{id}/edit")
    public String editItem(@PathVariable Integer id, @RequestParam("name") String name,
                           @RequestParam("description") String description, @RequestParam("price") Double price,
                           @RequestParam("amount") Integer amount) {
        DBManager.MANAGER.editItem(new Item(id.longValue(), name, description, price, amount));
        return "redirect:/lecture1/task2";
    }

    @PostMapping(value = "/lecture1/task2/{id}/delete")
    public String deleteItem(@PathVariable Integer id) {
        DBManager.MANAGER.deleteItem(DBManager.MANAGER.getItemById((long)id).getId());
        return "redirect:/lecture1/task2";
    }
}
