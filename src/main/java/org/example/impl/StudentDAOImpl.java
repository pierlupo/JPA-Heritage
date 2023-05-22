package org.example.impl;

import org.example.dao.StudentDAO;
import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class StudentDAOImpl implements StudentDAO {

    private EntityManagerFactory entityManagerFactory;

    public StudentDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean addStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }
}
