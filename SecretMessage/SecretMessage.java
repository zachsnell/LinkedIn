import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SecretMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileLoc = "\\SecretMessage.txt";
        
       // Display ASCII art
        String asciiArt =
                
       "          _____                    _____                    _____                    _____                    _____ \n" +          
       "         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\  \n" +        
       "        /::\\    \\                /::\\    \\                /::\\    \\                /::\\    \\                /::\\    \\  \n" +      
       "       /::::\\    \\              /::::\\    \\              /::::\\    \\               \\:::\\    \\              /::::\\    \\  \n" +    
       "      /::::::\\    \\            /::::::\\    \\            /::::::\\    \\               \\:::\\    \\            /::::::\\    \\  \n" +   
       "     /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\  \n" +    
       "    /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\               \\:::\\    \\        /:::/  \\:::\\    \\  \n" +    
       "   /::::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\              /::::\\    \\      /:::/    \\:::\\    \\  \n" +   
       "  /::::::\\   \\:::\\    \\    ___\\:::\\   \\:::\\    \\    ___\\:::\\   \\:::\\    \\    ____    /::::::\\    \\    /:::/    / \\:::\\    \\  \n" +  
       " /:::/\\:::\\   \\:::\\    \\  /\\   \\:::\\   \\:::\\    \\  /\\   \\:::\\   \\:::\\    \\  /\\   \\  /:::/\\:::\\    \\  /:::/    /   \\:::\\ ___\\  \n" + 
       "/:::/  \\:::\\   \\:::\\____\\/::\\   \\:::\\   \\:::\\____\\/::\\   \\:::\\   \\:::\\____\\/::\\   \\/:::/  \\:::\\____\\/:::/____/  ___\\:::|    |  \n" +
       "\\::/    \\:::\\  /:::/    /\\:::\\   \\:::\\   \\::/    /\\:::\\   \\:::\\   \\::/    /\\:::\\  /:::/    \\::/    /\\:::\\    \\ /\\  /:::|____|  \n" +
       " \\/____/ \\:::\\/:::/    /  \\:::\\   \\:::\\   \\/____/  \\:::\\   \\:::\\   \\/____/  \\:::\\/:::/    / \\/____/  \\:::\\    /::\\ \\::/    /  \n" + 
       "          \\::::::/    /    \\:::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\       \\::::::/    /            \\:::\\   \\:::\\ \\/____/  \n" +  
       "           \\::::/    /      \\:::\\   \\:::\\____\\       \\:::\\   \\:::\\____\\       \\::::/____/              \\:::\\   \\:::\\____\\  \n" +    
       "           /:::/    /        \\:::\\  /:::/    /        \\:::\\  /:::/    /        \\:::\\    \\               \\:::\\  /:::/    /  \n" +    
       "          /:::/    /          \\:::\\/:::/    /          \\:::\\/:::/    /          \\:::\\    \\               \\:::\\/:::/    /  \n" +     
       "         /:::/    /            \\::::::/    /            \\::::::/    /            \\:::\\    \\               \\::::::/    /  \n" +      
       "        /:::/    /              \\::::/    /              \\::::/    /              \\:::\\____\\               \\::::/    /  \n" +       
       "        \\::/    /                \\::/    /                \\::/    /                \\::/    /                \\::/____/  \n" +        
       "         \\/____/                  \\/____/ecret             \\/____/                  \\/____/ \n" +                                  
                                                                                                                                   
       "          _____                    _____                    _____                    _____                _____  \n" +              
       "         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\              /\\    \\  \n" +             
       "        /::\\____\\                /::\\____\\                /::\\    \\                /::\\____\\            /::\\    \\  \n" +            
       "       /::::|   |               /::::|   |               /::::\\    \\              /::::|   |            \\:::\\    \\  \n" +           
       "      /:::::|   |              /:::::|   |              /::::::\\    \\            /:::::|   |             \\:::\\    \\  \n" +          
       "     /::::::|   |             /::::::|   |             /:::/\\:::\\    \\          /::::::|   |              \\:::\\    \\  \n" +         
       "    /:::/|::|   |            /:::/|::|   |            /:::/__\\:::\\    \\        /:::/|::|   |               \\:::\\    \\  \n" +        
       "   /:::/ |::|   |           /:::/ |::|   |           /::::\\   \\:::\\    \\      /:::/ |::|   |               /::::\\    \\  \n" +       
       "  /:::/  |::|   | _____    /:::/  |::|___|______    /::::::\\   \\:::\\    \\    /:::/  |::|   | _____        /::::::\\    \\  \n" +      
       " /:::/   |::|   |/\\    \\  /:::/   |::::::::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/   |::|   |/\\    \\      /:::/\\:::\\    \\  \n" +     
       "/:: /    |::|   /::\\____\\/:::/    |:::::::::\\____\\/:::/__\\:::\\   \\:::\\____\\/:: /    |::|   /::\\____\\    /:::/  \\:::\\____\\  \n" +    
       "\\::/    /|::|  /:::/    /\\::/    / ~~~~~/:::/    /\\:::\\   \\:::\\   \\::/    /\\::/    /|::|  /:::/    /   /:::/    \\::/    /  \n" +    
       " \\/____/ |::| /:::/    /  \\/____/      /:::/    /  \\:::\\   \\:::\\   \\/____/  \\/____/ |::| /:::/    /   /:::/    / \\/____/  \n" +     
       "         |::|/:::/    /               /:::/    /    \\:::\\   \\:::\\    \\              |::|/:::/    /   /:::/    /  \n" +              
       "         |::::::/    /               /:::/    /      \\:::\\   \\:::\\____\\             |::::::/    /   /:::/    /  \n" +               
       "         |:::::/    /               /:::/    /        \\:::\\   \\::/    /             |:::::/    /    \\::/    /  \n" +                
       "         |::::/    /               /:::/    /          \\:::\\   \\/____/              |::::/    /      \\/____/  \n" +                 
       "         /:::/    /               /:::/    /            \\:::\\    \\                  /:::/    /  \n" +                               
       "        /:::/    /               /:::/    /              \\:::\\____\\                /:::/    /  \n" +                                
       "        \\::/    /                \\::/    /                \\::/    /                \\::/    /  \n" +                                 
       "         \\/____/                  \\/____/essage            \\/____/                  \\/____/  \n" +                                  
                                                                                                                                    
       "      _____                    _____                    _____                    _____                    _____  \n" +              
       "     /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\  \n" +             
       "    /::\\    \\                /::\\____\\                /::\\    \\                /::\\    \\                /::\\    \\  \n" +            
       "    \\:::\\    \\              /:::/    /               /::::\\    \\              /::::\\    \\              /::::\\    \\  \n" +           
       "     \\:::\\    \\            /:::/    /               /::::::\\    \\            /::::::\\    \\            /::::::\\    \\  \n" +          
       "      \\:::\\    \\          /:::/    /               /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\  \n" +         
       "       \\:::\\    \\        /:::/____/               /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\  \n" +        
       "       /::::\\    \\      /::::\\    \\              /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\  \n" +       
       "      /::::::\\    \\    /::::::\\    \\   _____    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\  \n" +      
       "     /:::/\\:::\\    \\  /:::/\\:::\\    \\ /\\    \\  /:::/\\:::\\   \\:::\\____\\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  \n" +     
       "    /:::/  \\:::\\____\\/:::/  \\:::\\    /::\\____\\/:::/  \\:::\\   \\:::|    |/:::/__\\:::\\   \\:::\\____\\/:::/__\\:::\\   \\:::\\____\\  \n" +    
       "   /:::/    \\::/    /\\::/    \\:::\\  /:::/    /\\::/   |::::\\  /:::|____|\\:::\\   \\:::\\   \\::/    /\\:::\\   \\:::\\   \\::/    /  \n" +    
       "  /:::/    / \\/____/  \\/____/ \\:::\\/:::/    /  \\/____|:::::\\/:::/    /  \\:::\\   \\:::\\   \\/____/  \\:::\\   \\:::\\   \\/____/  \n" +     
       " /:::/    /                    \\::::::/    /         |:::::::::/    /    \\:::\\   \\:::\\    \\       \\:::\\   \\:::\\    \\  \n" +         
       "/:::/    /                      \\::::/    /          |::|\\::::/    /      \\:::\\   \\:::\\____\\       \\:::\\   \\:::\\____\\  \n" +        
       "\\::/    /                       /:::/    /           |::| \\::/____/        \\:::\\   \\::/    /        \\:::\\   \\::/    /  \n" +        
       " \\/____/                       /:::/    /            |::|  ~|               \\:::\\   \\/____/          \\:::\\   \\/____/  \n" +         
       "                              /:::/    /             |::|   |                \\:::\\    \\               \\:::\\    \\  \n" +             
       "                             /:::/    /              \\::|   |                 \\:::\\____\\               \\:::\\____\\  \n" +            
       "                             \\::/    /                \\:|   |                  \\::/    /                \\::/    /  \n" +            
       "                              \\/____/                  \\|___|                   \\/____/                  \\/____/  \n" ;

        System.out.println(asciiArt);    
        System.out.println(
                "\nSecret message, where is it?! \nThis app reads the message.txt file and encodes or decodes a secret message");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert message into document");
            System.out.println("2. Read message from document");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.println("Type your secret message");
                    String msg = scanner.nextLine();
                    InsertMessage(msg, fileLoc);
                    System.out.println("Your message has been inserted. Open the document " + fileLoc
                            + " and see if you can find it!");
                    break;

                case 2:
                    String hdnMessage = ReadMessage();
                    System.out.println("Here is your secret message: \n" + hdnMessage);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void InsertMessage(String msg, String loc) {
        // Get our encoded hidden message from the user message
        byte[] bytes = msg.getBytes();
        StringBuilder binary = new StringBuilder();
        StringBuilder encoded = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                encoded.append((val & 128) == 0 ? "\t" : " ");
                val <<= 1;
            }
            binary.append(' ');
        }

        System.out.println("'" + msg + "' to binary: " + binary);

        // Read in our document
        // try (InputStream inputStream = new FileInputStream(loc)) {
        // int byteRead = -1;
        // while ((byteRead = inputStream.read()) != -1) {

        // }
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // }


        
        System.out.println("File");
        String currentWorkingDir = System.getProperty("user.dir");
        System.out.println(currentWorkingDir);
        try {
            File file = new File(currentWorkingDir + loc);
            List<String> fileLinesList = Files.readAllLines(file.toPath());

            for (String s : fileLinesList) {
                System.out.println(s);
            }
        } 
        catch (Exception e) 
        {
System.out.println(e);
        }

        Path currentWorkingDirr = Paths.get("").toAbsolutePath();
System.out.println(currentWorkingDirr.normalize().toString());

        // Place message at the end of the document after the last line of text

        // Insert the secret message at the end of the last line
        // If there is no New Line, insert one and make message
        // If there is a new line, insert after

    }

    public static String ReadMessage() {
        return "test";
    }
}