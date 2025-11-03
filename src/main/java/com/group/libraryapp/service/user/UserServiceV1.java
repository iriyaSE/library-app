package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserAddRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {
    UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void addUser(UserAddRequest request) {
        String name = request.getName();
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is null or blank");
        }
        userJdbcRepository.AddUser(name, request.getAge());
    }

    public List<UserResponse> getAllUsers() {
        return userJdbcRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request) {
        if (userJdbcRepository.UpdateUserName(request.getName(), request.getId()) == 0) {
            throw new EmptyResultDataAccessException("Such user is not Exist", 1);
        }
    }

    public void deleteUser(String username) {
        if (userJdbcRepository.DeleteUser(username) == 0) {
            throw new EmptyResultDataAccessException("Such user is not Exist", 1);
        }
    }
}
