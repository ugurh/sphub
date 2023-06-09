package io.ugurh.sphub.files;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author harun ugur
 * @project resttemplate-interceptor
 * @created 5.05.2023 - 01:09
 */
public interface FilesStorageService {

    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
