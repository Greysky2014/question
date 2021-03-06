package com.example.question.flowable.listener;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-10 08:34
 * @modify:
 * @version: v1.0
 **/
public class BossTaskHandler implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("老板");
    }
}
