package com.Media_File.Media_File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repo;

    public String saveImage(MultipartFile file, String name, String desc) {
        try {
            Image image = new Image();
            image.setName(name);
            image.setDesc(desc);
            image.setImage(file.getBytes());
            repo.save(image);
            return "Saved file to db";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save file: " + e.getMessage();
        }
    }

    public List<Image> getAll() {
        List<Image> images = repo.findAll();
        // Convert image bytes to Base64 for displaying in HTML
        for (Image image : images) {
            byte[] encodedImage = Base64.getEncoder().encode(image.getImage());
            String base64Image = new String(encodedImage);
            image.setBase64Image(base64Image);
        }
        return images;
    }
}
