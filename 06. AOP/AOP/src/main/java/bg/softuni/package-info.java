package bg.softuni;

/* AOP demo
1. We are creating one class Student with some methods in it.
2. We are injecting the Student class in BasicExample, so we are able to call it's methods in the console.
3. In "BasicExampleAspect" class we will implement our AOP. To work we need to to add the AOP dependency in pom.xml.
4. To define a class as aspect and to be recognizable from Spring we need @Aspect & @Component on the class.
5. The logic in the advises is called concerns (in the demo concern is the Logger.info).
6. AOP methods :

  @Before advise

  6.1 @Before advise on Student methods : before all methods from "Student", we will log some info in the console.

  * with @Pointcut expression we are defining the scope of the AOP. (* bg.softuni.aop.Student.*(..))");
  In the example we want our AOP to access all methods from the "Student" class.
  @Pointcut is valid only for methods.

  @Pointcut("execution(* bg.softuni.aop.Student.*(..))")
  public void track(){}

  * After we defined the scope with @Pointcut, we are creating the s.c. "advise".
    With the @Before annotation, we are implementing a Logger.info, which will be called before each method from the Students class.
    @Before accept the @Pointcut as a reference to the scope, for the @Before advise will be valid..
    JointPoint joinPoint argument

  @Before("track()")
  public void beforeAnyMethod(JoinPoint joinPoint) {
    LOGGER.info("Before calling: {}", joinPoint.getSignature());
  }

  6.2 @Before advise on single method

  * In the pointcut we are specifying that a Logger info will be shown on the console, before the calling of student.echo();

  @Pointcut("execution(* bg.softuni.aop.Student.echo(..))")
  public void trackEcho(){}

  @Before("trackEcho()")
  public void beforeEcho() {
  LOGGER.info("Advice execution before calling echo.");

  @After advise

  6.3 @AfterThrowing we will log in the console the exception which we throw, AFTER it is thrown.
      This will be valid for all methods in students (reference to "track()");

  @AfterThrowing(pointcut = "track()", throwing = "error")
  public void trackExceptions(Throwable error) {
    LOGGER.info("I have detected an exception: ", error);
  }

   6.4 @Around advise
   With @Around advise we can "catching" the logging from ModifyingExample and we are changing it :

       String result = student.concat("A", "B");

     // if there is no aspect we would expect - result => AB
    // if there is an aspect we would expect - result => ([A]-[B])

   @Pointcut("execution(* bg.softuni.aop.Student.concat(..))")
   public void concatPointcut(){}

   @Around("concatPointcut() && args(a, b)")
   public Object modify(ProceedingJoinPoint pjp, String a, String b) throws Throwable {

   // before the execution of the method

   String modifiedArgument1 = "[" + a + "]";
   String modifiedArgument2 = "[" + b + "]";

   // call the method via th proceeding join point

   Object methodResult = pjp.proceed(new Object[]{
        modifiedArgument1,
        modifiedArgument2
    });

    // modify the result.
    return "(" + methodResult + ")";
  }


  }
  */