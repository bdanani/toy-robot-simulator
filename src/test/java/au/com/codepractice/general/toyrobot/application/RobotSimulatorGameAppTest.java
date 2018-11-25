package au.com.codepractice.general.toyrobot.application;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RobotSimulatorGameAppTest {

    @Test
    public void testGame() throws InterruptedException{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> RobotSimulatorGameApp.main(new String[0]));

        String input = "PLACE 1,1,NORTH\n" +
                "MOVE\n" +
                "RIGHT\n" +
                "MOVE\n" +
                "MOVE\n" +
                "MOVE\n" +
                "REPORT\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "PLACE_OBJECT 4,4\n" +
                "MOVE\n" +
                "REPORT\n" +
                "EXIT\n";

        simulateUserInput(input);
        executorService.awaitTermination(3000L, TimeUnit.MILLISECONDS);
    }


    private void simulateUserInput(String inputLine) {
        inputLine = inputLine + "\n";
        System.setIn(new ByteArrayInputStream(inputLine.getBytes()));
    }
}