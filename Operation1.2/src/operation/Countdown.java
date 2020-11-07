package operation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import view.pracController;

public class Countdown extends Thread{
    private static int time;
    private static String str;
    private ActionEvent eve;
    private pracController pra;
    public Countdown(int t, pracController pra){
        this.time=t;
        this.pra=pra;
    }
    //开始倒计时
    public void run(){
        while (time > 0 && !pra.timeend){
            time--;

            try {
                Thread.sleep(1000);
                int mm = time / 60 % 60;
                int ss = time % 60;
                str="还剩" + mm + "分钟" + ss + "秒";

            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pra.resttime.setText(str);
                }
            });

        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pra.judge(new ActionEvent());
            }
        });
        System.out.println("ffff");
    }



    @Override
    public String toString(){
        String s=str;
        return s;
    }
}
