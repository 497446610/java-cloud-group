/*
 * @(#)CommentPlugin.java        1.0 2018年2月7日
 *
 *
 */

package com.kuangxf.cloud.genertor.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.internal.JDBCConnectionFactory;

/**
 * 备注插件.
 *
 * @version 1.0 2018年2月7日
 * @author kuangxf
 * @history
 * 
 */
public class CommentPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType) {

		// 添加字段注释
		StringBuffer sb = new StringBuffer();
		field.addJavaDocLine("/**");
		if (introspectedColumn.getRemarks() != null)
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks() + "<br/>");
		sb.append(" * 字段名 : ");
		sb.append(introspectedColumn.getActualColumnName());
		field.addJavaDocLine(sb.toString());
		// addJavadocTag(field, false);
		field.addJavaDocLine(" */");
		return true;
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
			Plugin.ModelClassType modelClassType) {
		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * 字段映射: "); //$NON-NLS-1$
		sb.append(introspectedColumn.getActualColumnName());
		method.addJavaDocLine(sb.toString());

		method.addJavaDocLine(" *"); //$NON-NLS-1$

		sb.setLength(0);
		sb.append(" * @return  "); //$NON-NLS-1$
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
		return true;
	}

	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
			Plugin.ModelClassType modelClassType) {
		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * 字段映射: "); //$NON-NLS-1$
		sb.append(introspectedColumn.getActualColumnName());
		method.addJavaDocLine(sb.toString());

		method.addJavaDocLine(" *"); //$NON-NLS-1$

		Parameter parm = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param "); //$NON-NLS-1$
		sb.append(parm.getName());
		sb.append("  "); //$NON-NLS-1$
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		addModelClassComment(topLevelClass, introspectedTable);
		return true;
	}

	private void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String remarks = "";
		String author = this.getProperties().getProperty("author");
		if (null == author || "".equals(author)) {
			author = System.getProperty("user.name");
		}

		FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();

		try {
			JDBCConnectionConfiguration jdbcConnectionConfiguration = this.context.getJdbcConnectionConfiguration();
			Connection connection = new JDBCConnectionFactory(jdbcConnectionConfiguration).getConnection();
			/*
			 * ResultSet rs =
			 * connection.getMetaData().getTables(table.getIntrospectedCatalog(),
			 * table.getIntrospectedSchema(), table.getIntrospectedTableName(), (String[])
			 * null);
			 */

			PreparedStatement ps = connection.prepareStatement("show table status where name=?");
			ps.setString(1, table.getIntrospectedTableName());
			ResultSet rs = ps.executeQuery();

			if (null != rs && rs.next()) {
				remarks = rs.getString("Comment");
				if (remarks != null && remarks.length() > 0) {
					remarks = remarks + " <br/>";
				}
			}

			this.closeConnection(connection, rs);
		} catch (SQLException var8) {
			;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		topLevelClass.addJavaDocLine("/**");
		topLevelClass.addJavaDocLine(" * " + remarks);
		topLevelClass.addJavaDocLine(" * table: " + introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(" * @author " + author);
		topLevelClass.addJavaDocLine(" * @date " + format.format(new Date()));
		topLevelClass.addJavaDocLine(" *");
		topLevelClass.addJavaDocLine(" */");
	}

	private void closeConnection(Connection connection, ResultSet rs) {
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
