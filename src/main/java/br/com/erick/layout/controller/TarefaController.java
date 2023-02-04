package br.com.erick.layout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import br.com.erick.layout.model.Tarefa;

@Controller
public class TarefaController {

    List<Tarefa> tarefas = new ArrayList<>();
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tarefas") 
    public ModelAndView tarefas() {
        ModelAndView model = new ModelAndView("tarefas");
        model.addObject("tarefas", tarefas);
        return model;
    }

    @GetMapping("/criar")
    public String criar() {
        return "criar";
    }

    @PostMapping("/criar")
    public String criar(Tarefa model) {
        // System.out.println("O nome da tarefa é: " + model.getNome() + " as " + model.getData() + "\n\n\n");

        int id = tarefas.size() + 1;

        tarefas.add(
            new Tarefa(
                id,
                model.getNome(),
                model.getData(),
                model.getDescricao()
            )
        );
        return "redirect:/tarefas";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("editar");
        
        Tarefa resultado = tarefas.stream()
                                .filter(item -> id == item.getId())
                                .findFirst()
                                .get();
                                
        model.addObject("tarefa", resultado);
        return model;
    }

    @PostMapping("/editar")
    public String editar(Tarefa model) {
        
        Tarefa tarefa = tarefas.stream()
                .filter(item -> item.getId() == model.getId())
                .findFirst()
                .get();
        tarefa.setNome(model.getNome());
        tarefa.setData(model.getData());
        tarefa.setDescricao(model.getDescricao());

        return "redirect:/tarefas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        Tarefa tarefa = tarefas.stream()
                                .filter(item -> item.getId() == id)
                                .findFirst()
                                .get();
        if (tarefa != null) {
            tarefas.remove(tarefa);
        }

        return "redirect:/tarefas";
    }
}
