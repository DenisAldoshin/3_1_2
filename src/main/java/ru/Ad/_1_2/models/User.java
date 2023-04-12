package ru.Ad._1_2.models;


import jakarta.persistence.*;

@Entity
@Table(name="User")

public class User {
@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name="name")
    private String name;
@Column(name="last_name")
    private String last_name;

public User(){
}

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + last_name;
    }
}
