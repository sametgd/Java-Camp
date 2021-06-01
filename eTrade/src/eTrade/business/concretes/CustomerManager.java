package eTrade.business.concretes;

import java.util.regex.Pattern;

import eTrade.business.abstracts.CustomerService;
import eTrade.core.abstracts.ExternalServiceSignIn;
import eTrade.core.abstracts.VerificationService;
import eTrade.dataAccess.abstracts.CustomerDao;
import eTrade.entities.concretes.Customer;

import java.util.regex.Matcher;

public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;

	private VerificationService verificationService;

	private ExternalServiceSignIn externalServiceSignIn;

	private boolean checked = false;

	private final Pattern validEmailAddressRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private boolean validateEmail(String email) {
		Matcher matcher = validEmailAddressRegex.matcher(email);
		return matcher.find();
	}

	public CustomerManager(CustomerDao customerDao, VerificationService verificationService,
			ExternalServiceSignIn externalServiceSignIn) {
		super();
		this.customerDao = customerDao;
		this.verificationService = verificationService;
		this.externalServiceSignIn = externalServiceSignIn;
	}

	@Override
	public void addFromExternalService(Customer customer) {
		
		customerDao.getAll().add(customer);

		this.externalServiceSignIn.addWithExternalService(" Kay�t ba�ar�l�. Ho�geldiniz. " + customer.getFirstName() + " " + customer.getLastName() + " :)");
		return;

	}

	@Override
	public void add(Customer customer) {

		if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2) {
			System.out.println("�sminiz veya soyisminiz 2 harften fazla olmal�d�r. L�tfen kontrol ediniz.");
			return;
		} else {
			checked = true;
		}

		if (!validateEmail(customer.getEmail())) {
			System.out.println("Yanl�� E-Mail adresi girdiniz. L�tfen kontrol ediniz.");
			return;
		} else {
			checked = true;
		}

		for (int i = 0; i < customerDao.getAll().toArray().length; i++) {
			if (customerDao.getAll().get(i).getEmail() == customer.getEmail()) {
				System.out.println("Zaten bu e-posta adresine ait bir hesap var.");
				return;
			} else {
				checked = true;
			}
		}

		if (customer.getPassword().length() > 6 && customer.getPassword().length() < 10) {
			System.out.println("�ifre en az 6, en fazla 10 haneli olmal�d�r.");
			return;
		} else {
			checked = true;
		}

		this.verificationService.sendVerification(customer);

		this.verificationService.verified(customer);

		checked = true;

		if (checked == true) {

			customerDao.getAll().add(customer);

			System.out.println("Kay�t ba�ar�l�. Ho�geldiniz. " + customer.getFirstName() + " " + customer.getLastName() + " :) ");
		} else {
			System.out.println("Bir �eyler ters gitti. L�tfen tekrar deneyiniz. ");
		}

	}

	@Override
	public void login(Customer customer) {

		if (!validateEmail(customer.getEmail())) {
			System.out.println("Yanl�� E-Mail adresi girdiniz. L�tfen kontrol ediniz.");
			return;
		} else {
			checked = true;
		}

		if (customer.getPassword().length() > 6 && customer.getPassword().length() < 10) {
			System.out.println("�ifre en az 6, en fazla 10 haneli olmal�d�r.");
			return;
		} else {
			checked = true;
		}

		if (checked == true) {
			for (int i = 0; i < customerDao.getAll().toArray().length; i++) {
				if (customerDao.getAll().get(i).getEmail() == customer.getEmail()
						&& customerDao.getAll().get(i).getPassword() == customer.getPassword()) {
					System.out.println("E-posta ve �ifre do�ru. Ho�geldiniz. " + customer.getFirstName() + " " + customer.getLastName() + " :)");
				} else {
					System.out.println("E-posta veya �ifre hatal�. L�tfen kontol ediniz.");
				}
			}

		}

	}

	@Override
	public void update(Customer customer) {
		
		customerDao.update(customer);
		
		System.out.println("Bilgileriniz g�ncellendi; " + customer.getFirstName() + " " + customer.getLastName());
		
	}

	@Override
	public void delete(Customer customer) {
		
		customerDao.delete(customer);
		
		System.out.println("Hesab�n�z silindi; " + customer.getFirstName() + " " + customer.getLastName() + " Sizi kaybetti�imiz i�in �zg�n�z. L�tfen bize nedenini s�yleyin.");
		
	}

}
