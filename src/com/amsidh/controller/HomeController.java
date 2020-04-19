package com.amsidh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.amsidh.services.FlightService;

public class HomeController extends AbstractController {
    
    private static final int FIVE_MINUTES = 5*60;
    private FlightService flights;
    
    public HomeController() {
        setSupportedMethods(new String[]{METHOD_GET});
        setCacheSeconds(FIVE_MINUTES);
        System.out.println("Inside HomeController constructor");
    }
    
    public void setFlightService(FlightService flightService) {
        this.flights = flightService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req,
            HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("homePage");
        mav.addObject("specials", flights.getSpecialDeals());
        System.out.println("Inside handleRequestInternal() Method");
        return mav;
    }

}
