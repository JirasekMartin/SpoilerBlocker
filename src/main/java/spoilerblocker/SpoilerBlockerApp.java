package spoilerblocker;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpoilerBlockerApp {
    public static void main(String[] args) {
        // Vytvoření seznamu pro uchování textových polí
        List<JTextArea> textAreas = new ArrayList<>();

        // Vytvoření okna aplikace
        JFrame frame = new JFrame("Spoiler Blocker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Vytvoření panelu pro tlačítka a textová pole
        JPanel buttonsAndTextsPanel = new JPanel();
        buttonsAndTextsPanel.setLayout(new BoxLayout(buttonsAndTextsPanel, BoxLayout.Y_AXIS));

        // Vytvoření tlačítka pro přidání nového textového pole
        JButton addTextAreaButton = new JButton("Přidat další text");
        addTextAreaButton.addActionListener(e -> {
            JTextArea newTextArea = new JTextArea(5, 30);
            newTextArea.setLineWrap(true);
            newTextArea.setWrapStyleWord(true);
            textAreas.add(newTextArea);
            buttonsAndTextsPanel.add(new JScrollPane(newTextArea));
            frame.revalidate();
        });

        // Přidání tlačítek do panelu
        buttonsAndTextsPanel.add(addTextAreaButton);

        // Přidání panelu s tlačítky a textovými poli do okna
        frame.add(buttonsAndTextsPanel, BorderLayout.CENTER);

        // Vytvoření tlačítka pro zobrazení textu s odhalenými spoilery
        JButton spoilerButton = new JButton("Zobrazit spoilery");
        spoilerButton.addActionListener(e -> {
            // Vytvoření objektu StringBuilder pro sestavení textu s odhalenými spoilery
            StringBuilder stringBuilder = new StringBuilder();
            // Projděte všechna textová pole a nahraďte spoilery
            for (JTextArea textArea : textAreas) {
                String text = textArea.getText();
                String spoilerText = text.replaceAll("Spoiler", "<a href=\"#\" data-spoiler=\"true\">Spoiler</a>");
                stringBuilder.append(spoilerText).append("<br>");
            }

            // Vytvoření a nastavení editoru pro zobrazení HTML
            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText("<html>" + stringBuilder.toString() + "</html>");

            // Vytvoření panelu pro editor
            JPanel spoilerPanel = new JPanel();
            spoilerPanel.add(new JScrollPane(editorPane));

            // Vytvoření a zobrazení dialogu s odhalenými spoilery
            JDialog dialog = new JDialog(frame, "Spoilers", true);
            dialog.add(spoilerPanel);
            dialog.setSize(300, 300);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
        });

        // Přidání tlačítka pro zobrazení textu s odhalenými spoilery do dolní části okna
        frame.add(spoilerButton, BorderLayout.SOUTH);

        // Zobrazení okna
        frame.setVisible(true);
    }
}