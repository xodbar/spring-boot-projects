package kz.xodbar.springprojects.big_project.controllers;

import kz.xodbar.springprojects.big_project.services.FolderService;
import kz.xodbar.springprojects.big_project.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrelloCategoryController {
    @Autowired
    private TaskCategoryService categoryService;

    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "/trello/categories", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getCategories(@RequestParam(required = false) Long cid,
                                      ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.getAllCategories());

        if (cid != null) {
            try {
                modelMap.addAttribute("categoryFolders",
                        folderService.getFoldersByCategory(categoryService.getCategoryById(cid)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ModelAndView("./big_project/category", modelMap);
    }
}
