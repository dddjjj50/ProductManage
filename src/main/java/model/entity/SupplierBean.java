package model.entity;

import java.io.Serializable;

public class SupplierBean implements Serializable {

	private int id;
	private String supplier_name;

	public SupplierBean(int id, String supplier_name) {
		this.id = id;
		this.supplier_name = supplier_name;
	}

	//ゲッター
	public int getId() { return id; }
	public String getSupplierName() { return supplier_name; }

	//セッター
	public void setId(int id) {
		this.id = id;
	}
    public void setSupplierName(String supplier_name) {
    	this.supplier_name = supplier_name;
    }

}
