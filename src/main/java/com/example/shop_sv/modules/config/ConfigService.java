package com.example.shop_sv.modules.config;

import com.example.shop_sv.modules.config.dto.resquest.ConfigReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {
    @Autowired
    private ConfigRepository configRepository;

    public List<ConfigModel> getAll() {
        return configRepository.findAll();
    }

    public ConfigModel save(ConfigReq config) {
        ConfigModel configModel = new ConfigModel();
        configModel.setConfigName(config.getConfigName());
        return configRepository.save(configModel);
    }

    public ConfigModel findById(Integer id) {
        return configRepository.findById(Byte.valueOf(String.valueOf(id))).orElse(null);
    }
}
