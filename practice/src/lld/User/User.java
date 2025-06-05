package lld.User;

import lld.person.Person;

public class User extends Person {

    public String userEmail;

    public User(int userId , String userName, String userEmail) {
        super(userId, userName);
        this.userEmail = userEmail;
    }
}
