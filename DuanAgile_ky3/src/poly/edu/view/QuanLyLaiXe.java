package poly.edu.view;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.model.quanLyLaiXe;

public class QuanLyLaiXe extends javax.swing.JFrame {

    ArrayList<quanLyLaiXe> list = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    int viTri;

    public QuanLyLaiXe() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        LoadTable();
          if(tblLaiXe.getRowCount()>1){
            viTri=0;
            tblLaiXe.setRowSelectionInterval(viTri, viTri);
           ShowDetaid();
            
        }

    }

    private void LoadTable() throws Exception {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT ID, TenNV, Tuoi, LoaiBang, Luong, NamKN, \n"
                    + "    CASE \n"
                    + "        WHEN NamKN > 2 THEN N'Lái cũ' \n"
                    + "        ELSE N'Lái mới' \n"
                    + "    END AS N'Trạng thái' \n"
                    + "FROM Laixe";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            ArrayList<quanLyLaiXe> listLaiXe = new ArrayList<>();
            while (rs.next()) {

                quanLyLaiXe qLaiXe = new quanLyLaiXe();
                qLaiXe.setID(rs.getInt(1));
                qLaiXe.setTenNV(rs.getString(2));
                qLaiXe.setTuoi(rs.getInt(3));
                qLaiXe.setLoaiBang(rs.getString(4));
                qLaiXe.setLuong(rs.getDouble(5));
                qLaiXe.setNamKinhNghiem(rs.getInt(6));
                listLaiXe.add(qLaiXe);
            }
            tblLaiXe.setModel(model);
            model.setColumnCount(0);
            model.addColumn("ID");
            model.addColumn("Tên NV");
            model.addColumn("Tuổi");
            model.addColumn("Loại bằng");
            model.addColumn("Lương");
            model.addColumn("Năm KN");
            model.addColumn("Trạng thái");
            model.setRowCount(0);
            for (quanLyLaiXe lyLaiXe : listLaiXe) {
                model.addRow(new Object[]{lyLaiXe.getID(), lyLaiXe.getTenNV(), lyLaiXe.getTuoi(), lyLaiXe.getLoaiBang(), lyLaiXe.getLuong(), lyLaiXe.getNamKinhNghiem(), lyLaiXe.getStatus(lyLaiXe.getNamKinhNghiem())});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loatd(quanLyLaiXe quanxe) {

        if (quanxe == null) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu");
        } else if (quanxe.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        } else {
            model = (DefaultTableModel) tblLaiXe.getModel();
            model.setColumnCount(0);
            model.addColumn("ID");
            model.addColumn("Tên NV");
            model.addColumn("Tuổi");
            model.addColumn("Loại bằng");
            model.addColumn("Lương");
            model.addColumn("Năm KN");
            model.addColumn("Trạng thái");

            model.setRowCount(0);

            model.addRow(new Object[]{quanxe.getID(), quanxe.getTenNV(), quanxe.getTuoi(), quanxe.getLoaiBang(), quanxe.getLuong(), quanxe.getNamKinhNghiem(), quanxe.getStatus(quanxe.getNamKinhNghiem())});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIDcanTim = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        cboLoaiBang = new javax.swing.JComboBox<>();
        txtNam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaiXe = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí nhân viên lái xe");
        setMaximumSize(new java.awt.Dimension(628, 685));
        setMinimumSize(new java.awt.Dimension(628, 685));
        setPreferredSize(new java.awt.Dimension(628, 685));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 33, 33));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN LÁI XE ");

        jPanel1.setBackground(new java.awt.Color(31, 232, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(32167, 32167));
        jPanel1.setPreferredSize(new java.awt.Dimension(497, 107));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("ID");

        txtIDcanTim.setPreferredSize(new java.awt.Dimension(245, 28));
        txtIDcanTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtIDcanTimCaretUpdate(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(240, 26, 26));
        btnSearch.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/edu/image/Search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtIDcanTim, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtIDcanTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnSearch)))
                .addGap(38, 38, 38))
        );

        jPanel2.setBackground(new java.awt.Color(31, 232, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMaximumSize(new java.awt.Dimension(55, 55));
        jPanel2.setPreferredSize(new java.awt.Dimension(354, 338));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Tuổi");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Tên NV");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Lương");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Loại bằng");

        txtID.setEnabled(false);
        txtID.setPreferredSize(new java.awt.Dimension(140, 28));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtTenNV.setMaximumSize(new java.awt.Dimension(140, 28));
        txtTenNV.setMinimumSize(new java.awt.Dimension(140, 28));
        txtTenNV.setPreferredSize(new java.awt.Dimension(140, 28));

        txtTuoi.setPreferredSize(new java.awt.Dimension(140, 28));

        txtLuong.setPreferredSize(new java.awt.Dimension(140, 28));

        cboLoaiBang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B1", "B2", "C" }));
        cboLoaiBang.setPreferredSize(new java.awt.Dimension(140, 28));
        cboLoaiBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiBangActionPerformed(evt);
            }
        });

        txtNam.setPreferredSize(new java.awt.Dimension(140, 28));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setText("Năm KN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLoaiBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cboLoaiBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26))
        );

        txtTenNV.getAccessibleContext().setAccessibleName("");
        txtTenNV.getAccessibleContext().setAccessibleDescription("");

        btnNew.setBackground(new java.awt.Color(233, 236, 64));
        btnNew.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/edu/image/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.setMaximumSize(new java.awt.Dimension(110, 36));
        btnNew.setMinimumSize(new java.awt.Dimension(110, 36));
        btnNew.setPreferredSize(new java.awt.Dimension(110, 36));
        btnNew.setSelected(true);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(233, 236, 64));
        btnSave.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/edu/image/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setMaximumSize(new java.awt.Dimension(110, 36));
        btnSave.setMinimumSize(new java.awt.Dimension(110, 36));
        btnSave.setPreferredSize(new java.awt.Dimension(110, 36));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(233, 236, 64));
        btnDelete.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/edu/image/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMaximumSize(new java.awt.Dimension(87, 36));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(233, 236, 64));
        btnUpdate.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/edu/image/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblLaiXe.setBackground(new java.awt.Color(107, 245, 220));
        tblLaiXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLaiXe.setPreferredSize(new java.awt.Dimension(596, 127));
        tblLaiXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLaiXeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLaiXe);

        btnExit.setBackground(new java.awt.Color(233, 236, 64));
        btnExit.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/edu/image/Exit.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel1))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnUpdate)
                        .addGap(23, 23, 23)
                        .addComponent(btnExit)
                        .addGap(53, 53, 53)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtID.setText("");
        txtTenNV.setText("");
        txtTuoi.setText("");
        txtLuong.setText("");
        txtNam.setText("");
        tblLaiXe.clearSelection(); 
      

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (txtTenNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return;
        }
        if (txtTuoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tuổi không được để trống");
            return;
        }
        try {
            int tuoi = Integer.parseInt(txtTuoi.getText());
            if (tuoi >= 18 && tuoi <= 70) {

            } else {
                JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số");
            return;
        }
        if (txtLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lương không được để trống");
            return;
        }
        try {
            double luong = Double.parseDouble(txtLuong.getText());
            if (luong > 0) {

            } else {
                JOptionPane.showMessageDialog(this, "Lương không hợp lệ");
                return;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương không đúng định dạng");
            return;
        }
        if (txtNam.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Năm KN không được để trống");
            return;
        }
        try {
            int namKN = Integer.parseInt(txtNam.getText());
            if (namKN > 0 && namKN <= 30) {
            } else {
                JOptionPane.showMessageDialog(this, "Năm KN không hợp lệ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Năm KN phải là số");
            return;
        }
        try {
            int yesNo = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm không?", "thêm", JOptionPane.YES_NO_OPTION);
            if (yesNo == JOptionPane.YES_OPTION) {

                Connection connection = DBConnection.getConnection();
                String sql = "INSERT INTO Laixe(TenNV,Tuoi,LoaiBang,Luong,NamKN)VALUES(?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, txtTenNV.getText());
                ps.setInt(2, Integer.parseInt(txtTuoi.getText()));
                ps.setString(3, (String) cboLoaiBang.getSelectedItem());
                ps.setDouble(4, Double.parseDouble(txtLuong.getText()));
                ps.setInt(5, Integer.parseInt(txtNam.getText()));
                ps.executeUpdate();
                ps.close();
                connection.close();
                JOptionPane.showMessageDialog(this, "Đã thêm");
                LoadTable();
            } else {
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (tblLaiXe.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(this, "Không còn dữ liệu để xóa");
                return;
            }
            int viTri = tblLaiXe.getSelectedRow();
            if (viTri == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!!");
                return;
            }

            int yesNo = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (yesNo == JOptionPane.YES_OPTION) {

                Connection connection = DBConnection.getConnection();
                String sql = "DELETE FROM Laixe WHERE ID=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtID.getText()));

                ps.executeUpdate();
                ps.close();
                connection.close();
                JOptionPane.showMessageDialog(this, "Đã xóa");
                LoadTable();
            } else {
                return;
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtTenNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return;
        }
        if (txtTuoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tuổi không được để trống");
            return;
        }
        try {
            int tuoi = Integer.parseInt(txtTuoi.getText());
            if (tuoi >= 18 && tuoi <= 70) {

            } else {
                JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số");
            return;
        }
        if (txtLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lương không được để trống");
            return;
        }
        try {
            double luong = Double.parseDouble(txtLuong.getText());
            if (luong > 0) {

            } else {
                JOptionPane.showMessageDialog(this, "Lương không hợp lệ");
                return;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương không đúng định dạng");
            return;
        }
        if (txtNam.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Năm KN không được để trống");
            return;
        }
        try {
            int namKN = Integer.parseInt(txtNam.getText());
            if (namKN > 0 && namKN <= 30) {
            } else {
                JOptionPane.showMessageDialog(this, "Năm KN không hợp lệ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Năm KN phải là số");
            return;
        }
        try {

            int yesNo = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa không?", "sửa", JOptionPane.YES_NO_OPTION);
            if (yesNo == JOptionPane.YES_OPTION) {
                Connection connection = DBConnection.getConnection();
                String sql = "UPDATE Laixe SET TenNV=?,Tuoi=?,LoaiBang=?,Luong=?,NamKN=? WHERE ID=?";
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, txtTenNV.getText());
                ps.setInt(2, Integer.parseInt(txtTuoi.getText()));
                ps.setString(3, (String) cboLoaiBang.getSelectedItem());
                ps.setDouble(4, Double.parseDouble(txtLuong.getText()));
                ps.setInt(5, Integer.parseInt(txtNam.getText()));
                ps.setInt(6, Integer.parseInt(txtID.getText()));

                ps.executeUpdate();
                ps.close();
                connection.close();
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                LoadTable();
            } else {
                return;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
public void ShowDetaid(){
    
        try {
            viTri = tblLaiXe.getSelectedRow();
            Integer id = (Integer) tblLaiXe.getValueAt(viTri, 0);
            String ten = (String) tblLaiXe.getValueAt(viTri, 1);
            Integer tuoi = (Integer) tblLaiXe.getValueAt(viTri, 2);
            String loaiBang = (String) tblLaiXe.getValueAt(viTri, 3);
            Double luong = (Double) tblLaiXe.getValueAt(viTri, 4);
            Integer namKN = (Integer) tblLaiXe.getValueAt(viTri, 5);

            txtID.setText(id + "");
            txtTenNV.setText(ten);
            txtTuoi.setText(tuoi + "");
            cboLoaiBang.setSelectedItem(loaiBang);
            txtLuong.setText(luong + "");
            txtNam.setText(namKN + "");

        } catch (Exception e) {
        }
}
    private void tblLaiXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaiXeMouseClicked
ShowDetaid();
    }//GEN-LAST:event_tblLaiXeMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        try {
            if (txtIDcanTim.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập ID cần tìm!");
                return;
            }
            int ma = Integer.parseInt(txtIDcanTim.getText());
            ArrayList<quanLyLaiXe> listLaiXe = timKiem(ma);

            if (listLaiXe.size() == 0) {
                JOptionPane.showMessageDialog(this, "ID không tồn tại");
                return;
            } else {
                quanLyLaiXe quanLyLaiXe = listLaiXe.get(0);
                JOptionPane.showMessageDialog(this, "Tìm thành công");
                txtID.setText(quanLyLaiXe.getID() + "");
                txtTenNV.setText(quanLyLaiXe.getTenNV());
                txtTuoi.setText(quanLyLaiXe.getTuoi() + "");
                cboLoaiBang.setSelectedItem(quanLyLaiXe.getLoaiBang());
                txtLuong.setText(quanLyLaiXe.getLuong() + "");
                txtNam.setText(quanLyLaiXe.getNamKinhNghiem() + "");
                loatd(quanLyLaiXe);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID phải là số");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    public ArrayList<quanLyLaiXe> timKiem(int ID) throws Exception {
        ArrayList<quanLyLaiXe> listLaiXe = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT ID,TenNV,Tuoi,LoaiBang,Luong,NamKN FROM Laixe WHERE ID=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            quanLyLaiXe qllx = new quanLyLaiXe();
            qllx.setID(rs.getInt("ID"));
            qllx.setTenNV(rs.getString("TenNV"));
            qllx.setTuoi(rs.getInt("Tuoi"));
            qllx.setLoaiBang(rs.getString("LoaiBang"));
            qllx.setLuong(rs.getDouble("Luong"));
            qllx.setNamKinhNghiem(rs.getInt("NamKN"));
            listLaiXe.add(qllx);
        }
        ps.close();
        connection.close();
        return listLaiXe;

    }
    private void cboLoaiBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiBangActionPerformed

    }//GEN-LAST:event_cboLoaiBangActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        new DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed

    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDcanTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtIDcanTimCaretUpdate

    }//GEN-LAST:event_txtIDcanTimCaretUpdate

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLyLaiXe().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyLaiXe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboLoaiBang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaiXe;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDcanTim;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

}
