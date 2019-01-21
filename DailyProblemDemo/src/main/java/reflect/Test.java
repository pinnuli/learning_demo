package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Test {
    public static void main(String[] args) {

        Student student = new Student("pinnuli", 18);

        Class studentClass = student.getClass();
        /*Field[] studentField = studentClass.getDeclaredFields();

        for (int i = 0; i < studentField.length; i++) {
            studentField[i].setAccessible(true);
            try {
                System.out.println(studentField[i].get(student));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(studentField[i].getName());
        }*/

       /* Method[] studentMethods = studentClass.getDeclaredMethods();
        for (int i = 0; i < studentMethods.length; i++) {
            studentMethods[i].setAccessible(true);
            System.out.println(studentMethods[i].getName());
        }*/

        Method[] studentMethods = studentClass.getDeclaredMethods();
        for (int i = 0; i < studentMethods.length; i++) {
            studentMethods[i].setAccessible(true);
            try {
                studentMethods[i].invoke(student,"pinnuli");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(studentMethods[i].getName());
        }


    }
}
