package kz.xodbar.springprojects.lectures.lecture4.services;

import kz.xodbar.springprojects.lectures.lecture4.entities.ApplicationRequest;

import java.util.List;

public interface ApplicationRequestService {
    void addRequest(ApplicationRequest request);
    ApplicationRequest getRequestById(Long id);
    List<ApplicationRequest> getAllRequests();
    List<ApplicationRequest> getUnhandledRequests();
    List<ApplicationRequest> getHandledRequests();
    List<ApplicationRequest> searchRequestByComment(String query);
    void updateRequest(ApplicationRequest request);
    void deleteRequest(Long id);
    void handleRequest(Long id);
}
