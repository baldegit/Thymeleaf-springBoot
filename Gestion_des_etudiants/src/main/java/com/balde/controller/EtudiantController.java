package com.balde.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.balde.beans.Etudiant;
import com.balde.dao.EtudiantRepository;
import com.balde.service.GestionFiles;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@Autowired
	private EtudiantRepository etutiantRepo;
	
	@Autowired
	private GestionFiles gf;
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		//recuperation des etudiants par page
		Page<Etudiant> etds = this.etutiantRepo.chercherEtudiants(mc,PageRequest.of(page, 4));
		//on crée untableau qui va cotenir les numerso de page.
		int[] pages = new int[etds.getTotalPages()];
		//on charge les numeros de page
		for(int i = 0; i < etds.getTotalPages(); i++) pages[i] = i;
		//on envoie les variable à la vue
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		model.addAttribute("pageEtudiants", etds);
		
		
		return "etudiants";
	}
	
	/*
	 * cette methode fait un mapage entre un objet(Etudiant)
	 * du controller et le formulaire correspondant)
	 */
	@GetMapping("/form")
	public String formEtudiant(Model model) {
		//le contenu de l'objet etudiant sera afficher dans le form
		model.addAttribute("etudiant",new Etudiant());
		return "formEtudiant";
	}
	
	/*
	 * les champ de l'objet etudiant doivent etre identique a ceux present dans le form.
	 * dans ce cas, la transmission de l'objet etudiant dans la methode formEtudiant
	 * assure la compatibilité
	 * */
	@PostMapping("/saveEtudiant")
	public String Save(Model model, @Valid Etudiant etudiant, BindingResult result,
			@RequestParam(name="picture") MultipartFile file,RedirectAttributes red) throws Exception {
		
		if(result.hasErrors()) {
			return "formEtudiant";
		}
		
		if(!file.isEmpty())
			etudiant.setPhoto(file.getOriginalFilename());
		
		this.etutiantRepo.saveAndFlush(etudiant);
		
		
		gf.saveFile(file,etudiant.getId());
		
		
		return "redirect:/etudiant/index";
	}
	
	@GetMapping("/supprimer")
	public String supprimer(Long id) {
		this.etutiantRepo.deleteById(id);
		
		return "redirect:/etudiant/index";
	}
	
	@GetMapping("/edit")
	public String edite(Long id, Model model) {
		Etudiant et = this.etutiantRepo.getOne(id);
		model.addAttribute("etudiant",et);
		return "formEtudiant";
	}
	
	@GetMapping(value="/getPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody()
	public byte[] getPhoto(Long idEt) {
		File f = gf.getPhotoById(idEt);
		
		try {
			return IOUtils.toByteArray(new FileInputStream(f));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//fin 45

}
