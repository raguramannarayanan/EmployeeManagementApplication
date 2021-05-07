package com.ragu.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragu.app.dao.AddressDAOImpl;
import com.ragu.app.entity.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements IEntityService<Address> {

	@Autowired
	private AddressDAOImpl addressDAO;
	
	@Override
	public List<Address> findAll() {
		return this.addressDAO.findAll();
	}

	@Override
	public Address save(Address address) {
		return this.addressDAO.save(address);
	}
	
	@Override
	public Address update(Address address) {
		return this.addressDAO.update(address);
	}

	@Override
	public Address findOne(int id) {
		return this.addressDAO.findOne(id);
	}

	@Override
	public boolean delete(int id) {
		return this.addressDAO.delete(id);
	}

}
