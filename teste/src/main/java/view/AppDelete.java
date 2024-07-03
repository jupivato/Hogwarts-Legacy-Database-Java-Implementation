package view;

import java.awt.EventQueue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import teste.MagicalCreature;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppDelete extends JFrame {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("julia");
    private EntityManager em = emf.createEntityManager();
    private MagicalCreature creature = new MagicalCreature();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCreatureName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppDelete frame = new AppDelete();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AppDelete() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 955, 506);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        txtCreatureName = new JTextField();
        txtCreatureName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtCreatureName.setBounds(10, 60, 342, 38);
        contentPane.add(txtCreatureName);
        txtCreatureName.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Digite o nome da criatura mágica que deseja excluir:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 11, 486, 38);
        contentPane.add(lblNewLabel);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    em.getTransaction().begin();
                    
                    // Buscar a criatura mágica pelo nome
                    String hql = "from MagicalCreature c where c.name = :name";
                    Query query = em.createQuery(hql);
                    query.setParameter("name", txtCreatureName.getText());
                    creature = (MagicalCreature) query.getSingleResult();
                    
                    if (creature != null) {
                        // Remover a criatura mágica
                        em.remove(creature);
                        em.getTransaction().commit();
                        JOptionPane.showMessageDialog(null, "Criatura mágica removida com sucesso!");
                    }
                } catch (NoResultException nre) {
                    em.getTransaction().rollback();
                    JOptionPane.showMessageDialog(null, "Criatura mágica não encontrada.");
                } catch (Exception ex) {
                    em.getTransaction().rollback();
                    JOptionPane.showMessageDialog(null, "Não foi possível a remoção");
                    ex.printStackTrace();
                }
            }
        });
        btnDelete.setFont(new Font("Arial", Font.PLAIN, 15));
        btnDelete.setBounds(369, 60, 109, 38);
        contentPane.add(btnDelete);
    }
}