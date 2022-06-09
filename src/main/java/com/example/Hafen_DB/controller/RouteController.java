package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
    

@Controller
public class RouteController extends DBController {
        
    ArrayList<Route> routen;

    public RouteController() {
        setRouten(new ArrayList<Route>());

        loadRoutenFromDB();
    }

    //Lädt aktuelle Frischwaren aus der Datenbank und wirft bei bedarf eine SQL-Exeption aus
    private void loadRoutenFromDB(){
        DBRoutenController dbrc = new DBRoutenController();
        setRouten(dbrc.getAllRouten());
        System.out.println("Sammelt Routen ein");
    }

    @GetMapping("/routen")
    public String routen(@RequestParam(name = "activePage", required = false, defaultValue = "routen") String activePage, Model model){
        loadRoutenFromDB();

        model.addAttribute("activePage", "routen");
        model.addAttribute("routen", getRouten());
        
        //Städte laden
        DBStadtController dbsc = new DBStadtController();
        model.addAttribute("staedte", dbsc.getAllStadt());

        //Check ob das Mapping läuft: tut es!
        System.out.println("Mapping?");
        return "index.html";
    }

    @RequestMapping("/delroute")
    public String delroute(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "route") String activePage, Model model){
        DBRoutenController dbrc = new DBRoutenController();
        dbrc.delRoute(id);
        return "redirect:/routen";
    }

   
    @RequestMapping("/changeroute")
    public String changeroute(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changeroute") String activePage, Model model){
        // Route zur Bearbeitung laden
        DBRoutenController dbrc = new DBRoutenController();
        model.addAttribute("route", dbrc.getRoute(id));
        model.addAttribute("routeId", id);

        //Mögliche Städte hier hinzufügen
        DBStadtController dbsc = new DBStadtController();
        model.addAttribute("staedte", dbsc.getAllStadt());

        model.addAttribute("activePage", "routeUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updateroute")
    public String updateroute(@RequestParam(name="routeId", required = true, defaultValue = "null") int routeId, @RequestParam(name = "start", required = true, defaultValue = "null") int startId, @RequestParam(name="ziel", required = true, defaultValue = "null") int zielId, @RequestParam(name="fahrtdauer", required = true, defaultValue = "null") int fahrtdauer, @RequestParam(name="entfernung", required = true, defaultValue = "null") int entfernung, @RequestParam(name="activePage", required = false, defaultValue = "routen") String activePage, Model model){
        DBRoutenController dbrc = new DBRoutenController();
        dbrc.updateRoute(routeId, entfernung, fahrtdauer, startId, zielId);
        return "redirect:/routen";
    }


    public void setRouten(ArrayList<Route> routen) {
        this.routen = routen;
    }
    public ArrayList<Route> getRouten() {
        return routen;
    }

}