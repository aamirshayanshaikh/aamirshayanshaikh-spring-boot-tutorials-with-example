package com.javakar.springdemomaster.largefile;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class LargeFileService {


    public StreamingResponseBody downloadFile(URL url, String targetCsvFileName){
        return out -> {
            try (InputStream inputStream = url.openStream();
                 ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {

                ZipEntry entry;
                byte[] buffer = new byte[8192];
                while ((entry = zipInputStream.getNextEntry()) != null) {
                    if (!entry.isDirectory() && entry.getName().equals(targetCsvFileName)) {
                        int bytesRead;
                        while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                        break; // Found the file, exit loop
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log any exceptions
            }
        };
    }



    public StreamingResponseBody downloadLargeFile(String myUrl){


        try {
            URL url = new URL(myUrl); // URL of the large file
            URLConnection connection = url.openConnection();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

             return outputStream -> {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
            };
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
