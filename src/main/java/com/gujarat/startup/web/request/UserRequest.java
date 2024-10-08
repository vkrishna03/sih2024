package com.gujarat.startup.web.request;

import java.util.List;

import com.gujarat.startup.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private List<User> users;
}
