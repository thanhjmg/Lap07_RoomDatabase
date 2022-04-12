package com.example.lap07_roomdatabase;


import androidx.room.PrimaryKey;

@androidx.room.Entity (tableName ="user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
