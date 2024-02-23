package bg.softuni.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

  public static void main(String[] args) throws Exception {
    UserDetails myUserDetails = new MyUserDetails().
        setAge(42).
        setName("Lucho");

    System.out.println(test(myUserDetails, "Age"));
  }

  private static Object test(UserDetails userDetails, String propertyName)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Method getProperty =
        userDetails.getClass().getMethod("get" + propertyName);

    return getProperty.invoke(userDetails);
  }

}
