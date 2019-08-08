/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoEscola;
import javax.swing.JOptionPane;
import modelo.Escola;
import tela.manutencao.ManutencaoEscola;


/**
 *
 * @author Administrador
 */
public class ControladorEscola {

  public static void inserir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setSigla(man.jtfnome.getText());
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setNome(man.jtfsigla.getText());
        
        boolean resultado = DaoEscola.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    
}
