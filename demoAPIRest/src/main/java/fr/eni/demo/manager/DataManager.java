package fr.eni.demo.manager;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.demo.bll.BottleService;
import fr.eni.demo.bll.BottleServiceImp;
import fr.eni.demo.bll.ColorService;
import fr.eni.demo.bll.ColorServiceImp;
import fr.eni.demo.bll.RegionService;
import fr.eni.demo.bll.RegionServiceImp;
import fr.eni.demo.bo.Color;
import fr.eni.demo.bo.Region;
import fr.eni.demo.dal.BottleRepository;
import fr.eni.demo.dal.ColorRepository;
import fr.eni.demo.dal.RegionRepository;
import fr.eni.demo.execption.BusinessException;

@Service
public class DataManager {
	
	private BottleService bsi;
	private ColorService csi;
	private RegionService rsi;
	
	public DataManager() {
	}

	@Autowired
	public DataManager(BottleService bsi, ColorService csi, RegionService rsi) {
		this.bsi = bsi;
		this.csi = csi;
		this.rsi = rsi;
	}

	public void validateString(String data,String Key, BusinessException be) {
		if(data == null || data.isBlank() && (data.length() < 5 || data.length() > 50 )) {
			be.addError("the expression "+Key+" couldn't be blank or null and need to beetwen 5 and 50 caracter");
		}
	}
	
	public void validateInt(int data, BusinessException be) {
		if(data < 1 ) {
			be.addError("the expression "+data+" is not valid");
		}
	}
		
	public void validateVintage(String data, BusinessException be) {
		int year = LocalDate.now().getYear()+1;
		int dataI;
		try {
			 dataI = Integer.parseInt(data);
			 if(data == null || data.isBlank()|| data.length() > 4 || dataI > year || dataI < 1950 ) {
					be.addError("the expression "+data+" is not valid");
				}
		} catch (Exception e) {
			be.addError("the expression "+data+" is not valid");
		}
		
	}
	
	
	public void validateColorNameId(String name, int id, BusinessException be) {
			
			Color result = csi.findColorByNameAndId(name,id);
			
			if (result == null) {
				be.addError("The id = " +id+" with the name = "+name+" doesn't correspond to a color");
			}
			
		}
	
	public void validateRegionNameId(String name, int id, BusinessException be) {
		
		Region result = rsi.findRegionByNameAndId(name,id);
		
		if (result == null) {
			be.addError("The id = " +id+" with the name = "+name+" doesn't correspond to a region");
		}
		
	}
	
}
