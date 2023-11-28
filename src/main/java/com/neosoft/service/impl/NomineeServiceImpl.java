package com.neosoft.service.impl;

import com.neosoft.model.Nominee;
import com.neosoft.model.Policy;
import com.neosoft.repository.NomineeRepository;
import com.neosoft.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NomineeServiceImpl implements NomineeService {
    @Autowired
    private NomineeRepository nomineeRepository;
    @Override
    public Nominee saveNominee(Nominee nominee) {
        return nomineeRepository.save(nominee);
    }

    @Override
    public List<Nominee> getNomineeByUserId(Integer UserId) {
        return Collections.emptyList();
    }


}
