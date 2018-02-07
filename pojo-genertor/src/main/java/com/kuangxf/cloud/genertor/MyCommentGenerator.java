/*
 * @(#)MyCommentGenerator.java        1.0 2018年2月7日
 *
 *
 */

package com.kuangxf.cloud.genertor;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 自定义Mybatis生成器.
 *
 * @version 1.0 2018年2月7日
 * @author kuangxf
 * @history
 * 
 */
public class MyCommentGenerator extends DefaultCommentGenerator {

	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		// 添加字段注释
		StringBuffer sb = new StringBuffer();
		field.addJavaDocLine("/**");
		if (introspectedColumn.getRemarks() != null)
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
		sb.append(" * 字段名 : ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		 sb.append('.');
		sb.append(introspectedColumn.getActualColumnName());
		field.addJavaDocLine(sb.toString());
		// addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		System.out.println("------------->test class comment");
		StringBuilder sb = new StringBuilder();

		innerClass.addJavaDocLine("/**");
		sb.append(" * 表名： "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" * 备注：");
		sb.append(introspectedTable.getRemarks());
		innerClass.addJavaDocLine(sb.toString());

		System.out.println(sb.toString());
		//addJavadocTag(innerClass, false);

		innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * 字段映射: "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append('.');
		sb.append(introspectedColumn.getActualColumnName());
		method.addJavaDocLine(sb.toString());

		method.addJavaDocLine(" *"); //$NON-NLS-1$

		sb.setLength(0);
		sb.append(" * @return  "); //$NON-NLS-1$
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());

		// addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$

		sb.append(" * 字段映射: "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append('.');
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
	}
}
