package fr.eni.demo.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.eni.demo.bo.Color;


public interface ColorRepository extends JpaRepository<Color, Integer> {
	
	Optional<Color> findColorByNameAndId(String name , int id);
}
