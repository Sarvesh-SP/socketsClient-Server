package clientServer;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("---------------------Server Side-------------------");
        System.out.println("Server Ready for connection.....");
        Socket connSocket = ss.accept();

        InputStream istream = connSocket.getInputStream();
        BufferedReader fRead = new BufferedReader(new InputStreamReader(istream));
        String fname = fRead.readLine();
        File fileName = new File(fname);

        OutputStream ostream = connSocket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        if (fileName.exists()) {
            String str;
            BufferedReader contentRead = new BufferedReader(new FileReader(fname));
            while ((str = contentRead.readLine())!= null) {
                pwrite.println(str);
            }
            contentRead.close();
        }
        else {
            System.out.println("Requested File does not exists.");
            String msg = "Requested file does'nt exists in at server side";
            pwrite.println(msg);

        }
        connSocket.close();
        ss.close();
        fRead.close();
        pwrite.close();

    }
}
