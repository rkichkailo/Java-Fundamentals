package by.academy.homework7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task2 {

    public static void main(String[] args) {

        Person user = new User("Vasia", "Ivanov", 35, "20.12.2000", "Vasia", "qwerty", "vasia@gmail.com");
        Class<User> userClass = User.class;

//        getMethod()
        System.out.println("\ngetMethod() - example: " + "\n--------------------------------");

        try{
            Method getUserLogin = userClass.getMethod("getLogin");
            System.out.println(getUserLogin);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

//        getMethods()
        System.out.println("\ngetMethods() - examples: " + "\n--------------------------------");

        Method [] methods = userClass.getMethods();
        print(methods);

//        getField()
        System.out.println("\ngetField() - example: " + "\n--------------------------------");

        try{
            Field userName = userClass.getField("firstName");
            System.out.println(userName);
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }

//        getFields()
        System.out.println("\ngetFields() - examples: " + "\n--------------------------------");

        Field [] fields = userClass.getFields();
        print(fields);

//        getDeclaredMethod()
        System.out.println("\ngetDeclaredMethod() - examples: " + "\n--------------------------------");

        try{
            Method getPrivateMethod = userClass.getDeclaredMethod("printUserInfo", User.class);
            System.out.println(getPrivateMethod);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

//        getDeclaredMethods()
        System.out.println("\ngetDeclaredMethods() - examples: " + "\n--------------------------------");

        Method [] declaredMethods = userClass.getDeclaredMethods();
        print(declaredMethods);

//        getDeclaredField()
        System.out.println("\ngetDeclaredField() - example: " + "\n--------------------------------");

        try{
            Field userPassword = userClass.getDeclaredField("password");
            System.out.println(userPassword);
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }

//        getDeclaredFields()
        System.out.println("\ngetDeclaredFields() - examples: " + "\n--------------------------------");

        Field [] declaredFields = userClass.getDeclaredFields();
        print(declaredFields);

//
        System.out.println("\nsetPublicFields() - examples: " + "\n--------------------------------");

        try{
//            getInfo
            Field userLogin =  userClass.getDeclaredField("login");
            Field userPassword =  userClass.getDeclaredField("password");
            Field userEmail =  userClass.getDeclaredField("email");
//            setAccessible - true
            userLogin.setAccessible(true);
            userPassword.setAccessible(true);
            userEmail.setAccessible(true);
//            setInfo
            userLogin.set(user, "Petya");
            userPassword.set(user, "qazqaz");
            userEmail.set(user, "petya@gmail.com");
//            printToString
            Method print = userClass.getMethod("toString");
            System.out.println(print.invoke(user));
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static void print(Object[] array){
        for (Object o: array){
            System.out.println(o);
        }
    }

}
