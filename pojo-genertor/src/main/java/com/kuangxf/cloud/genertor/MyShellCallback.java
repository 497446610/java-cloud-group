/*
 * @(#)MyShellCallBack.java        1.0 2018年2月7日
 *
 *
 */

package com.kuangxf.cloud.genertor;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.File;
import java.util.StringTokenizer;

import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Class description goes here.
 *
 * @version 1.0 2018年2月7日
 * @author kuangxf
 * @history
 * 
 */
public class MyShellCallback extends DefaultShellCallback {
	/**
	 * @param overwrite
	 */
	public MyShellCallback(boolean overwrite) {
		super(overwrite);

	}

	@Override
	public File getDirectory(String targetProject, String targetPackage) throws ShellException {
		File project = new File(targetProject);
		if (!project.isDirectory()) {// 非全目录则认为配置的是工程名称
			String path = this.getClass().getResource("/").getPath();
			int index = path.indexOf(targetProject);
			path = path.substring(0, index);
			path = path + targetProject + "/src/main/";
			project = new File(path);
		}

		if (!project.isDirectory()) {
			throw new ShellException(getString("Warning.9", //$NON-NLS-1$
					targetProject));
		}

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(targetPackage, "."); //$NON-NLS-1$
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
			sb.append(File.separatorChar);
		}

		File directory = new File(project, sb.toString());
		if (!directory.isDirectory()) {
			boolean rc = directory.mkdirs();
			if (!rc) {
				throw new ShellException(getString("Warning.10", //$NON-NLS-1$
						directory.getAbsolutePath()));
			}
		}

		return directory;
	}

}
