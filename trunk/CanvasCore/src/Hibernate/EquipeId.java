package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0



/**
 * Classe gerada pelo Hibernate - controla a chave primária da tabela Equipe
 */
public class EquipeId  implements java.io.Serializable {


     private int idUsuario;
     private int idProjeto;

    public EquipeId() {
    }

    public EquipeId(int idUsuario, int idProjeto) {
       this.idUsuario = idUsuario;
       this.idProjeto = idProjeto;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdProjeto() {
        return this.idProjeto;
    }
    
    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EquipeId) ) return false;
		 EquipeId castOther = ( EquipeId ) other; 
         
		 return (this.getIdUsuario()==castOther.getIdUsuario())
 && (this.getIdProjeto()==castOther.getIdProjeto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUsuario();
         result = 37 * result + this.getIdProjeto();
         return result;
   }   


}


