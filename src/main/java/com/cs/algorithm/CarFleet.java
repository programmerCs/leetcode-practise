package com.cs.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarFleet {

    public static void main(String[] args) {
        double d1 = 1e-8;
        System.out.println(d1);
        int target = 10;//10; 12
        int[] position = new int[]{0, 4, 2};  //{10, 8, 0, 5, 3}
        int[] speed = new int[]{2, 1, 3};  //{2, 4, 1, 1, 3}
        int carFeetNum = carFleet(target, position, speed);
        System.out.println(carFeetNum);
    }


    public static int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0 || position.length == 1) {
            return position.length;
        }
        List<CarInfo> carInfos = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            carInfos.add(new CarInfo(position[i], speed[i], target));
        }
        Collections.sort(carInfos, new PositionComparator());//按照位置排序去找
        //现在是不考虑怎么去追的问题 换个思路去思考问题
        //每次比较都会有 追的山 追不上这两种情况
        int carFleetsNum = 0;
        CarInfo[] carInfoArray = carInfos.toArray(new CarInfo[]{});
        for (int i = 0, size = carInfos.size(); i < size; ) {
            int j = i + 1;
            for (; j < size; j++) {
                if (carInfoArray[j].costTime >= carInfoArray[i].costTime) {
                    break;
                }
            }
            if (j == size) {
                carFleetsNum++;
                i++;
            } else {
                i = j;
            }

        }
        return carFleetsNum;
    }


    static class CarInfo {
        int position;
        int speed;
        double costTime;

        public CarInfo(int position, int speed, int target) {
            this.position = position;
            this.speed = speed;
            costTime = (target - position) * 1.0 / speed;
        }
    }

    static class PositionComparator implements Comparator<CarInfo> {

        @Override
        public int compare(CarInfo o1, CarInfo o2) {
            return o1.position - o2.position;
        }
    }


}

