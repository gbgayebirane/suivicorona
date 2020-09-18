package com.gb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gb.dao.ICas;
import com.gb.dao.ICasConfirme;
import com.gb.entities.Cas;
import com.gb.entities.CasConfirme;

@Controller
public class CasConfirmeController {
	@Autowired
	private ICasConfirme iconf;
	@Autowired
	private ICas icas;
	 @RequestMapping(value="/CasConfirme/liste")
	public String liste(ModelMap modelmap)
	{
		
		List<CasConfirme> cas=iconf.findAll();
		modelmap.put("liste_conf",  cas);
		 
		return "casconfirme/liste";
	}
	 @RequestMapping(value="/CasConfirme/add")
	 public String add(int id, String symptome)
		{
			
			CasConfirme cc=new CasConfirme();
			cc.setSymptome(symptome);
			//Cas c=icas.getOne(cas);
			//cc.setCas(c);
			try 
			{
				iconf.save(cc);
				iconf.flush();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 return  "redirect:/CasConfirme/liste";
		}
	 @RequestMapping(value="/CasConfirme/delete",method=RequestMethod.GET)
		public String delete(int id)
		{
			try
			{
				iconf.delete(iconf.getOne(id));
				iconf.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  "redirect:/CasConfirme/liste";
		}	
		@RequestMapping(value="/CasConfirme/edit" , method=RequestMethod.GET)
		public String edit(int id ,ModelMap  model)
		{
			
			
			 model.put("liste_conf",iconf.getOne(id));
			 
			return "casconfirme/liste";
			
		}
}
