package org.example.sitoillogico.controller;


import org.example.sitoillogico.model.dao.AltroDao;
import org.example.sitoillogico.model.dao.QualcosaDao;
import org.example.sitoillogico.model.entities.Altro;
import org.example.sitoillogico.model.entities.Qualcosa;
import org.example.sitoillogico.model.enums.Enumeratore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class Cla {

    @Autowired
    QualcosaDao qdao;

    @Autowired
    AltroDao adao;

    @GetMapping("/qwe")
    public String abc() {
        return "abc";
    }

    @PostMapping("/qwe")
    public String creaQualcosa(
            @RequestParam String b,
            @RequestParam String c,
            @RequestParam LocalDate d
    ) {

        Qualcosa q = new Qualcosa();
        q.setB(b);
        switch (c) {
            case "AAA" -> q.setC(Enumeratore.AAA);
            case "BBB" -> q.setC(Enumeratore.BBB);
            case "CCC" -> q.setC(Enumeratore.CCC);
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


}
