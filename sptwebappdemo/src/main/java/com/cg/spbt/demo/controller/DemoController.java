package com.cg.spbt.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // ~component
@ResponseBody // indicating that return value will be included to the response body straightly he will sent to the cilent 
public class DemoController
{
	//@RequestMapping(value = "/wish",method=RequestMethod.GET)
	@GetMapping(value="/wish")
	public String sayHello()
	{
		return "hello world";
	}
	//@RequestMapping(value = "/getweatherRepo",method=RequestMethod.GET)
	@GetMapping(value = "/weatherRepo")
	public String getWeatherReport()
	{
		return "sunny , 38 degree celcius";
		
	}

}


//http://localhost:8080/wish
//@RequestMapping(method=REquestMethod.GET)    @getMapping
//@REquestMapping(method= RequestMethod.PUT)   @