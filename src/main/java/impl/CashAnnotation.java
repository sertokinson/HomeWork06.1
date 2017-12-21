package impl;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CashAnnotation {
    public static Object annotated(Object bean,Method method,Object[] args,Map<Value,Object> mapCash) throws InvocationTargetException, IllegalAccessException {
        Value value=new Value(args[0],args[2],(Operation)args[1]);
        for (Value v: mapCash.keySet()) {
            if(v.equals(value)) {
                System.out.println("Значение из кеша:");
                return mapCash.get(v);
            }
        }
                Object result=method.invoke(bean,args);
                mapCash.put(value,result);
                System.out.println("Записали в кеш:");
                return mapCash.get(value);
    }
}
