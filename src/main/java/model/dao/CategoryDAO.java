package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {

	public List<CategoryBean> allCategories() throws SQLException, ClassNotFoundException {

		List<CategoryBean> categoriesList = new ArrayList<>();

		try (
				Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM categories")) {
			while (res.next()) {
				CategoryBean bean = new CategoryBean(
						res.getInt("id"),
						res.getString("category_name"));
				bean.setId(res.getInt("id"));
				bean.setCategoryName(res.getString("category_name"));
				categoriesList.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categoriesList;
	}
}