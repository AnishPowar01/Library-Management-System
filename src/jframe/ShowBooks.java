/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import static jframe.DBConnection.con;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import  java.sql.PreparedStatement;

/**
 *
 * @author Anish Powar
 */
public class ShowBooks extends javax.swing.JFrame {

    /**
     * Creates new form Manage books
     * 
     */
    String book_name,autho;
    int book_id,quant;
    
    DefaultTableModel model;
    public ShowBooks() {
        initComponents();
        setBookDetails();
    }
    
    public void setBookDetails()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from book_details");
           
            while (rs.next()) {

                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String quantity = rs.getString("quantity");
                
                Object[] obj = {bookId,bookName,author,quantity};
                model = (DefaultTableModel) table_bookDetails.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public boolean addBook()
//    {
//        boolean isAdded = false;
//        book_id = Integer.parseInt(text_BookId.getText());
//        book_name = text_BookName.getText();
//        autho = text_Author.getText();
//        quant = Integer.parseInt(text_Quant.getText());
//        
//        try {
//            Connection con = DBConnection.getConnection();
//            String sql = "insert into book_details values(?,?,?,?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, book_id);
//            pst.setString(2, book_name);
//            pst.setString(3, autho);
//            pst.setInt(4, quant);
//            
//            int rowCount = pst.executeUpdate();
//            
//            if (rowCount > 0) {
//                
//                isAdded = true;
//                
//            }
//            else
//            {
//                isAdded = false;
//            }
//        } catch (Exception e) {
//            
//            e.printStackTrace();
//        }
//        
//        return isAdded;
//    }
//    
//    //to update book
//    
//    public boolean updateBook()
//            {
//                  boolean isUpdated = false;
//        book_id = Integer.parseInt(text_BookId.getText());
//        book_name = text_BookName.getText();
//        autho = text_Author.getText();
//        quant = Integer.parseInt(text_Quant.getText());
//        
//                try {
//                    Connection con = DBConnection.getConnection();
//                    String sql = "update book_details set book_name = ?,author = ?,quantity = ? where book_id = ?";
//                    PreparedStatement pst = con.prepareStatement(sql);
//                    
//                    pst.setString(1, book_name);
//                    pst.setString(2, autho);
//                    pst.setInt(3, quant);
//                    pst.setInt(4, book_id);
//                    
//                    int rowCount = pst.executeUpdate();
//                    
//                    if (rowCount > 0) {
//                        
//                        isUpdated = true;
//                        
//                    }
//                    else
//                    {
//                        isUpdated = false;
//                    }
//                            
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                
//                return isUpdated;
//            }
//    
//    
//    //delte book
//    
//    
//    public boolean deleteBook()
//    {
//        boolean isDeleted = false;
//                book_id = Integer.parseInt(text_BookId.getText());
//                
//                try {
//            Connection con = DBConnection.getConnection();
//            String sql = "delete from book_details where book_id = ?";
//            
//            PreparedStatement pst = con.prepareStatement(sql);
//            
//            pst.setInt(1, book_id);
//            int rowCount = pst.executeUpdate();
//            
//                    if (rowCount > 0) {
//                        isDeleted = true;
//                        
//                    }
//                    
//                    else
//                    {
//                        isDeleted = false;
//                    }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//                
//                return isDeleted;
//
//    }
    
    //clear table
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) table_bookDetails.getModel();
        model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 310));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", " Name", "Author", "Quantity"
            }
        ));
        table_bookDetails.setColorBackgoundHead(new java.awt.Color(1, 77, 109));
        table_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        table_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_bookDetails.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        table_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        table_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        table_bookDetails.setRowHeight(30);
        table_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_bookDetails);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 1080, 340));

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText(" Available Books");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 290, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 410, 5));

        rSMaterialButtonRectangle1.setText("LOG OUT");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel4.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, 190, 70));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 830));

        setSize(new java.awt.Dimension(1567, 831));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookDetailsMouseClicked

        // TODO add your handling code here:
        
//        int rowNo = table_bookDetails.getSelectedRow();
//        TableModel model = table_bookDetails.getModel();
//        
//        text_BookId.setText(model.getValueAt(rowNo, 0).toString());
//        text_BookName.setText(model.getValueAt(rowNo, 1).toString());
//        text_Author.setText(model.getValueAt(rowNo, 2).toString());
//        text_Quant.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_table_bookDetailsMouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
        MainPage main = new MainPage();
        main.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojeru_san.complementos.RSTableMetro table_bookDetails;
    // End of variables declaration//GEN-END:variables
}
