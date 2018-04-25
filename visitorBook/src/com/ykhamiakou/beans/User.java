package com.ykhamiakou.beans;

import java.io.Serializable;
import java.util.Objects;

/**
 * Describes some user
 */
public class User implements Serializable {
    /**
     * Serial version
     */
    private static final long serialVersionUID = 1L;
    /**
     * Fields
     */
    private int id;
    private String username;
    private String login;
    private String password;

    /**
     * No-arg constructor
     */
    public User() {
    }

    /**
     * Constructor with args
     *
     * @param id       - user's id
     * @param login    - user's login
     * @param password - user's password
     */
    public User(final int id, String username, final String login, final String password) {
        this.id = id;
        this.username = username;
        this.login = login;
        this.password = password;
    }

    /**
     * @return id to get
     */
    public int getId() {
        return id;
    }

    /**
     * @return username to get
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return login to get
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return password to get
     */
    public String getPassword() {
        return password;
    }

    /**
     * Equals
     * @param o - other user
     * @return - equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    /**
     * Hashcode
     * @return - user's hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, login, password);
    }
}
