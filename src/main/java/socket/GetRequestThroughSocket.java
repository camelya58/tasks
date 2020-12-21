package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class GetRequestThroughSocket {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            //Instantiate a new socket
            Socket s = new Socket(url.getHost(), 80);

            //Instantiates a new PrintWriter passing in the sockets output stream
            PrintWriter wtr = new PrintWriter(s.getOutputStream());

            //Prints the request string to the output stream
            wtr.println("GET " + url.getPath() + " HTTP/1.1");
            wtr.println("Host: " + url.getHost());
            wtr.flush();

            //Creates a BufferedReader that contains the server response
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String responseLine;

            //Prints each line of the response
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }

            //Closes out buffer and writer
            bufferedReader.close();
            wtr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}