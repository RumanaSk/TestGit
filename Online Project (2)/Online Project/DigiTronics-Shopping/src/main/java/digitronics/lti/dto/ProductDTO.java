package digitronics.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {

	private int generatedId;
	private String name;
	private int quantity;
	private int price;
	private String content;
	private MultipartFile pro_images;
	private String categoryName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MultipartFile getPro_images() {
		return pro_images;
	}

	public void setPro_images(MultipartFile pro_images) {
		this.pro_images = pro_images;
	}

	public int getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
