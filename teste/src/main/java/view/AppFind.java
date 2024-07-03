package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import teste.MagicalCreature;
import teste.Place;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppFind extends JFrame {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("julia");
    private EntityManager em = emf.createEntityManager();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textType;
    private JTextField textFeatures;
    private JTextField textPlace;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppFind frame = new AppFind();
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
    public AppFind() {
        setTitle("Find and Update Magical Creature");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 698, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textName = new JTextField();
        textName.setBounds(10, 35, 612, 32);
        contentPane.add(textName);
        textName.setColumns(10);

        JLabel lblNewLabel = new JLabel("Digite o nome da criatura mágica");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 11, 255, 25);
        contentPane.add(lblNewLabel);

        textType = new JTextField();
        textType.setColumns(10);
        textType.setBounds(10, 130, 612, 25);
        contentPane.add(textType);

        JLabel lblType = new JLabel("Tipo:");
        lblType.setFont(new Font("Arial", Font.PLAIN, 15));
        lblType.setBounds(10, 100, 62, 25);
        contentPane.add(lblType);

        textFeatures = new JTextField();
        textFeatures.setColumns(10);
        textFeatures.setBounds(10, 190, 612, 25);
        contentPane.add(textFeatures);

        JLabel lblFeatures = new JLabel("Características:");
        lblFeatures.setFont(new Font("Arial", Font.PLAIN, 15));
        lblFeatures.setBounds(10, 160, 120, 25);
        contentPane.add(lblFeatures);

        textPlace = new JTextField();
        textPlace.setColumns(10);
        textPlace.setBounds(10, 250, 612, 25);
        contentPane.add(textPlace);

        JLabel lblPlace = new JLabel("Local:");
        lblPlace.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPlace.setBounds(10, 220, 100, 25);
        contentPane.add(lblPlace);

        JButton btnBuscar = new JButton("Buscar e Atualizar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    em.getTransaction().begin();
                    
                    MagicalCreature creature = (MagicalCreature) em.createQuery(
                        "from MagicalCreature c where c.name = :name"
                    ).setParameter("name", textName.getText()).getSingleResult();

                    if (creature != null) {
                        boolean updated = false;

                        // Verificar e atualizar o tipo
                        if (!textType.getText().equals(creature.getMagicalCreatureType())) {
                            creature.setMagicalCreatureType(textType.getText());
                            updated = true;
                        }

                        // Verificar e atualizar as características
                        if (!textFeatures.getText().equals(creature.getMaagicalFeatures())) {
                            creature.setMaagicalFeatures(textFeatures.getText());
                            updated = true;
                        }

                        // Verificar e atualizar o local
                        Place place = null;
                        try {
                            place = (Place) em.createQuery(
                                "from Place p where p.name = :name"
                            ).setParameter("name", textPlace.getText()).getSingleResult();
                        } catch (NoResultException nre) {
                            place = new Place();
                            place.setName(textPlace.getText());
                            em.persist(place);
                            updated = true;
                        }

                        if (!textPlace.getText().equals(creature.getPlace().getName())) {
                            creature.setPlace(place);
                            updated = true;
                        }

                        // Atualizar a criatura se houver alterações
                        if (updated) {
                            em.merge(creature);
                            em.getTransaction().commit();
                            JOptionPane.showMessageDialog(null, "Criatura mágica atualizada com sucesso!");
                        } else {
                            em.getTransaction().rollback();
                            JOptionPane.showMessageDialog(null, "Nenhuma mudança detectada.");
                        }
                    }
                } catch (NoResultException nre) {
                    // Trata o caso onde nenhum resultado é encontrado
                    JOptionPane.showMessageDialog(null, "Criatura mágica não encontrada.");
                    em.getTransaction().rollback();
                } catch (Exception ex) {
                    // Trata outras exceções
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar/atualizar a criatura mágica: " + ex.getMessage());
                    em.getTransaction().rollback();
                }
            }
        });
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 13));
        btnBuscar.setBounds(470, 300, 150, 39);
        contentPane.add(btnBuscar);
    }
}
