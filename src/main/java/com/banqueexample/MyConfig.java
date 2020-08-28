package com.banqueexample;

import com.banqueexample.rmi.BanqueRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {

    @Bean
    public SimpleJaxWsServiceExporter getJWS(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8088/banque");
        return exporter;
    }

    @Bean
    public RmiServiceExporter getRmiService(ApplicationContext ctx){
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(ctx.getBean("RMI-Service"));
        exporter.setRegistryPort(1099);
        exporter.setServiceName("BK");
        exporter.setServiceInterface(BanqueRemote.class);
        return exporter;
    }
}
