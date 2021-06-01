package eTrade.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.CustomerDao;
import eTrade.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {

	List<Customer> customerlist = new ArrayList<Customer>();

	@Override
	public void add(Customer customer) {

		System.out.println("Kullanýcý veritabanýna eklendi");

	}

	@Override
	public void update(Customer customer) {

		System.out.println("Kullanýcý veritabanýnda güncellendi.");

	}

	@Override
	public void delete(Customer customer) {

		System.out.println("Kullanýcý veritabanýndan silindi.");

	}

	@Override
	public List<Customer> getAll() {
		return customerlist;

	}

}
