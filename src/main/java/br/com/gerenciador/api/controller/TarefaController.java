package br.com.gerenciador.api.controller;

import br.com.gerenciador.api.constants.ConstantsPath;
import br.com.gerenciador.api.service.TarefaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantsPath.PATH_GERENCIADOR_TEREFA_TAREFA)
@Api(tags = {"Tarefa"})
public class TarefaController {

    @Autowired
    private TarefaService service;

}
