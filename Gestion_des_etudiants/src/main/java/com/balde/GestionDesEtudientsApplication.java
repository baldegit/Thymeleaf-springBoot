package com.balde;

import java.text.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.balde.beans.Etudiant;
import com.balde.dao.EtudiantRepository;

@SpringBootApplication
public class GestionDesEtudientsApplication implements CommandLineRunner{
	
	@Autowired
	EtudiantRepository etudiantRepo;

	public static void main(String[] args) {
		SpringApplication.run(GestionDesEtudientsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("BALDE", df.parse("1988-11-10"), "mazokou18@yahoo.fr", "balde.jpg"));
//		this.etudiantRepo.save(new Etudiant("DIALLO", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("SOW", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
//		this.etudiantRepo.save(new Etudiant("CAMARA", df.parse("1981-01-01"), "mazokou20@yahoo.fr", "camara.jpg"));
//		this.etudiantRepo.save(new Etudiant("SYLLA", df.parse("1987-5-13"), "mazokou18@yahoo.fr", "diallo.jpg"));
//		this.etudiantRepo.save(new Etudiant("KABA", df.parse("1948-1-5"), "mazokou19@yahoo.fr", "sow.jpg"));
		
		Page<Etudiant> etds = this.etudiantRepo.findAll(PageRequest.of(0, 4));
		
		
		
		etds.forEach(e -> {
			System.out.println(" - "+e.getNom()+" - ");
		});
	}
}
