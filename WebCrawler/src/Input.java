import java.util.Scanner;

/**
 * Created by Renju R on 1/9/2016.
 */
public class Input {
    private String url;
    private int levels;

    private Scanner in = new Scanner(System.in);
    public String getUserUrl() {
        System.out.println("What is the website you would like to start the crawl from?");
        String url = in.nextLine();
        return url;
    }

    public Integer getUserLevelChoices() {
        Integer levels = 0;
        try {
            System.out.println("How many levels deep would you like to go?");
            levels = Integer.parseInt(in.nextLine());
        } catch(Exception e) {
            getUserLevelChoices();
        }

        return levels;
    }
}
