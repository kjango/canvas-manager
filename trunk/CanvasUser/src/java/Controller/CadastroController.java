/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modelo.CadastroCM;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rosana
 */
@ManagedBean(name="cadastro")
@ViewScoped
public class CadastroController {
    private CadastroCM cadastroCM;
    private boolean concluido;

    public CadastroCM getCadastroCM() {
        return cadastroCM;
    }

    public void setCadastroCM(CadastroCM cadastroCM) {
        this.cadastroCM = cadastroCM;
    }

    public CadastroController() {
        cadastroCM = new CadastroCM();
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
    public void cadastrar(){
        
    }
}
