package model.entity;

import java.io.Serializable;

public class CategoryBean implements Serializable {
	private int id;
	private String category_name;

	public CategoryBean(int id, String category_name) {
		this.id = id;
		this.category_name = category_name;
	}

	//ゲッター
	public int getId() { return id; }
	public String getCategoryName() { return category_name; }

	//セッター
	public void setId(int id) {
		this.id = id;
	}
    public void setCategoryName(String category_name) {
    	this.category_name = category_name;
    }


}
