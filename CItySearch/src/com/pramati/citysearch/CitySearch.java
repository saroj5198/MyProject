package com.pramati.citysearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pramati.dao.CityDAOImpl;



/**
 * Api for searching city name Based entered text.
 * requestParam
 * @author Saroj Goudo
 *
 */
@Controller
public class CitySearch {

	@Autowired
	CityDAOImpl dao;
	
	/**
	 * Api for handling city name search.
	 * @param start
	 * 			Text entered for city search.
	 * @param atmost
	 * 			Limit for suggested city name.
	 * @return
	 */
	@RequestMapping(value = "/suggest_cities", method = RequestMethod.GET,produces = "text/plain")
	@ResponseBody
	public String home(@RequestParam("start")String start,@RequestParam("atmost")int atmost) {
		System.out.println("Request received for " + start);
		return dao.getCityName(start, atmost);

		
	}

	
}
