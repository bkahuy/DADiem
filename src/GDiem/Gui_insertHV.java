/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import GDiem.XLDiem;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

/**
 *
 * @author buikh
 */
public class Gui_insertHV extends JFrame implements MouseListener, ActionListener{

    private JTextField tfmahv, tfhoten;
    private JComboBox<String> cblop;
    private JTextField tfdiem;
    private JButton btnthem;
    private JTable tb;
    private DefaultTableModel dfmodel;
    
    public Gui_insertHV(){
        setTitle("them hoc vien");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(1000,600);
        setLocationRelativeTo(null);
        
        BuildGui();
        loadData(dfmodel);
}
    
    private void BuildGui(){
        JPanel pntrai = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        
        //ma hv
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lbmahv = new JLabel("ma hoc vien");
        pntrai.add(lbmahv, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        tfmahv = new JTextField();
        tfmahv.setSize(new Dimension(300,30));
        pntrai.add(tfmahv, gbc);
        
        //ho ten
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lbhoten = new JLabel("ho ten");
        pntrai.add(lbhoten, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        tfhoten = new JTextField();
        tfhoten.setSize(new Dimension(300,30));
        pntrai.add(tfhoten, gbc);
        
        //lop
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblop = new JLabel("lop");
        pntrai.add(lblop, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        cblop = new JComboBox<>(new String[]{"64KTPM1", "64KTPM2", "64KTPM3", "64KTPM4", "64KTPM5"});
        pntrai.add(cblop, gbc);
        
        //diem
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lbdiem = new JLabel("diem");
        pntrai.add(lbdiem,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        tfdiem = new JTextField();
        tfdiem.setSize(new Dimension(300,30));
        pntrai.add(tfdiem,gbc);
        
        //button
        gbc.gridx = 0;
        gbc.gridy = 6;
        btnthem = new JButton("them hoc vien");
        btnthem.addActionListener((e) -> {
            String mahv = tfmahv.getText().trim();
            String hoten = tfhoten.getText().trim();
            String lop = cblop.getSelectedItem().toString();
            int diem = Integer.parseInt(tfdiem.getText());
            
            Hocvien hv = new Hocvien(mahv, hoten, lop, diem);
            XLDiem xl = new XLDiem();
            boolean res = xl.insertHV(hv);
            if(res){
                loadData(dfmodel);
                JOptionPane.showMessageDialog(null, "them hoc vien thanh cong");
            } else {
                JOptionPane.showMessageDialog(null, "them hoc vien khong thanh cong");
            }
            
        });
        pntrai.add(btnthem, gbc);
        
        //table
        JPanel pnphai = new JPanel(new GridLayout(1, 1));
        String[] headers = {"ma hoc vien", "ho ten", "lop", "diem", "ket qua"};
        dfmodel = new DefaultTableModel(headers, 0);
        tb = new JTable(dfmodel);
        pnphai.add(new JScrollPane(tb));
        
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pntrai, BorderLayout.WEST);
        getContentPane().add(pnphai, BorderLayout.CENTER);

}
        

    private void loadData(DefaultTableModel dfmodel){
        try {
            ResultSet res = XLDiem.getHV();
            dfmodel.setRowCount(0);
            if(res != null){
                while(res.next()){
                    Hocvien hv = new Hocvien(
                            res.getString("mahv"), 
                            res.getString("hoten"), 
                            res.getString("lop"), 
                            res.getInt("diem")
                    );
                    String ketqua = hv.Ketqua(hv.getDiem());
                    
                    dfmodel.addRow(new Object[]{
                        hv.getMahv(),
                        hv.getHoten(),
                        hv.getLop(),
                        hv.getDiem(),
                        ketqua
                    });
                }
            }
            dfmodel.fireTableDataChanged();
        } catch (SQLException e) {
            System.out.println("loadData failed "+ e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Gui_insertHV().setVisible(true);
    }
    
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
