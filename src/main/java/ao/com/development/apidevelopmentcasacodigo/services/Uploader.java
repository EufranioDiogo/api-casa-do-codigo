package ao.com.development.apidevelopmentcasacodigo.services;

import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;

public interface Uploader<T> {
    <T extends InputStreamSource> String upload(T file);
}
