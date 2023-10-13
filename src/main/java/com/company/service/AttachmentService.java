package com.company.service;

import com.company.entity.AttachmentEntity;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface AttachmentService {
    AttachmentEntity save(MultipartFile multipartFile) throws IOException;

    AttachmentEntity addAttachment(MultipartHttpServletRequest request) throws IOException;

    AttachmentEntity downloadToServer(String hashid, HttpServletResponse response) throws IOException;

    ResponseEntity<InputStreamResource> getFile(String hashId, HttpServletResponse httpServletResponse) throws FileNotFoundException;

    String deleteFile(String hashid);
}
