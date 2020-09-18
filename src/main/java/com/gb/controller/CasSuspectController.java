package com.gb.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gb.dao.ICas;
import com.gb.dao.ICasSuspect;
import com.gb.entities.Cas;
import com.gb.entities.CasSuspect;

@Controller
public class CasSuspectController {
	@Autowired
	private ICasSuspect isus;
	@Autowired
	private ICas icas;
	 @RequestMapping(value="/CasSuspect/liste")
	public String liste(ModelMap modelmap)
	{
		
		List<CasSuspect> cas=isus.findAll();
		modelmap.put("liste_sus",  cas);
		 
		return "cassuspect/liste";
	}
	 @RequestMapping(value="/CasSuspect/add")
	 public String add(int id, String date, int cas)
		{
			
			CasSuspect cs=new CasSuspect();
			
			//Cas c=icas.getOne(cas);
			//cs.setCas(c);;
			
			try {
				cs.setDateConfirmation((new SimpleDateFormat("yyyy-MM-dd").parse(date)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try 
			{
				isus.save(cs);
				isus.flush();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 return  "redirect:/CasSuspect/liste";
		}
	 @RequestMapping(value="/CasSuspect/delete",method=RequestMethod.GET)
		public String delete(int id)
		{
			try
			{
				isus.delete(isus.getOne(id));
				isus.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return  "redirect:/CasSuspect/liste";
		}	
		@RequestMapping(value="/CasSuspect/edit" , method=RequestMethod.GET)
		public String edit(int id ,ModelMap  model)
		{
			
			
			 model.put("liste_sus",isus.getOne(id));
			 
			return "cassuspect/liste";
			
		}
}
