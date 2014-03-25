/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.BuscarSituacao;
import Modelo.CadastroCM;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author Rosana Local
 */
@ManagedBean(name = "logado")
@RequestScoped
public class LogadoController {

    private String usuario;
    private CadastroCM user;
    private int id_user;

    private List<String> status;
    private String status_curso;
    private BuscarSituacao buscar;
    private String tab;

    public List<String> getStatus() {
        return status;
    }

    public String getStatus_curso() {
        if (buscar != null) {
            for (String i : buscar.getStatus().keySet()) {
                if (buscar.getStatus().get(i) == user.getUsuario().getStatus_curso()) {
                    status_curso = i;
                }
            }
        }
        return status_curso;
    }

    public LogadoController() {
        buscar = new BuscarSituacao();
        status = new ArrayList();
        status = new ArrayList(buscar.getAllStatus().keySet());
        user = new CadastroCM();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
        String param2 = req.getParameter("id");

        if (param2 != null) {
            id_user = Integer.parseInt(param2);
            user.buscar(id_user);

        }
    }

    public CadastroCM getUser() {
        return user;
    }

    public void setUser(CadastroCM user) {
        this.user = user;
    }

    public String getUsuario() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
        String parametroRecebido = req.getParameter("user");

        String param2 = req.getParameter("id");

        if (parametroRecebido != null) {
            usuario = parametroRecebido;
        } else {
            usuario = "Nao funciona";
        }

        if (param2 != null) {
            user.getUsuario().setId(Integer.parseInt(param2));
        }
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void alterarUsuario() {
        if (tab.equalsIgnoreCase("alteraDados")) {
            if (user.validaDadosUsuario() && user.validarStatusCurso(status_curso)) {
                if (user.update()) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario alterado com sucesso.", ""));
                    user.buscar(id_user);
                }
            }
        }
    }

    public void alterarCredencial() {
        if (tab.equalsIgnoreCase("alteraSenha")) {
            if (user.getCredencial().getSenha().equals(user.getCredencial().getSenha2())) {
                if (user.updateCredencial()) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Senha alterada com sucesso!", ""));
                    user.buscar(id_user);

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao atualizar senha. Tente novamente!", ""));
                    user.buscar(id_user);

                }
            }
        }
    }

    public void cancelar() {
        user.buscar(id_user);

    }

    public void onTabChange(TabChangeEvent event) {
        this.tab = event.getTab().getTitle();
    }

}
