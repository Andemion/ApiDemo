package fr.eni.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.demo.bo.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
	
	Region findRegionByNameAndId(String name , int id);

}
