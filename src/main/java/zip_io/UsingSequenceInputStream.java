package zip_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Class UsingSequenceInputStream allows to collect all stream to one zip stream and write in file
 * using SequenceInputStream(Enumeration<? extends InputStream> e).
 *
 * @author Kamila Meshcheryakova
 * created by 03.07.2020
 */
// Args:
    // args[0] - C:/resultFile.txt;
    // args[1] - args[n] -
// C:/pathToTest/test.zip.003
//C:/pathToTest/test.zip.001
//C:/pathToTest/test.zip.004
//C:/pathToTest/test.zip.002
public class UsingSequenceInputStream {
    public static void main(String[] args) {
        // sort pasts of archive
        Arrays.sort(args, 1, args.length);
        // create stream to write into a file
        try (FileOutputStream fos = new FileOutputStream(args[0])) {
            List<FileInputStream> list = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                //add to List <? extends InputStream>
                list.add(new FileInputStream(args[i]));
            }
            // create zip stream to read from parts of streams collected in one
            ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(list)));
            byte[] bytes = new byte[1024 * 1024];
            while ((zis.getNextEntry()) != null) {
                int count;
                while ((count = zis.read(bytes)) != -1) {
                    fos.write(bytes, 0, count);
                }
                fos.flush();
                zis.closeEntry();
            }
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
