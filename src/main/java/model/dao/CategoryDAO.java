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

	//=====================
	//Week11 登録機能の追加
	//=====================

	public void addCategory(int id,String categoryName) throws SQLException, ClassNotFoundException {

		try (
				Connection con = ConnectionManager.getConnection();
				java.sql.PreparedStatement pst =con.prepareStatement(
						"INSERT INTO categories (id,category_name) VALUES (?,?)"
		)){
			//プレースホルダに値をセット
			pst.setInt(1, id);
			pst.setString(2, categoryName);

			//SQL実行
			int result = pst.executeUpdate();

			//結果を振り分け
			if (result>0) {
				System.out.println("登録成功☆");
				System.out.printf("登録内容： id = %2d , category_name = %s\n",id,categoryName);
			}else {
				System.out.println("登録失敗…△");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	//========================================================
	//カテゴリ登録の際、既にあるデータとかぶってないかチェック
	//========================================================

	public boolean checkInput(int inputId) throws SQLException,ClassNotFoundException {

		List<CategoryBean> categories = allCategories();
		for(CategoryBean bean: categories) {
			if(bean.getId() == inputId) {
				return true;
			}
		}
		return false;
	}

	public boolean checkInputCategoryName(String inputCategoryName)throws SQLException,ClassNotFoundException {
		List<CategoryBean> categories = allCategories();
		for(CategoryBean bean: categories) {
			if(bean.getCategoryName().equals(inputCategoryName)) {
				return true;
			}
		}
		return false;
	}
	
}