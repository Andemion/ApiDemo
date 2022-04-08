package fr.eni.demo.bll;

import java.util.List;

import fr.eni.demo.bo.Region;


public interface RegionService {

	List<Region> getAllRegion();
	
	Region findRegionByNameAndId(String name,int id);
}
