package pl.tfkable.quality.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	

	@RequestMapping(value = "/")
	public String index() {
		return "app/index";
	}
}
