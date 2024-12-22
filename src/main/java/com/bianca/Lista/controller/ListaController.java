package com.bianca.Lista.controller;

import com.bianca.Lista.model.Lista;
import com.bianca.Lista.model.ListaDto;
import com.bianca.Lista.repository.ListaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ListaController {

    @Autowired
    private ListaRepository listaRepository;

    // Afișează lista de produse
    @GetMapping("/")
    public String getProduse(Model model) {
        var prod = listaRepository.findAll(Pageable.unpaged(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("produse", prod);
        return "index"; // numele fișierului HTML
    }

    @GetMapping("/create ")
    public String createProdus(Model model) {
        ListaDto listaDto = new ListaDto();
        model.addAttribute("listaDto", listaDto);
        return "produse/create";
    }

    @PostMapping("/create")
    public String createProdus(
        @Valid @ModelAttribute ListaDto listaDto,
        BindingResult rez
    )

    {
        if(listaRepository.findById(listaDto.getId())!=null) {
            rez.addError(
                    new FieldError("listaDto", "id", listaDto.getId(), false, null, null, "ID-u; este deja folosit")
            );
        }
        if(rez.hasErrors())
        {
            return "produse/create";

        }
        Lista lista=new Lista();
        lista.setId((listaDto.getId()));
        lista.setNumeProdus((lista.getNumeProdus()));
        lista.setPretProdus(lista.getPretProdus());
        lista.setCantitateProdus(lista.getCantitateProdus());
        listaRepository.save(lista);
    return "redirect:/produse";
    }
    // Editează un produs
    @GetMapping("/editare")
    public String ediProdus(Model model, @RequestParam Long id){
        Lista lista= listaRepository.findById(id).orElse(null);
        if(lista==null)
        {
            return "redirect:/produse";
        }
        ListaDto listaDto=new ListaDto();
        ListaDto.setId((lista.getId()));
        ListaDto.setNumeProdus((lista.getNumeProdus()));
        ListaDto.setPretProdus(lista.getPretProdus());
        ListaDto.setCantitateProdus(lista.getCantitateProdus());

        model.addAttribute("lista",lista);
        model.addAttribute("listaDto",listaDto);
        return "produse/edit";
    }

}

