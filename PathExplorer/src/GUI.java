import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame {

    private JPanel rootPanelGUI;
    private JTextField textField1;
    private JLabel logo;
    private JTextPane inputPathTextName;
    private JButton GOButton;
    private JScrollPane fileshere;
    private JTextPane filesherePane;
    private ArrayList allFiles = new ArrayList();
    private ArrayList allFolders = new ArrayList();
    int dj = 0;
    public String filePath;

    public GUI() {

        super("PathFinder beta v0.1");
        FrameSetUp();
        CenterTextPane();
        addActionListeners();
    
    }
    
    //-----------------------------------------------------
    
    private void FrameSetUp() {
        setSize(800,600);
        setLocationRelativeTo(null);
        add(rootPanelGUI);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void CenterTextPane() {
        StyledDocument doc = inputPathTextName.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
    
    private void createUIComponents() {
        logo = new JLabel(new ImageIcon("res/cool.jpg"));
    }
    
    private void addActionListeners() {
        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFileTreeAndPrintIt();
            }
        });
    }
    
    //------------------------------------------------------
    
    public void getFileTreeAndPrintIt() {
        filePath = textField1.getText().trim();
        PathScanner ps = new PathScanner();
        ps.Pathscanner(filePath);
        filesherePane.setText(ps.toGiveToGUI);
    }
    
    //-------------------------------------------------------
   


}
