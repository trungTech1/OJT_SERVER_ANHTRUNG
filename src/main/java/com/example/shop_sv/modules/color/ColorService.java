package com.example.shop_sv.modules.color;

import com.example.shop_sv.modules.color.dto.ColorReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;

    public List<ColorModel> getAll() {
        return colorRepository.findAll();
    }

    public ColorModel save(ColorReq color) {
        ColorModel colorModel = new ColorModel();
        colorModel.setColorName(color.getColorName());
        return colorRepository.save(colorModel);
    }
}
