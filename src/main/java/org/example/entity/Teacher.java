package org.example.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    public Teacher() {
        super();
    }

    public Teacher(String lastName, String firstName, String subject) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.subject = subject;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() +"Teacher{" + "id=" + id + ", subject='" + subject + '\'' + '}';
    }
}
