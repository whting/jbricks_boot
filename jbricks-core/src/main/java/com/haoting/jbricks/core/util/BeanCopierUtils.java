package com.haoting.jbricks.core.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ican on 2017/2/22.
 */
public class BeanCopierUtils {

    public static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<String, BeanCopier>(32);

    /**
     * @Title: copyProperties
     * @Description: TODO(bean属性转换)
     * @param source 资源类
     * @param target 目标类
     */
    public static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }
    /*
     * 注： (1)相同属性名，且类型不匹配时候的处理，ok，但是未满足的属性不拷贝； (2)get和set方法不匹配的处理，创建拷贝的时候报错，无法拷贝任何属性(当且仅当sourceClass的get方法超过set方法时出现)
     * (3)BeanCopier 初始化例子：BeanCopier copier = BeanCopier.create(Source.class, Target.class, useConverter=true)
     * 第三个参数userConverter,是否开启Convert,默认BeanCopier只会做同名，同类型属性的copier,否则就会报错. copier =
     * BeanCopier.create(source.getClass(), target.getClass(), false); copier.copy(source, target, null);
     * (4)修复beanCopier对set方法强限制的约束 改写net.sf.cglib.beans.BeanCopier.Generator.generateClass(ClassVisitor)方法 将133行的
     * MethodInfo write = ReflectUtils.getMethodInfo(setter.getWriteMethod()); 预先存一个names2放入 109 Map names2 = new
     * HashMap(); 110 for (int i = 0; i < getters.length; ++i) { 111 names2.put(setters[i].getName(), getters[i]); }
     * 调用这行代码前判断查询下，如果没有改writeMethod则忽略掉该字段的操作，这样就可以避免异常的发生。
     */
}
