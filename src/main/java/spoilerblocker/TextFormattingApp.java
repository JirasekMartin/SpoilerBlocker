package spoilerblocker;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextFormattingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Formatting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension(300, 200));

        // Vytvoření panelu pro tlačítka s formátovacími možnostmi
        JPanel formatPanel = new JPanel();

        // Tlačítko pro změnu stylu na tučné písmo
        JToggleButton boldButton = new JToggleButton("Bold");
        boldButton.addActionListener(e -> {
            setBoldStyle(textPane, boldButton.isSelected());
        });
        formatPanel.add(boldButton);

        // Tlačítko pro změnu stylu na kurzivní písmo
        JToggleButton italicButton = new JToggleButton("Italic");
        italicButton.addActionListener(e -> {
            setItalicStyle(textPane, italicButton.isSelected());
        });
        formatPanel.add(italicButton);

        // Tlačítko pro podtržení textu
        JToggleButton underlineButton = new JToggleButton("Underline");
        underlineButton.addActionListener(e -> {
            setUnderlineStyle(textPane, underlineButton.isSelected());
        });
        formatPanel.add(underlineButton);

        // Tlačítko pro přeškrtnutí textu
        JToggleButton strikeThroughButton = new JToggleButton("Strike Through");
        strikeThroughButton.addActionListener(e -> {
            setStrikeThroughStyle(textPane, strikeThroughButton.isSelected());
        });
        formatPanel.add(strikeThroughButton);

        // Tlačítko pro změnu barvy textu
        JButton colorButton = new JButton("Barva");
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Vyberte barvu textu", Color.BLACK);
            setTextColor(textPane, selectedColor);
        });
        formatPanel.add(colorButton);

        // Tlačítko pro změnu velikosti písma
        String[] fontSizes = {"10", "12", "14", "16", "18", "20"};
        JComboBox<String> fontSizeComboBox = new JComboBox<>(fontSizes);
        fontSizeComboBox.addActionListener(e -> {
            int fontSize = Integer.parseInt((String) fontSizeComboBox.getSelectedItem());
            setFontSize(textPane, fontSize);
        });
        formatPanel.add(new JLabel("Font Size:"));
        formatPanel.add(fontSizeComboBox);

        // Rozbalovací seznam pro změnu typu písma
        String[] fontTypes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JComboBox<String> fontTypeComboBox = new JComboBox<>(fontTypes);
        fontTypeComboBox.addActionListener(e -> {
            String fontName = (String) fontTypeComboBox.getSelectedItem();
            setFontType(textPane, fontName);
        });
        formatPanel.add(new JLabel("Font Type:"));
        formatPanel.add(fontTypeComboBox);

        frame.add(new JScrollPane(textPane), BorderLayout.CENTER);
        frame.add(formatPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }


    // Metoda pro nastavení barvy textu
    private static void setTextColor(JTextPane textPane, Color color) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setForeground(attrs, color);
        doc.setCharacterAttributes(start, end - start, attrs, false);
    }

    // Metoda pro nastavení velikosti písma
    private static void setFontSize(JTextPane textPane, int size) {
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setFontSize(attrs, size);
        textPane.setCharacterAttributes(attrs, false);
    }

    // Metoda pro nastavení tučného stylu písma
    private static void setBoldStyle(JTextPane textPane, boolean bold) {
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setBold(attrs, bold);
        textPane.setCharacterAttributes(attrs, false);
    }

    // Metoda pro nastavení kurzivního stylu písma
    private static void setItalicStyle(JTextPane textPane, boolean italic) {
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setItalic(attrs, italic);
        textPane.setCharacterAttributes(attrs, false);
    }
    // Metoda pro nastavení podtržení textu
    private static void setUnderlineStyle(JTextPane textPane, boolean underline) {
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setUnderline(attrs, underline);
        textPane.setCharacterAttributes(attrs, false);
    }

    // Metoda pro nastavení přeškrtnutí textu
    private static void setStrikeThroughStyle(JTextPane textPane, boolean strikeThrough) {
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setStrikeThrough(attrs, strikeThrough);
        textPane.setCharacterAttributes(attrs, false);
    }

    // Metoda pro změnu typu písma
    private static void setFontType(JTextPane textPane, String fontName) {
        MutableAttributeSet attrs = textPane.getInputAttributes();
        StyleConstants.setFontFamily(attrs, fontName);
        textPane.setCharacterAttributes(attrs, false);
    }
}