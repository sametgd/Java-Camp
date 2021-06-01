package GameProject;

public class Campaign extends CampaignManager{
	
	private int id;
	private String name;
	private String code;
	private int discountAmount;
	private int numberOfParticipant;
	
	public Campaign() {
		
	}
	
	public Campaign(int id, String name, String code, int numberOfParticipant) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.numberOfParticipant = numberOfParticipant;
	}

	public Campaign(int discountAmount) {
		super();
		this.discountAmount = discountAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getNumberOfParticipant() {
		return numberOfParticipant;
	}

	public void setNumberOfParticipant(int numberOfParticipant) {
		this.numberOfParticipant = numberOfParticipant;
	}
	
}
