package com.company.controller;

import com.company.entity.AttachmentEntity;
import com.company.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(value = "*",maxAge = 3600)
@RequestMapping("/api")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @Value("${upload.server}")
    private String serverPath;

    @PostMapping("/user/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        AttachmentEntity attachmentEntity = attachmentService.save(multipartFile);
        return ResponseEntity.ok(attachmentEntity);
    }

    @PostMapping("/user/addAttachment")
    public ResponseEntity<?> addAttach(MultipartHttpServletRequest request) throws IOException {
        AttachmentEntity attachmentEntity=attachmentService.addAttachment(request);
        return ResponseEntity.ok(attachmentEntity);
    }
    @GetMapping("/user/downloadToServer/{hashid}")
    public  ResponseEntity<?> downloadToServer(@PathVariable String hashid, HttpServletResponse response) throws IOException {
        AttachmentEntity attachment= attachmentService.downloadToServer(hashid, response);
        return ResponseEntity.ok(attachment);
    }

    @GetMapping("/user/viewFile/{hashId}")
    public  ResponseEntity<InputStreamResource> viewFile(@PathVariable String hashId, HttpServletResponse httpServletResponse) throws IOException {
        return attachmentService.getFile(hashId, httpServletResponse);
    }

    @DeleteMapping("/user/delete/{hashid}")
    public ResponseEntity deleteFile(@PathVariable String hashid){
        String file = attachmentService.deleteFile(hashid);
        return ResponseEntity.ok(file);
    }


}
