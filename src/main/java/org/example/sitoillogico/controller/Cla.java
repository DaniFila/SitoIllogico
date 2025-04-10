package org.example.sitoillogico.controller;


import org.apache.commons.codec.digest.DigestUtils;
import org.example.sitoillogico.exceptions.LoginErrorException;
import org.example.sitoillogico.model.dao.AltroDao;
import org.example.sitoillogico.model.dao.QualcosaDao;
import org.example.sitoillogico.model.dao.UtenteDao;
import org.example.sitoillogico.model.entities.Altro;
import org.example.sitoillogico.model.entities.Qualcosa;
import org.example.sitoillogico.model.entities.Utente;
import org.example.sitoillogico.model.enums.Enumeratore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@SessionAttributes({"utente"})
@Controller
public class Cla {

    @Autowired
    QualcosaDao qdao;

    @Autowired
    AltroDao adao;

    @Autowired
    UtenteDao udao;

    @GetMapping("/qwe")
    public String abc(@SessionAttribute(value = "utente",required = false) Utente utente) {
        if (utente!=null)
            return "abc";

        throw new LoginErrorException("Non hai i permessi!!");
    }

    @PostMapping("/qwe")
    public String creaQualcosa(
            @RequestParam String b,
            @RequestParam String c,
            @RequestParam LocalDate d
    ) {

        System.out.println(c);
        Qualcosa q = new Qualcosa();
        q.setB(b);
        switch (c) {
            case "CCC" ->  q.setC(Enumeratore.CCC);
            case "AAA" -> q.setC(Enumeratore.AAA);
            case "BBB" -> q.setC(Enumeratore.BBB);
        }
        q.setD(d);
        qdao.save(q);

        return "redirect:/qwe";
    }

    @GetMapping("/rty")
    public String def(Model m) {
        List<Qualcosa> qq = qdao.findAll();
        m.addAttribute("qualcosa",qq);
        return "def";
    }

    @GetMapping("/uio")
    public String ghi(Model m) {

        List<Qualcosa> qfiltrato = qdao.filtroBBB();
        m.addAttribute("OnlyBBB",qfiltrato);
        return "ghi";
    }

    @GetMapping("/pas")
    public String pas() {
        return "lmn";
    }

    @GetMapping("/DESTRUCTION")
    public String destruct() {

        adao.deleteAll();
        qdao.deleteAll();
        return "desolazione";
    }

    @GetMapping("/dfg")
    public String dfg(Model m, @RequestParam Long a) {

        Qualcosa qualcosa = qdao.getById(a);
        List<Altro> altri = qualcosa.getAltri();
        m.addAttribute("qualcosa",qualcosa);
        m.addAttribute("altri",altri);
        return "opq";
    }

    @PostMapping("/dfg")
    public String dfgform(@RequestParam String f, @RequestParam Long a) {

        Qualcosa qualcosa = qdao.getById(a);
        Altro altro = new Altro();
        altro.setF(f);
        altro.setQualcosa(qualcosa);
        adao.save(altro);
        return "redirect:/dfg?a="+a;
    }

    @GetMapping("/login")
    public String apriLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String eseguiLogin(@RequestParam String username, @RequestParam String password, Model m) {

        String passwordHash = DigestUtils.md5Hex(password);
        Utente utente0 = udao.findByUsernameAndPassword(username,passwordHash);
        if (utente0==null)
            throw new LoginErrorException("Utente non trovato");

        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setPassword(passwordHash);

        m.addAttribute("utente",utente);

        return "redirect:/qwe";
    }

    @GetMapping("/registrazione")
    public String apriRegistrazione() {
        return "Registrazione";
    }

    @PostMapping("/registrazione")
    public String eseguiRegistrazione(@RequestParam String username, @RequestParam String password) {

        Utente u = new Utente();
        u.setUsername(username);
        String passwordHash = DigestUtils.md5Hex(password);
        u.setPassword(passwordHash);
        udao.save(u);
        return "redirect:/login";
    }


}
