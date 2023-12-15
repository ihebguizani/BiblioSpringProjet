package E_commerceDbachna.controller;

import E_commerceDbachna.models.Article;
import E_commerceDbachna.models.ImageData;
import E_commerceDbachna.servicesImpl.ArticleServiceImpl;
import E_commerceDbachna.servicesImpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@RestController
public class ImageController {
    @Autowired
    private ImageServiceImpl service;
    @Autowired
    private ArticleServiceImpl serviceArticle;


    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }


}
