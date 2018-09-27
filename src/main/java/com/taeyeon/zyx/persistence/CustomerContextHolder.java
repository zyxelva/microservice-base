package com.taeyeon.zyx.persistence;

public class CustomerContextHolder {
	public final static String SESSION_FACTORY_MASTER = "master";
	public final static String SESSION_FACTORY_SLAVE = "slave";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setContextType(String contextType) {
		contextHolder.set(contextType);
	}

	public static String getContextType() {
		return contextHolder.get();
	}

	public static void clearContextType() {
		contextHolder.remove();
	}
}
