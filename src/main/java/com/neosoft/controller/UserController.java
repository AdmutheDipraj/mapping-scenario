package com.neosoft.controller;

import com.neosoft.model.Nominee;
import com.neosoft.model.Policy;
import com.neosoft.model.User;
import com.neosoft.service.NomineeService;
import com.neosoft.service.PolicyService;
import com.neosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{userId}")
    ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(userId);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());

        User updatedUserEntity = userService.saveUser(existingUser);

        // Update policies
        List<Policy> updatedPolicies = updatedUser.getPolicyList();
        for (Policy policy : updatedPolicies) {
            policy.setUserId(updatedUserEntity.getId());
            policyService.upsert(policy);
        }

        List<Nominee> updatedNominees = updatedUser.getNomineeList();
        for (Nominee nominee : updatedNominees) {
            nominee.setUserId(updatedUserEntity.getId());
            nomineeService.saveNominee(nominee);
        }
        return ResponseEntity.ok().body(updatedUserEntity);
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Fetch policies and nominees associated with the user
        List<Policy> policies = policyService.getPolicyByUserId(userId);
        List<Nominee> nominees = nomineeService.getNomineeByUserId(userId);

        user.setPolicyList(policies);
        user.setNomineeList(nominees);

        return ResponseEntity.ok().body(user);
    }


}
