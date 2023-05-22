package org.example.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("student")
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String room;

    public Student() {
        super();
    }

    public Student(String lastname, String firstname, String room) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.room = room;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString() +"Student{" + "id=" + id + ", room='" + room + '\'' + '}';
    }
}
