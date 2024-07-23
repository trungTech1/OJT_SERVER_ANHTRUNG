package com.example.shop_sv.modules.color;

import com.example.shop_sv.modules.color.dto.ColorReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/color")
public class ColorController {
    @Autowired
    ColorService colorService;

    @GetMapping("")
    public ResponseEntity<Object> getColor() {
        try{
            return ResponseEntity.ok(colorService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get Color fail");

        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addColor(@RequestBody ColorReq colorReq) {
        colorService.save(colorReq);
            return new ResponseEntity<>("Add Color ok", HttpStatus.OK);
    }
}
