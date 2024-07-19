package com.uisrael.muestras.controller;

import com.uisrael.muestras.service.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SolicitudController {
    @Autowired
    private ISolicitudService service;
    @GetMapping("/solicitudes")
    public String solicitudes(Model model) {
        model.addAttribute("solicitudes", service.listarSolicitud());
        return "pages/listar-solicitud";
    }
}
