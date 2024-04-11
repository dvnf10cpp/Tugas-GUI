package window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Database;
import data.Student;

public class App 
{
    private GFrame frame;

    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel nimLabel;
    private JLabel statusLabel;

    private JButton submitButton;
    
    private JTextField nameField;
    private JTextField nimField;


    private Container cont;

    public App()
    {
        frame = new GFrame();
        cont = frame.getContentPane(); 

        titleLabel = new JLabel("<HTML>Selamat Datang di Sistem IDK</HTML>");
        nameLabel = new JLabel("Nama ");
        nimLabel = new JLabel("Nim ");
        statusLabel = new JLabel("<HTML></HTML>");

        nameField = new JTextField(16);
        nimField = new JTextField(16);

        submitButton = new JButton("SIMPAN");

        setFont(titleLabel, 26, Color.BLACK, Font.PLAIN);
        setFont(nameLabel, 22, Color.BLACK, Font.PLAIN);
        setFont(nimLabel, 22, Color.BLACK, Font.PLAIN);
        setFont(submitButton, 22, Color.BLACK, Font.PLAIN);
        setFont(statusLabel, 16, Color.BLACK,Font.PLAIN);
        setFont(nameField,22,Color.BLACK,Font.PLAIN);
        setFont(nimField,22,Color.BLACK,Font.PLAIN);

        titleLabel.setVisible(true);
        titleLabel.setBounds(360, 60, 350,100); 

        nameLabel.setVisible(true);
        nameLabel.setBounds(290,150,100,100);

        nimLabel.setVisible(true);
        nimLabel.setBounds(292, 250, 100, 100);

        nameField.setVisible(true);
        nameField.setBounds(400,180,250,40);

        nimField.setVisible(true);
        nimField.setBounds(402, 280, 250,40);

        submitButton.setVisible(true);
        submitButton.setBounds(400,350,250,50);

        statusLabel.setBounds(400, 420, 400, 100);

        setButtonColor(submitButton);
        
        cont.add(titleLabel);
        cont.add(nameLabel);
        cont.add(nameField);
        cont.add(nimLabel);
        cont.add(nimField);
        cont.add(submitButton);
        cont.add(statusLabel);

        frame.setVisible(true);

        submitButton.addActionListener(new SaveController());
    }

    private class SaveController implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (notValid())
                return;
                
            String nama, nim;
            nama = nameField.getText();
            nim = nimField.getText();
            Student student = new Student(nama, nim);

            if (Database.hasStudent(student))
            {
                statusLabel.setText(String.format("<HTML>Siswa dengan nama %s nim %s sudah terdaftar</HTML>",nama,nim));
                return;
            }
            
            Database.insertStudent(student);
            statusLabel.setText(String.format("<HTML>Informasi Terdaftar! Kamu terdaftar sebagai %s dengan NIM %s</HTML>",nama,nim));
        }
    }

    private boolean notValid()
    {
        boolean value = false;
        if(nameField.getText().equals("") || nimField.getText().equals(""))
        {
            statusLabel.setText("Isikan informasi terlebih dahulu");
            value = true;
        }
        return value;
    }

    private void setFont(JComponent comp, int size, Color color, int type)
    {
        comp.setFont(new Font("Calibri",type,size));
        comp.setForeground(color);
    }

    private void setButtonColor(JButton button)
    {
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK); 
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER); 
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setFocusPainted(false);
    }
}
