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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rosana
 */
@ManagedBean(name = "cadastro")
@ViewScoped
public class CadastroController {

    private CadastroCM cadastroCM;
    private List<String> status;
    private String status_curso;
    private BuscarStatus buscar;

    public List<String> getStatus() {
        status = new ArrayList();
        buscar = new BuscarStatus();
        status = new ArrayList(buscar.getAllStatus().keySet());
        return status;
    }

    public CadastroCM getCadastroCM() {
        return cadastroCM;
    }

    public void setCadastroCM(CadastroCM cadastroCM) {
        this.cadastroCM = cadastroCM;
    }

    public void setStatus_curso(String status_curso) {
        this.status_curso = status_curso;
    }

    public String getStatus_curso() {
        return status_curso;
    }

    public CadastroController() {
        cadastroCM = new CadastroCM();
    }

    public void cadastrar() {

        if (cadastroCM.validarUsuario() != 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email já cadastrado! Se Você quer recuperar a senha volte para a página inicial.", ""));
        } else if(!cadastroCM.validarStatusCurso(this.status_curso)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status do curso e Data de Conclusão do curso não conferem. Por favor verifique.", ""));
        }else{
            if (cadastroCM.getCredencial().getSenha().equalsIgnoreCase(cadastroCM.getCredencial().getSenha2())) {
                cadastroCM.getUsuario().setStatus_curso(buscar.getStatus().get(this.status_curso));

                cadastroCM.salvar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario cadastrado com sucesso.", ""));

                cadastroCM = new CadastroCM();
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "As senhas estão diferentes. Tente novamente.", ""));
            }
        }
    }
}
