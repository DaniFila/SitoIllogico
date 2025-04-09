package org.example.sitoillogico.controller;


import org.example.sitoillogico.model.dao.QualcosaDao;
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

        qdao.deleteAll();
        return "desolazione";
    }


}
