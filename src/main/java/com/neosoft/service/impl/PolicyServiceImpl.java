package com.neosoft.service.impl;

import com.neosoft.model.Policy;
import com.neosoft.repository.PolicyRepository;
import com.neosoft.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepository;
    @Override
    public Policy upsert(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPolicyByUserId(Integer UserId) {
        return Collections.emptyList();
    }

}
