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

		this.externalServiceSignIn.addWithExternalService(" Kayýt baþarýlý. Hoþgeldiniz. " + customer.getFirstName() + " " + customer.getLastName() + " :)");
		return;

	}

	@Override
	public void add(Customer customer) {

		if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2) {
			System.out.println("Ýsminiz veya soyisminiz 2 harften fazla olmalýdýr. Lütfen kontrol ediniz.");
			return;
		} else {
			checked = true;
		}

		if (!validateEmail(customer.getEmail())) {
			System.out.println("Yanlýþ E-Mail adresi girdiniz. Lütfen kontrol ediniz.");
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
			System.out.println("Þifre en az 6, en fazla 10 haneli olmalýdýr.");
			return;
		} else {
			checked = true;
		}

		this.verificationService.sendVerification(customer);

		this.verificationService.verified(customer);

		checked = true;

		if (checked == true) {

			customerDao.getAll().add(customer);

			System.out.println("Kayýt baþarýlý. Hoþgeldiniz. " + customer.getFirstName() + " " + customer.getLastName() + " :) ");
		} else {
			System.out.println("Bir þeyler ters gitti. Lütfen tekrar deneyiniz. ");
		}

	}

	@Override
	public void login(Customer customer) {

		if (!validateEmail(customer.getEmail())) {
			System.out.println("Yanlýþ E-Mail adresi girdiniz. Lütfen kontrol ediniz.");
			return;
		} else {
			checked = true;
		}

		if (customer.getPassword().length() > 6 && customer.getPassword().length() < 10) {
			System.out.println("Þifre en az 6, en fazla 10 haneli olmalýdýr.");
			return;
		} else {
			checked = true;
		}

		if (checked == true) {
			for (int i = 0; i < customerDao.getAll().toArray().length; i++) {
				if (customerDao.getAll().get(i).getEmail() == customer.getEmail()
						&& customerDao.getAll().get(i).getPassword() == customer.getPassword()) {
					System.out.println("E-posta ve þifre doðru. Hoþgeldiniz. " + customer.getFirstName() + " " + customer.getLastName() + " :)");
				} else {
					System.out.println("E-posta veya þifre hatalý. Lütfen kontol ediniz.");
				}
			}

		}

	}

	@Override
	public void update(Customer customer) {
		
		customerDao.update(customer);
		
		System.out.println("Bilgileriniz güncellendi; " + customer.getFirstName() + " " + customer.getLastName());
		
	}

	@Override
	public void delete(Customer customer) {
		
		customerDao.delete(customer);
		
		System.out.println("Hesabýnýz silindi; " + customer.getFirstName() + " " + customer.getLastName() + " Sizi kaybettiðimiz için üzgünüz. Lütfen bize nedenini söyleyin.");
		
	}

}
