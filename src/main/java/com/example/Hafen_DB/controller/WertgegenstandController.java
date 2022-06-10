package com.example.Hafen_DB.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hafen_DB.models.Wertgegenstand;

@Controller
public class WertgegenstandController {

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
        return "index.html";
    }

    @RequestMapping("/delwertgegenstand")
    public String delwertgegenstand(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "wertgegenstaende") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        dbwc.delWertgegenstand(id);
        return "redirect:/wertgegenstaende";
    }

    @RequestMapping("/changewertgegenstand")
    public String changewertgegenstand(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changewertgegenstand") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        model.addAttribute("wertgegenstand", dbwc.getWertgegenstand(id));
        model.addAttribute("wertgegenstandId", id);
        
       // model.addAttribute("wertgegenstaende_name", getWertgegenstaendeName());

        model.addAttribute("activePage", "wertgegenstandUpdate");
        return "index.html";
    }

    @RequestMapping("/updateWertgegenstand")
    public String updatewertgegenstand(@RequestParam(name="wertgegenstandId", required = true, defaultValue = "null") int wertgegenstandId, @RequestParam(name="wertgegenstandName", required = true, defaultValue = "null") String wertgegenstandName, @RequestParam(name="activePage", required = false, defaultValue = "wertgegenstand") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        dbwc.updateWertgegenstand(wertgegenstandId, wertgegenstandName);
        return "redirect:/wertgegenstaende";
    }

    @RequestMapping("/addWertgegenstand")
    public String addWertgegenstand(@RequestParam(name="wertgegenstandName", required = true, defaultValue = "null") String wertgegenstandName,@RequestParam(name="activePage", required = false, defaultValue = "wertgegenstaende") String activePage, Model model){
        DBWertgegenstandController dbwc = new DBWertgegenstandController();
        dbwc.addNeWertgegenstand(wertgegenstandName);
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
