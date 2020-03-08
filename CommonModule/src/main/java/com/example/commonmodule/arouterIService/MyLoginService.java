package com.example.commonmodule.arouterIService;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 比如，业务模块需要获取登录模块中的用户信息，那就要再CommonModule中创建一个接口，
 * 里面定义一个获取信息的方法,然后再登录模块创建一个类，继承改接口，重写获取方法函数，
 * 最后，再需要调用的地方，直接获取此处的接口对象，然后调用里面定义的方法
 */
public interface MyLoginService extends IProvider {

    String getName(String name);


}
