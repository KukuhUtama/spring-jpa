package org.mvc.security.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mvc.security.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entity;

	protected Query query;

	protected String hql;

	public BaseRepositoryImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entity = (Class) pt.getActualTypeArguments()[0];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	public void add(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}


	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) getCurrentSession().get(entity.getName(), id);
	}


	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}
	

	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		query = getCurrentSession().createQuery("from "+entity.getName());
		return query.getResultList();
	}
	

	public void update(T entity){
		getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public void deleteById(Long id) {
		hql = "delete " + entity.getName() + " where id = :id";
		query = getCurrentSession().createQuery(hql).setParameter("id", id);
		query.executeUpdate();
	}

}
