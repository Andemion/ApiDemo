package fr.eni.demo.bll;

import java.util.List;

import fr.eni.demo.bo.Bottle;


public interface BottleService {
	
	List<Bottle> getAllBottles();
	
	Bottle findBottleById(int id);
	
	String saveBottle(Bottle bottle);
	
	String deleteBottle(int id);
	
	List<Bottle> findAllByOrderByNameAsc();
	List<Bottle> findAllByOrderByNameDesc();
	
	
	List<Bottle> findAllByOrderByVintageAsc();
	List<Bottle> findAllByOrderByVintageDesc();
	
	
	List<Bottle> findAllByOrderBySparklingAsc();
	List<Bottle> findAllByOrderBySparklingDesc();
	
	
	List<Bottle> findAllByOrderByQuantityAsc();
	List<Bottle> findAllByOrderByQuantityDesc();
	
	
	List<Bottle> findAllByOrderByColorAsc();
	List<Bottle> findAllByOrderByColorDesc();
	
	
	List<Bottle> findAllByOrderByRegionAsc();
	List<Bottle> findAllByOrderByRegionDesc();
}
