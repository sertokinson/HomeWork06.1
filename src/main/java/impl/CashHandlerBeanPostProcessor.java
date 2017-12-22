package impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CashHandlerBeanPostProcessor implements BeanPostProcessor {
    public static String FILE_NAME="C:\\Users\\Сергей\\Desktop\\JavaSchool\\Homeworks\\HomeWork_06\\new\\calculator\\cash.txt";
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;


    }
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Map<Value,Object> mapCash=new HashMap<>();
        Class<?> beanClass = bean.getClass();
        Cash annotation= beanClass.getAnnotation(Cash.class);
        if(annotation!=null) {
            if (annotation.typeCash() == TypeCash.FILE)
                try {
                    FileWriter writer = new FileWriter(FILE_NAME, false);
                        return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> CashAnnotation.cashInFile(bean, method, args, writer));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (annotation.typeCash() == TypeCash.MEMORY)
                    return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> CashAnnotation.cashingInMemory(bean, method, args, mapCash));
        }

        return bean;
    }
}
