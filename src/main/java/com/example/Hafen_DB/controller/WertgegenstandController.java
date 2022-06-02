package com.example.Hafen_DB.controller;

import java.util.ArrayList;

import com.example.Hafen_DB.models.Wertgegenstand;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WertgegenstandController {

    //ArrayList-Deklaration
    ArrayList<Wertgegenstand> wertgegenstaende;

    public WertgegenstandController(){
        setWertgegenstand(new ArrayList<Wertgegenstand>());
        loadWertgegenstaendeFromDB();
    }

    // Lädt aktuelle Wertgegenstaende aus der Datenbank und wirft bei Bedarf eine SQL-Exception
    private void loadWertgegenstaendeFromDB(){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        setWertgegenstand(dbwc.getAllWertgegenstaende());
    }

    /*
    //Holt alle wertgegenstaende_name aus der DB
    private ArrayList<Passagier> getPassagiere(){
        ArrayList<Passagier> passagiere = new ArrayList<>();
        DBController db = new DBController();
        passagiere = db.getAllPassagiere();
        return passagiere;
    }
    */
    
    @GetMapping("/wertgegenstaende")
    public String wertgegenstaende(@RequestParam(name="activePage", required = false, defaultValue = "wertgegenstaende") String activePage, Model model){
        loadWertgegenstaendeFromDB();
        model.addAttribute("activePage", "wertgegenstaende");
        model.addAttribute("wertgegenstaende", getWertgegenstaende());
        
        // Standort für einen Bahnhof holen
       //model.addAttribute("wertgegenstaende_name", getWertgegenstaendeName();

        return "index.html";
    }

    @RequestMapping("/delwertgegenstand")
    public String delwertgegenstand(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "wertgegenstaende") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        dbwc.delWertgegenstand(id);
        return "redirect:/wertgegenstaende";
    }

    @RequestMapping("/changeWertgegenstand")
    public String changeWertgegenstand(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changeWertgegenstand") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        model.addAttribute("wertgegenstand", dbwc.getWertgegenstand(id));
        model.addAttribute("wertgegenstaendeID", id);
        
       // model.addAttribute("wertgegenstaende_name", getWertgegenstaendeName());

        model.addAttribute("activePage", "wertgegenstaendeUpdate");
        return "index.html";
    }

    @RequestMapping("/updateWertgegenstand")
    public String updateWertgegenstand(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="wertgegenstaende_name", required = true, defaultValue = "null") String wertgegenstaende_name, @RequestParam(name="activePage", required = false, defaultValue = "updateWertgegenstand") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        dbwc.updateWertgegenstand(id, wertgegenstaende_name);
        return "redirect:/wertgegenstaende";
    }

    @RequestMapping("/addWertgegenstand")
    public String addWertgegenstand(@RequestParam(name="wertgegenstaende_name", required = true, defaultValue = "null") String wertgegenstaende_name,@RequestParam(name="activePage", required = false, defaultValue = "wertgegenstaende") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        dbwc.addNeWertgegenstand(wertgegenstaende_name);
        return "redirect:/wertgegenstaende";
    }

    //Setter und Getter
    public void setWertgegenstand(ArrayList<Wertgegenstand> wertgegenstaende) {
        this.wertgegenstaende = wertgegenstaende;
    }
    public ArrayList<Wertgegenstand> getWertgegenstaende() {
        return wertgegenstaende;
    }
}
