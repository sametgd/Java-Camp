package eTrade.business.abstracts;

import eTrade.entities.concretes.Customer;

public interface CustomerService {

	void add(Customer customer);

	void addFromExternalService(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	void login(Customer customer);

}
