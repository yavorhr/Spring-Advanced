package bg.softuni.cloudinary.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

  CloudinaryImage upload(MultipartFile file) throws IOException;

  boolean delete(String publicId);

}
