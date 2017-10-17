package view;

import javax.swing.*;

/**
 * Created by JuAmo_000 on 17/10/2017.
 */
public class Window {
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
    private JTextField textField1;
    private JLabel qResult;
    private JPanel qResultPanel;
    private JPanel lResultPanel;
    private JPanel lqResultPanel;
    private JPanel wResultPanel;
    private JPanel wqResultPanel;
    private JPanel tauResultPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Window");
        frame.setContentPane(new Window().mainPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
