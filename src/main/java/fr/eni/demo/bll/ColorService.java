package fr.eni.demo.bll;

import java.util.List;

import fr.eni.demo.bo.Color;


public interface ColorService {

	List<Color> getAllColor();
	
	Color findColorByNameAndId(String name,int id);
}
