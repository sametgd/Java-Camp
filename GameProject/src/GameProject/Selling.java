package GameProject;

public class Selling extends SellingManager{
	
	private String campaignCode;
	private double price;
	private int discount;
	private double discountedPrice;
	
	public Selling() {
		// TODO Auto-generated constructor stub
	}

	public Selling(String campaignCode, double price, int discount, double discountedPrice) {
		super();
		this.campaignCode = campaignCode;
		this.price = price;
		this.discount = discount;
		this.discountedPrice = discountedPrice;
	}

	public String getCampaignCode() {
		return campaignCode;
	}

	public void setCampaignCode(String campaignCode) {
		this.campaignCode = campaignCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getDiscountedPrice() {
		return discountedPrice = price - price*discount / 100;
	}
	
}
