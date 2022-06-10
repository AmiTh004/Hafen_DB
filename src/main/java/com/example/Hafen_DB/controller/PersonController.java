/*
package com.example.Hafen_DB.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hafen_DB.models.Person;

@Controller
public class PersonController extends DBController{
    
    ArrayList<Person> personen;

    public PersonController() {
        setPersonen(new ArrayList<Person>());

        loadPersonFromDB();
    }

    private void loadPersonFromDB(){
        DBPersonController dbpc = new DBPersonController();
        setPersonen(dbpc.getAllPerson());
    }

    
    @GetMapping("/personen")
    public String personen(@RequestParam(name="activePage", required = false, defaultValue = "personen") String activePage, Model model) {
        loadPersonFromDB();
        
        model.addAttribute("activePage", "personen");
        model.addAttribute("personen", getPersonen());
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
    public String updatefrischware(@RequestParam(name="frischwareId", required = true, defaultValue = "null") int frischwareId, @RequestParam(name="frischware_name", required = true, defaultValue = "null") String frischwareName, @RequestParam(name="activePage", required = false, defaultValue = "frischwaren") String activePage, Model model){
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

    



    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }
    public ArrayList<Person> getPersonen() {
        return personen;
    }
}

*/