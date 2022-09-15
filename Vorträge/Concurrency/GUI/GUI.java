import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class GUI {

    public static void main(String[] args) {
        // UI wird zusammengebastelt.
        // nicht wirklich relevant fürs Thema

        JFrame f = new JFrame("Thread launcher");

        JTextField textField = new JTextField();

        textField.setBounds(50, 20, 180, 20);
        JButton addThreadButton = new JButton("Aufgabe hinzufügen");
        addThreadButton.setBounds(50, 50, 180, 30);

        JButton clearNumbersButton = new JButton("Aufgaben löschen");
        clearNumbersButton.setBounds(50, 75, 180, 30);

        JButton runThreadsButton = new JButton("0 Threads starten...");
        runThreadsButton.setEnabled(false);
        runThreadsButton.setBounds(50, 110, 180, 30);

        JLabel MTLabel = new JLabel("Multithreading aktivieren");
        MTLabel.setBounds(50, 150, 180, 20);
        JCheckBox toggleMultithreading = new JCheckBox();
        toggleMultithreading.setBounds(210, 150, 180, 20);

        String[] columnNames = { "Nummer" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(50, 180, 180, 100);
        resultTable.setFillsViewportHeight(true);

        f.add(textField);
        f.add(addThreadButton);
        f.add(clearNumbersButton);
        f.add(runThreadsButton);
        f.add(MTLabel);
        f.add(toggleMultithreading);
        f.add(scrollPane);

        f.setSize(280, 320);
        f.setLayout(null);
        f.setVisible(true);

        // Button-Action, um Zahl aus Eingabefeld in die Liste der zu berechnenden
        // Zahlen zu übertragen
        // (und Input Sanitation)
        addThreadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // RegEx erkennt alles, was NICHT 0-9 ist. Das wird dann replaced durch nichts,
                    // aka. ""
                    String numString = textField.getText().replaceAll("[^0-9]", "");
                    int numToCalculate = Integer.parseInt(numString);

                    Object[] newNumber = { numToCalculate };
                    tableModel.addRow(newNumber);

                    // Exception wenn im bereinigten String keine Ziffer ist - dann passiert einfach
                    // nichts
                } catch (NumberFormatException ex) {
                    return;
                }
                // Überprüft wie viele Aufgaben insgesamt hinzugefügt worden; aktualisiert
                // Button-Label vom 'Start'-Button und aktiviert/deaktiviert diesen
                checkTaskCount(runThreadsButton, tableModel);
            }
        });

        clearNumbersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Tabellenzeilen werden geloescht
                int rowCount = tableModel.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    tableModel.removeRow(0);
                }
                // überprüfen ob mehr als 0 numbern eingegeben wurden, dann wird button
                // aktiviert etc.
                checkTaskCount(runThreadsButton, tableModel);
            }
        });

        runThreadsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // loopt über Tabelle mit Aufgaben, instanziiert für jede einen Worker
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    int numToCalculate = (int) tableModel.getValueAt(i, 0);

                    greatestDivisorWorker worker = new greatestDivisorWorker(numToCalculate);

                    if (toggleMultithreading.isSelected()) {
                        // start() = Ausführung in neuem Thread
                        worker.start();
                    } else {
                        // run() = Ausführung im Hauptthread
                        worker.run();
                    }
                }
            }
        });
    }

    static void checkTaskCount(JButton runThreadsButton, DefaultTableModel tableModel) {
        // Überprüft wie viele Aufgaben insgesamt hinzugefügt worden; aktualisiert
        // Button-Label vom 'Start'-Button und aktiviert/deaktiviert diesen

        // keine Einträge, zB. nach Reset der Liste → button deaktivieren, Text setzen
        if (tableModel.getRowCount() == 0) {
            runThreadsButton.setText("0 Threads starten...");
            runThreadsButton.setEnabled(false);
        }
        // es gibt Einträge → Button aktivieren, Text setzen
        else {
            runThreadsButton.setEnabled(true);

            if (tableModel.getRowCount() == 1) {
                runThreadsButton.setText("1 Thread starten...");
            } else {
                runThreadsButton.setText(Integer.toString(tableModel.getRowCount()) + " Threads starten...");
            }
        }
    }
}