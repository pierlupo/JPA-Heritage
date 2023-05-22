package org.example.impl;

import org.example.dao.TeacherDAO;
import org.example.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TeacherDAOImpl implements TeacherDAO {
    private EntityManagerFactory entityManagerFactory;

    public TeacherDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public boolean addTeacher(Teacher teacher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(teacher);
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
