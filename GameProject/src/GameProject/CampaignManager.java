package GameProject;

public class CampaignManager implements CampaignService{

	@Override
	public void addCampaign(Campaign campaign) {
		
		System.out.println("Kampanya veritaban�na eklendi: " + campaign.getName() + " ID: " + campaign.getId() + " Kampanya Kodu: " + campaign.getCode());
		
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		
		System.out.println("Kampanya g�ncellendi." + campaign.getName() + " ID: " + campaign.getId() + " Kampanya Kodu: " + campaign.getCode());
		
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		
		System.out.println("Kampanya veritaban�ndan silindi." + campaign.getName() + " ID: " + campaign.getId() + " Kampanya Kodu: " + campaign.getCode());
		
	}

	@Override
	public void numberOfCampaignOwner(Campaign campaign) {
		
		System.out.println(campaign.getName() + "Kampanyaya kat�l�m say�s�: " + campaign.getNumberOfParticipant());
		
	}

}
