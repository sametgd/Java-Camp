package GameProject;

public class CampaignManager implements CampaignService{

	@Override
	public void addCampaign(Campaign campaign) {
		
		System.out.println("Kampanya veritabanýna eklendi: " + campaign.getName() + " ID: " + campaign.getId() + " Kampanya Kodu: " + campaign.getCode());
		
	}

	@Override
	public void updateCampaign(Campaign campaign) {
		
		System.out.println("Kampanya güncellendi." + campaign.getName() + " ID: " + campaign.getId() + " Kampanya Kodu: " + campaign.getCode());
		
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		
		System.out.println("Kampanya veritabanýndan silindi." + campaign.getName() + " ID: " + campaign.getId() + " Kampanya Kodu: " + campaign.getCode());
		
	}

	@Override
	public void numberOfCampaignOwner(Campaign campaign) {
		
		System.out.println(campaign.getName() + "Kampanyaya katýlým sayýsý: " + campaign.getNumberOfParticipant());
		
	}

}
