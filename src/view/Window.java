package view;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Created by JuAmo_000 on 17/10/2017.
 */
public class Window extends JFrame{
    private JPanel mainPane;
    private JPanel inputPane;
    private JPanel serveurPanel;
    private JPanel clientsPanel;
    private JPanel arrivePanel;
    private JPanel departPanel;
    private JTextField lambda_field;
    private JTextField mu_field;
    private JTextField serveur_field;
    private JRadioButton serverRadioBtn;
    private JTextField clients_max_field;
    private JRadioButton clientsRadioBtn;
    private JPanel resultPane;
    private JTextField jInput;
    private JLabel qResult;
    private JPanel qResultPanel;
    private JPanel lResultPanel;
    private JPanel lqResultPanel;
    private JPanel wResultPanel;
    private JPanel wqResultPanel;
    private JPanel tauResultPanel;
    private JLabel lValue;
    private JLabel lqvalue;
    private JLabel wValue;
    private JLabel wqValue;
    private JTextField tInput;
    private JLabel tauValue;
    private JRadioButton classicRadioButton;
    private ButtonGroup btnGrp;

    public Window(){
        setContentPane(mainPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        btnGrp = new ButtonGroup();
        btnGrp.add(serverRadioBtn);
        btnGrp.add(clientsRadioBtn);
        btnGrp.add(classicRadioButton);

        mu_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateGeneralValues();
            }
        });
        lambda_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateGeneralValues();
            }
        });
        serveur_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateServerValue();
            }
        });
        clients_max_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateKlientValue();
            }
        });
        jInput.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateJValue();
            }
        });
        tInput.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateTauValue();
            }
        });
    }

    private void updateGeneralValues(){
        System.out.println("General!");
    }

    private void updateServerValue(){
        System.out.println("Server!");
    }

    private void updateKlientValue(){
        System.out.println("Client!");
    }

    private void updateJValue(){
        System.out.println("J!");
    }

    private void updateTauValue(){
        System.out.println("Tau!");
    }
}
