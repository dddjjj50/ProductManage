package model.entity;

import java.io.Serializable;

public class ProductBean implements Serializable {
	
	private int id;
	private String productName;
	private int price;
	private int stock;
	private int categoryId;
	private int supplierId;
	private String categoryName;
	private String supplierName;

	public ProductBean(int id, String productName,int price,int stock) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}

	//ゲッター
	public int getId() { return id; }
	public String getProductName() { return productName; }
	public int getPrice() { return price; }
	public int getStock() { return stock; }
	public int getCategoryId() { return categoryId; }
	public int getSupplierId() { return supplierId; }
	
	public String getCategoryName() { return categoryName; }
	public String getSupplierName() { return supplierName; }

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
    public void setCategoryName(String categoryName) {
    	this.categoryName = categoryName;
    }
    public void setSupplierName(String supplierName) {
    	this.supplierName = supplierName;
    }

}
