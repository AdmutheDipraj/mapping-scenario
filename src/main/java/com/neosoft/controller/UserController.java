package com.neosoft.controller;

import com.neosoft.model.Nominee;
import com.neosoft.model.Policy;
import com.neosoft.model.User;
import com.neosoft.service.NomineeService;
import com.neosoft.service.PolicyService;
import com.neosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private NomineeService nomineeService;
    @PostMapping
   ResponseEntity<User> saveUser(@RequestBody User user){
        User saveuser = userService.saveUser(user);
        List<Policy> policies = user.getPolicyList();
        for(Policy policy:policies){
             policy.setUserId(user.getId());
             policyService.upsert(policy);
        }
        List<Nominee> nominees = user.getNomineeList();
        for(Nominee nominee:nominees){
           nominee.setUserId(user.getId());
            nomineeService.saveNominee(nominee);
        }
        return ResponseEntity.ok().body(saveuser);
    }
}
