/**
 * Clasa pentru gestionarea operațiunilor legate de lista de produse.
 * @author Petcan Bianca-Andreea
 * @version 2 Ianuarie 2025
 */

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
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller

public class ListaController {

    @Autowired
    private ListaRepository listaRepository;
    @GetMapping("/")
    public String getProduse(Model model) {
        var prod = listaRepository.findAll(Pageable.unpaged(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("produse", prod);
        return "index"; // numele fișierului HTML
    }

    @GetMapping("/create")
    public String createProduse(Model model) {
        model.addAttribute("listaDto", new ListaDto());
        return "create";
    }

    @PostMapping("/create")
    public String createProduse( @ModelAttribute ListaDto listaDto,
                               BindingResult rez) {

        if (rez.hasErrors()) {
            return "create"; // Dacă sunt erori de validare, redirecționează înapoi la formular
        }

        Lista lista = new Lista();
        lista.setNumeProdus(listaDto.getNumeProdus());
        lista.setPretProdus(listaDto.getPretProdus());
        lista.setCantitateProdus(listaDto.getCantitateProdus());

        listaRepository.save(lista);
        return "redirect:/"; // Redirecționează către pagina cu lista de produse
    }

    // Editează un produs
    @GetMapping("/editare")
    public String editProduse(Model model, @RequestParam Long id) {
        Lista lista = listaRepository.findById(id).orElse(null);
        if (lista == null) {
            return "redirect:/"; // Dacă produsul nu există, redirecționează
        }

        // Crează un obiect ListaDto cu datele produsului
        ListaDto listaDto = new ListaDto();
        listaDto.setId(lista.getId());
        listaDto.setNumeProdus(lista.getNumeProdus());
        listaDto.setPretProdus(lista.getPretProdus());
        listaDto.setCantitateProdus(lista.getCantitateProdus());

        // Adaugă obiectele la model pentru a le folosi în view
        model.addAttribute("lista", lista);
        model.addAttribute("listaDto", listaDto);

        return "editare"; // Redirecționează către formularul de editare
    }

    @PostMapping("/editare")
    public String editProduse(
            Model model,
            @RequestParam Long id,
            @Valid @ModelAttribute ListaDto listaDto,
            BindingResult rez
    ){
        Lista lista = listaRepository.findById(id).orElse(null);
        if (lista == null) {
            return "redirect:/"; // Dacă produsul nu există, redirecționează
        }

        if (rez.hasErrors()) {
            return "editare"; // Asigură-te că redirecționezi corect la pagina "editare"
        }

        // Actualizează produsul
        lista.setNumeProdus(listaDto.getNumeProdus());
        lista.setPretProdus(listaDto.getPretProdus());
        lista.setCantitateProdus(listaDto.getCantitateProdus());

        listaRepository.save(lista);

        return "redirect:/"; // Redirecționează către lista de produse
    }

    @GetMapping("/stergere")
    public String stergereProduse( @RequestParam Long id){
        Lista lista=listaRepository.findById(id).orElse(null);
        if(lista != null)
        {
            listaRepository.delete(lista);
        }
        return "redirect:/";
    }
    // Endpoint pentru ștergerea multiplă
    @PostMapping("/deleteMultiple")
    public String deleteMultiple(@RequestParam(name = "selectedIds", required = false) List<Long> selectedIds) {
        if (selectedIds != null && !selectedIds.isEmpty()) {
            listaRepository.deleteAllById(selectedIds);
        }
        return "redirect:/"; // Redirecționează înapoi la lista de produse
    }

    @PostMapping("/marcheazaCumpărat")
    public String marcheazaCumparat(@RequestParam Long id) {
        // Verifică dacă ID-ul este valid
        if (id == null || id == 0) {
            // Poți arunca o excepție sau poți face un redirect în cazul în care ID-ul nu este valid
            return "redirect:/";  // Redirecționează către pagina principală
        }

        Lista produs = listaRepository.findById(id).orElse(null);
        if (produs != null) {
            // Schimbă starea de cumpărat
            produs.setCumparat(!produs.isCumparat());
            listaRepository.save(produs); // Salvează modificările
        }
        return "redirect:/"; // Redirecționează către pagina principală
    }





}