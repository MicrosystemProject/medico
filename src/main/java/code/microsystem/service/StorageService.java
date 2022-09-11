package code.microsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import code.microsystem.dao.DocRepository;
import code.microsystem.entity.UserDoc;
import code.microsystem.util.DocUtil;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private DocRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {

        UserDoc docData = repository.save( UserDoc.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                . docData(DocUtil.compressImage(file.getBytes())).build());
        if ( docData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional< UserDoc> dbuserdoc  = repository.findByName(fileName);
        byte[] docs=DocUtil.decompressImage(dbuserdoc.get().getDocData());
        return docs;
    }
}
