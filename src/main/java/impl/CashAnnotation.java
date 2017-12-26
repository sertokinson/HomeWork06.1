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
    public static Object cashInFile(Object bean, Method method, Object[] args, DataOutputStream oos) throws InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException {
        DataInputStream dis=new DataInputStream(new FileInputStream(CashHandlerBeanPostProcessor.FILE_NAME));
        String s=args[0]+" "+args[1]+" "+args[2];
        while (dis.available()>0){
            String s2=dis.readUTF();
            Integer resultInt=null;
            Double resultDouble = null;
            if(dis.readBoolean())
                resultInt=dis.readInt();
            else resultDouble=dis.readDouble();
            if(s.equals(s2)){
                System.out.println("Взяли из кеша:");
                if(resultInt!=null)
                    return resultInt;
                return resultDouble;
            }
        }
        System.out.println("Записали в кеш:");
        Object result = method.invoke(bean, args);
        oos.writeUTF(s);
        boolean type=method.getReturnType().equals(Integer.class);
        oos.writeBoolean(type);
        if(type)
            oos.writeInt((Integer)result);
        else oos.writeDouble((Double)result);
        return result;
    }
}
