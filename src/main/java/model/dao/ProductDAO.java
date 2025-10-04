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

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM products");
				ResultSet res = pst.executeQuery()) {
			while (res.next()) {
				ProductBean bean = new ProductBean(
						res.getInt("id"),
						res.getString("name"),
						res.getInt("price"),
						res.getInt("stock"));
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
						"SELECT * FROM products WHERE category_id = ?")) {
			pst.setInt(1, categoryId);
			ResultSet res = pst.executeQuery();

			while (res.next()) {
				ProductBean bean = new ProductBean(
						res.getInt("id"),
						res.getString("name"),
						res.getInt("price"),
						res.getInt("stock"));
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

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO products (name,price,stock,category_id,supplier_id) VALUES (?,?,?,?,?)")) {
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getStock());
			pst.setInt(4, product.getCategoryId());
			pst.setInt(5, product.getSupplierId());

			pst.executeUpdate();
		} catch (Exception e) {
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
						"SELECT id,name,price,stock FROM products WHERE id = ?")) {
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();

			if (res.next()) {
				ProductBean bean = new ProductBean(
						res.getInt("id"),
						res.getString("name"),
						res.getInt("price"),
						res.getInt("stock"));
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

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"DELETE FROM products WHERE id = ?")) {
			pst.setInt(1, id);
			int result = pst.executeUpdate();

			//IDが存在しない場合
			if (result == 0) {
				throw new SQLException("商品情報を取得できませんでした");
			}
		} //例外はサーブレットで処理する

	}

	//=======================================
	//week18:idを受け取って編集ページに飛ぶ
	//=======================================

	public ProductBean ProductInfoById_edit(int id) throws SQLException, ClassNotFoundException {

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"SELECT products.id AS product_id," +
								"products.name," +
								"products.price," +
								"products.stock," +
								"categories.id AS categoryId," +
								"categories.category_name " +
								"FROM products JOIN categories ON products.category_id = categories.id " +
								"WHERE products.id = ?")) {
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();

			if (res.next()) {
				ProductBean bean = new ProductBean(
						res.getInt("product_id"),
						res.getString("name"),
						res.getInt("price"),
						res.getInt("stock"),
						res.getInt("categoryId"),
						res.getString("category_name"));
				return bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	//===================================
	//week17:ボタンを押した商品を編集する
	//===================================

	public void EditProduct(ProductBean bean) throws SQLException, ClassNotFoundException {

		int id = bean.getId();
		PreparedStatement pst;
		int resultProductName = -1;
		int resultPrice = -1;
		int resultStock = -1;
		int resultCategoryId = -1;
		
		
		try (Connection con = ConnectionManager.getConnection();) {
			
			//■商品名
			if (bean.hasProductName()) {
				pst = con.prepareStatement(
						"UPDATE products SET name = ? WHERE products.id = ?");
				pst.setString(1, bean.getProductName());
				pst.setInt(2, id);
				resultProductName = pst.executeUpdate();
			}

			//■価格
			if (bean.hasPrice()) {
				pst = con.prepareStatement(
						"UPDATE products SET price = ? WHERE products.id = ?");
				pst.setInt(1, bean.getPrice());
				pst.setInt(2, id);
				resultPrice = pst.executeUpdate();
			}

			//■在庫数
			if (bean.hasStock()) {
				pst = con.prepareStatement(
						"UPDATE products SET stock = ? WHERE products.id = ?");
				pst.setInt(1, bean.getStock());
				pst.setInt(2, id);
				resultStock = pst.executeUpdate();
			}

			//■カテゴリ
			if (bean.hasCategoryId()) {
				pst = con.prepareStatement(
						"UPDATE products SET category_id = ? WHERE products.id = ?");
				pst.setInt(1, bean.getCategoryId());
				pst.setInt(2, id);
				resultCategoryId = pst.executeUpdate();
			}

			//IDが存在しない場合
			if (
					resultProductName == 0
					|| resultPrice == 0
					|| resultStock == 0
					|| resultCategoryId == 0
			) {
				throw new SQLException("商品情報を取得できませんでした");
			}
		} //例外はサーブレットで処理する

	}

}