/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import  java.sql.PreparedStatement;

/**
 *
 * @author Anish Powar
 */
public class ViewRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewRecord
     */
    DefaultTableModel model;
    public ViewRecord() {
        initComponents();
        setIssueBookDetails();
    }
     public void setIssueBookDetails()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from issue_book");
           
            while (rs.next()) {
                
                String id = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String Stud_id = rs.getString("student_id");
                String studentname = rs.getString("student_name");
                String IssueDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String Status = rs.getString("status");
                
                Object[] obj = {id,bookName,Stud_id,studentname,IssueDate,DueDate,Status};
                model = (DefaultTableModel) table_issueBookDetails.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
        public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) table_issueBookDetails.getModel();
        model.setRowCount(0);
    }
        
        public void pendingREcords()
        {
             try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from issue_book where status ='"+"pending"+"'");
           
            while (rs.next()) {
                
                String id = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String Stud_id = rs.getString("student_id");
                String studentname = rs.getString("student_name");
                String IssueDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String Status = rs.getString("status");
                
                Object[] obj = {id,bookName,Stud_id,studentname,IssueDate,DueDate,Status};
                model = (DefaultTableModel) table_issueBookDetails.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        // Search conditions
        
//        public void search()
//        {
////              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////         String vIssueDate = sdf.format(Date_Issue.getDate());
////         String vDueDate = sdf.format(Date_Due.getDate());
//            
////             int studentId = Integer.parseInt(text_BookId.getText());
//         
//            try {
//                Connection con = DBConnection.getConnection();
//                String sql = "select * from issue_book where student_id = ?";
//                PreparedStatement pst  =  con.prepareStatement(sql);
////                pst.setInt(1, studentId);
//                
////                pst.setString(1, vIssueDate);
////                pst.setString(2, vDueDate);
////                
//                ResultSet rs = pst.executeQuery();
//                 while (rs.next()) {
//                
//                String id = rs.getString("book_id");
//                String bookName = rs.getString("book_name");
//                String Stud_id = rs.getString("student_id");
//                String studentname = rs.getString("student_name");
//                String IssueDate = rs.getString("issue_date");
//                String DueDate = rs.getString("due_date");
//                String Status = rs.getString("status");
//                
//                Object[] obj = {id,bookName,Stud_id,studentname,IssueDate,DueDate,Status};
//                model = (DefaultTableModel) table_issueBookDetails.getModel();
//                model.addRow(obj);
//                
//                
//            }
//               
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        Panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 128, 166));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText(" Library Records");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(229, 14, 71));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(217, 39, 86));
        rSMaterialButtonRectangle1.setText("ALL RECORDS");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(217, 39, 86));
        rSMaterialButtonRectangle2.setText("PENDING RECORDS");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(611, 611, 611))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1553, 290));

        Panel_table.setBackground(new java.awt.Color(255, 255, 255));
        Panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Student Id", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        table_issueBookDetails.setColorBackgoundHead(new java.awt.Color(36, 128, 166));
        table_issueBookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        table_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_issueBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_issueBookDetails.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        table_issueBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        table_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_issueBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        table_issueBookDetails.setRowHeight(30);
        table_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_issueBookDetails);

        Panel_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 1160, 440));

        getContentPane().add(Panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1550, 540));

        setSize(new java.awt.Dimension(1567, 831));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_issueBookDetailsMouseClicked

        // TODO add your handling code here:

        
    }//GEN-LAST:event_table_issueBookDetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        clearTable();
        setIssueBookDetails();
        
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        // TODO add your handling code here:
        clearTable();
        pendingREcords();
        
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojeru_san.complementos.RSTableMetro table_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
