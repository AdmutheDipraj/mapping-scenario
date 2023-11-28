package com.neosoft.service.impl;

import com.neosoft.model.Nominee;
import com.neosoft.repository.NomineeRepository;
import com.neosoft.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NomineeServiceImpl implements NomineeService {
    @Autowired
    private NomineeRepository nomineeRepository;
    @Override
    public Nominee saveNominee(Nominee nominee) {
        return nomineeRepository.save(nominee);
    }
}
