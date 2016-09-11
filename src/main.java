/**
 * Created by vladislav on 27.03.2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class main implements ActionListener {
    JTextField Atable,Btable;
    JLabel func, degrees, stop, radian, value, count, test_value;
    JTextArea radianv, valuev,countv, test_valuev;
    double degree, eps, d, sum, t, x, xsq, test;
    int i;
    String operation;

    main() {
        JFrame mainframe = new JFrame("Taylor Series");
        mainframe.setLayout(new FlowLayout());
        mainframe.setSize(240, 300);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Atable= new JTextField(8);
        Btable= new JTextField(8);

        JButton btncalc = new JButton("Считать");
        JButton btnclear = new JButton("Очистить");

        degrees = new JLabel("Величина в градусах");
        func = new JLabel("Функция f(x)=sin(x);");
        stop = new JLabel("Условие останова");
        radian = new JLabel("Величина в радианах");
        value = new JLabel("Найденное значение");
        count = new JLabel("Число членов");
        test_value = new JLabel("Тестовое значение");
        radianv = new JTextArea("");
        valuev = new JTextArea("");
        countv = new JTextArea("");
        test_valuev = new JTextArea("");


        btncalc.addActionListener(this);
        btnclear.addActionListener(this);


        mainframe.add(func);
        mainframe.add(degrees);
        mainframe.add(Atable);
        mainframe.add(stop);
        mainframe.add(Btable);

        mainframe.add(btncalc);
        mainframe.add(btnclear);

        mainframe.add(radian);
        mainframe.add(radianv);
        mainframe.add(value);
        mainframe.add(valuev);
        mainframe.add(count);
        mainframe.add(countv);
        mainframe.add(test_value);
        mainframe.add(test_valuev);

        radian.setVisible(false);
        value.setVisible(false);
        count.setVisible(false);
        test_value.setVisible(false);
        radianv.setVisible(false);
        valuev.setVisible(false);
        countv.setVisible(false);
        test_valuev.setVisible(false);

        mainframe.setVisible(true);


    }

    public void clearData() {
        Atable.setText("");
        Btable.setText("");
        radianv.setText("");
        valuev.setText("");
        countv.setText("");
        test_valuev.setText("");
        degree = 0;
        eps = 0;
        degree = 0;
        eps = 0;
        d=0;
        sum=0;
        t=0;
        x=0;
        xsq=0;
        test=0;
        radian.setVisible(false);
        value.setVisible(false);
        count.setVisible(false);
        test_value.setVisible(false);
        radianv.setVisible(false);
        valuev.setVisible(false);
        countv.setVisible(false);
        test_valuev.setVisible(false);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getActionCommand().equals("Считать")) {

                degree = Double.parseDouble(Atable.getText());
                eps = Double.parseDouble(Btable.getText());
                x = (degree*Math.PI)/180;
                test = Math.sin(x);
                i=1;
                sum=x;
                t=x;
                d=3;
                xsq = x*x;
                while (Math.abs(t)>=eps) {
                    t = -t*xsq/(d*(d-1));
                    sum +=t;
                    d = d+2;
                    i++;
                }
                radianv.setText(""+x);
                valuev.setText(""+sum);
                countv.setText(""+i);
                test_valuev.setText(""+test);
                radian.setVisible     (true);
                value.setVisible      (true);
                count.setVisible      (true);
                test_value.setVisible (true);
                radianv.setVisible    (true);
                valuev.setVisible     (true);
                countv.setVisible     (true);
                test_valuev.setVisible(true);




            }

            if (ae.getActionCommand().equals("-")) {
                degree = Double.parseDouble(Atable.getText());
                eps = Double.parseDouble(Btable.getText());
                operation = "del";
                Atable.setText("");
                Btable.setText("");
            }

            if (ae.getActionCommand().equals("Очистить")) {
                clearData();
            }


        }catch (Exception exc) {JOptionPane.showMessageDialog(null, "ENTER RIGHT VALUE");
            clearData(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new main();

            }
        });
    }


}