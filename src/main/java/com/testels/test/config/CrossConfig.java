/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testels.test.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 *
 * @author HFerchichi
 
 * */
@Configuration
@EnableWebMvc
public class CrossConfig extends WebMvcConfigurerAdapter{
     @Override
   public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
               // .exposedHeaders("*")
               .allowCredentials(true).maxAge(3600);
   }
}
