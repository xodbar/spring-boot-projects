package kz.xodbar.springprojects.lectures.lecture7.services.impl;

import kz.xodbar.springprojects.lectures.lecture7.entities.ApplicationRequestUpdated;
import kz.xodbar.springprojects.lectures.lecture7.entities.Operator;
import kz.xodbar.springprojects.lectures.lecture7.repositories.OperatorRepository;
import kz.xodbar.springprojects.lectures.lecture7.services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorServiceImplementation implements OperatorService {
    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public Operator getOperatorById(Long id) {
        return operatorRepository.getReferenceById(id);
    }

    @Override
    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public List<Operator> getOperatorsForRequest(ApplicationRequestUpdated request) {
        return operatorRepository.findAllByAssignedRequests(request);
    }
}
