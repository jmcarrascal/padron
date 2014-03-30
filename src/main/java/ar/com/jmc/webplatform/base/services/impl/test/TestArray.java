package ar.com.jmc.webplatform.base.services.impl.test;

import java.util.ArrayList;
import java.util.List;

import ar.com.jmc.webplatform.base.model.ExcelData;
import ar.com.jmc.webplatform.base.model.Padron;

import com.google.gson.Gson;

public class TestArray {

	public static void main(String[] args) {
		String json = "{\"data\":[[\"30-12345678-3\",\"123\",\"\"],[\"30-345634556-3\",\"456\",null],[null,null,null]]}";
		
		 Gson gson = new Gson();
		 
		 ExcelData data = gson.fromJson(json, ExcelData.class);
		 
		 List<Padron> listPadron = new ArrayList<Padron>();
		 
		 for(String[] registro : data.getData()){
			if (registro[0] != null){ 
				Padron padron = new Padron();
				padron.setCuit( registro[0]);
				padron.setAlicuota(Double.parseDouble(registro[1]));
				listPadron.add(padron);
			}
		 }
		 
		 for(Padron p: listPadron){
			 System.out.println(p.toString());
		 }
		
	}

}


