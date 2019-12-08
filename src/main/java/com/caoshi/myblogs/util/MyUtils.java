package com.caoshi.myblogs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  自定义工具类
 * Created by CaoShi on 2019/12/8 9:54
 */
public class MyUtils {

  /**
   *  随机产生n 个范围在 [start, end) 的随机数
   * @param n    要产生的随机数个数
   * @param start   左边界值(包含)
   * @param end     右边界值(不包含)
   * @return        随机数集合
   */
  public static List<Integer> getRandomNumList(int n, int start, int end) {
    List<Integer> list = new ArrayList<>();
    Random random = new Random();
    while (list.size() != n) {    // 保证每次都能产生两个随机数
      int num = random.nextInt(end-start) + start;
      if (!(list.contains(num))) {
        list.add(num);
      }
    }
    return list;
  }



}
