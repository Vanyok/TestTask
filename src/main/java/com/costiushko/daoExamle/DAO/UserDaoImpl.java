package com.costiushko.daoExamle.DAO;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.costiushko.daoExamle.logic.User;

@Repository("userDAO")
@Transactional

public class UserDaoImpl implements UserDAO{
    private HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory( SessionFactory sessionFactory){
	hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void addUser(User user) throws SQLException {
	hibernateTemplate.save(user);
    }

    public void deleteUser(User user) throws SQLException {
	hibernateTemplate.delete(user);
    }

    public void updateUser(User user) throws SQLException {
	hibernateTemplate.saveOrUpdate(user);
    }

    public User getUserById(long id) throws SQLException {
	
	return hibernateTemplate.get(User.class, id);
    }

    public List<?> getAllUsers() throws SQLException {
	
	return (List<?>) hibernateTemplate.find("from "+User.class.getName());
    }

}
