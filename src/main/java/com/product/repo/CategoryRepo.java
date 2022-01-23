package com.product.repo;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.product.entity.Categories;
import com.product.util.HibernateUtil;

@Repository
public class CategoryRepo {
	
	
	public void save(Categories categories) {
		Session session=HibernateUtil.sessionFactory().openSession();
		session.beginTransaction();
		session.save(categories);
		session.getTransaction().commit();
	}
	public Categories getCategoryById(Integer id) {
		Session session=HibernateUtil.sessionFactory().openSession();
		session.beginTransaction();
		Categories categories= session.get(Categories.class, id);
		session.getTransaction().commit();
		return categories;
	}

}
