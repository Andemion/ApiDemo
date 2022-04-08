package fr.eni.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.demo.bll.BottleService;
import fr.eni.demo.bll.ColorService;
import fr.eni.demo.bll.RegionService;
import fr.eni.demo.bo.Bottle;
import fr.eni.demo.bo.Color;
import fr.eni.demo.bo.Region;

@RestController
@RequestMapping("/bottle")
public class BottleController {
	
	private BottleService bs;
	private RegionService rs;
	private ColorService cs;
	
	@Autowired
	public BottleController(BottleService bs, RegionService rs, ColorService cs) {
		this.bs = bs;
		this.rs = rs;
		this.cs = cs;
	}
	
	@GetMapping
	public List<Bottle> findAll(){
		return bs.getAllBottles();
	}
	
	@GetMapping("/{id}")
	public Bottle findById(@PathVariable int id) {
		
		Bottle bottle = bs.findBottleById(id);

		return bottle;
	}
	
	@PostMapping
	public String addBottle(@RequestBody Bottle bottle) {
		
		String message = null;
		bottle.setId(0);
		Region result = rs.findRegionByNameAndId(bottle.getRegion().getName(),bottle.getRegion().getId());
		Color result2 = cs.findColorByNameAndId(bottle.getColor().getName(), bottle.getColor().getId());
		if(result != null || result2 != null) {
			message = bs.saveBottle(bottle);
			return message;
		}	
		return result+" or "+result2+" incorrect information given";
	}
	
	@PutMapping
	public String putBottle(@RequestBody Bottle bottle) {
		
		String message = bs.saveBottle(bottle);
		
		return message;
	}
	
	@DeleteMapping("/{id}")
	public String deleteBottle(@PathVariable int id) {
		
		String message = bs.deleteBottle(id);
		
		return message;
	}
	
	
}
