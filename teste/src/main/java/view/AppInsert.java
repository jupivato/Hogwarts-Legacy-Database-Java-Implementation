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
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AppInsert extends JFrame {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("julia");
    private EntityManager em = emf.createEntityManager();
    private MagicalCreature creature = new MagicalCreature();

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
                    AppInsert frame = new AppInsert();
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
    public AppInsert() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 698, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textName = new JTextField();
        textName.setBackground(new Color(192, 192, 192));
        textName.setFont(new Font("Arial", Font.PLAIN, 12));
        textName.setBounds(10, 38, 612, 29);
        contentPane.add(textName);
        textName.setColumns(10);

        JLabel lblName = new JLabel("Nome da Criatura Mágica:");
        lblName.setFont(new Font("Arial", Font.PLAIN, 14));
        lblName.setBounds(10, 11, 206, 29);
        contentPane.add(lblName);

        JLabel lblType = new JLabel("Tipo de Criatura Mágica:");
        lblType.setFont(new Font("Arial", Font.PLAIN, 14));
        lblType.setBounds(10, 65, 206, 35);
        contentPane.add(lblType);

        textType = new JTextField();
        textType.setFont(new Font("Arial", Font.PLAIN, 12));
        textType.setColumns(10);
        textType.setBackground(Color.LIGHT_GRAY);
        textType.setBounds(10, 97, 612, 29);
        contentPane.add(textType);

        JLabel lblFeatures = new JLabel("Características Mágicas:");
        lblFeatures.setFont(new Font("Arial", Font.PLAIN, 14));
        lblFeatures.setBounds(10, 136, 206, 35);
        contentPane.add(lblFeatures);

        textFeatures = new JTextField();
        textFeatures.setFont(new Font("Arial", Font.PLAIN, 12));
        textFeatures.setColumns(10);
        textFeatures.setBackground(Color.LIGHT_GRAY);
        textFeatures.setBounds(10, 172, 612, 29);
        contentPane.add(textFeatures);

        JLabel lblPlace = new JLabel("Local:");
        lblPlace.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPlace.setBounds(10, 211, 206, 35);
        contentPane.add(lblPlace);

        textPlace = new JTextField();
        textPlace.setFont(new Font("Arial", Font.PLAIN, 12));
        textPlace.setColumns(10);
        textPlace.setBackground(Color.LIGHT_GRAY);
        textPlace.setBounds(10, 247, 612, 29);
        contentPane.add(textPlace);

        JButton creatureButton = new JButton("Adicionar");
        creatureButton.setForeground(new Color(0, 0, 0));
        creatureButton.setBackground(new Color(126, 129, 126));
        creatureButton.setFont(new Font("Arial", Font.PLAIN, 13));
        creatureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creature.setName(textName.getText());
                creature.setMagicalCreatureType(textType.getText());
                creature.setMaagicalFeatures(textFeatures.getText());

                try {
                    em.getTransaction().begin();
                    
                    // Verificar se a criatura mágica já existe
                    List<MagicalCreature> creatures = em.createQuery(
                        "from MagicalCreature c where c.name = :name", MagicalCreature.class)
                        .setParameter("name", textName.getText())
                        .getResultList();

                    if (creatures.isEmpty()) {
                        // Verificar se o local já existe
                        Place place = (Place) em.createQuery(
                            "from Place p where p.name = :name", Place.class)
                            .setParameter("name", textPlace.getText())
                            .getResultStream()
                            .findFirst()
                            .orElseGet(() -> {
                                Place newPlace = new Place();
                                newPlace.setName(textPlace.getText());
                                em.persist(newPlace);
                                return newPlace;
                            });
                        
                        creature.setPlace(place);
                        em.persist(creature);
                        em.getTransaction().commit();
                        JOptionPane.showMessageDialog(null, "Criatura mágica criada com sucesso!");
                    } else {
                        em.getTransaction().rollback();
                        JOptionPane.showMessageDialog(null, "Criatura mágica já existe");
                    }
                } catch (Exception ex) {
                    em.getTransaction().rollback();
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao verificar criatura mágica");
                }
            }
        });
        creatureButton.setBounds(10, 554, 612, 41);
        contentPane.add(creatureButton);
    }
}
