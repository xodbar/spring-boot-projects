package kz.xodbar.springprojects.lectures.lecture4.services.impl;

import kz.xodbar.springprojects.lectures.lecture4.entities.ApplicationRequest;
import kz.xodbar.springprojects.lectures.lecture4.repositories.ApplicationRequestRepository;
import kz.xodbar.springprojects.lectures.lecture4.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationRequestServiceImplementation implements ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepository repository;

    @Override
    public void addRequest(ApplicationRequest request) {
        try {
            repository.save(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ApplicationRequest getRequestById(Long id) {
        try {
            return repository.getReferenceById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationRequest> getAllRequests() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateRequest(ApplicationRequest request) {
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
    public List<ApplicationRequest> getUnhandledRequests() {
        try {
            return repository.findAllByHandledFalse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationRequest> searchRequestByComment(String query) {
        try {
            return repository.findAllByCommentaryIsLike(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationRequest> getHandledRequests() {
        try {
            return repository.findAllByHandledTrue();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
