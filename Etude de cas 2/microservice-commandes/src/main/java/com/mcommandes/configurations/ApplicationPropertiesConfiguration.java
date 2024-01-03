package com.mcommandes.configurations;


import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mes-config-ms")
@RefreshScope
public class ApplicationPropertiesConfiguration {
    private int commandesLast;


    public int getcommandesLast() {
        System.out.println(commandesLast);
        return commandesLast;
    }
    public void setCommandesLast(int commandesLast) {

        this.commandesLast = commandesLast;
    }

    @PostConstruct
    public void afterPropertiesSet() {
        System.out.println("Commandes Last property read from properties: " + commandesLast);

    }
}
