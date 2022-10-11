package com.tis.crud;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.tis.crud"})
@EnableJpaRepositories(basePackages="com.tis.crud.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.tis.crud.model")
public class SpringBootCrudDemoApplication {

    public static void main(String[] args) {        
		if (!Desktop.isDesktopSupported()) {
			System.out.println("App needs a desktop manager to run, exiting.");
			System.exit(1);
		}

		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootCrudDemoApplication.class);
		builder.headless(false).run(args);
    }
    
    
    @EventListener(ApplicationReadyEvent.class)
    public void openBrowserAfterStartup() throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI("http://localhost:8080/bands"));
    }
    
    
}
