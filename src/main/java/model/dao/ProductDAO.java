package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.ProductBean;

public class ProductDAO {
	
	//===================================
	//全てのproductを表示する
	//===================================
	public List<ProductBean> choiceAllCategories() throws SQLException, ClassNotFoundException {
		
		List<ProductBean> list = new ArrayList<>();
		
		try(
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM products");
				ResultSet res = pst.executeQuery()
		){
			while(res.next()) {
				ProductBean bean = new ProductBean(
						res.getInt("id"),
						res.getString("name"),
						res.getInt("price"),
						res.getInt("stock")
				);
				list.add(bean);
			}
		}
		return list;
	}
	
	//===================================
	//選択したカテゴリのproductを表示する
	//===================================
	public List<ProductBean> choiceCategories(int categoryId) throws SQLException, ClassNotFoundException {

		List<ProductBean> choiceCategoriesList = new ArrayList<>();

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"SELECT * FROM products WHERE category_id = ?")
		){
			pst.setInt(1, categoryId);
			ResultSet res = pst.executeQuery();
			
			while (res.next()) {
				ProductBean bean = new ProductBean(
					res.getInt("id"),
					res.getString("name"),
					res.getInt("price"),
					res.getInt("stock")
				);
				choiceCategoriesList.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return choiceCategoriesList;
	}
	
	//===================================
	//新しいproductを登録する
	//===================================
	
	public void addProduct(ProductBean product) throws SQLException, ClassNotFoundException {
		
		try(
				Connection con  = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO products (name,price,stock,category_id,supplier_id) VALUES (?,?,?,?,?)")
		){
			pst.setString(1,product. getProductName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getStock());
			pst.setInt(4, product.getCategoryId());
			pst.setInt(5, product.getSupplierId());
			
			pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//============================================
	//week17:削除確認ページにとぶためのメソッド
	//============================================
	
	public ProductBean ProductInfoById(int id) throws SQLException, ClassNotFoundException {

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"SELECT id,name,price,stock FROM products WHERE id = ?"
						)
		){
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			
			if (res.next()) {
				ProductBean bean = new ProductBean(
					res.getInt("id"),
					res.getString("name"),
					res.getInt("price"),
					res.getInt("stock")
				);
				return bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//===================================
	//week17:ボタンを押した商品を削除する
	//===================================
	
	public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
		
		try(
				Connection con  = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"DELETE FROM products WHERE id = ?")
		){
			pst.setInt(1, id);
			int result = pst.executeUpdate();
			
			//IDが存在しない場合
			if(result == 0) {
				throw new SQLException("商品情報を取得できませんでした");
			}
		} //例外はサーブレットで処理する
		
	}
}