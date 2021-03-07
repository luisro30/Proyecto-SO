/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shadow
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    Reloj reloj = new Reloj();
    ArrayList<nodo> lista = new ArrayList<>();
    RoundRobin rr = new RoundRobin();
    boolean bandera;
    int quantum = 10;
    int c = 0;
    int cantidad = 0;
    int tmemoria = 500;

    DefaultTableModel modelo;
    //Object[] miTabla = new Object[1];

    public menu() {
        // DefaultTableModel modelo = (DefaultTableModel) memoria.getModel();
        //Object[] miTabla = new Object[1];
        modelo = new DefaultTableModel();

        initComponents();
        modelo.addColumn("Proceso");
        modelo.addColumn("Tiempo");
        modelo.addColumn("Contador de Programa");
        modelo.addColumn("Estado");
  //      memoria.setBackground(Color.cyan);
        this.memoria.setModel(modelo);
        this.setLocationRelativeTo(null);
        reloj.start();
        tmemoria = tmemoria - 50;
        System.out.println(lista.isEmpty());
        tmem.setText(String.valueOf(tmemoria + " mb"));
//                    
    }

    public class Reloj extends Thread {

        Calendar obtener;

        @Override
        public void run() {
            while (true) {
                obtener = Calendar.getInstance();

                hora.setText(String.valueOf(obtener.get(Calendar.HOUR_OF_DAY)) + " :");

                if (obtener.get(Calendar.MINUTE) < 10) {
                    minutos.setText(String.valueOf("0" + obtener.get(Calendar.MINUTE)) + " :");
                } else {
                    minutos.setText(String.valueOf(obtener.get(Calendar.MINUTE)) + " :");
                }

                if (obtener.get(Calendar.SECOND) < 10) {
                    segundos.setText(String.valueOf("0" + obtener.get(Calendar.SECOND)));
                } else {
                    segundos.setText(String.valueOf(obtener.get(Calendar.SECOND)));
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

    public class RoundRobin extends Thread {

        @Override
        public void run() {

            while (true) {
                int cuenta = 0;
                int proceso = 0;
                String dir = "";
                try {
                    if (lista.isEmpty()) {
                        jtject.setText("En espera");
                        Thread.sleep(100);
                    } else {
                        while (modelo.getRowCount()!=0) {

                           

                            if (lista.get(cuenta).getDuracion() <= quantum) {
                                 proceso = lista.get(cuenta).getNumero();
                                 dir = lista.get(cuenta).getDireccion();
                                 jtject.setText("P" + proceso);
                                 jconp.setText(dir);
                                System.out.println("proceso" + proceso);
                                modelo.setValueAt(("Ejecutándose"), cuenta, 3);         
                                Thread.sleep(lista.get(cuenta).getDuracion() * 1000);
                                modelo.setValueAt(("Finalizdo"), cuenta, 3);
                                tmemoria = tmemoria + lista.get(cuenta).getDuracion();
                                tmem.setText(String.valueOf(tmemoria) + " mb");
                                historial.setText(historial.getText() + "\n" + "Proceso " + String.valueOf(proceso)
                                        + " terminado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
                                lista.remove(cuenta);
                                modelo.removeRow(cuenta);
                                if (modelo.getRowCount()==0){
                                JOptionPane.showMessageDialog(null, "Procesos Finalizados");
                                jconp.setText("-");
                                break;}
                                if(cuenta == (lista.size())){
                                    cuenta = 0;
                                }
                                if (cuenta == 0) {
                                    cuenta = 0;
                                } 

                            }

                            if (lista.get(cuenta).getDuracion() > 10) {
                                proceso = lista.get(cuenta).getNumero();
                                dir = lista.get(cuenta).getDireccion();
                                jconp.setText(dir);
                                jtject.setText("P" + proceso);
                                int nuevaduracion = lista.get(cuenta).getDuracion() - quantum;
                                lista.get(cuenta).setDuracion(nuevaduracion);
                                modelo.setValueAt(("Ejecutándose"), cuenta, 3);
                                Thread.sleep(quantum * 1000);  
                                modelo.setValueAt(("En espera..."), cuenta, 3);
                                tmemoria = tmemoria + quantum;
                                tmem.setText(String.valueOf(tmemoria) + " mb");
                                modelo.setValueAt((nuevaduracion + " ms"), cuenta, 1);
                                
                                if ((lista.size()-1) == cuenta) {
                                    cuenta = 0;
                                }else {
                                cuenta++;
                                }
                                if (lista.size() == 1) {
                                    cuenta = 0;
                                }
                                
                           
                                
                                
                            }
                            

                        }

                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void Ingresar(int duracion, String dir) {

        String[] info = new String[4];
        info[0] = "proceso  " + c;
        info[1] = duracion + " ms";
        info[2] = dir;
        info[3] = "En espera...";
        modelo.addRow(info);
    }

public void Clear_Table1(){
for (int i = 0; i < modelo.getRowCount(); i++) {
modelo.removeRow(i);
i-=1;
}
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hora = new javax.swing.JLabel();
        minutos = new javax.swing.JLabel();
        segundos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jtject = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        memoria = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tmem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jconp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlimite = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbase = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historial = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 650, 45, 53));

        minutos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 45, 53));

        segundos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(segundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 650, 74, 53));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("hrs");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 670, -1, 24));

        jButtonCrear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCrear.setText("AGREGAR PROCESO");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 260, 80));

        jtject.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jtject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtject.setText("PROCESO");
        jtject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jtject, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 160, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("LIMITE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 320, -1, -1));

        memoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proceso", "Tiempo", "Contador de Programa", "Estado"
            }
        ));
        jScrollPane3.setViewportView(memoria);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 550, 540));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setText("               S.O.");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 550, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Memoria Restante");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, -1, 30));

        tmem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tmem.setText("500 mb");
        getContentPane().add(tmem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 650, -1, -1));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 460, 580));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Calendarizador");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, -1, -1));

        jconp.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jconp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jconp.setText("-");
        jconp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jconp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 170, 160, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Contador de Programa");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, -1, -1));

        jlimite.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlimite.setText("   LIMITE");
        jlimite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jlimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 310, 100, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("BASE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 280, -1, -1));

        jbase.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbase.setText("     BASE");
        jbase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jbase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 260, 100, 50));

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 610, 330, 100));

        historial.setColumns(20);
        historial.setRows(5);
        jScrollPane1.setViewportView(historial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 400, 130));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("RELOJ EN TIEMPO REAL");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 620, -1, 24));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("HISTORIAL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, -1, 24));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("INICIAR PROCESOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 260, 80));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("LIMPIAR HISTORIAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 260, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        char obtener;
        int duracion = (int) (Math.random() * 11) + 5;
        if (tmemoria >= duracion) {
            tmemoria = tmemoria - duracion;
            tmem.setText(String.valueOf(tmemoria + " mb"));
            c += 1;
            nodo n = new nodo();
            n.setNumero(c);
            n.setDuracion(duracion);
            obtener = (char)(96+c);    
            n.setDireccion(String.valueOf(obtener));
            lista.add(n);
            Ingresar(duracion,String.valueOf(obtener));
            if ("".equals(historial.getText())) {
                historial.setText("Proceso " + String.valueOf(c) + " agregado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
            } else {
                historial.setText(historial.getText() + "\n" + "Proceso " + String.valueOf(c) + " agregado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
            }

        } else {
            JOptionPane.showMessageDialog(null, "memoria insuficiente");
        }
        //System.out.println(lista.isEmpty());
        cantidad = cantidad + 1;

    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        rr.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  historial.setText("");
  Clear_Table1();
  c = 0;
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea historial;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jbase;
    private javax.swing.JLabel jconp;
    private javax.swing.JLabel jlimite;
    private javax.swing.JLabel jtject;
    private javax.swing.JTable memoria;
    private javax.swing.JLabel minutos;
    private javax.swing.JLabel segundos;
    private javax.swing.JLabel tmem;
    // End of variables declaration//GEN-END:variables
}
