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
	
	public ProductBean(int id, String productName, int price, int stock) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}
	
	public ProductBean(int id, String productName,int price,int stock,String categoryName,String supplierName) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.categoryName = categoryName;
		this.supplierName = supplierName;
	}
	
	public ProductBean(int id, String productName,int price,int stock,int categoryId,String categoryName) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public ProductBean(int id, String productName,int price,int stock,int categoryId) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.categoryId = categoryId;
	}
	
	public ProductBean() {
		
	}

	//ゲッター
	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getSupplierName() {
		return supplierName;
	}
	
	//値が入っているか確認する変数
	private boolean hasProductName = false;
	public boolean hasProductName() {
		return hasProductName;
	}
	
	private boolean hasPrice = false;
	public boolean hasPrice() {
		return hasPrice;
	}
	
	private boolean hasStock = false;
	public boolean hasStock() {
		return hasStock;
	}
	
	private boolean hasCategoryId = false;
	public boolean hasCategoryId() {
		return hasCategoryId;
	}
	
	//セッター
	public void setId(int id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
		this.hasProductName = true;
	}

	public void setPrice(int price) {
		this.price = price;
		this.hasPrice = true;
	}

	public void setStock(int stock) {
		this.stock = stock;
		this.hasStock = true;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
		this.hasCategoryId = true;
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
