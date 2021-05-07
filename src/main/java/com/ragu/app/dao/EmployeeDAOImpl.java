package com.ragu.app.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ragu.app.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EntityDAO<Employee> {

    @Autowired
    @Qualifier("sf1")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List < Employee > findAll() {
        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery < Employee > cq = cb.createQuery(Employee.class);
//        Root < Employee > root = cq.from(Employee.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
        Query query = session.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.byId(Employee.class).load(id);
        session.delete(emp);
        return true;
    }

    @Override
    public Employee save(Employee emp) {
    	Session session = sessionFactory.getCurrentSession();
//    	Employee employee = this.findOne(emp.getId());
//    	if(employee.getId() > 0 && emp.getId() == employee.getId()) {
//    	}
        session.saveOrUpdate(emp);
        return emp;
    }
    
    @Override
    public Employee update(Employee emp) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(emp);
        return emp;
    }

    @Override
    public Employee findOne(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee emp = currentSession.get(Employee.class, id);
        return emp;
    }
}
