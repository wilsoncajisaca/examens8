package com.uisrael.muestras.controller;

import com.uisrael.muestras.model.Departamento;
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
public class DepartamentoController {
    @Autowired
    private IDepartamentoService service;
    @GetMapping("/listar-departamento")
    public String listar(Model model) {
        model.addAttribute("departamentos", service.listarDepartamentos());
        return "pages/listar-departamento";
    }

    @GetMapping("nuevo-departamento")
    public String nuevo(Model model) {
        model.addAttribute("nuevo", new Departamento());
        return "/pages/nuevo-departamento";
    }

    @PostMapping("guardar-departamento")
    private String guardar(@ModelAttribute("nuevo")Departamento departamento) {
        service.insertarDepartamento(departamento);
        return "redirect:/listar-departamento";
    }

    @GetMapping("eliminar-departamento/{id}")
    public String eliminar(@PathVariable("id") int id) throws Exception {
        service.deleteDepartamento(id);
        return "redirect:/listar-departamento";
    }

    @GetMapping("editar-departamento/{id}")
    public String editar(@PathVariable("id") int id, Model model) throws Exception {
        Departamento obj = service.getCategoriaById(id);
        model.addAttribute("nuevo", obj);
        return "/pages/nuevo-departamento";
    }
}
