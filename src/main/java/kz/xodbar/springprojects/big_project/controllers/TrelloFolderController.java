package kz.xodbar.springprojects.big_project.controllers;

import kz.xodbar.springprojects.big_project.entities.Folder;
import kz.xodbar.springprojects.big_project.services.FolderService;
import kz.xodbar.springprojects.big_project.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrelloFolderController {
    @Autowired
    private FolderService folderService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/trello/folders", method = RequestMethod.POST)
    public ModelAndView addNewFolder(@RequestParam(defaultValue = "Unnamed Folder") String folderName,
                                     ModelMap modelMap) {
        modelMap.addAttribute("folder",
                folderService.addNewFolder(new Folder(null, folderName, null)));
        modelMap.addAttribute("folderTasks",
                null);

        return new ModelAndView("./big_project/folder", modelMap);
    }

    @RequestMapping(value = "/trello/folders", method = RequestMethod.GET)
    public String redirectToHome() {
        return "redirect:/trello";
    }

    @RequestMapping(value = "/trello/folders/{id}", method = RequestMethod.GET)
    public ModelAndView getSpecificFolder(@PathVariable Long id,
                                          ModelMap modelMap) {
        modelMap.addAttribute("folder", folderService.getFolderById(id));
        modelMap.addAttribute("folderTasks", taskService.getTasksByFolder(id));

        return new ModelAndView("./big_project/folder", modelMap);
    }

    @RequestMapping(value = "/trello/folders/{id}/delete", method = RequestMethod.POST)
    public String deleteSpecificFolder(@PathVariable Long id) {
        folderService.deleteFolder(folderService.getFolderById(id));
        return "redirect:/trello";
    }

    @RequestMapping(value = "/trello/folders/{id}/update", method = RequestMethod.POST)
    public String updateSpecificFolder(@PathVariable Long id,
                                             @RequestParam String name) {
        folderService.updateFolder(new Folder(id, name, folderService.getFolderById(id).getFolderCategories()));
        return "redirect:/trello/folders/" + id;
    }

    @RequestMapping(value = "/trello/folders/{id}/assignCategory", method = RequestMethod.POST)
    public String assignCategoryToSpecificFolder(@PathVariable Long id,
                                                 @RequestParam String categoryName) {
        folderService.assignCategoryToFolder(id, categoryName);
        return "redirect:/trello/folders/" + id;
    }

    @RequestMapping(value = "/trello/folders/{id}/removeCategory", method = RequestMethod.POST)
    public String removeCategoryFromSpecificFolder(@PathVariable Long id,
                                                   @RequestParam Long categoryId) {
        folderService.removeCategoryFromFolder(id, categoryId);
        return "redirect:/trello/folders/" + id;
    }
}
