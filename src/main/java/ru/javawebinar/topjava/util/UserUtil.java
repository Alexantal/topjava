package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtil {
    public static final List<User> users = Arrays.asList(
            new User(1, "User1", "user1@yandex.ru", "user1Password", Role.USER, Role.values())
    );
}
