package org.Xiomara.aplication;


import org.Xiomara.Infraestructure.Repository.ImplRecetaRepository;
import org.Xiomara.Interfaces.RecetaService;
import org.Xiomara.aplication.Service.RecetaServiceImpl;

import java.io.Serializable;

public class Main implements Serializable {

    public static void main(String[] args) {

        ImplRecetaRepository RecetaRepository = new ImplRecetaRepository();
        RecetaServiceImpl recetaService = new RecetaServiceImpl(RecetaRepository);

        Menu menu= new Menu(recetaService);
        menu.iniciar();

    }

}
