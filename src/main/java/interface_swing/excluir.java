package interface_swing;

import java.awt.EventQueue;
import java.awt.Image;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.projetofinal.PureLamb;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class excluir extends JFrame {
    private static final long serialVersionUID = 5010052770689641095L;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhofinal");
    private EntityManager em = emf.createEntityManager();
    private PureLamb pureLamb;

    private JPanel contentPane;
    private JTextField textField_name;
    private JComboBox<String> comboBox_HasHorn;
    private JComboBox<String> comboBox_isPure;
    private JComboBox<String> comboBox_isFirstBorn;
    private JButton btnExcluir;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    excluir frame = new excluir();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public excluir() {
        setTitle("Excluir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 822);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] booleanOptions = { "true", "false" };

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(166, 264, 70, 17);
        contentPane.add(lblName);

        textField_name = new JTextField();
        textField_name.setBackground(new Color(255, 228, 188));
        textField_name.setBounds(243, 264, 167, 20);
        contentPane.add(textField_name);
        textField_name.setColumns(10);

        //diferenca 80 
        
        JButton btnBuscar = new JButton("Search");
        btnBuscar.setBackground(new Color(255, 228, 188));
        btnBuscar.setBounds(250, 344, 89, 23);
        contentPane.add(btnBuscar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBackground(new Color(255, 228, 188));
        btnExcluir.setBounds(246, 400, 100, 30);
        contentPane.add(btnExcluir);

        JLabel backgroundLabel = new JLabel();
        ImageIcon backgroundIcon = new ImageIcon(
                "C:\\Users\\LNV\\eclipse-workspace\\projetofinal\\Design sem nome.png");
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(625, 784, Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(backgroundImage);
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 625, 784);
        contentPane.add(backgroundLabel);

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textField_name.getText();
                    Query query = em.createQuery("SELECT p FROM PureLamb p WHERE p.name = :name");
                    query.setParameter("name", name);
                    pureLamb = (PureLamb) query.getSingleResult();

                    em.getTransaction().begin();
                    em.remove(pureLamb);
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Excluído com Sucesso");
                } catch (NoResultException ex) {
                    JOptionPane.showMessageDialog(null, "Cordeiro não encontrado");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textField_name.getText();
                    Query query = em.createQuery("SELECT p FROM PureLamb p WHERE p.name = :name");
                    query.setParameter("name", name);
                    pureLamb = (PureLamb) query.getSingleResult();
                    comboBox_HasHorn.setSelectedItem(String.valueOf(pureLamb.isHasHorn()));
                    comboBox_isPure.setSelectedItem(String.valueOf(pureLamb.isPure()));
                    comboBox_isFirstBorn.setSelectedItem(String.valueOf(pureLamb.isFirstBorn()));
                } catch (NoResultException ex) {
                    JOptionPane.showMessageDialog(null, "Cordeiro não encontrado");
                }
            }
        });
    }
}
