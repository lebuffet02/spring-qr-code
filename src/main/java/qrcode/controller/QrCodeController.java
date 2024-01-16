package qrcode.controller;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qrcode.service.QrCodeService;

import java.io.IOException;

@RestController
@RequestMapping(value = "qr-code", produces = MediaType.IMAGE_PNG_VALUE)
public class QrCodeController {

    @Autowired
    QrCodeService qrCodeService;

    @GetMapping
    public ResponseEntity<Object> getQrCode() throws IOException, WriterException {
        return ResponseEntity.ok(qrCodeService.getQrCodeService("https://github.com/lebuffet02", 300, 300));
    }
}
