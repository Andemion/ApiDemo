package fr.eni.demo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.demo.bo.Color;
import fr.eni.demo.dal.ColorRepository;

@Service
public class ColorServiceImp implements ColorService {
	
	private ColorRepository cr;

	@Autowired
	public ColorServiceImp(ColorRepository cr) {
		this.cr = cr;
	}

	@Override
	public List<Color> getAllColor() {
		
		return cr.findAll();
	}

	@Override
	public Color findColorByNameAndId(String name, int id) {
		Optional<Color> result = cr.findColorByNameAndId(name,id);
		
		if (result.isPresent()) {
			return result.get();
		}
		throw new RuntimeException("The id = " +id+" with the name ="+name+" doesn't correspond to a color");
	}

}
