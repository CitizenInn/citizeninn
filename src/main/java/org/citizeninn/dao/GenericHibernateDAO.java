package org.citizeninn.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().load(getPersistentClass(), id,
					LockMode.UPGRADE);
		} else {
			entity = (T) getSession().load(getPersistentClass(), id);
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {

		Criteria crit = getSession().createCriteria(getPersistentClass());

		for (Criterion c : criterion) {
			crit.add(c);
		}

		return crit.list();

	}

	@Override
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		
		Criteria crit 
	}

	@Override
	public T makePersistent(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeTransient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	private Class<T> persistentClass;

	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public void setSession(Session s) {

		this.session = s;
	}

	protected Session getSession() {
		if (session == null) {
			session = HibernateUtil.sessionFactory.getCurrentSession();
		}
		return session;
	}

	public Class<T> getPersistentClass() {

		return persistentClass;

	}

}
