/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.*;
import  java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import  java.util.Date;

/**
 *
 * @author Anish Powar
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails()
    {
        int bookId = Integer.parseInt(text_BookId.getText());
        
        try {
            Connection con  = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id =  ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                lbl_BookId.setText(rs.getString("book_id"));
                lbl_BookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quant.setText(rs.getString("quantity"));
                
            }
            else
            {
//                lbl_bookError.setText("Invalid BooK ID");
               JOptionPane.showMessageDialog(this, "No Book Details Found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
     public void getStudentDetails()
    {
        int StudentId = Integer.parseInt(text_StudentId.getText());
        
        try {
            Connection con  = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id =  ?");
            pst.setInt(1, StudentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                lbl_StudentId.setText(rs.getString("student_id"));
                lbl_StudentName.setText(rs.getString("student_name"));
                lbl_div.setText(rs.getString("class"));
                lbl_branch.setText(rs.getString("branch"));
                
            }
            else
            {
//                lbl_StudentError.setText("Invalid Student Id");
                 JOptionPane.showMessageDialog(this, "No STudnet Details Found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
     
     
     ///Issue Book
     
     public boolean issue_book()
     {
         boolean isIssued = false;
         int bookId = Integer.parseInt(text_BookId.getText());
         int studentId = Integer.parseInt(text_StudentId.getText());
         String bookName = lbl_BookName.getText();
         String studentName = lbl_StudentName.getText();
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String sIssueDate = sdf.format(Date_Issue.getDate());
        String sDueDate = sdf.format(Date_Due.getDate());
         
//        Date uIssueDate =  Date_Issue.getDatoFecha();
//          Date uDueDate =  Date_Due.getDatoFecha();
//          
//          Long l1 = uIssueDate.getTime();
//          
//         
//          java.sql.Date sIssueDate = new java.sql.Date(l1);
//         
//          Long l2 = uDueDate.getTime();
//         
//         
//          java.sql.Date sDueDate = new java.sql.Date(l2);
          
          try {
             Connection con =DBConnection.getConnection();
             String sql = "insert into issue_book(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookId);
             pst.setString(2, bookName);
             pst.setInt(3, studentId);
             pst.setString(4, studentName);
             pst.setString(5, sIssueDate);
             pst.setString(6, sDueDate);
             pst.setString(7, "pending");
             
             int rowCount = pst.executeUpdate();
             
              if (rowCount > 0) {
                  
                  isIssued = true;
              }
              else
              {
                  isIssued =false;
              }
         } catch (Exception e) {
             
             e.printStackTrace();
         }
         
         return isIssued;
         
         
         
     }
     
     public void updateBookCount()
     {
         int bookId = Integer.parseInt(text_BookId.getText());
         
         try {
             Connection con  = DBConnection.getConnection();
             String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
             
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookId);
             
             int rowCount = pst.executeUpdate();
             
             if (rowCount > 0) {
                 
               JOptionPane.showMessageDialog(this, "Book Count Updated");
               int initialCount = Integer.parseInt(lbl_quant.getText());
               lbl_quant.setText(Integer.toString(initialCount - 1));
             }
             
             else
             {
                 JOptionPane.showMessageDialog(this, "Book COunt Updation Failed");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     // Checking duplicate
     
     public boolean isAlreadyIssued()
     {
         boolean isAlreadyIssu =false;
         int bookId = Integer.parseInt(text_BookId.getText());
         int studentId = Integer.parseInt(text_StudentId.getText());
         
         try {
             Connection con = DBConnection.getConnection();
             String sql = "select * from issue_book where book_id = ? and student_id = ? and status =?";
             PreparedStatement pst = con.prepareStatement(sql);
             
             pst.setInt(1, bookId);
             pst.setInt(2, studentId);
             pst.setString(3, "pending");
             
             ResultSet rs = pst.executeQuery();
             
             if (rs.next()) {
                
                 isAlreadyIssu = true;
             }
             else
             {
                 isAlreadyIssu = false;
             }
            
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return isAlreadyIssu;
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_quant = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_BookId = new javax.swing.JLabel();
        lbl_BookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_StudentId = new javax.swing.JLabel();
        lbl_StudentName = new javax.swing.JLabel();
        lbl_div = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        text_BookId = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        text_StudentId = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        Date_Issue = new com.toedter.calendar.JDateChooser();
        Date_Due = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(229, 14, 71));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("  Book Details");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 270, -1));

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

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 320, 5));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 90, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 140, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 100, -1));

        lbl_quant.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_quant.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_quant, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 140, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Book Id :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 100, -1));

        lbl_BookId.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_BookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 140, 30));

        lbl_BookName.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_BookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 210, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 200, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 100, -1));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 830));

        jPanel7.setBackground(new java.awt.Color(1, 77, 109));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel13.setText("  Student Details");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 300, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 320, 5));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Branch :");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 100, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 90, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student Name :");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 150, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Division :");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 100, -1));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 170, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Student Id :");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 120, -1));

        lbl_StudentId.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_StudentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 140, 30));

        lbl_StudentName.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_StudentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 200, 30));

        lbl_div.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        lbl_div.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_div, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 140, 30));

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 450, 830));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel18.setText("  Issue Book");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 120, 300, -1));

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_main.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 200, -1, -1));

        text_BookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        text_BookId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_BookId.setPlaceholder("Enter Book ID..");
        text_BookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_BookIdFocusLost(evt);
            }
        });
        text_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_BookIdActionPerformed(evt);
            }
        });
        panel_main.add(text_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 270, 260, 40));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Book ID :");
        panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 120, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Issue Date :");
        panel_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 460, 130, 40));

        text_StudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        text_StudentId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_StudentId.setPlaceholder("Enter Student ID..");
        text_StudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_StudentIdFocusLost(evt);
            }
        });
        text_StudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_StudentIdActionPerformed(evt);
            }
        });
        panel_main.add(text_StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 350, 260, 40));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Student ID :");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 360, 130, 40));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("Due Date :");
        panel_main.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 550, 130, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(229, 14, 71));
        rSMaterialButtonCircle2.setText("ISSUE BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 680, 350, 60));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panel_main.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 320, 50));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, -1, 5));

        Date_Issue.setBackground(new java.awt.Color(255, 51, 51));
        panel_main.add(Date_Issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 462, 250, 40));

        Date_Due.setBackground(new java.awt.Color(255, 51, 51));
        panel_main.add(Date_Due, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, 250, 40));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 830));

        setSize(new java.awt.Dimension(1567, 831));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void text_BookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_BookIdFocusLost
        // TODO add your handling code here:
        if (!text_BookId.getText().isEmpty()) {
            getBookDetails();
        }
        
    }//GEN-LAST:event_text_BookIdFocusLost

    private void text_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_BookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_BookIdActionPerformed

    private void text_StudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_StudentIdFocusLost
        // TODO add your handling code here:
                 if (!text_StudentId.getText().isEmpty()) {
            getStudentDetails();
        }
    }//GEN-LAST:event_text_StudentIdFocusLost

    private void text_StudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_StudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_StudentIdActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        
        if (lbl_quant.getText().equals("0")) {
            
            JOptionPane.showMessageDialog(this, "This Book IS Not Available");
            
        }
        else
        {
            if (isAlreadyIssued() == false) {
            if(issue_book() == true)
        {
            JOptionPane.showMessageDialog(this, "Book Issued Successfully");
            updateBookCount();
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Book Issue Failed");
        }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Book IS Already Issued");
        }
        }
        
        
        

       
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_Due;
    private com.toedter.calendar.JDateChooser Date_Issue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_BookId;
    private javax.swing.JLabel lbl_BookName;
    private javax.swing.JLabel lbl_StudentId;
    private javax.swing.JLabel lbl_StudentName;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_div;
    private javax.swing.JLabel lbl_quant;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField text_BookId;
    private app.bolivia.swing.JCTextField text_StudentId;
    // End of variables declaration//GEN-END:variables
}
