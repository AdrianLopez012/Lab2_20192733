package com.example.lab2_20192733.controller;

import com.example.lab2_20192733.model.Cartas;
import com.example.lab2_20192733.model.Juego;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BingoController {
    private List<Cartas> cartasBingo = new ArrayList<>();
    private Juego juego;
    private String mensaje = "";
    private boolean juegoInit = false;

    @GetMapping("/configuracion")
    public String configuracionForm() {
        return "configuracion";
    }

    @PostMapping("/guardarDatos")
    public String guardarConfig(
            @RequestParam("tamaño") int tamaño,
            @RequestParam("tarjetas") int tarjetas,
            Model model
    ) {
        for (int i = 0; i < tarjetas; i++) {
            cartasBingo.add(new Cartas(tamaño));
        }
        juegoInit = false;
        mensaje = "";
        model.addAttribute("listaCartas",cartasBingo);
        return "juego";
    }
    @PostMapping("/juegoIniciado")
    public String iniciarJuego(

            @RequestParam("tamaño") int tamaño,
            @RequestParam("tarjetas") int tarjetas,
            Model model
    ) {
        juegoInit = true;
        model.addAttribute("listaCartas",cartasBingo);
        model.addAttribute("juegoIniciado", juegoInit);
        model.addAttribute("mensaje", mensaje);

        return "juego";
    }

    @PostMapping("/marcado")
    public String marcarNumero(@RequestParam("numeroselec") int numeroselec, Model model) {
        for (int i = 0; i < cartasBingo.size(); i++) {
            if (cartasBingo.get(i).marcarNumero(numeroselec); {
                mensaje = "¡Tarjeta " + (i + 1) + " ha ganado!";
                break;
            }
        }

        return "juego";
    }



}
