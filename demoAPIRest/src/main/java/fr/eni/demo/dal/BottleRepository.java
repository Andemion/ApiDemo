package fr.eni.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.demo.bo.Bottle;


public interface BottleRepository extends JpaRepository<Bottle, Integer> {
	
	
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
