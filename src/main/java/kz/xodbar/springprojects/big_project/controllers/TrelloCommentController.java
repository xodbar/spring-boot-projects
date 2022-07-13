package kz.xodbar.springprojects.big_project.controllers;

import kz.xodbar.springprojects.big_project.entities.Comment;
import kz.xodbar.springprojects.big_project.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrelloCommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/trello/folders/{folderId}/{taskId}/addComment", method = RequestMethod.POST)
    public String addCommentToTask(@PathVariable Long folderId,
                                   @PathVariable Long taskId,
                                   @RequestParam String content) {
        commentService.addNewComment(new Comment(null, content, null), taskId);
        return "redirect:/trello/folders/" + folderId + "/" + taskId;
    }

    @RequestMapping(value = "/trello/folders/{folderId}/{taskId}/deleteComment", method = RequestMethod.POST)
    public String removeCommentFromTask(@PathVariable Long folderId,
                                        @PathVariable Long taskId,
                                        @RequestParam Long commentId) {
        commentService.deleteComment(commentService.getCommentById(commentId));
        return "redirect:/trello/folders/" + folderId + "/" + taskId;
    }

    @RequestMapping(value = "/trello/folders/{folderId}/{taskId}/updateComment", method = RequestMethod.POST)
    public String updateCommentOnTask(@PathVariable Long folderId,
                                      @PathVariable Long taskId,
                                      @RequestParam Long commentId,
                                      @RequestParam String newContent) {
        commentService.updateComment(commentId, newContent);
        return "redirect:/trello/folders/" + folderId + "/" + taskId;
    }
}
