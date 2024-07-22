package interface_swing;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class tela {

	private JFrame frmTela;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela window = new tela();
					window.frmTela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTela = new JFrame();
		frmTela.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LNV\\eclipse-workspace\\projetofinal\\Obra Letra.png"));
		frmTela.setTitle("Tela");
		frmTela.setBounds(100, 100, 1080, 720);
		frmTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTela.setJMenuBar(menuBar);
		
		JMenuItem mntmNovo = new JMenuItem("Incluir");
		mntmNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluir.main(null);
			}
		});
		menuBar.add(mntmNovo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alterar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar.main(null);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Excluir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir.main(null);
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		frmTela.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LNV\\eclipse-workspace\\projetofinal\\Obra Letra.png"));
		lblNewLabel.setBounds(0, 0, 1064, 653);
		frmTela.getContentPane().add(lblNewLabel);
	}
}
