package com.sewoomprojectv1.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    public static final String ENCRYPT_KEY = "sweoom";
    public static final String ENCRYPT_ALGORITHM = "PBEWithMD5AndDES";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(ENCRYPT_KEY);          // 암호화에 사용할 키
        config.setAlgorithm(ENCRYPT_ALGORITHM);   // 사용할 알고리즘
        config.setPoolSize("1");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
