package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void AddUser(String username, Integer age) {
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, username, age);
    }

    public List<UserResponse> getUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, num) ->
                new UserResponse(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                )
        );
    }

    public int UpdateUserName(String username, Long id) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";

        return jdbcTemplate.update(sql, username, id);
    }

    public int DeleteUser(String username) {
        String sql = "DELETE FROM user WHERE name = ?";
        return jdbcTemplate.update(sql, username);
    }
}
