package impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;


    }
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Map<Value,Object> mapCash=new HashMap<>();
        Class<?> beanClass = bean.getClass();
        if(beanClass!=null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return CashAnnotation.annotated(bean,method,args,mapCash);
                }
            });
        }
        return bean;
    }
}
