package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Schiff;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
    
import java.util.ArrayList;


@Controller
public class SchiffController extends DBController {
          
    ArrayList<Schiff> schiffe;
    
    public SchiffController() {
            setSchiffe(new ArrayList<Schiff>());
    
            loadSchiffFromDB();
        }
    
        //Lädt aktuelle Frischwaren aus der Datenbank und wirft bei bedarf eine SQL-Exeption aus
        private void loadSchiffFromDB(){
            DBSchiffeController dbsc = new DBSchiffeController();
            setSchiffe(dbsc.getAllSchiffe());
        }
    
        @GetMapping("/schiffe")
        public String schiffe(@RequestParam(name = "activePage", required = false, defaultValue = "schiffe") String activePage, Model model){
            loadSchiffFromDB();
    
            model.addAttribute("activePage", "schiffe");
            model.addAttribute("schiffe", getSchiffe());
            
        //Hier werden dann Kapitäne geladen, muss aber erstmal eingebaut werden
        //DBStadtController dbsc = new DBStadtController();
        //model.addAttribute("staedte", dbsc.getAllStadt());
    
            return "index.html";
        }
    
        @RequestMapping("/delschiffe")
        public String delschiffe(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "schiff") String activePage, Model model){
            DBSchiffeController dbsc = new DBSchiffeController();
            dbsc.delSchiff(id);
            return "redirect:/schiffe";
        }
    
       
        @RequestMapping("/changeschiff")
        public String changeschiff(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changeschiff") String activePage, Model model){
            // Route zur Bearbeitung laden
            DBSchiffeController dbsc = new DBSchiffeController();
            model.addAttribute("schiff", dbsc.getSchiff(id));
            model.addAttribute("schiffId", id);
    
        //Hier läuft das Gleiche mit den Kapitänen evenetuell
        //DBStadtController dbsc = new DBStadtController();
        //model.addAttribute("staedte", dbsc.getAllStadt());
    
            model.addAttribute("activePage", "schiffUpdate");
            return "index.html";
        }
        
        @RequestMapping("/updateschiff")
        public String updateschiff(@RequestParam(name="schiffId", required = true, defaultValue = "null") int schiffId, @RequestParam(name="schiff_name", required = true, defaultValue = "null") String schiff_name, @RequestParam(name="kapitaen", required = true, defaultValue = "null") String kapitaen, @RequestParam(name="activePage", required = false, defaultValue = "schiffe") String activePage, Model model){
            DBSchiffeController dbsc = new DBSchiffeController();
            dbsc.updateSchiff(schiffId, schiff_name, kapitaen);
            return "redirect:/schiffe";
        }
    
    public ArrayList<Schiff> getSchiffe() {
        return schiffe;
    }
    public void setSchiffe(ArrayList<Schiff> schiffe) {
        this.schiffe = schiffe;
    }
}