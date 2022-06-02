package com.example.Hafen_DB.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hafen_DB.models.Frischware;

@Controller
public class FrischwareController extends DBController{
    
    ArrayList<Frischware> frischwaren;

    public FrischwareController() {
        setFrischwaren(new ArrayList<Frischware>());

        loadFrischwarenFromDB();
    }

    //Lädt aktuelle Frischwaren aus der Datenbank und wirft bei bedarf eine SQL-Exeption aus
    private void loadFrischwarenFromDB(){
        DBFrischwareController dbfc = new DBFrischwareController();
        setFrischwaren(dbfc.getAllFrischware());
    }

    @GetMapping("/frischwaren")
    public String frischwaren(@RequestParam(name="activePage", required = false, defaultValue = "frischwaren") String activePage, Model model) {
        loadFrischwarenFromDB();
        
        model.addAttribute("activePage", "frischwaren");
        model.addAttribute("frischwaren", getFrischwaren());
        return "index.html";
    }

    @RequestMapping("/delfrischware")
    public String delfrischware(@RequestParam(name="id", required = true, defaultValue = "null")int id, @RequestParam(name="activePage", required = false, defaultValue = "frischwaren") String activePage, Model model) {
        DBFrischwareController dbfc = new DBFrischwareController();
        dbfc.delFrischware(id);
        return "redirect:/frischwaren";        
    }

    @RequestMapping("/changefrischware")
    public String changefrischware(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changefrischware") String activePage, Model model){
        // Frischware zur Bearbeitung laden
        DBFrischwareController dbfc = new DBFrischwareController();
        model.addAttribute("frischware", dbfc.getFrischware(id));
        model.addAttribute("frischwareId", id);

        
        model.addAttribute("activePage", "frischwareUpdate");
        return "index.html";
    }

    @RequestMapping("/updatefrischware")
    public String updatefrischware(@RequestParam(name="frischwareId", required = true, defaultValue = "null") int frischwareId, @RequestParam(name="frischwareName", required = true, defaultValue = "null") String frischwareName, @RequestParam(name="activePage", required = false, defaultValue = "frischwaren") String activePage, Model model){
        DBFrischwareController dbfc = new DBFrischwareController();
        dbfc.updateFrischware(frischwareId, frischwareName);
        return "redirect:/frischwaren";
    }

    @RequestMapping("/addfrischware")
    public String addfrischware(@RequestParam(name="frischwareName", required = true, defaultValue = "null")String frischwareName, @RequestParam(name="activePage", required = false, defaultValue = "frischwaren") String activePage, Model model){
        DBFrischwareController dbfc = new DBFrischwareController();
        dbfc.addNewFrischware(frischwareName);
        return "redirect:/frischwaren";
    }




    public void setFrischwaren(ArrayList<Frischware> frischwaren) {
        this.frischwaren = frischwaren;
    }

    public ArrayList<Frischware> getFrischwaren() {
        return frischwaren;
    }
}
