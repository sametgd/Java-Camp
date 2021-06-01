package GameProject;

public class Main {

	public static void main(String[] args) {
		
		Campaign campaign1 = new Campaign();
		campaign1.setId(1);
		campaign1.setName("Arkadaþ Daveti");
		campaign1.setCode("letsBattle");
		campaign1.setDiscountAmount(10);
		
		campaign1.addCampaign(campaign1);
		
		Campaign campaign2 = new Campaign();
		campaign2.setId(2);
		campaign2.setName("Welcome2021");
		campaign2.setCode("2020goHOME");
		campaign2.setDiscountAmount(50);
		
		campaign2.addCampaign(campaign2);
		
		System.out.println("**********************************************************************");
		
		Gamer gamer1 = new Gamer();
		gamer1.setId(1);
		gamer1.setFirstName("Samet");
		gamer1.setLastName("Göde");
		gamer1.setUserName("samet.354546");
		gamer1.setEmail("sametgd34@yahoo.com");
		gamer1.setPassword("20_sg_21");
		
		gamer1.checkAccount(gamer1);
		
		gamer1.addAccount(gamer1);
		
		Gamer gamer2 = new Gamer();
		gamer2.setId(2);
		gamer2.setFirstName("Þevket");
		gamer2.setLastName("Göde");
		gamer2.setUserName("þg46");
		gamer2.setEmail("sevketGode@gmail.com");
		gamer2.setPassword("þG59724565");
		
		gamer2.checkAccount(gamer2);
		
		gamer2.addAccount(gamer2);
		
		System.out.println("**********************************************************************");
		
		Selling sell = new Selling();
		sell.setCampaignCode(campaign2.getCode());
		sell.setDiscount(campaign2.getDiscountAmount());
		sell.setPrice(200);
		
		sell.sell(gamer1);
		
		Selling sell2 = new Selling();
		sell2.setCampaignCode(campaign1.getCode());
		sell2.setDiscount(campaign1.getDiscountAmount());
		sell2.setPrice(200);
		
		sell2.sell(gamer2);
		
		
		
		}
	}


