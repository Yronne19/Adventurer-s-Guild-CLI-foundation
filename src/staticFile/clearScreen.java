package staticFile;

public class clearScreen {
    
    public static void clearscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
