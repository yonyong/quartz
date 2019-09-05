package cn.yonyong.quartz.task;

import cn.yonyong.quartz.provider.HelloRabbitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PrintCurrentTimeTask {
    @Autowired
    private HelloRabbitProvider helloRabbitProvider;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void printCurrentTime() {
        System.out.println();
        System.out.println("任务调度-----Current Time is:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        helloRabbitProvider.send();
    }
}