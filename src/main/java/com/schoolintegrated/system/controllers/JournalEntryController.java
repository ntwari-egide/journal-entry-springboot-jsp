package com.schoolintegrated.system.controllers;

import com.schoolintegrated.system.models.JournalEntry;
import com.schoolintegrated.system.repositories.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JournalEntryController {

    @Autowired
    private JournalEntryRepository repository;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

//    @GetMapping("/home")
//    public String viewHome(Model model) {
//        return "home";
//    }
    //******************** Basic CRUD operations are here ***************************

    // Create and update

    @RequestMapping("/addEntry")
    public String addJournalEntry(JournalEntry entry) {

        repository.save(entry);

        return "home.jsp";
    }

    // Retrieving all data

    @RequestMapping("/getAllEntries")
    public ModelAndView getAllJournalEntries() {
        ModelAndView modelAndView = new ModelAndView();
        List<JournalEntry> journalEntries = repository.findAll();

        modelAndView.addObject("entries", journalEntries);
        modelAndView.setViewName("getAllEntries.jsp");

        return modelAndView;
    }

    @RequestMapping("/getEntry")
    public ModelAndView getJournalEntry(@RequestParam int id) {

        ModelAndView modelAndView = new ModelAndView();
        JournalEntry entryFound = repository.findById(id).orElse(new JournalEntry());

        modelAndView.addObject("entry", entryFound);
        modelAndView.setViewName("getEntry.jsp");

        return modelAndView;

    }

    // Delete data

    @RequestMapping("/deleteEntry")
    public String deleteJournalEntry( @RequestParam int id) {
        repository.deleteById( id);

        return "home.jsp";
    }

    //**************** MORE COMPLEX QUERIES **********************

    // Find by category

    @RequestMapping("/getEntriesByCategory")
    public ModelAndView getEntriesByCategory ( @RequestParam String  category) {

        ModelAndView modelAndView = new ModelAndView();

        List<JournalEntry> entries = repository.findByCategory(category);

        modelAndView.addObject("entries", entries);

        modelAndView.setViewName("getEntriesByCategory.jsp");

        return modelAndView;
    }

    // Find by Greater than

    @RequestMapping("/getEntriesByIdGT")
    public ModelAndView getEntriesByIdGT(@RequestParam int id) {

        ModelAndView modelAndView = new ModelAndView();
        List<JournalEntry> entries = repository.findByIdGreaterThan(id);

        modelAndView.addObject("entries",entries);
        modelAndView.setViewName("getEntriesByIdGT.jsp");

        return modelAndView;
    }

    //Find By Category but sorted by title

    @RequestMapping("/getEntriesByCategorySorted")
    public ModelAndView getEntriesByCategorySorted(@RequestParam String category) {

        ModelAndView mv = new ModelAndView();
        List<JournalEntry> entries = repository.findByCategorySorted(category);

        mv.addObject("entries",entries);
        mv.setViewName("getEntriesByCategorySorted.jsp");

        return mv;

    }

}
