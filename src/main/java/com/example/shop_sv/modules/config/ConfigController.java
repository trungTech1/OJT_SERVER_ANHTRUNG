package com.example.shop_sv.modules.config;

import com.example.shop_sv.modules.config.dto.resquest.ConfigReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @GetMapping("")
    public ResponseEntity<Object> getConfig() {
        try {
            return ResponseEntity.ok(configService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get Config fail");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Object> addConfig(@RequestBody ConfigReq configReq) {
         configService.save(configReq);
        return new ResponseEntity<>("Add Config ok", HttpStatus.OK);
    }
}
