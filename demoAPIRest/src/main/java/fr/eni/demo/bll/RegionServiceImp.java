package fr.eni.demo.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.demo.bo.Region;
import fr.eni.demo.dal.RegionRepository;

@Service
public class RegionServiceImp implements RegionService {
	
	private RegionRepository rr;
	
	@Autowired
	public RegionServiceImp(RegionRepository rr) {
		this.rr = rr;
	}

	@Override
	public List<Region> getAllRegion() {
		
		return rr.findAll();
	}

	@Override
	public Region findRegionByNameAndId(String name,int id) {
		
		Region result = rr.findRegionByNameAndId(name,id);
		
		if (result != null) {
			return result;
		}
		throw new RuntimeException("The id = " +id+" with the name ="+name+" doesn't correspond to a region");
	}

}
