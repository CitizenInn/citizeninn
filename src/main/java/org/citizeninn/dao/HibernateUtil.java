package org.citizeninn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static Session session = null;

	@SuppressWarnings("deprecation")
	protected static Session setUp() throws Exception {



		try {

			// A SessionFactory is set up once for an application
			sessionFactory = new Configuration().configure() // configures
																// settings
																// from
																// hibernate.cfg.xml
					.buildSessionFactory();
			session = sessionFactory.openSession();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return session;

	}

}
