package org.polytech.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Repository 
public class PatientDataBase  implements PatientStore{
    @Value ("${database.url}")
    private String urlDb;
    @Override 
    public void savePatient(Patient p){
        System.out.print("Sauvegarde dans la base de donnée: " + p.getName());
    }
    @PostConstruct 
    public void init(){
    System.out.println("Initialisation patient database");
    }
    @PreDestroy 
    public void close(){
    System.out.println("Destruction patient database");
    }
}
