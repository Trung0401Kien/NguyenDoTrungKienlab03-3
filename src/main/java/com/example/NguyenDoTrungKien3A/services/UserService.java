package com.example.NguyenDoTrungKien3A.services;

import com.example.NguyenDoTrungKien3A.entity.User;
import com.example.NguyenDoTrungKien3A.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
