package kz.xodbar.springprojects.big_project.controllers;

import kz.xodbar.springprojects.big_project.services.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrelloHomeController {
    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "/trello", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getTrelloHomePage(ModelMap modelMap) {
        modelMap.addAttribute("folders", folderService.getAllFolders());
        return new ModelAndView("./big_project/index", modelMap);
    }
}
