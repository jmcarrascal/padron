package ar.com.jmc.webplatform.base.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.jmc.webplatform.base.dao.impl.DatosEntrega;
import ar.com.jmc.webplatform.base.model.ExcelData;
import ar.com.jmc.webplatform.base.model.Padron;
import ar.com.jmc.webplatform.base.model.message.JsonResult;
import ar.com.jmc.webplatform.base.services.I18NService;

import com.google.gson.Gson;

@Controller
@Transactional
public class PadronController {
	
	
	
	
	@Autowired
	private I18NService i18nService;
	
	
	//@PreAuthorize("hasRole('avanzado')")
	@RequestMapping(value="/importPadron", method=RequestMethod.POST)
	public @ResponseBody JsonResult importPadron(HttpServletRequest request) {
		
		String json = "";
		try {
			json = IOUtils.toString( request.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		Gson gson = new Gson();
		 
		 ExcelData data = gson.fromJson(json, ExcelData.class);
		 
		 List<Padron> listPadron = new ArrayList<Padron>();
		 
		 for(String[] registro : data.getData()){
			if (registro[0] != null){ 
				Padron padron = new Padron();
				padron.setCuit( registro[0]);
				try{
					padron.setAlicuota(Double.parseDouble(registro[1]));
				}catch(NumberFormatException ne){
					return new JsonResult(false, "El registro con el cuit " + registro[1] + " contiene el valor de la alicuota incorrecto. ");
				}
				listPadron.add(padron);
			}
		 }
		 
		 for(Padron p: listPadron){
			 System.out.println(p.toString());
		 }
		 
		 DatosEntrega de = new DatosEntrega();
		 
		 de.updatePadron(listPadron);
		
		return new JsonResult(true, "OK");
		
	}
	
	
	
	
	
}
