package com.ragu.app.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ragu.app.entity.Address;
@Repository
public class AddressDAOImpl implements EntityDAO<Address> {

	@Autowired
	@Qualifier("sf1")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Address");
		return query.getResultList();
	}

	@Override
	public Address save(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(address);
		return address;
	}

	@Override
	public Address update(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(address);
		return address;
	}
	
	@Override
	public Address findOne(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Address where employee_id="+id);
		@SuppressWarnings("unchecked")
		List<Address> addressList = query.getResultList(); 
		if(addressList.size() > 0 ) {
			return addressList.get(0);
		}else {
			return new Address();
		}
	}

	@Override
	public boolean delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select * from Address where employee_id="+id);
		Address address = (Address) query.getResultList().get(0);
		session.delete(address);
		return true;
	}

}
