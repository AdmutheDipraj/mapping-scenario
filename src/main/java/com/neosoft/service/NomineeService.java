package com.neosoft.service;

import com.neosoft.model.Nominee;

import java.util.List;
import java.util.Optional;

public interface NomineeService {

    Nominee saveNominee(Nominee nominee);

    List<Nominee> getNomineeByUserId(Integer UserId);
}
