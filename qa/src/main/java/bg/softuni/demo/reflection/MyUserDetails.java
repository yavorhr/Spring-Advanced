package bg.softuni.demo.reflection;

public class MyUserDetails extends UserDetails{

  private int age;

  public int getAge() {
    return age;
  }

  public MyUserDetails setAge(int age) {
    this.age = age;
    return this;
  }
}
