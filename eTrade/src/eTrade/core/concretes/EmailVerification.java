package eTrade.core.concretes;

import eTrade.core.abstracts.VerificationService;
import eTrade.entities.concretes.Customer;

public class EmailVerification implements VerificationService {

	@Override
	public void sendVerification(Customer customer) {

		System.out.println("Doðrulama E-postasý gönderildi." + customer.getEmail());

	}

	@Override
	public void verified(Customer customer) {

		System.out.println("E-posta doðrulamasý baþarýlý.");

	}

}
