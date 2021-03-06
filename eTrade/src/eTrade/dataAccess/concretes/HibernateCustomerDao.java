package eTrade.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.CustomerDao;
import eTrade.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {

	List<Customer> customerlist = new ArrayList<Customer>();

	@Override
	public void add(Customer customer) {

		System.out.println("Kullanıcı veritabanına eklendi");

	}

	@Override
	public void update(Customer customer) {

		System.out.println("Kullanıcı veritabanında güncellendi.");

	}

	@Override
	public void delete(Customer customer) {

		System.out.println("Kullanıcı veritabanından silindi.");

	}

	@Override
	public List<Customer> getAll() {
		return customerlist;

	}

}
