package GameProject;

public class GamerManager implements GamerAccountService, GamerCheckService{

	@Override
	public void checkAccount(Gamer gamer) {
		
		System.out.println("Mernis do�rulamas� ba�ar�l�.");
		
	}

	@Override
	public void addAccount(Gamer gamer) {
		
		System.out.println("Kullan�c� veritaban�na eklendi. " + " �sim: " + gamer.getFirstName() + " Soyisim: " + gamer.getLastName() + " ID: " + gamer.getId());
		
	}

	@Override
	public void updateAccount(Gamer gamer) {
		
		System.out.println("Kullan�c� g�cellendi. " + " �sim: " + gamer.getFirstName() + " Soyisim: " + gamer.getLastName() + " ID: " + gamer.getId());
		
	}

	@Override
	public void deleteAccount(Gamer gamer) {
		
		System.out.println("Kullan�c� veritaban�ndan silindi. " + " �sim: " + gamer.getFirstName() + " Soyisim: " + gamer.getLastName() + " ID: " + gamer.getId());
		
	}
	
	
	
}
