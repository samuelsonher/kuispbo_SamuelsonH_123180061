/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.FlowLayout;
/**
 *
 * @author Hp
 */
public class DataViewInput extends JFrame implements ActionListener{
    JLabel lJudul, lTipe, lId, lUrut, lEpisode, lGenre, lStatus, lRating;
    JTextField tfJudul, tfTipe, tfEpisode, tfGenre, tfRating;
    JComboBox cmbStatus;
    String[] statusFilm = {"Belum", "Selesai"};
    
    JTable tabel;
    String[][] data = new String[500][8];
    String[] kolom = {"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"};
    JScrollPane scrollPane;
    JButton btnSimpan;
    
    JTextField tfSearch;
    JButton btnRefresh, btnCreate, btnUpdate, btnDelete, btnExit, btnSearch;

    String DBurl = "jdbc:mysql://localhost/praktikum";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public DataViewInput(){
        setTitle("Lihat Data Film dan Input Data Film");
        setDefaultCloseOperation(3);
        setSize(500, 450);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from mahasiswa";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()){
                data[p][0] = resultSet.getString(p+1);
                data[p][1] = resultSet.getString("ID");
                data[p][2] = resultSet.getString("Judul");
                data[p][3] = resultSet.getString("Tipe");
                data[p][4] = resultSet.getString("Episode");
                data[p][5] = resultSet.getString("Genre");
                data[p][6] = resultSet.getString("Status");
                data[p][7] = resultSet.getString("Rating");
                p++;
            }
            statement.close();
            koneksi.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        tabel = new JTable(data, kolom);
        lJudul = new JLabel("Judul");
        tfJudul = new JTextField(20);
        lTipe = new JLabel("Tipe");
        tfTipe = new JTextField(20);
        lEpisode = new JLabel("Episode");
        tfEpisode = new JTextField(20);
        lGenre = new JLabel("Genre");
        tfGenre = new JTextField(20);
        lStatus = new JLabel("Status");
        cmbStatus = new JComboBox(statusFilm);
        lRating = new JLabel("Rating");
        tfRating = new JTextField(20);
        btnSimpan = new JButton("Simpan");
        tfJudul.addActionListener(this);
        tfTipe.addActionListener(this);
        tfEpisode.addActionListener(this);
        tfGenre.addActionListener(this);
        cmbStatus.addActionListener(this);
        tfRating.addActionListener(this);
        btnSimpan.addActionListener(this);
        
        tfSearch = new JTextField(20);
        btnRefresh = new JButton("Refresh");
        btnUpdate = new JButton("Ubah");
        btnDelete = new JButton("Hapus");
        btnExit = new JButton("Exit");
        btnSearch = new JButton("Search");
        btnRefresh.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        tfSearch.addActionListener(this);
        btnSearch.addActionListener(this);

        setLayout(new FlowLayout());
        add(scrollPane);
        add(tfSearch);
        add(btnSearch);
        add(btnRefresh);
        add(btnDelete);
        add(btnUpdate);
        add(btnExit);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnDelete) {
            Delete(); 
        }
        if (e.getSource()==btnUpdate) {
            new DataViewInput();
        }
        if (e.getSource()== btnSearch) {
            Search(); 
        }
        if (e.getSource()== btnExit) {
            new Login(); 
        }
        if (e.getSource()== btnRefresh) {
            new DataViewInput(); 
        }
    }
    private void Delete(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("delete from mahasiswa where nim = '"+ tfSearch.getText() + "'" );
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void Search(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("delete from mahasiswa where nim = '"+ tfSearch.getText() + "'" );
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data GagalDihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}

