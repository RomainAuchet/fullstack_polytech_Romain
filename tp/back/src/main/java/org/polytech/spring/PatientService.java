package org.polytech.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service 
public class PatientService {
    private final PatientStore store;
    public PatientService(@Qualifier ("patientSerialization")PatientStore store)
     {
        this.store = store;
    }
    public void savePatient(Patient p){
        store.savePatient(p);
    }
}
