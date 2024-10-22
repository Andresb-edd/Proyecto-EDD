/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd.bdi.proj;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 * Clase que representa la interfaz gráfica de usuario para la aplicación de gestión de la red de transporte.
 * Permite cargar redes de transporte, visualizar el grafo y realizar diversas operaciones sobre la red.
 */
public class Interfaz extends javax.swing.JFrame {
    App app = new App();

    /**
     * Clase que representa la interfaz gráfica de usuario para la aplicación de gestión de la red de transporte.
     * Permite cargar redes de transporte, visualizar el grafo y realizar diversas operaciones sobre la red.
     */
    public Interfaz() {
        initComponents();
        button_exit.setVisible(false);
        button_select_file.setVisible(false);
        button_select_red.setVisible(false);
        comboBoxCiudades.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_bienvenida = new javax.swing.JTextField();
        button_add_red = new javax.swing.JButton();
        button_exit = new javax.swing.JButton();
        button_mostrar_red = new javax.swing.JButton();
        button_select_file = new javax.swing.JButton();
        button_select_red = new javax.swing.JButton();
        comboBoxCiudades = new javax.swing.JComboBox<>();
        Label_t_value = new javax.swing.JLabel();
        Input_t = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text_bienvenida.setText("Manejo de Sucursales");
        text_bienvenida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_bienvenidaActionPerformed(evt);
            }
        });
        getContentPane().add(text_bienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 6, -1, 71));

        button_add_red.setText("Añadir Red");
        button_add_red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_redActionPerformed(evt);
            }
        });
        getContentPane().add(button_add_red, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 290, 91));

        button_exit.setText("Salir");
        button_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_exitActionPerformed(evt);
            }
        });
        getContentPane().add(button_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 506, -1, -1));

        button_mostrar_red.setText("Mostrar Red");
        button_mostrar_red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mostrar_redActionPerformed(evt);
            }
        });
        getContentPane().add(button_mostrar_red, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 290, 91));

        button_select_file.setText("Seleccionar Archivo");
        button_select_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_select_fileActionPerformed(evt);
            }
        });
        getContentPane().add(button_select_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 290, 92));

        button_select_red.setText("Seleccionar Red");
        button_select_red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_select_redActionPerformed(evt);
            }
        });
        getContentPane().add(button_select_red, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 290, 90));

        comboBoxCiudades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCiudadesActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxCiudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 210, 40));

        Label_t_value.setText("Modificar valor de t");
        getContentPane().add(Label_t_value, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        Input_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Input_tActionPerformed(evt);
            }
        });
        getContentPane().add(Input_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_bienvenidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_bienvenidaActionPerformed

    }//GEN-LAST:event_text_bienvenidaActionPerformed

    private void button_add_redActionPerformed(java.awt.event.ActionEvent evt) {                                               
        button_mostrar_red.setVisible(false); 
        button_add_red.setVisible(false); 
        button_exit.setVisible(true);
        button_select_file.setVisible(true);

    }

    private void button_mostrar_redActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_mostrar_redActionPerformed
        button_mostrar_red.setVisible(false); 
        button_add_red.setVisible(false); 
        button_exit.setVisible(true);
        button_select_red.setVisible(true);
    }//GEN-LAST:event_button_mostrar_redActionPerformed

    private void Input_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Input_tActionPerformed
        String ciudadSeleccionada = (String) comboBoxCiudades.getSelectedItem();
        Ciudad aux = app.buscar_ciudad(ciudadSeleccionada);
        try {
            aux.setT(Integer.parseInt(Input_t.getText()));
            System.out.println(aux.getT());
        } catch (NumberFormatException e) {
            System.err.println("El valor ingresado no es un número entero válido.");
        }
    }//GEN-LAST:event_Input_tActionPerformed

    private void button_select_fileActionPerformed(java.awt.event.ActionEvent evt) {
        app = LectorArchivo.run(app);
    }                                                  

    private void comboBoxCiudadesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void button_select_redActionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxCiudades.removeAllItems();
        NodoDeListas current = app.getcFirst();
        while (current != null) {
            Ciudad ciudad = (Ciudad) current.getDataCiudad();
            comboBoxCiudades.addItem(ciudad.getNombre());
            current = current.getpNext();
            System.out.println(ciudad.getNombre());
            

        }
        comboBoxCiudades.setVisible(true);
        String ciudadSeleccionada = (String) comboBoxCiudades.getSelectedItem();
        System.out.println("Ciudad seleccionada: " + ciudadSeleccionada);
        Ciudad aux = app.buscar_ciudad(ciudadSeleccionada);
        Input_t.setText(String.valueOf(aux.getT()));
        Grafo.renderGrafo(ciudadSeleccionada, app);

    }

    private void button_exitActionPerformed(java.awt.event.ActionEvent evt) {                                            
        button_mostrar_red.setVisible(true);
        button_add_red.setVisible(true);
        button_select_file.setVisible(false);
        button_select_red.setVisible(false);
        button_exit.setVisible(false);
        comboBoxCiudades.setVisible(false);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Input_t;
    private javax.swing.JLabel Label_t_value;
    private javax.swing.JButton button_add_red;
    private javax.swing.JButton button_exit;
    private javax.swing.JButton button_mostrar_red;
    private javax.swing.JButton button_select_file;
    private javax.swing.JButton button_select_red;
    private javax.swing.JComboBox<String> comboBoxCiudades;
    private javax.swing.JTextField text_bienvenida;
    // End of variables declaration//GEN-END:variables
}
