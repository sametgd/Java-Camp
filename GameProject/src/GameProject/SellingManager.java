package GameProject;

public class SellingManager implements SellingService{

	@Override
	public void sell(Gamer gamer) {
		
		System.out.println("Tebrikler, "  + gamer.getUserName() + "." + " Sat�n alma i�lemi tamamland�.");
		
	}

}
