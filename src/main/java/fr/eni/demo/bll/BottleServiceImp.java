package fr.eni.demo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.demo.bo.Bottle;
import fr.eni.demo.dal.BottleRepository;
import fr.eni.demo.execption.BusinessException;
import fr.eni.demo.manager.DataManager;

@Service
public class BottleServiceImp implements BottleService {
	
	private BottleRepository bottleRepository;
	
	@Autowired
	public BottleServiceImp(BottleRepository bottleRepository) {
		this.bottleRepository = bottleRepository;
	}

	@Override
	public List<Bottle> getAllBottles() {
		
		return bottleRepository.findAll();
	}

	@Override
	public Bottle findBottleById(int id) {
		Optional<Bottle> result = bottleRepository.findById(id);
		
		if (result.isPresent()) {
			return result.get();
		}
		throw new RuntimeException("Bottle not found with the id = " + id);
	}

	@Override
	public String saveBottle(Bottle bottle) {
		
		if(bottle.getId() == 0) {
			BusinessException be = new BusinessException();
			DataManager da = new DataManager();
			String name = "name";
			
			da.validateString(bottle.getName(), name, be);
			//da.validateRegionNameId(bottle.getRegion().getName(),bottle.getRegion().getId(), be);
			//da.validateColorNameId(bottle.getColor().getName(), bottle.getColor().getId(), be);
			da.validateVintage(bottle.getVintage(), be);
			da.validateInt(bottle.getQuantity(), be);
			
			if(be.isErrors()) {		
				throw be;
			}
			bottleRepository.save(bottle);
			
			return "Your bottle has been saved";
		}else {
			Optional<Bottle> result = bottleRepository.findById(bottle.getId());
			if (result.isPresent()) {
				Bottle b = result.get();
				b.setName(bottle.getName());
				b.setRegion(bottle.getRegion());
				b.setColor(bottle.getColor());
				b.setSparking(bottle.isSparkling());
				b.setVintage(bottle.getVintage());
				b.setQuantity(bottle.getQuantity());
				
				bottleRepository.save(b);
				
				return "The bottle "+bottle.getId()+" has been updated";
			}else {
				throw new RuntimeException("Bottle not found with the id = " + bottle.getId());
			}
		}
	}

	@Override
	public String deleteBottle(int id) {
		Optional<Bottle> result = bottleRepository.findById(id);
		
		if (result.isPresent()) {
			Bottle bottle = result.get();
			bottleRepository.delete(bottle);
			return "The bottle "+id+" has been deleted";
		}
		throw new RuntimeException("Bottle not found with the id = " + id);
	}

	@Override
	public List<Bottle> findAllByOrderByNameAsc() {
		
		return bottleRepository.findAllByOrderByNameAsc();
	}

	@Override
	public List<Bottle> findAllByOrderByNameDesc() {
		
		return bottleRepository.findAllByOrderByNameDesc();
	}

	@Override
	public List<Bottle> findAllByOrderByVintageAsc() {
		
		return bottleRepository.findAllByOrderByVintageAsc();
	}

	@Override
	public List<Bottle> findAllByOrderByVintageDesc() {
		
		return bottleRepository.findAllByOrderByVintageDesc();
	}

	@Override
	public List<Bottle> findAllByOrderBySparklingAsc() {
		
		return bottleRepository.findAllByOrderBySparklingAsc();
	}

	@Override
	public List<Bottle> findAllByOrderBySparklingDesc() {
		
		return bottleRepository.findAllByOrderBySparklingDesc();
	}

	@Override
	public List<Bottle> findAllByOrderByQuantityAsc() {
		
		return bottleRepository.findAllByOrderByQuantityAsc();
	}

	@Override
	public List<Bottle> findAllByOrderByQuantityDesc() {
		
		return bottleRepository.findAllByOrderByQuantityDesc();
	}

	@Override
	public List<Bottle> findAllByOrderByColorAsc() {
		
		return bottleRepository.findAllByOrderByColorAsc();
	}

	@Override
	public List<Bottle> findAllByOrderByColorDesc() {
		
		return bottleRepository.findAllByOrderByColorDesc();
	}

	@Override
	public List<Bottle> findAllByOrderByRegionAsc() {
		
		return bottleRepository.findAllByOrderByRegionAsc();
	}

	@Override
	public List<Bottle> findAllByOrderByRegionDesc() {
		
		return bottleRepository.findAllByOrderByRegionDesc();
	}
}
