package clientServer;
import java.net.*;
import java.io.*;
import java.util.*;
public class client {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Socket clientSocket = new Socket("127.0.0.1", 4000);
        System.out.println("Enter the fileName");
        String fname = in.nextLine();

        OutputStream ostream = clientSocket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);

        InputStream istream = clientSocket.getInputStream();
        BufferedReader sRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Contents of " + fname );
        String str;
        while((str = sRead.readLine()) != null){
            System.out.println(str);
        }
        pwrite.close();
        sRead.close();
    }
}
