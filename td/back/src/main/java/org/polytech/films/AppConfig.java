package org.polytech.films;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration 
@ComponentScan ("org.polyech.films")
@PropertySource( "classpath:application.properties")
public class AppConfig {
}

