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
    
    public CadastroCM getCadastroCM() {
        return cadastroCM;
    }

    public void setCadastroCM(CadastroCM cadastroCM) {
        this.cadastroCM = cadastroCM;
    }

    public CadastroController() {
        cadastroCM = new CadastroCM();
    }

    public void cadastrar(){
        
    }
}
