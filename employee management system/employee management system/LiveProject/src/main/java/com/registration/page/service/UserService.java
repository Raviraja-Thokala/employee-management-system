package com.registration.page.service;

import com.registration.page.model.User;
import com.registration.page.model.Details;
import com.registration.page.repository.UserRepository;
import com.registration.page.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    public boolean authenticateUser(String email, String password) {
        Details details = detailsRepository.findByEmail(email);
        return details != null && details.getPassword().equals(password);
    }

    public Details findDetailsByEmail(String email) {
        return detailsRepository.findByEmail(email);
    }

    public User registerUser(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error registering user", e);
        }
    }
}

