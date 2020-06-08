package proj.java.user.model;
public class Medicine {
	protected int med_id;
    protected String med_name;
    protected String category;
    protected int price;
    protected String exp_date;
    
	public Medicine(int med_id, String med_name, String category, int price, String date) {
		super();
		this.med_id = med_id;
		this.med_name = med_name;
		this.category = category;
		this.price = price;
		this.exp_date = date;
	}	
	public Medicine(String med_name, String category, int price, String date) {
		super();
		this.med_name = med_name;
		this.category = category;
		this.price = price;
		this.exp_date = date;
	}
	public int getMed_id() {
		return med_id;
	}
	public void setMed_id(int med_id) {
		this.med_id = med_id;
	}
	public String getMed_name() {
		return med_name;
	}
	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return exp_date;
	}
	public void setDate(String exp_date) {
		this.exp_date = exp_date;
	}
    
    
}
