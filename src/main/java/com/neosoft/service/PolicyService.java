package com.neosoft.service;

import com.neosoft.model.Nominee;
import com.neosoft.model.Policy;

import java.util.List;

public interface PolicyService {

    Policy upsert(Policy policy);

   List<Policy> getPolicyByUserId(Integer UserId);

}
