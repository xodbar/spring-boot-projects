package kz.xodbar.springprojects.big_project.services.impl;

import kz.xodbar.springprojects.big_project.entities.Comment;
import kz.xodbar.springprojects.big_project.entities.Task;
import kz.xodbar.springprojects.big_project.repositories.CommentRepository;
import kz.xodbar.springprojects.big_project.services.CommentService;
import kz.xodbar.springprojects.big_project.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public void addNewComment(Comment comment, Long taskId) {
        try {
            comment.setCommentTask(taskService.getTaskById(taskId));
            commentRepository.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Comment getCommentById(Long id) {
        try {
            return commentRepository.getReferenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {
        try {
            return commentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateComment(Long commentId, String newContent) {
        try {
            Comment temp = commentRepository.getReferenceById(commentId);
            temp.setCommentContent(newContent);
            commentRepository.save(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComment(Comment comment) {
        try {
            commentRepository.delete(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getCommentsForTask(Task task) {
        try {
            return commentRepository.findAllByCommentTaskOrderByCommentIdDesc(task);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
