import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsEx {
    public static void main(String args[]) {
        try {
            fetch();
            System.out.println("No Exception"); 
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    public static void fetch() throws IOException {
        File f1 = new File("abc.txt");
        FileInputStream stream = new FileInputStream(f1);
    }
}
