package kz.xodbar.springprojects.lectures.lecture7.services;

import kz.xodbar.springprojects.lectures.lecture7.entities.ApplicationRequestUpdated;

import java.util.List;

public interface ApplicationRequestServiceUpdated {
    void addRequest(ApplicationRequestUpdated request);
    ApplicationRequestUpdated getRequestById(Long id);
    List<ApplicationRequestUpdated> getAllRequests();
    List<ApplicationRequestUpdated> getUnhandledRequests();
    List<ApplicationRequestUpdated> getHandledRequests();
    List<ApplicationRequestUpdated> searchRequestByComment(String query);
    void updateRequest(ApplicationRequestUpdated request);
    void deleteRequest(Long id);
    void handleRequest(Long id, Long[] operators);
}
