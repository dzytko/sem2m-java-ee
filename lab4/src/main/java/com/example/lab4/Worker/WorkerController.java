package com.example.lab4.Worker;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WorkerController {
    final WorkerDao workerDao;

    public WorkerController(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @RequestMapping("/addForm")
    public String showForm(Model model) {
        model.addAttribute("command", new Worker());
        return "addForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("worker") Worker worker) {
        workerDao.save(worker);
        return "redirect:/viewAll";
    }

    @RequestMapping("/viewAll")
    public String viewAll(Model model) {
        List<Worker> list = workerDao.getAll();
        model.addAttribute("list", list);
        return "viewAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        workerDao.deleteById(id);
        return "redirect:/viewAll";
    }
}
