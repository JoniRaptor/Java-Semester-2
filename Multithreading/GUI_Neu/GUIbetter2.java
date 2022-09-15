import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class GUIbetter2 {
    public static int threadsCount = 0;
    public static int[] threadList;

    public static Integer numToCalculate;

    public static void main(String[] args) {
        JFrame f = new JFrame("Thread launcher");

        String[] columnNames = { "Nummer" };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable resultTable = new JTable(tableModel);
        resultTable.setBounds(50, 150, 180, 30);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(50, 150, 180, 100);
        resultTable.setFillsViewportHeight(true);

        final JTextField textField = new JTextField();

        textField.setBounds(50, 20, 180, 20);
        JButton addThreadButton = new JButton("Aufgabe hinzufügen");
        addThreadButton.setBounds(50, 50, 180, 30);

        JButton runThreadsButton = new JButton("0 Threads starten...");
        runThreadsButton.setEnabled(false);
        runThreadsButton.setBounds(50, 100, 180, 30);

        f.add(textField);
        f.add(addThreadButton);
        f.add(runThreadsButton);
        f.add(scrollPane);

        addThreadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    numToCalculate = Integer.parseInt(textField.getText().replaceAll("[^0-9]", ""));
                    Object[] newNumber = { numToCalculate };
                    tableModel.addRow(newNumber);

                } catch (NumberFormatException ex) {
                    return;
                }

                textField.setText("");

                runThreadsButton.setEnabled(true);

                threadsCount++;
                if (threadsCount == 1) {
                    runThreadsButton.setText("1 Thread starten...");
                } else {
                    runThreadsButton.setText(Integer.toString(threadsCount) + " Threads starten...");
                    ;
                }

            }
        });

        runThreadsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < tableModel.getRowCount(); i++) {

                    Integer numToCalculate = (Integer) tableModel.getValueAt(i, 0);

                    greatestDivisorWorker worker = new greatestDivisorWorker(numToCalculate);
                    worker.start();
                }
            }
        });

        f.setSize(280, 280);
        f.setLayout(null);
        f.setVisible(true);
    }
}