package ao.com.development.apidevelopmentcasacodigo.services;

import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class LocalUploaderSpring implements Uploader<MultipartFile> {
    @Override
    public <T extends InputStreamSource> String upload(T file) {
        MultipartFile multipartFile = (MultipartFile) file;

        return "image" + ThreadLocalRandom.current().nextLong() + ".jpg";
    }
}
