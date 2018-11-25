package au.com.codepractice.general.toyrobot.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    private Scanner scanner;

    public ConsoleInputReader(){
        initialiseInputScanner();
    }

    private static final Logger logger = LoggerFactory.getLogger(ConsoleInputReader.class);

    @Override
    public String readInputLine(){
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    private void initialiseInputScanner(){
        scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        logger.info("Initialising Console Reader");
        logger.info("\nWaiting for Input. Type EXIT to end the game.\n");
    }
}