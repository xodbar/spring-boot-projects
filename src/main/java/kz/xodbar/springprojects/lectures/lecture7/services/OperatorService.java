package kz.xodbar.springprojects.lectures.lecture7.services;

import kz.xodbar.springprojects.lectures.lecture4.entities.ApplicationRequest;
import kz.xodbar.springprojects.lectures.lecture7.entities.ApplicationRequestUpdated;
import kz.xodbar.springprojects.lectures.lecture7.entities.Operator;

import java.util.List;

public interface OperatorService {
    Operator getOperatorById(Long id);
    List<Operator> getAllOperators();
    List<Operator> getOperatorsForRequest(ApplicationRequestUpdated request);
}
