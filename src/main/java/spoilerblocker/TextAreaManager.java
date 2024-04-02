package spoilerblocker;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextAreaManager {
    private final List<JTextArea> textAreas;

    public TextAreaManager() {
        this.textAreas = new ArrayList<>();
    }

    public void addNewTextArea(JPanel panel) {
        JTextArea newTextArea = new JTextArea(5, 30);
        newTextArea.setLineWrap(true);
        newTextArea.setWrapStyleWord(true);
        textAreas.add(newTextArea);
        panel.add(new JScrollPane(newTextArea), BorderLayout.CENTER);
        panel.revalidate();
    }

    public List<JTextArea> getTextAreas() {
        return textAreas;
    }
}