package ai.advance.thinking.in.spring.ioc.overview.dependency.lookup;

import ai.advance.thinking.in.spring.ioc.overview.annotation.Super;
import ai.advance.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xy
 * @version 1.0
 * @className DependencyLookupDemo
 * @description 1. 通过名称查找
 * 2. 通过类型查找
 * @date 2020/4/26 22:56
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置xml文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);
        // 按照类型查找
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        // 通过注解查找
        lookupByAnnotationType(beanFactory);

    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到的标注@Super 集合对象" + beansWithAnnotation);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有Users 集合对象" + users);
        }

    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时通过类型查找:" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找:" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找:" + user);
    }
}
