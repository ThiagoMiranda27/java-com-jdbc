package com.curso.java2;

import com.curso.java2.dao.SetorDAO;
import com.curso.java2.model.Setor;

public class Application {

    public static void main(String[] args) {

        SetorDAO setorDAO = new SetorDAO();

        //Inserir

        Setor setor = new Setor();
        setor.setNome("Financeiro");

        setorDAO.adicionarSetor(setor);


        //Consultar

        System.out.println("Setores cadastrados: \n\n");
        for(Setor setor1 : setorDAO.listarSetor()){
            System.out.println(setor1.getNome());
        }

        //Buscar

        Setor setor1 = setorDAO.buscarSetorPeloId(1L);
        System.out.println(setor1.getNome());

        //Alterar

        setor1.setNome("Juridico");
        setorDAO.alterarSetor(setor1);


        //Deletar

        setorDAO.deletarSetor(3L);

    }
}
