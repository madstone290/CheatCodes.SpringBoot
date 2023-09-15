package mad290.spring.tutorial.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
/*
    Postgresql is case-sensitive, so we need to specify the table name in quotes.
    The table name and columns should be in quotes.
 */
@Table(name = "\"AspNetUsers\"")
public class AspNetUser {

    @Id
    @Column(name = "\"Id\"")
    private String id;
    @Column(name = "\"UserName\"")
    private String userName;
    @Column(name = "\"Email\"")
    private String email;

    @Column(name = "\"IsAdmin\"")
    private boolean isAdmin;

    protected AspNetUser() { }

    public AspNetUser(String userName, String email) {
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String print(){
        return "id: " + id + ", userName: " + userName + ", email: " + email;
    }
}
