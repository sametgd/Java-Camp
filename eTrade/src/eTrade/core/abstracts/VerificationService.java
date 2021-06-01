package eTrade.core.abstracts;

import eTrade.entities.concretes.Customer;

public interface VerificationService {

	void sendVerification(Customer customer);

	void verified(Customer customer);

}
