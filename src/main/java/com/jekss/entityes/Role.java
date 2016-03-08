package com.jekss.entityes;

import javax.persistence.*;

/**
 * Created by jekss on 10.10.15.
 */
@Entity
public class Role {
    private int id;
    private String role;
    private User user;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne(mappedBy="role")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (id != role1.id) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;
        if (user != null ? !user.equals(role1.user) : role1.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
