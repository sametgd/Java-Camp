package GameProject;

public class GamerManager implements GamerAccountService, GamerCheckService{

	@Override
	public void checkAccount(Gamer gamer) {
		
		System.out.println("Mernis doðrulamasý baþarýlý.");
		
	}

	@Override
	public void addAccount(Gamer gamer) {
		
		System.out.println("Kullanýcý veritabanýna eklendi. " + " Ýsim: " + gamer.getFirstName() + " Soyisim: " + gamer.getLastName() + " ID: " + gamer.getId());
		
	}

	@Override
	public void updateAccount(Gamer gamer) {
		
		System.out.println("Kullanýcý gücellendi. " + " Ýsim: " + gamer.getFirstName() + " Soyisim: " + gamer.getLastName() + " ID: " + gamer.getId());
		
	}

	@Override
	public void deleteAccount(Gamer gamer) {
		
		System.out.println("Kullanýcý veritabanýndan silindi. " + " Ýsim: " + gamer.getFirstName() + " Soyisim: " + gamer.getLastName() + " ID: " + gamer.getId());
		
	}
	
	
	
}
