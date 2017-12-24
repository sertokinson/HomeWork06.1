package impl;

import org.springframework.util.ReflectionUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class CashAnnotation {
    public static Object cashingInMemory(Object bean, Method method, Object[] args, Map<Value, Object> mapCash) throws InvocationTargetException, IllegalAccessException {
        Value value = new Value(args[0], args[2], (Operation) args[1]);
        for (Value v : mapCash.keySet()) {
            if (v.equals(value)) {
                System.out.println("Значение из кеша:");
                return mapCash.get(v);
            }
        }
        Object result = method.invoke(bean, args);
        mapCash.put(value, result);
        System.out.println("Записали в кеш:");
        return result;
    }
    public static Object cashInFile(Object bean, Method method, Object[] args,ObjectOutputStream oos) throws InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException {
        Value value = new Value(args[0], args[2], (Operation) args[1],args[0]);
        FileInputStream fis = new FileInputStream(CashHandlerBeanPostProcessor.FILE_NAME);
        ObjectInputStream oin= new ObjectInputStream(fis);
        oos.writeObject(value);
        oos.flush();
        Value ts = (Value) oin.readObject();
        System.out.println("version="+ts.result);
        Object result = method.invoke(bean, args);
        return result;
    }
}
