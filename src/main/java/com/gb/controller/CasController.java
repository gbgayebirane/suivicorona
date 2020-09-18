package com.gb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gb.dao.ICas;
import com.gb.entities.Cas;

@Controller
public class CasController {
	@Autowired
	private ICas icas;
	
	 @RequestMapping(value="/Cas/liste")
	public String liste(ModelMap modelmap)
	{
		
		List<Cas> cas=icas.findAll();
		modelmap.put("liste_cas",  cas);
		 
		return "cas/liste";
	}
	 @RequestMapping(value="/Cas/add")
	 public String add(int id, String nom, String prenom, String adresse)
		{
			
			Cas c= new Cas();
			c.setNom(nom);
			c.setPrenom(prenom);
			c.setAdresse(adresse);
			try 
			{
				icas.save(c);
				icas.flush();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 return  "redirect:/Cas/liste";
		}
	 @RequestMapping(value="/Cas/delete",method=RequestMethod.GET)
		public String delete(int id)
		{
			try
			{
				icas.delete(icas.getOne(id));
				icas.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  "redirect:/Cas/liste";
		}	
		@RequestMapping(value="/Cas/edit" , method=RequestMethod.GET)
		public String edit(int id ,ModelMap  model)
		{
			
			
			 model.put("liste_cas",icas.getOne(id));
			 
			return "cas/liste";
			
		}
}
