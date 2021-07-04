package me.nic.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取请求次数
     *
     * @return
     */
    private final int getAndIncrement() {
        int current;
        int next;
        do {
            // 当前请求次数
            current = this.atomicInteger.get();
            // 请求次数加1
            next = current >= 2147483647 ? 0 : current + 1;
            // 多线程并发访问，自旋修改
        } while (!this.atomicInteger.compareAndSet(current, next));  //第一个参数是期望值，第二个参数是修改值是
        System.out.println("*******第几次访问，次数next: " + next);
        return next;
    }

    /**
     * 计算获取机器实例
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 得到服务器的下标位置
        // 请求次数与实例数取余
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
