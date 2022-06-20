package com.example.Hafen_DB.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hafen_DB.models.Kapitaen;

@Controller
public class KapitaenController extends DBController{
    
    ArrayList<Kapitaen> kapitaene;

    public KapitaenController() {
        setKapitaene(new ArrayList<Kapitaen>());

        loadKapitaenFromDB();
    }

    private void loadKapitaenFromDB(){
        DBKapitaenController dbkc = new DBKapitaenController();
        setKapitaene(dbkc.getAllKapitaene());
    }

    /*@GetMapping("/kapitaene")
    public String kapitaene(@RequestParam(name="activePage", required = false, defaultValue = "kapitaene") String activePage, Model model) {
        loadKapitaenFromDB();
        
        model.addAttribute("activePage", "kapitaene");
        model.addAttribute("kapitaene", getKapitaene());
        ;

        DBPersonController dbpc = new DBPersonController();
        model.addAttribute("personen", dbpc.getAllPerson());
    
        return "index.html";
    }

    @RequestMapping("/changekapitaen")
    public String changekapitaen(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changekapitaen") String activePage, Model model){
        // Frischware zur Bearbeitung laden
        DBKapitaenController dbkc = new DBKapitaenController();
        model.addAttribute("kapitaen", dbkc.getKapitaen(id));
        model.addAttribute("kapitaenId", id);

        DBPersonController dbpc = new DBPersonController();
        model.addAttribute("personen", dbpc.getAllPerson());

        model.addAttribute("activePage", "kapitaenUpdate");
        return "index.html";
    }

    @RequestMapping("/delkapitaen")
    public String delkapitaen(@RequestParam(name="id", required = true, defaultValue = "null")int id, @RequestParam(name="activePage", required = false, defaultValue = "kapitaene") String activePage, Model model) {
        DBKapitaenController dbkc = new DBKapitaenController();
        dakc.delKapitaen(id);
        return "redirect:/kapitaene";        
    }

    @RequestMapping("/updatefrischware")
    public String updatefrischware(@RequestParam(name="frischwareId", required = true, defaultValue = "null") int frischwareId, @RequestParam(name="frischware_name", required = true, defaultValue = "null") String frischwareName, @RequestParam(name="activePage", required = false, defaultValue = "kapitaene") String activePage, Model model){
        DBFrischwareController dbfc = new DBFrischwareController();
        dbfc.updateFrischware(frischwareId, frischwareName);
        return "redirect:/kapitaene";
    }

    @RequestMapping("/addfrischware")
    public String addfrischware(@RequestParam(name="frischwareName", required = true, defaultValue = "null")String frischwareName, @RequestParam(name="activePage", required = false, defaultValue = "kapitaene") String activePage, Model model){
        DBFrischwareController dbfc = new DBFrischwareController();
        dbfc.addNewFrischware(frischwareName);
        return "redirect:/kapitaene";
    }

    */



    public void setKapitaene(ArrayList<Kapitaen> kapitaene) {
        this.kapitaene = kapitaene;
    }
    public ArrayList<Kapitaen> getKapitaene() {
        return kapitaene;
    }
}

