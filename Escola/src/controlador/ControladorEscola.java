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

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Endereço");
        modelo.addColumn("Sigla");
        modelo.addColumn("Número de Alunos");
        modelo.addColumn("Área");
        List<Escola> resultados = DaoEscola.consultar();
        for (Escola objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getSigla());
            linha.add(objeto.getNr_aluno());
             linha.add(objeto.getArea());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
