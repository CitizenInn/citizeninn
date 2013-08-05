package org.citizeninn.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().load(getPersistentClass(), id,
					LockOptions.UPGRADE);
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
		
		return null;
	}

	@Override
	public T makePersistent(T entity) {

		Session session = getSession();

		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(entity);
		trans.commit();
		return entity;
	}

	@Override
	public void makeTransient(T entity) {
		getSession().delete(entity);

	}

	@Override
	public void flush() {
		getSession().flush();

	}

	@Override
	public void clear() {
		getSession().clear();

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
			try {
				session = HibernateUtil.getSessionFactory().getCurrentSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return session;
	}

	public Class<T> getPersistentClass() {

		return persistentClass;

	}

}
