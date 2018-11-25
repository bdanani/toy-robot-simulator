CANDIDATE NAME: Bob Danani

TECHNOLOGY CHOICE
- Language: JAVA 8
- Build Tool: Gradle 4.8
- Test Framework: JUnit, Hamcrest, Mockito/Captor
- Test Coverage: Jacoco with Project Lombok Instrumentation
- Framework Integration: Springboot


**********OBSERVATION**********

0. I am a keen believer in Clean Code & Clean Architecture.
With that in mind, my codes have the following quality:
- sensible naming of variables/methods/class names,
- clear and readable methods
- thin methods that only do little things,
- loosely coupled classes that are easy to be tested and easy to be mocked for testing purpose,
- highly cohesive classes and properly structured classes driven by the corresponding domain,
- very minimum comments given that the codes are clean and self explanatory.

*Book Reference*: Clean Code & Clean Coder by Robert Martin, A Handbook of Agile Software Craftsmanship.

1. The application is implemented as a CommandLine Springboot Application.

2. Unit tests and Application Feature test are implemented for this project.
Positive and negative scenarios test had been implemented, covering the normal cases and majority of the edge cases.

3. Codes were designed to allow flexibility for extension, but as the known scope is limited, it's hard to imagine every possibility for extension.
As a simple extension to the problem, the following was implemented (just for fun):
- PLACE_OBJECT command to place an obstacle object on the Game Board.

4. Minimum error handling functionality have been implemented, but may not cover all cases.

5. No code style rule is enforced due to time availability. For production level application, a stricter coding standard will be adopted using CheckStyle plugin for Java.

6. Test coverage can be run using: ./gradlew jacocoTestReport
The current code coverage includes: 98% Instructions Coverage AND 94% Branch Coverage.

7. The program will invoke the System console and prompt for the input (Refer to: ConsoleInputReader class)
Type 'EXIT' (without the quote) to break from the Console.



**********INSTRUCTIONS**********

1. Cleaning and building the program: ./gradlew clean build

This will install all necessary dependencies from JCenter repository and build the project.
Additionally, it will also run all the unit / feature tests.
If all the test are passed, a jar file will be created inside the build/libs directory.

2. Running the program: <JarName>.

Go to build/libs directory and run the program as follow:
java -jar toy-robot-simulator-0.1.0.jar

3. Test coverage report can be accessed at: file://{PROJECT_DIR}/build/jacocoHtml/index.html
i.e., file:///Users/bob.danani/Development/Codes/toy-robot-simulator/build/jacocoHtml/index.html

Jacoco Test Report has to be run before opening the coverage report.
i.e., ./gradlew jacocoTestReport



**********SAMPLE RUN**********

bob.danani$ java -jar build/libs/toy-robot-simulator-0.1.0.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.3.RELEASE)

2018-11-25 21:43:24.280  INFO 10074 --- [main] a.c.c.g.toyrobot.io.ConsoleInputReader   : Initialising Console Reader
2018-11-25 21:43:24.280  INFO 10074 --- [main] a.c.c.g.toyrobot.io.ConsoleInputReader   :

Waiting for Input. Type EXIT to end the game.

2018-11-25 21:43:24.484  INFO 10074 --- [main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
PLACE 1,1,NORTH
MOVE
REPORT
2018-11-25 21:43:37.841  INFO 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Robot is at Location (1,2,NORTH)

PLACE_OBJECT 1,3
REPORT
2018-11-25 21:43:54.464  INFO 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Robot is at Location (1,2,NORTH)

MOVE
2018-11-25 21:43:55.271 ERROR 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Cannot place TOY ROBOT at position Position [xPos=1, yPos=3]. The position has been occupied.

RIGHT
MOVE
MOVE
MOVE
MOVE
2018-11-25 21:44:08.831 ERROR 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Oops... Cannot move to Position [xPos=5, yPos=2] as it is outside the boundary.

LEFT
REPORT
2018-11-25 21:44:17.079  INFO 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Robot is at Location (4,2,NORTH)

PLACE_OBJECT 4,4
MOVE
REPORT
2018-11-25 21:44:33.702  INFO 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Robot is at Location (4,3,NORTH)

MOVE
2018-11-25 21:44:35.966 ERROR 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGame           : Cannot place TOY ROBOT at position Position [xPos=4, yPos=4]. The position has been occupied.

LEFT
MOVE
EXIT

2018-11-25 21:44:49.730  INFO 10074 --- [main] a.c.c.g.t.a.RobotSimulatorGameApp        : Started RobotSimulatorGameApp in 87.172 seconds (JVM running for 87.85)
2018-11-25 21:44:49.731  INFO 10074 --- [Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@531d72ca: startup date [Sun Nov 25 21:43:23 AEDT 2018]; root of context hierarchy
2018-11-25 21:44:49.732  INFO 10074 --- [Thread-1] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
