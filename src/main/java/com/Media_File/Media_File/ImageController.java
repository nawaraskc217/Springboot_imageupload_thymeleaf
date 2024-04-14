package com.Media_File.Media_File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String image(Model model) {
        model.addAttribute("image", new Image());
        return "image"; // Assuming there is an HTML file named "image.html"
    }

    @PostMapping("/save")
    public String saveImagesFile(@ModelAttribute Image image,
                                 @RequestParam("file") MultipartFile file,
                                 Model model) {
        String message = imageService.saveImage(file, image.getName(), image.getDesc());
        List<Image> images = imageService.getAll();
        model.addAttribute("message", message);
        model.addAttribute("images", images);
        return "display"; // Assuming there is an HTML file named "display.html"
    }
}
