import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends Frame {
    Random rd = new Random();
    private Button btleft = new Button("<<<<");
    private Button btright = new Button(">>>>");
    private Button btfire = new Button("fire");
    private Label labshowpoint = new Label("000");
    private int count = 0, labx = 20, laby = 420, labz = 40;
    private Button bt1 = new Button("poi");
    private Button bt2 = new Button();
    private Button bt3 = new Button("打我阿");
    private Timer t1;
    private boolean aa = true;
    private int v1;

    public MainFrame() {
        init();
    }

    private void init() {
        this.setBounds(100, 100, 1000, 700);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.setLayout(null);
        btleft.setBounds(350, 500, 100, 30);
        btright.setBounds(550, 500, 100, 30);
        btfire.setBounds(450, 500, 100, 30);
        this.add(btleft);
        this.add(btright);
        this.add(btfire);
        v1 = rd.nextInt(999) + 1;
        System.out.println(v1);
        bt3.setBounds(v1, 50, 50, 50);
        this.add(bt3);
        labshowpoint.setBounds(20, 600, 100, 30);
        this.add(labshowpoint);
        bt1.setBounds(labx, 450, 50, 30);
        this.add(bt1);
        bt2.setBounds(labz, laby, 10, 50);
        this.add(bt2);
        btleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labx--;
                labz--;
                bt1.setLocation(labx, 450);
                bt2.setLocation(labz, laby);
                System.out.println("aa=" + labz);
                if (labx <= 0) {
                    bt1.setLocation(10, 450);
                    bt2.setLocation(30, 420);
                }
            }
        });
        btright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labx++;
                labz++;
                bt1.setLocation(labx, 450);
                bt2.setLocation(labz, laby);
                System.out.println("aa=" + labz);
                if (labx >= 1000) {
                    bt1.setLocation(10, 450);
                    bt2.setLocation(30, 420);
                }
            }
        });
        t1 = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                laby--;
                bt2.setLocation(labz, laby);
                if (laby <= 0) {
                    bt2.setLocation(labz, 420);
                    laby = 420;
                    t1.stop();

                } else {
                    if (v1 == laby) {
                        v1 = rd.nextInt(999) + 1;
                        bt3.setLocation(v1, 50);
                        count++;
                        labshowpoint.setText(Integer.toString(count));
                    }
                }
            }
        });
        btfire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t1.start();

            }
        });


    }


}