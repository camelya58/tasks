package url;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class UrlDownload {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //получаем OutputStream, чтобы писать в него данные запроса
//        connection.setDoOutput(true);
//        OutputStream outputStream = connection.getOutputStream();
//        outputStream.write(1);
//        outputStream.flush();

//получаем InputStream, чтобы читать из него данные ответа
        InputStream inputStream = connection.getInputStream();
        Files.copy(inputStream, new File("C:\\Users\\Игорь\\IdeaProjects\\tasks\\src\\main\\java\\url\\google.png").toPath());
        inputStream.close();
  //      outputStream.close();
        connection.disconnect();
    }
}
