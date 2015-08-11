package pack1.service;

import pack1.model.User;

import java.util.List;

/**
 * Created by Mihai7 on 7/15/2015.
 */
public interface IUserService {

    List<User> findAllUsers();
}
