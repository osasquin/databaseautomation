package interface_swing;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

import br.edu.unifei.ecot13.projetofinal.PureLamb;

public class alterar extends JFrame {
    private static final long serialVersionUID = 8749944474496072440L;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhofinal");
    private EntityManager em = emf.createEntityManager();
    private PureLamb pureLamb;

    private JPanel contentPane;
    private JTextField textField_name;
    private JSpinner spinner_age;
    private JSpinner spinner_weight;
    private JTextField textField_color;
    private JTextField textField_lineage;
    private JSpinner spinner_daysAwayFromMother;
    private JButton btnAlterar;
    private JLabel lblNewLabel;
    private JLabel lblAge;
    private JLabel lblWeight;
    private JLabel lblColor;
    private JLabel lblHasHorn;
    private JLabel lblPure;
    private JLabel lblLineage;
    private JLabel lblFirstBorn;
    private JLabel lblDaysAwaysFromMother;
    private JLabel lblNewLabel_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    alterar frame = new alterar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public alterar() {
        setTitle("Alterar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 822);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        spinner_age = new JSpinner();
        spinner_age.setForeground(new Color(255, 228, 188));
        spinner_age.setBackground(new Color(255, 228, 188));
        spinner_age.setBounds(365, 323, 168, 20);
        contentPane.add(spinner_age);

        btnAlterar = new JButton("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pureLamb.setName(textField_name.getText());
                pureLamb.setAge((Integer) spinner_age.getValue());
                pureLamb.setWeight((Float) spinner_weight.getValue());
                pureLamb.setColor(textField_color.getText());
                pureLamb.setDaysAwaysFromMother((Integer) spinner_daysAwayFromMother.getValue());
                em.getTransaction().begin();
                em.merge(pureLamb);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Alterado Com Sucesso");
            }
        });
        btnAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnAlterar.setBackground(new Color(255, 228, 188));
        btnAlterar.setBounds(301, 574, 168, 20);
        contentPane.add(btnAlterar);

        textField_name = new JTextField();
        textField_name.setBackground(new Color(255, 228, 188));
        textField_name.setBounds(365, 264, 70, 20);
        contentPane.add(textField_name);
        textField_name.setColumns(10);

        textField_color = new JTextField();
        textField_color.setBackground(new Color(255, 228, 188));
        textField_color.setBounds(365, 382, 168, 20);
        textField_color.setColumns(10);
        contentPane.add(textField_color);
        
        String[] booleanOptions = {"true", "false"};

        JComboBox<String> comboBox_HasHorn = new JComboBox<>(booleanOptions);
        comboBox_HasHorn.setBounds(365, 416, 168, 20);
        contentPane.add(comboBox_HasHorn);
        
        JComboBox<String> comboBox_isPure = new JComboBox<>(booleanOptions);
        comboBox_isPure.setBounds(362, 450, 168, 20);
        contentPane.add(comboBox_isPure);
        
        JComboBox<String> comboBox_isFirstBorn = new JComboBox<>(booleanOptions);
        comboBox_isFirstBorn.setBounds(362, 512, 168, 20);
        contentPane.add(comboBox_isFirstBorn);
        
        textField_lineage = new JTextField();
        textField_lineage.setBackground(new Color(255, 228, 188));
        textField_lineage.setBounds(365, 481, 168, 20);
        textField_lineage.setColumns(10);
        contentPane.add(textField_lineage);
        
        spinner_weight = new JSpinner();
        spinner_weight.setBounds(362, 354, 168, 20);
        contentPane.add(spinner_weight);

        spinner_daysAwayFromMother = new JSpinner();
        spinner_daysAwayFromMother.setBounds(362, 543, 168, 20);
        contentPane.add(spinner_daysAwayFromMother);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(255, 228, 188));
        btnBuscar.setBounds(444, 264, 89, 23);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField_name.getText();
                Query query = em.createQuery("SELECT p FROM PureLamb p WHERE p.name = :name");
                query.setParameter("name", name);
                try {
                    pureLamb = (PureLamb) query.getSingleResult();

                    // Set the retrieved values in the text fields and spinners
                    textField_name.setText(pureLamb.getName());
                    spinner_age.setValue(pureLamb.getAge());
                    spinner_weight.setValue(pureLamb.getWeight());
                    textField_color.setText(pureLamb.getColor());
                    spinner_daysAwayFromMother.setValue(pureLamb.getDaysAwaysFromMother());

                    // Enable the "Alterar" button
                    btnAlterar.setEnabled(true);
                } catch (NoResultException ex) {
                    JOptionPane.showMessageDialog(null, "Cordeiro não existe");
                }
            }
        });

        contentPane.add(btnBuscar);

        lblNewLabel = new JLabel("Buscar:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(180, 264, 85, 14);
        contentPane.add(lblNewLabel);

        lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAge.setBounds(180, 323, 89, 20);
        contentPane.add(lblAge);

        lblWeight = new JLabel("Weight:");
        lblWeight.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblWeight.setBounds(180, 354, 85, 14);
        contentPane.add(lblWeight);

        lblColor = new JLabel("Color:");
        lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblColor.setBounds(180, 385, 85, 14);
        contentPane.add(lblColor);

        lblHasHorn = new JLabel("HasHorn:");
        lblHasHorn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblHasHorn.setBounds(180, 416, 89, 14);
        contentPane.add(lblHasHorn);

        lblPure = new JLabel("Pure:");
        lblPure.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPure.setBounds(180, 450, 104, 14);
        contentPane.add(lblPure);

        lblLineage = new JLabel("Lineage:");
        lblLineage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblLineage.setBounds(180, 481, 153, 14);
        contentPane.add(lblLineage);

        lblFirstBorn = new JLabel("First Born:");
        lblFirstBorn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblFirstBorn.setBounds(180, 512, 163, 14);
        contentPane.add(lblFirstBorn);

        lblDaysAwaysFromMother = new JLabel("Days Away From Mother:");
        lblDaysAwaysFromMother.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblDaysAwaysFromMother.setBounds(180, 543, 163, 14);
        contentPane.add(lblDaysAwaysFromMother);

        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LNV\\eclipse-workspace\\projetofinal\\Design sem nome.png"));
        lblNewLabel_1.setBounds(0, 0, 626, 783);
        contentPane.add(lblNewLabel_1);
    }
}
