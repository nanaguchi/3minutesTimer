import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;
import java.awt.*;

/**
 * ３分タイマーを実行するクラス。
 * 
 * @author N.Taguchi,S.Tanaka(J2SB,Reviewer)
 */

public class Main extends Object {

     /**
     * エントリポイント。
     * 
     * @param args 実行時引数。ここでは使用しない。
     */
    public static void main(String[] args) {

        //ウィンドウの設定
        JFrame jframe = new JFrame();
        JLabel jLabel = new JLabel();
        jframe.setLayout(new FlowLayout());
        jframe.setBounds(500, 300, 500, 100);
        jframe.setTitle("３分タイマー");
        jframe.add(jLabel);
        jframe.setVisible(true);

        Timer atimer = new Timer();

        //１秒ごとの処理
        TimerTask aTimerTask = new TimerTask() {

            int count = 180;

            public void run() {

                jLabel.setText("Time :  " + count);
                count--;

                if (count <= 0) {
                    atimer.cancel();
                    jLabel.setText("Time up");
                }
            }
        };

        atimer.scheduleAtFixedRate(aTimerTask, 0, 1000);

}

}