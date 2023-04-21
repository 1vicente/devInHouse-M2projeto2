package devInHouse.M2projeto2.controller;

import devInHouse.M2projeto2.model.Estatistica;
import devInHouse.M2projeto2.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticaController {
    @Autowired
    private EstatisticaService service;
    @GetMapping
    private Estatistica lista(){
        return service.listarQtd();
    }
}
