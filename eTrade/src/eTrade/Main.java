package eTrade;

import eTrade.business.concretes.CustomerManager;
import eTrade.business.concretes.GoogleSessionAssistantAdapter;
import eTrade.core.concretes.EmailVerification;
import eTrade.dataAccess.concretes.HibernateCustomerDao;
import eTrade.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {

		CustomerManager customerManager = new CustomerManager(new HibernateCustomerDao(), new EmailVerification(),
				new GoogleSessionAssistantAdapter());

		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Samet");
		customer1.setLastName("Göde");
		customer1.setEmail("samethd34@gmail.com");
		customer1.setPassword("smt.343434");

		customerManager.add(customer1);

		System.out.println("************************************************************");

		customerManager.login(customer1);

		System.out.println("************************************************************");

		customerManager.update(customer1);

		System.out.println("************************************************************");

		customerManager.delete(customer1);

		System.out.println("************************************************************");

		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setFirstName("Þevket");
		customer2.setLastName("Göde");
		customer2.setEmail("sevketgode46@hotmail.com");
		customer2.setPassword("sevket346");

		customerManager.addFromExternalService(customer2);

		System.out.println("************************************************************");

		customerManager.update(customer2);

		System.out.println("************************************************************");

		customerManager.delete(customer2);

		System.out.println("************************************************************");

		customerManager.add(customer2);

		System.out.println("************************************************************");

		customerManager.login(customer2);

	}

}
