package com.javakar.springdemomaster.largefile;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestController
public class LargeFileController {

    private final LargeFileService largeFileService;

    public LargeFileController(LargeFileService largeFileService){
        this.largeFileService = largeFileService;
    }


    @GetMapping("/extract-and-download-csv")
    public ResponseEntity<StreamingResponseBody> extractAndDownloadCsvFromZip(HttpServletResponse response) throws IOException {
        String myUrl = "place your actual url here, remember I am extracting a zip folder and then downloading a 10gb large csv file";
        String targetCsvFileName = "name-of-your-csv-file.csv";
        URL url = new URL(myUrl);

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + targetCsvFileName + "\"");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + targetCsvFileName + "\"")
                .body(largeFileService.downloadFile(url, targetCsvFileName));
    }



    @GetMapping("/download-large-file")
    public ResponseEntity<StreamingResponseBody> downloadLargeFile(){
        String myUrl = "url to download any file";
        return ResponseEntity.ok()
                .body(largeFileService.downloadLargeFile(myUrl));
    }

}
