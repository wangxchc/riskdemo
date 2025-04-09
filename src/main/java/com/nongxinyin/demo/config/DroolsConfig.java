package com.nongxinyin.demo.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// DroolsConfig.java
@Configuration
public class DroolsConfig {
    private static final String RULES_PATH = "rules/risk-control.drl";

//    public KieContainer kieContainer() {
//        KieServices kieServices = KieServices.get();
//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH));
//
//        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
//        try {
//            kieBuilder.buildAll();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        KieModule kieModule = kieBuilder.getKieModule();
//        return kieServices.newKieContainer(kieModule.getReleaseId());

    /// /        return kieServices.newKieClasspathContainer(kieModule.getReleaseId().toString());
//    }
    @Bean
    public KieContainer getKieContainer() {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        return kc;
    }
}