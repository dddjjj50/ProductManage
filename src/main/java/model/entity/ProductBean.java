package model.entity;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private int id;
	private String productName;
	private int price;
	private int stock;
	private int categoryId;
	private int supplierId;



	public ProductBean(int id, String productName,int price,int stock,int categoryId,int supplierId) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.categoryId = categoryId;
		this.supplierId = supplierId;

		
	}

	//ゲッター
	public int getId() { return id; }
	public String getProductName() { return productName; }
	public int getPrice() { return price; }
	public int getStock() { return stock; }
	public int getCategoryId() { return categoryId; }
	public int getSupplierId() { return supplierId; }



	//セッター
	public void setId(int id) {
		this.id = id;
	}
    public void setProductName(String productName) {
    	this.productName = productName;
    }
    public void setPrice(int price) {
		this.price = price;
	}
    public void setStock(int stock) {
		this.stock = stock;
	}
    public void setCategoryId(int categoryId) {
    	this.categoryId = categoryId;
    }
    public void setSupplierId(int supplierId) {
    	this.supplierId = supplierId;
    }


}
