import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class GUI {
    //public static int numToCalculate;
    public static int threadsCount = 0;
    public static int[] threadList;
    //public static String[] Result;

    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<String>();
        GlobalArray.Output = res;
        JFrame f = new JFrame("Thread launcher");
        ArrayList<String> test = new ArrayList<String>();
        DefaultListModel Result = new DefaultListModel<>();
        ArrayList<Integer> numToCalculate = new ArrayList<Integer>();

        // final DefaultListModel test = new DefaultListModel<>();

        final JTextField tf = new JTextField();

        tf.setBounds(50, 20, 180, 20);
        JButton addThread = new JButton("Aufgabe hinzufügen");
        addThread.setBounds(50, 50, 180, 30);

        JButton runThreads = new JButton("0 Threads starten...");
        runThreads.setEnabled(false);
        runThreads.setBounds(50, 100, 180, 30);

        JList<String> threadListView = new JList<String>(GlobalArray.OutputArray);
        threadListView.setBounds(50, 150, 180, 30);

        f.add(tf);
        f.add(addThread);
        f.add(runThreads);
        f.add(threadListView);

        addThread.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //numToCalculate = Integer.parseInt(tf.getText().replaceAll("[^0-9]", ""));
                numToCalculate.add(Integer.parseInt(tf.getText()));
                tf.setText("");
                runThreads.setEnabled(true);

                threadsCount++;
                if (threadsCount == 1) {
                    runThreads.setText("1 Thread starten...");
                } else {
                    runThreads.setText(Integer.toString(threadsCount) + " Threads starten...");
                }

            }
        });

        runThreads.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                test.clear();
                Result.clear();
                for (int i = 0; i < threadsCount; i++){
                    greatestDivisorWorker worker = new greatestDivisorWorker(numToCalculate.get(i), res);
                    res.clear();
                    worker.start();
                    //test.add(worker.ThreadID + " " +String.valueOf(worker.greatestDivisor));
                    //Result.addElement(test.get(i));
                }
                System.out.println(GlobalArray.Output);
                //Result = String[test.size()];
                System.out.println(test);
                //Result = test.toArray(new String[0]);
                for (int i = 0; i < Result.getSize(); i++){
                    System.out.println(Result.get(i));
                }
                //threadListView.updateUI();
            }
        });

        f.setSize(280, 280);
        f.setLayout(null);
        f.setVisible(true);
    }
}