package com.taeyeon.zyx.utils;

import com.taeyeon.zyx.common.Page;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lynn on 2015/8/24.
 */
public class BeanUtil {

	protected static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	public static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

	public static void beanCopy(Object source, Object target) {
		if (null == source || null == target) {
			return;
		}

		String beanKey = generateKey(source.getClass(), target.getClass());
		BeanCopier copier = beanCopierMap.get(beanKey);

		if (null == copier) {
			copier = BeanCopier.create(source.getClass(), target.getClass(), false);
			beanCopierMap.put(beanKey, copier);
		}
		copier.copy(source, target, new DateConverterBeanCopier());
	}

	public static <T> T copy(Object source, T target) {
		if (null == source || null == target) {
			return null;
		}
		beanCopy(source, target);
		return target;
	}

	public static <T> T copy(Object source, Class<T> targetClass) {
		if (null == source || null == targetClass) {
			return null;
		}
		T target = null;
		try {
			target = targetClass.newInstance();
		} catch (InstantiationException e) {
			logger.error("bean copy InstantiationException", e);
		} catch (IllegalAccessException e) {
			logger.error("bean copy IllegalAccessException", e);
		}
		if (null == target) {
			return null;
		}
		beanCopy(source, target);
		return target;
	}

	/**
	 *
	 * @param source
	 *            src instantiation
	 * @param target
	 *            target instantiation
	 * @param mapper
	 *            在拷贝过程中需要的额外操作
	 * @param <S>
	 *            source
	 * @param <T>
	 *            target
	 * @return target
	 */
	public static <S, T> T copy(S source, T target, BiFunction<S, T, T> mapper) {
		if (null == source || null == target) {
			return null;
		}
		return mapper.apply(source, copy(source, target));

	}

	public static <T> Page<T> copyPage(Page<?> source, Class<T> cls) {
		if (null == source || null == cls) {
			return Page.emptyPage();
		}
		Page<T> page = copyPageCommon(source);
		if (source.getList() != null && !source.getList().isEmpty()) {
			page.setList(source.getList().stream().map(t -> {
				try {
					return BeanUtil.copy(t, cls.newInstance());
				} catch (Exception e) {
					return null;
				}
			}).filter(Objects::nonNull).collect(Collectors.toList()));
		} else {
			page.setList(Collections.emptyList());
		}
		return page;
	}

	/**
	 *
	 * @param source
	 *            bean Page
	 * @param cls
	 *            dto class
	 * @param mapper
	 *            在拷贝过程中需要的额外操作
	 * @param <S>
	 *            bean
	 * @param <T>
	 *            dto
	 * @return
	 */
	public static <S, T> Page<T> copyPage(Page<S> source, Class<T> cls, BiFunction<S, T, T> mapper) {
		if (null == source || null == cls) {
			return Page.emptyPage();
		}
		Page<T> page = copyPageCommon(source);
		if (source.getList() != null && !source.getList().isEmpty()) {
			page.setList(source.getList().stream().map(bean -> {
				try {
					return mapper.apply(bean, BeanUtil.copy(bean, cls.newInstance()));
				} catch (Exception e) {
					return null;
				}
			}).filter(Objects::nonNull).collect(Collectors.toList()));
		} else {
			page.setList(Collections.emptyList());
		}
		return page;
	}

    /**
     *
     * @param source 源对象
     * @param mapper 源个体对象转成目标个体对象的操作
     * @param <S> 源个体类型
     * @param <T> 目标个体类型
     * @return
     */
    public static <S, T> Page<T> copyPage(Page<S> source, Function<S, T> mapper) {
        if (null == source) {
            return Page.emptyPage();
        }
        Page<T> page = copyPageCommon(source);
        if (source.getList() != null && !source.getList().isEmpty()) {
            page.setList(source.getList().stream().map(mapper).filter(Objects::nonNull).collect(Collectors.toList()));
        } else {
            page.setList(Collections.emptyList());
        }
        return page;
    }

	public static <T> Page<T> copyPageCommon(Page<?> src) {
		if (src == null) {
			return Page.emptyPage();
		}
		Page<T> page = new Page<>();
		page.setTotal(src.getTotal());
		page.setPageNo(src.getPageNo());
		page.setPageSize(src.getPageSize());
		page.setOrderBy(src.getOrderBy());
		page.setFuncName(src.getFuncName());
		page.setFuncParam(src.getFuncParam());
		page.setLastPage(src.isLastPage());
		page.setFirstPage(src.isFirstPage());
		return page;
	}

	public static <T> List<T> copyList(List<?> source, Class<T> cls) {
		if (source == null || source.isEmpty()) {
			return Collections.emptyList();
		}
		return source.stream().map(t -> {
			try {
				return BeanUtil.copy(t, cls.newInstance());
			} catch (Exception e) {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	public static <S, T> List<T> copyList(List<S> source, Class<T> cls, BiFunction<S, T, T> mapper) {
		if (source == null || source.isEmpty()) {
			return Collections.emptyList();
		}
		return source.stream().map(t -> {
			try {
				return BeanUtil.copy(t, cls.newInstance(), mapper);
			} catch (Exception e) {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

    /**
     *
     * @param source 源对象
     * @param mapper 源个体对象转成目标个体对象的操作
     * @param <S> 源个体类型
     * @param <T> 目标个体类型
     * @return
     */
    public static <S, T> List<T> copyList(List<S> source, Function<S, T> mapper) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().map(mapper).filter(Objects::nonNull).collect(Collectors.toList());
    }
    
	private static String generateKey(Class<?> class1, Class<?> class2) {
		return class1.toString() + class2.toString();
	}

	public static Map<String, Object> transBean2Map(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			Map<String, Object> proMap = null;
			List<Map<String, Object>> beanMapList = null;
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (key.equals("class") || key.equals("page") || key.equals("html")) {
					continue;
				}
				// 得到property对应的getter方法
				Method getter = property.getReadMethod();
				if (getter == null) {
					continue;
				}
				Object value = getter.invoke(obj);
				if (value == null) {
					continue;
				}
				if (value instanceof String) {
					if (StringUtils.isNotBlank(value.toString())) {
						map.put(key, value);
					}
				} else if (isBaseDataType(value.getClass())) { // 基本类型
					map.put(key, value);
				} else if (value.getClass().isArray()) { // 数组
					// Object arrayList =
					// Array.newInstance(value.getClass().getComponentType(),
					// Array.getLength(value));
					// for(int index = 0; index <
					// Array.getLength(value); index ++){
					// Array.set(arrayList, index,
					// transBean2Map(Array.get(value, index)));
					// }
				} else if (value instanceof Collection) {
					beanMapList = new ArrayList<Map<String, Object>>();
					Iterator iter = ((Collection) value).iterator();
					while (iter.hasNext()) {
						beanMapList.add(transBean2Map(iter.next()));
					}
					map.put(key, beanMapList);
				} else { // 对象类型
					proMap = transBean2Map(value);
					map.put(key, proMap);
				}
			}
		} catch (Exception e) {
			logger.error("transBean2Map err.", e);
		}
		return map;
	}

	/**
	 * 判断一个类是否为基本数据类型。
	 *
	 * @param clazz
	 *            要判断的类。
	 * @return true 表示为基本数据类型。
	 */
	public static boolean isBaseDataType(Class clazz) {
		return (clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Byte.class)
				|| clazz.equals(Long.class) || clazz.equals(Double.class) || clazz.equals(Float.class)
				|| clazz.equals(Character.class) || clazz.equals(Short.class) || clazz.equals(BigDecimal.class)
				|| clazz.equals(BigInteger.class) || clazz.equals(Boolean.class) || clazz.equals(Date.class)
				|| clazz.equals(DateTime.class) || clazz.isPrimitive());
	}
}
