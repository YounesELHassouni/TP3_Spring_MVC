package ma.enset.hospital;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repostories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        /*
        Patient patient = new Patient();

        patient.setId(null);
        patient.setNom("Mohammed");
        patient.setDateNaissance(new Date());
        patient.setMalade(false);
        patient.setScore(23);

        Patient patient2 = new Patient(null,"Yassine",new Date(),false,23);

        Patient patient3 = Patient.builder().id(null).nom("Ahmed").malade(false).dateNaissance(new Date()).score(20).build();
        */
        patientRepository.save( new Patient(null,"Yassine",new Date(),false,123));
        patientRepository.save( new Patient(null,"Mohammed",new Date(),true,133));
        patientRepository.save( new Patient(null,"Hanane",new Date(),false,150));

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
