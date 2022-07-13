package kz.xodbar.springprojects.big_project.controllers;

import kz.xodbar.springprojects.big_project.entities.Task;
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
public class TrelloTaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "/trello/folders/{folderId}/addTask", method = RequestMethod.POST)
    public ModelAndView addTaskToFolder(@PathVariable Long folderId,
                                        @RequestParam String title,
                                        @RequestParam String description,
                                        @RequestParam int status,
                                        ModelMap modelMap) {
        modelMap.addAttribute("task",
                taskService.addNewTask(
                        new Task(null,
                                title,
                                description,
                                status,
                                folderService.getFolderById(folderId))));
        modelMap.addAttribute("folder", folderService.getFolderById(folderId));

        return new ModelAndView("./big_project/task", modelMap);
    }

    @RequestMapping(value = "/trello/folders/{folderId}/{taskId}", method = RequestMethod.GET)
    public ModelAndView getSpecificTask(@PathVariable Long folderId,
                                        @PathVariable Long taskId,
                                        ModelMap modelMap) {
        modelMap.addAttribute("task", taskService.getTaskById(taskId));
        modelMap.addAttribute("folder", folderService.getFolderById(folderId));

        return new ModelAndView("./big_project/task", modelMap);
    }

    @RequestMapping(value = "/trello/folders/{folderId}/{taskId}/update", method = RequestMethod.POST)
    public String updateSpecificTask(@PathVariable Long folderId,
                                           @PathVariable Long taskId,
                                           @RequestParam String title,
                                           @RequestParam String description,
                                           @RequestParam int status) {
        taskService.updateTask(new Task(taskId, title, description, status, folderService.getFolderById(folderId)));
        return "redirect:/trello/folders/" + folderId + "/" + taskId;
    }

    @RequestMapping(value = "/trello/folders/{folderId}/{taskId}/delete", method = RequestMethod.POST)
    public String deleteSpecificTask(@PathVariable Long folderId,
                                     @PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/trello/folders/" + folderId;
    }
}
