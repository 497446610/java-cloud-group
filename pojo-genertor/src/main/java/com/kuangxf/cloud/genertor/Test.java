/*
 * @(#)Test.java        1.0 2018年2月7日
 *
 *
 */

package com.kuangxf.cloud.genertor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.JDBCConnectionFactory;

/**
 * Class description goes here.
 *
 * @version 1.0 2018年2月7日
 * @author Administrator
 * @history
 * 
 */
public class Test {

	public static void main(String[] args) {
		try {
			JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
			jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://192.168.0.154/test");
			jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
			jdbcConnectionConfiguration.setUserId("kxf");
			jdbcConnectionConfiguration.setPassword("123456");
			Connection connection = new JDBCConnectionFactory(jdbcConnectionConfiguration).getConnection();
			PreparedStatement ps = connection.prepareStatement("show table status where name=?");
			ps.setString(1, "member");
			ResultSet rs = ps.executeQuery();
			/*ResultSet rs = connection.getMetaData().getTables(null,
					null, null, new String[]{"TABLE"});*/
			if (null != rs && rs.next()) {
				String comment = rs.getString("Comment");
				System.out.println("----------->" + comment);
				/*String remarks = rs.getString("REMARKS");
				System.out.println(remarks);*/
			}

			closeConnection(connection, rs);
		} catch (SQLException var8) {
			;
		}
	}

	private static void closeConnection(Connection connection, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException var5) {
				;
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException var4) {
				;
			}
		}

	}

}
