package com.ironyard.data;

import javax.persistence.*;

/**
 * Created by jasonskipper on 2/6/17.
 */
@Entity
public class MovieUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movieuser_sequence")
    @SequenceGenerator(name="movieuser_sequence", sequenceName = "mvusr_sequence")
    private long id;
    private String username;
    private String password;
    private String displayName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
