package eTrade.dataAccess.abstracts;

import java.util.List;

import eTrade.entities.concretes.Customer;

public interface CustomerDao {

	void add(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> getAll();

}
