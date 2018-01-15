package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;

    @Value("${password:default value}")
    private String password;

    @RequestMapping("/password")
    String getPassword() {
        return this.password;
    }

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}

// SPRING_CLOUD_CONFIG_SERVER_DEFAULTLABEL = develop
// SPRING_CLOUD_CONFIG_SERVER_GIT_URI = ssh://git@gitlab.pnr.local.vm:20022/Infrastruktur/componentconfig.git
// SPRING_CLOUD_CONFIG_SERVER_GIT_SEARCH-PATHS = global, global/*
// // SPRING_CLOUD_CONFIG_SERVER_GIT_SEARCH-PATHS=global,global/cg-itu-tp2,luv-intern,luv-intern/*
// SERVER_PORT=32888
// PORT_CALCULATION_ENABLED=False
// SPRING_CONFIG_LOCATION=/run/secrets/cg-itu-tp2-intern-luv-configserver-configuration.properties
// // "PORT_UMGEBUNG_MULTIPLIER=1000",
// // "PORT_OFFSET=30000",
// // UMGEBUNG