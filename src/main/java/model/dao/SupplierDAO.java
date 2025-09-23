package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.SupplierBean;

public class SupplierDAO {

	public List<SupplierBean> allSuppliers() throws SQLException, ClassNotFoundException {

		List<SupplierBean> supplierList = new ArrayList<>();

		try (
				Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM suppliers")) {
			while (res.next()) {
				SupplierBean bean = new SupplierBean(
						res.getInt("supplier_id"),
						res.getString("supplier_name")
				);
				supplierList.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return supplierList;
	}

}