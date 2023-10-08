package com.example.lab4.Worker;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class WorkerController {
    final WorkerDao workerDao;

    @RequestMapping("/viewAll")
    public String viewAll(Model model) {
        List<Worker> list = workerDao.getAll();
        model.addAttribute("list", list);
        return "viewAll";
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

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        workerDao.deleteById(id);
        return "redirect:/viewAll";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Worker worker = workerDao.getById(id);
        model.addAttribute("command", worker);
        return "editForm";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String edit(@ModelAttribute("worker") Worker worker) {
        workerDao.update(worker);
        return "redirect:/viewAll";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req,
                                    Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }

}
