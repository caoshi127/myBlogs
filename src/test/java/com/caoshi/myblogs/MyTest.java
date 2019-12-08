package com.caoshi.myblogs;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 自定义测试类
 * Created by CaoShi on 2019/12/8 9:44
 */
public class MyTest {

  @Test
  public void test() {

    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      int nextInt = random.nextInt(5);
      System.out.println(i + " --> " + nextInt);
      if (nextInt < 0) {
        break;
      }
    }


  }


}
