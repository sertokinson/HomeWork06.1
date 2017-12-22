package impl;

import org.springframework.util.ReflectionUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
    public static Object cashInFile(Object bean, Method method, Object[] args, FileWriter writer) throws InvocationTargetException, IllegalAccessException {
                StringBuilder s = new StringBuilder();
                StringBuilder stringValue=new StringBuilder();
                stringValue.append(args[0]+" "+args[2]+" "+args[1]+" ");
                int countSpace=0;
                try (FileReader reader = new FileReader("C:\\Users\\Сергей\\Desktop\\JavaSchool\\Homeworks\\HomeWork_06\\new\\calculator\\cash.txt")) {
                    int c;
                    while ((c = reader.read()) != -1) {
                        s.append((char) c);
                        if ((char) c == ' ')
                            countSpace++;
                        if(countSpace==3)
                            if(s.toString().equals(stringValue.toString())) {
                                s=new StringBuilder();
                                s.append((char)reader.read());
                                System.out.println("Значение из кеша:");
                                if(method.getReturnType().equals(Integer.class)) {
                                    return (int)Character.digit(s.charAt(0), 10);
                                }
                                return  (double)Character.digit(s.charAt(0), 10);
                            }
                        if ((char) c == '\n'){
                            countSpace=0;
                            s=new StringBuilder();
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

        Object result = method.invoke(bean, args);
        System.out.println("Записали в кеш:");
        try {
            writer.write(args[0] + " " + args[2] + " " + args[1] + " " + result + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
