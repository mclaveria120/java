package com.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.database.AbstractDAO;
import com.database.queries.AbstractQuery;
import com.database.queries.ComplexQuery;
import com.model.User;

@Repository
public class UserDAO extends AbstractDAO<User>{

	
	public boolean isUserRegister(String email) {
		boolean answer=true;
		try{
			AbstractQuery.query(sessionFactory, new ComplexQuery<User>() {
				
				@Override
				public User query(Session session) {
					TypedQuery<User> q = session.createQuery("SELECT o FROM User o where email=:email", entityClass)
							.setParameter("email", email);
					return q.getSingleResult();
				}
			});
		}catch(NoResultException e){
			answer=false;
		}
		return answer;
	}

	public User getUserByEmail(String email) {
		return AbstractQuery.query(sessionFactory, new ComplexQuery<User>() {
				
				@Override
				public User query(Session session) {
					TypedQuery<User> q = session.createQuery("SELECT o FROM User o where email=:email", entityClass)
							.setParameter("email", email);
					return q.getSingleResult();
				}
			});
	}
	
}
