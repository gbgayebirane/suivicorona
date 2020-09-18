package com.gb;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gb.dao.ICas;
import com.gb.dao.ICasConfirme;
import com.gb.dao.ICasSuspect;

import com.gb.entities.Cas;
import com.gb.entities.CasConfirme;
import com.gb.entities.CasSuspect;

@SpringBootApplication
public class SuivicoronaApplication {

	 @Autowired
	 private ICas icas;
	 @Autowired
	 private ICasSuspect icasSuspect;
	 
	 @Autowired
	 private ICasConfirme icasConfirme;
	 
	public static void main(String[] args) {
		//SpringApplication.run(SuivicoronaApplication.class, args);
		
        ApplicationContext ctx= SpringApplication.run(SuivicoronaApplication.class, args);
		
		ICas icas =ctx.getBean(ICas.class);
		  
		Cas c=new Cas();
		 c.setNom("ndiaye");
		 c.setPrenom("moussa");
		 c.setAdresse("keurmassar");
		 
		 icas.save(c);
		 
		 ICasSuspect icasSuspect =ctx.getBean(ICasSuspect.class);
		 CasSuspect cs= new CasSuspect(2, "fall", "amadou", "mbour", new Date());
		 icasSuspect.save(cs);
		 
		 ICasConfirme icasConfirme =ctx.getBean(ICasConfirme.class);
		 CasConfirme cc=new CasConfirme(3, "ndour", "lamine", "parcelle", "maux de tete");
		
		 icasConfirme.save(cc);
		 
		 
	}

}
