

package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

@Controller
public class RouteController extends DBController {
        
    PersonController pc;

    
    

    private ArrayList<String> getStaedte(){
        ArrayList<String> staedte = new ArrayList<>();

        staedte.add("Hamburg");
        staedte.add("Sidney");
        staedte.add("New York");
        staedte.add("Bremen");
        staedte.add("Dubai");
        staedte.add("Rotterdam");

        return staedte;
    }

    //Holt alle Personen aus der Datenbank
    /*
    private ArrayList<Person> getPersonen() {
        ArrayList<Person> personen = new ArrayList<>();
        
        DBController db= new DBController();
        personen = db.getAllPersonen();

        return personen;
    }
    */
    
    @GetMapping("/routen")
    public String routen(@RequestParam(name = "activePage", required = false, defaultValue = "routen") String activePage, Model model){
        model.addAttribute("activePage", "routen");
//        model.addAttribute("routen", getAllRouten());
        
        //Städte laden
        model.addAttribute("staedte", getStaedte());

        return "index.html";
    }

    @RequestMapping("/delroute")
    public String delroute(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "route") String activePage, Model model){
//        getAllRouten().remove(id);
        return "redirect:/routen";
    }

   
    @RequestMapping("/changeroute")
    public String changeroute(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changeroute") String activePage, Model model){
        // Route zur Bearbeitung laden
//        model.addAttribute("route", getAllRouten().get(id));
        model.addAttribute("routeid", id);

        //Mögliche Städte hier hinzufügen
        model.addAttribute("staedte", getStaedte());

        model.addAttribute("activePage", "routeUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updateroute")
    public String updateroute(@RequestParam(name="routeId", required = true, defaultValue = "null") int routeId, @RequestParam(name = "routeStart", required = true, defaultValue = "null") String start, @RequestParam(name="ziel", required = true, defaultValue = "null") String ziel, @RequestParam(name="fahrtdauer", required = true, defaultValue = "null") int fahrtdauer, @RequestParam(name="entfernung", required = true, defaultValue = "null") int entfernung, @RequestParam(name="activePage", required = false, defaultValue = "routen") String activePage, Model model){
//        getAllRouten().get(routeId).setStart(start);
//        getAllRouten().get(routeId).setZiel(ziel);
//        getAllRouten().get(routeId).setFahrtdauer(fahrtdauer);
//        getAllRouten().get(routeId).setEntfernung(entfernung);
        return "redirect:/routen";
    }



}