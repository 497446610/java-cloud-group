/*
 * @(#)StartUp.java        1.0 2018年2月7日
 *
 *
 */

package com.kuangxf.cloud.genertor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *
 * @version 1.0 2018年2月7日
 * @author kuangxf
 * @history
 * 
 */
public class StartUp {
	public static void main(String[] args) throws URISyntaxException {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new MyShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (IOException | XMLParserException | InvalidConfigurationException | SQLException
				| InterruptedException e) {
			e.printStackTrace();
		}

	}
}
