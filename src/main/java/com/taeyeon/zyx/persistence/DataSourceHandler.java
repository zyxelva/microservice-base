package com.taeyeon.zyx.persistence;

public class DataSourceHandler {
	public final static String MASTER = "master"; // 主库(写)
	public final static String SLAVE = "slave"; // 从库(读)
	// public static String DYNAMIC_DATA_SOURCE_USERDEFINE;// 用户外部定义的

	private static final ThreadLocal<String> dataSourceThreadLocal = new ThreadLocal<String>();

	protected static void set(String dynamic_data_source) {
		dataSourceThreadLocal.set(dynamic_data_source);
	}

	/**
	 * 设置为主库
	 * 
	 * @author bod
	 */
	public static void setMaster() {
		dataSourceThreadLocal.set(MASTER);
	}

	/**
	 * 设置为读库
	 * 
	 * @author bod
	 */
	public static void setSlave() {
		dataSourceThreadLocal.set(SLAVE);
	}

	/**
	 * 判断是否为主库
	 * 
	 * @author bod
	 */
	public static boolean isMaster() {
		return isThis(MASTER);
	}

	/**
	 * 判断是否为从
	 * 
	 * @author bod
	 */
	public static boolean isSlave() {
		return isThis(SLAVE);
	}

	public static boolean isUserDefine() {
		if (dataSourceThreadLocal.get() == null) {
			return false;
		}
		if (!isMaster() && !isSlave()) { // 既不是主也不是从，那就可以肯定是用户自定义了
			return true;
		}
		return false;
	}

	public static boolean isThis(String dynamic_data_source) {
		if (dataSourceThreadLocal.get() == null) {
			return false;
		}
		return dynamic_data_source.equals(dataSourceThreadLocal.get());
	}

	public static void DataSoruceClean() {
		dataSourceThreadLocal.remove();
	}

	public static void setUserDefineDataSource(String userDefineDataSourceName) {
		dataSourceThreadLocal.set(userDefineDataSourceName);
	}

	/**
	 * 返回用户自定义的DataSourceName
	 * 
	 * @return
	 */
	public static String getUserDefineName() {
		return dataSourceThreadLocal.get();
	}

}
