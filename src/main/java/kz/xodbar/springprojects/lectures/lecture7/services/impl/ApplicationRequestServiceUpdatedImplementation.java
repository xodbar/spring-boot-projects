package kz.xodbar.springprojects.lectures.lecture7.services.impl;

import kz.xodbar.springprojects.lectures.lecture7.entities.ApplicationRequestUpdated;
import kz.xodbar.springprojects.lectures.lecture7.repositories.ApplicationRequestRepositoryUpdated;
import kz.xodbar.springprojects.lectures.lecture7.services.ApplicationRequestServiceUpdated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationRequestServiceUpdatedImplementation implements ApplicationRequestServiceUpdated {
    @Autowired
    private ApplicationRequestRepositoryUpdated repository;

    @Override
    public void addRequest(ApplicationRequestUpdated request) {
        try {
            repository.save(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ApplicationRequestUpdated getRequestById(Long id) {
        try {
            return repository.getReferenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationRequestUpdated> getAllRequests() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateRequest(ApplicationRequestUpdated request) {
        try {
            repository.save(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRequest(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleRequest(Long id) {
        try {
            repository.handleRequestById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ApplicationRequestUpdated> getUnhandledRequests() {
        try {
            return repository.findAllByHandledFalse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationRequestUpdated> searchRequestByComment(String query) {
        try {
            return repository.findAllByCommentaryIsLike(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationRequestUpdated> getHandledRequests() {
        try {
            return repository.findAllByHandledTrue();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
