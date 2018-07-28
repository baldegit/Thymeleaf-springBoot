package com.balde.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GestionFiles {
	
	private String fileName;
	//sert a injecter un propriete declaré dans app.prop
	@Value("${images.dir:}")
	private String imagesDir;

	public GestionFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void saveFile(MultipartFile file,Long idE) throws Exception{

		try {

			//on verifie si l'existance du fichier
			if(file.isEmpty())
				throw new Exception("Failed to store empty file \" + nomFichier");
		
			//on recupere le nom du fichier
			this.fileName = file.getOriginalFilename();
			//verification de securite pour ne pas stocker les liens relatif
			if(this.fileName.contains(".."))
				throw new Exception("Cannot store file with relative path outside current directory "
						+ this.fileName);
		
			//on enregistre le fichier dans un dossier (de preference pas dans static)
			//file.transferTo(new File(System.getProperty("user.home")+"/test_img/"+this.fileName));
			System.out.println("####### "+imagesDir+this.fileName);
			file.transferTo(new File(this.imagesDir+idE));
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public File getPhotoById(Long id) {
		return new File(this.imagesDir+id);
	}
	
	
}
