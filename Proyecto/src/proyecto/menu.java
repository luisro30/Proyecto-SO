/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        modelo.addColumn("#Proceso");
        this.memoria.setModel(modelo);
        this.setLocationRelativeTo(null);
        reloj.start();
        tmemoria = tmemoria - 50;
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
        
 int cuenta = 0;
 int i = 0;
        @Override
        public void run() {
            
            while (true) {
                try {
                    if (lista.isEmpty()) {
//                        System.out.println("En espera");
                        jtject.setText("En espera");
                        Thread.sleep(100);
                    } 
                   else{ 
                    while(!lista.isEmpty()){
                        
                        
                            if(i==0){
                            cuenta=0;}
                            else if (i >0 && cantidad > 1){cuenta = cuenta + 1;}
                            else if(i>0 && cantidad==1){cuenta = 0;}
                            int proceso = lista.get(cuenta).getNumero();
                            jtject.setText("P" + proceso);

                           
                                if (lista.get(cuenta).getDuracion() <= quantum) {
                                    
                                    System.out.println("proceso" + proceso);
                                    Thread.sleep(lista.get(cuenta).getDuracion() * 1000);
                                    tmemoria = tmemoria + lista.get(cuenta).getDuracion();
                                    tmem.setText(String.valueOf(tmemoria) + " mb");
                                    lista.remove(cuenta);
                                    modelo.removeRow(cuenta);

             if ("".equals(historial.getText())) {
                historial.setText("Proceso " + String.valueOf(proceso) + " terminado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
            } else {
                historial.setText(historial.getText() + "\n" + "Proceso " + String.valueOf(proceso) + " terminado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
            }
                                    
                                   
                cuenta=cuenta-1;
                cantidad = cantidad -1;
                
          
                                } 
                                
                                
                                if(lista.get(cuenta).getDuracion()>10){
                                    int nuevaduracion = lista.get(cuenta).getDuracion() - quantum;
                                    lista.get(cuenta).setDuracion(nuevaduracion);
                                    //int p = lista.get(i).getNumero();
                                    System.out.println("proceso " + proceso);
                                    System.out.println("%% " + lista.get(cuenta).getDuracion());
                                    Thread.sleep(quantum * 1000);
                                    tmemoria = tmemoria + quantum;
                                    tmem.setText(String.valueOf(tmemoria) + " mb");
                                    modelo.setValueAt(("proceso  " + proceso + " " + nuevaduracion + " ms"), cuenta, 0);
                                }
                            
                    
                        i = i + 1;
                    }
                }
                } catch (InterruptedException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void Ingresar(int duracion) {

        String []info=new String[1];  
        info[0] = "proceso  " + c + " " + duracion + "ms";
        modelo.addRow(info);
        //memoria.setModel(modelo);
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
        jLabelPrejec = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 630, 45, 53));

        minutos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 630, 45, 53));

        segundos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(segundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 74, 53));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("hrs");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 650, -1, 24));

        jButtonCrear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCrear.setText("AGREGAR PROCESO");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 220, 80));

        jtject.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jtject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtject.setText("PROCESO");
        jtject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jtject, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 160, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("LIMITE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, -1, -1));

        memoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proceso"
            }
        ));
        jScrollPane3.setViewportView(memoria);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 540));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setText("    S.O.");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Memoria Restante");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, -1, 30));

        tmem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tmem.setText("500 mb");
        getContentPane().add(tmem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, -1, -1));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 460, 580));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Calendarizador");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jLabelPrejec.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabelPrejec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrejec.setText("-");
        jLabelPrejec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabelPrejec, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 160, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Contador de Programa");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        jlimite.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlimite.setText("   LIMITE");
        jlimite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jlimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, 100, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("BASE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, -1, -1));

        jbase.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbase.setText("     BASE");
        jbase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jbase, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 100, 50));

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, 330, 100));

        historial.setColumns(20);
        historial.setRows(5);
        jScrollPane1.setViewportView(historial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 400, 130));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("RELOJ EN TIEMPO REAL");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, -1, 24));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("HISTORIAL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 390, -1, 24));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        int duracion = (int) (Math.random() * 11) + 5;
        if (tmemoria >= duracion) {
            tmemoria = tmemoria - duracion;
            tmem.setText(String.valueOf(tmemoria + " mb"));
            c += 1;
            nodo n = new nodo();
            n.setNumero(c);
            n.setDuracion(duracion);
            lista.add(n);
            Ingresar(duracion);
            if ("".equals(historial.getText())) {
                historial.setText("Proceso " + String.valueOf(c) + " agregado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
            } else {
                historial.setText(historial.getText() + "\n" + "Proceso " + String.valueOf(c) + " agregado a las " + hora.getText() + minutos.getText() + segundos.getText() + " hrs");
            }

        } else {
            JOptionPane.showMessageDialog(null, "memoria insuficiente");
        }
        cantidad = cantidad + 1;
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     rr.start();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel jLabelPrejec;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jbase;
    private javax.swing.JLabel jlimite;
    private javax.swing.JLabel jtject;
    private javax.swing.JTable memoria;
    private javax.swing.JLabel minutos;
    private javax.swing.JLabel segundos;
    private javax.swing.JLabel tmem;
    // End of variables declaration//GEN-END:variables
}
