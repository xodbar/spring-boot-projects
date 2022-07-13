package kz.xodbar.springprojects.big_project.services;

import kz.xodbar.springprojects.big_project.entities.Comment;
import kz.xodbar.springprojects.big_project.entities.Task;

import java.util.List;

public interface CommentService {
    void addNewComment(Comment comment, Long taskId);
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    void updateComment(Long commentId, String newContent);
    void deleteComment(Comment comment);

    List<Comment> getCommentsForTask(Long taskId);
}
