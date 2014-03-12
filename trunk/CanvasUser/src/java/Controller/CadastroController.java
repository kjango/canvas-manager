/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modelo.BuscarStatus;
import Modelo.CadastroCM;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> status;

    public List<String> getStatus() {
        status = new ArrayList();
        BuscarStatus buscar = new BuscarStatus();
        status = buscar.getStatus();
        return status;
    }
    
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
        cadastroCM.salvar();
    }
}
