package interface_swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import br.edu.unifei.ecot13.projetofinal.PureLamb;

public class incluir extends JFrame {
    private static final long serialVersionUID = -1965577729372740284L;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhofinal");
    private EntityManager em = emf.createEntityManager();

    private JPanel contentPane;
    private JTextField textField_name;
    private JTextField textField_color;
    private JTextField textField_lineage;

    private JSpinner spinner_age;
    private JSpinner spinner_weight;
    private JSpinner spinner_daysAwayFromMother;

    private JComboBox<String> comboBox_HasHorn;
    private JComboBox<String> comboBox_isPure;
    private JComboBox<String> comboBox_isFirstBorn;

    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    incluir frame = new incluir();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public incluir() {
        setTitle("Incluir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 822);

        JLabel background = new JLabel();
        background.setBounds(0, 0, 625, 784); 
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\LNV\\eclipse-workspace\\projetofinal\\Design sem nome.png");
        Image img = backgroundImage.getImage().getScaledInstance(625, 784, Image.SCALE_SMOOTH);  // Ajuste da escala
        ImageIcon scaledImage = new ImageIcon(img);
        background.setIcon(scaledImage);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.add(background);

        spinner_age = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinner_age.setForeground(new Color(255, 228, 188));
        spinner_age.setBackground(new Color(255, 228, 188));
        spinner_age.setBounds(260, 293, 168, 20);
        background.add(spinner_age);

        spinner_weight = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1));
        spinner_weight.setForeground(new Color(255, 228, 188));
        spinner_weight.setBackground(new Color(255, 228, 188));
        spinner_weight.setBounds(260, 326, 168, 20);
        background.add(spinner_weight);

        spinner_daysAwayFromMother = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinner_daysAwayFromMother.setForeground(new Color(255, 228, 188));
        spinner_daysAwayFromMother.setBackground(new Color(255, 228, 188));
        spinner_daysAwayFromMother.setBounds(260, 513, 168, 20);
        background.add(spinner_daysAwayFromMother);

        String[] booleanOptions = {"true", "false"};

        comboBox_HasHorn = new JComboBox<>(booleanOptions);
        comboBox_HasHorn.setBounds(260, 388, 168, 20);
        background.add(comboBox_HasHorn);

        comboBox_isPure = new JComboBox<>(booleanOptions);
        comboBox_isPure.setBounds(260, 419, 168, 20);
        background.add(comboBox_isPure);

        comboBox_isFirstBorn = new JComboBox<>(booleanOptions);
        comboBox_isFirstBorn.setBounds(260, 481, 168, 20);
        background.add(comboBox_isFirstBorn);

        btnNewButton = new JButton("Incluir");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    PureLamb pureLamb = new PureLamb();
                    pureLamb.setName(textField_name.getText());
                    pureLamb.setAge((Integer) spinner_age.getValue());
                    pureLamb.setWeight(((Double) spinner_weight.getValue()).floatValue());
                    pureLamb.setColor(textField_color.getText());
                    pureLamb.setHasHorn(Boolean.parseBoolean((String) comboBox_HasHorn.getSelectedItem()));
                    pureLamb.setPure(Boolean.parseBoolean((String) comboBox_isPure.getSelectedItem()));
                    pureLamb.setLineage(textField_lineage.getText());
                    pureLamb.setFirstBorn(Boolean.parseBoolean((String) comboBox_isFirstBorn.getSelectedItem()));
                    pureLamb.setDaysAwaysFromMother((Integer) spinner_daysAwayFromMother.getValue());

                    em.getTransaction().begin();
                    em.persist(pureLamb);
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Inserido Com Sucesso");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    em.getTransaction().rollback();
                } finally {
                    em.close();
                }
            }
        });
        btnNewButton.setBackground(new Color(255, 228, 188));
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton.setBounds(250, 552, 89, 23);
        background.add(btnNewButton);

        textField_name = new JTextField();
        textField_name.setBackground(new Color(255, 228, 188));
        textField_name.setBounds(260, 264, 167, 20);
        background.add(textField_name);
        textField_name.setColumns(10);

        textField_color = new JTextField();
        textField_color.setBackground(new Color(255, 228, 188));
        textField_color.setBounds(260, 357, 167, 20);
        textField_color.setColumns(10);
        background.add(textField_color);

        textField_lineage = new JTextField();
        textField_lineage.setBackground(new Color(255, 228, 188));
        textField_lineage.setBounds(260, 450, 167, 20);
        textField_lineage.setColumns(10);
        background.add(textField_lineage);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(166, 264, 70, 17);
        background.add(lblNewLabel);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAge.setBounds(166, 293, 104, 20);
        background.add(lblAge);

        JLabel lblWeight = new JLabel("Weight:");
        lblWeight.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblWeight.setBounds(166, 326, 104, 17);
        background.add(lblWeight);

        JLabel lblColor = new JLabel("Color:");
        lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblColor.setBounds(166, 357, 86, 17);
        background.add(lblColor);

        JLabel lblHasHorn = new JLabel("Has Horn:");
        lblHasHorn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblHasHorn.setBounds(166, 388, 114, 17);
        background.add(lblHasHorn);

        JLabel lblPure = new JLabel("Pure:");
        lblPure.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPure.setBounds(166, 419, 114, 20);
        background.add(lblPure);

        JLabel lblLineage = new JLabel("Lineage:");
        lblLineage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblLineage.setBounds(166, 450, 104, 17);
        background.add(lblLineage);

        JLabel lblIsFirstBorn = new JLabel("First Born:");
        lblIsFirstBorn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblIsFirstBorn.setBounds(166, 481, 221, 17);
        background.add(lblIsFirstBorn);

        JLabel lblNewLabel_1 = new JLabel("Include new Lamb");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lblNewLabel_1.setBounds(166, 175, 390, 79);
        background.add(lblNewLabel_1);

        background.setOpaque(true);
        setContentPane(contentPane);
    }
}
