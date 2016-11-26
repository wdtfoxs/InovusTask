package ru.test.inovus.repositories;

import ru.test.inovus.entity.User;

public interface UserRepository {

    void add(User user);

    User getUseByUsername(String username);
}
