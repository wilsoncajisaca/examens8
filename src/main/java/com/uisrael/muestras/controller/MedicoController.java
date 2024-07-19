package com.uisrael.muestras.controller;

import com.uisrael.muestras.model.Medico;
import com.uisrael.muestras.service.IDepartamentoService;
import com.uisrael.muestras.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicoController {
    @Autowired
    private IMedicoService service;
    @Autowired
    private IDepartamentoService departamentoService;
    @GetMapping("/listar-medico")
    public String listar(Model model) {
        model.addAttribute("medicos", service.listarMedico());
        return "pages/listar-medico";
    }

    @GetMapping("nuevo-medico")
    public String nuevo(Model model) {
        model.addAttribute("nuevo", new Medico());
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        return "/pages/nuevo-medico";
    }

    @PostMapping("guardar-medico")
    private String guardar(@ModelAttribute("nuevo")Medico medico) {
        service.insertarMedico(medico);
        return "redirect:/listar-medico";
    }

    @GetMapping("eliminar-medico/{id}")
    public String eliminar(@PathVariable("id") int id) throws Exception {
        service.eliminarMedico(id);
        return "redirect:/listar-medico";
    }

    @GetMapping("editar-medico/{id}")
    public String editar(@PathVariable("id") int id, Model model) throws Exception {
        Medico obj = service.buscarMedico(id);
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        model.addAttribute("nuevo", obj);
        return "/pages/nuevo-medico";
    }
}
