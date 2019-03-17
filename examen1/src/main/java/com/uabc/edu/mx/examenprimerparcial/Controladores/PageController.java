package com.uabc.edu.mx.examenprimerparcial.Controladores;

import com.uabc.edu.mx.examenprimerparcial.Clases.Citas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
//@RequestMapping("/inicio")
@Controller
public class PageController {
    private List<Object> valores = new ArrayList<>();

    //@GetMapping(value = "/recursos")
    @RequestMapping(path="/inicio")
    public String pagina(Model model) {

        model.addAttribute("lista", valores);
        return "index";
    }



    @PostMapping("/add")
    public String add(String asunto, String hora, String fecha, String doctor){

        Citas cita = new Citas();


        cita.setAsunto(asunto);
        cita.setHora(hora);
        String[] split = fecha.split("-");
        String fe = split[1] + "/"+split[2]+"/"+ split[0];


        cita.setFecha(fe);
        cita.setDoctor(doctor);
        valores.add(cita);
        return "redirect:/inicio";
    }
}
