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
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		
	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

		
	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {

		
	}
}
