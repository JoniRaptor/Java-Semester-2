import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

class GUIbetter {
    // public static int numToCalculate;
    public static int threadsCount = 0;
    public static int[] threadList;
    // public static String[] Result;

    public static void main(String[] args) {
        JFrame f = new JFrame("Thread launcher");
        ArrayList<String> ergebnisArray = new ArrayList<String>();
        DefaultListModel Result = new DefaultListModel<>();

        ArrayList<Integer> numToCalculate = new ArrayList<Integer>();

        // final DefaultListModel ergebnisArray = new DefaultListModel<>();

        String[] columnNames = { "Nummer",
                "Ergebnis" };

        Object[][] data = {
                { "", "" }
        };

        JTable resultTable = new JTable(data, columnNames);
        resultTable.setBounds(50, 150, 180, 30);

        // tableModel test = new DefaultTableModel<>();
        // resultTable.setModel(model.DefaultListModel);

        final JTextField tf = new JTextField();

        tf.setBounds(50, 20, 180, 20);
        JButton addThreadButton = new JButton("Aufgabe hinzufügen");
        addThreadButton.setBounds(50, 50, 180, 30);

        JButton runThreadsButton = new JButton("0 Threads starten...");
        runThreadsButton.setEnabled(false);
        runThreadsButton.setBounds(50, 100, 180, 30);

        //JList<String> threadListView = new JList<String>(Result);
        //threadListView.setBounds(50, 150, 180, 30);

        f.add(tf);
        f.add(addThreadButton);
        f.add(runThreadsButton);
        // f.add(threadListView);

        // fuck me
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(50, 150, 180, 300);
        resultTable.setFillsViewportHeight(true);
        f.add(scrollPane);

        addThreadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // numToCalculate = Integer.parseInt(tf.getText().replaceAll("[^0-9]", ""));
                    numToCalculate.add(Integer.parseInt(tf.getText().replaceAll("[^0-9]", "")));
                } catch (NumberFormatException ex) {
                    return;
                }

                tf.setText("");

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
                ergebnisArray.clear();
                Result.clear();
                for (int i = 0; i < threadsCount; i++) {
                    greatestDivisorWorker worker = new greatestDivisorWorker(numToCalculate.get(i));
                    worker.start();
                    ergebnisArray.add(worker.ThreadID + " " + String.valueOf(worker.greatestDivisor));
                    data[i][0] = "numToCalculate.get(i)";
                    data[i][1] = "worker.greatestDivisor";
                }
                // Result = String[ergebnisArray.size()];
                System.out.println(ergebnisArray);
                // Result = ergebnisArray.toArray(new String[0]);
                for (int i = 0; i < Result.getSize(); i++) {
                    System.out.println(Result.get(i));
                }
                // threadListView.updateUI();
            }
        });

        f.setSize(280, 280);
        f.setLayout(null);
        f.setVisible(true);
    }
}