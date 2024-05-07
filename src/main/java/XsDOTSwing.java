import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class XsDOTSwing {

    static {
        try {
            // Load native library
            System.loadLibrary("movelladot_pc_sdk_java64");
            System.out.println("Loaded Library");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    private static XdpcHandler xdpcHandler = new XdpcHandler();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            XsDOTSwing xsDOTSwing = new XsDOTSwing();
            xsDOTSwing.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("XsDOT Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());


        // Left and right panels for decoration
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(230, 230, 230));
        leftPanel.setPreferredSize(new Dimension(50, 10)); // Adjust width as needed
        contentPane.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(230, 230, 230));
        rightPanel.setPreferredSize(new Dimension(50, 10)); // Adjust width as needed
        contentPane.add(rightPanel, BorderLayout.EAST);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 1, 5, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel menuLabel = new JLabel("MENU", SwingConstants.CENTER);
        menuLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(menuLabel);

        addButton(mainPanel, "Connect DOT(s)", "connect.png");
        addButton(mainPanel, "Perform MFM", "mfm.png");
        addButton(mainPanel, "Start Recording", "record.png");
        addButton(mainPanel, "Synchronize DOTs", "sync.png");
        addButton(mainPanel, "Get Info about DOT(s)", "info.png");
        addButton(mainPanel, "View Last Logs from DOT(s)", "logs.png");
        addButton(mainPanel, "Exit", "exit.png");

        contentPane.add(mainPanel, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

    private void addButton(JPanel panel, String text, String iconFileName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(255, 165, 0)); // Light orange color
        button.setFocusPainted(false);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(new Color(190, 116, 0), 2)); // Deep orange border
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Load and set icon
        ImageIcon icon = new ImageIcon(iconFileName);
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));

        button.addActionListener(e -> {
            try {
                handleButtonClick(text);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        panel.add(button);
    }

    // Implement your methods here
    private void handleButtonClick(String buttonText) throws Exception {
        switch (buttonText) {
            case "Connect DOT(s)":
                connectDOT();
                break;
            case "Perform MFM":
                mfm();
                break;
            case "Start Recording":
                startRecording();
                break;
            case "Synchronize DOTs":
                synchronizeDOTs();
                break;
            case "Get Info about DOT(s)":
                getInfo();
                break;
            case "View Last Logs from DOT(s)":
                viewLogs();
                break;
            case "Exit":
                exitApplication();
                break;
            default:
                break;
        }
    }

    public static void connectDOT() throws Exception{
        if (!xdpcHandler.initialize())
            System.exit(-1);
        //scans for available DOTs
        xdpcHandler.scanForDots();

        if (xdpcHandler.detectedDots().empty())
        {
            System.out.println("No Movella DOT device(s) found. Aborting.");
            System.exit(-1);
        }

        //connects to DOTs
        xdpcHandler.connectDots();

        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("Could not connect to any Movella DOT device(s). Aborting.");
            System.exit(-1);
        }
    }

    private void mfm() {
        // Your mfm() method implementation here
    }

    private void startRecording() {
        // Your startRecording() method implementation here
    }

    private void synchronizeDOTs() {
        // Your synchronizeDOTs() method implementation here
    }

    private void exportData() {
        // Your exportData() method implementation here
    }

    private void getInfo() {
        // Your getInfo() method implementation here
    }

    private void viewLogs() {
        // Your viewLogs() method implementation here
    }

    private void exitApplication() {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Do cleanup or other necessary tasks before exiting
            System.exit(0);
        }
    }
}
