package com.frank.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

public class HuaweiTest {


    @Test
    public void  checkNumber1(){


        Integer a= 10000;

        Integer b = 10000;

        System.out.println(a ==b);

    }

    @Test
    public void  checkNumber2(){


        Integer a= new Integer(100);

        Integer b = new Integer(100);

        System.out.println(a ==b);

    }

    @Test
    public void checkStr1(){
        String a = "nihao";
        String b = "nihao";
        System.out.println(a==b);
    }


    @Test
    public void checkStr2(){
        String a = new String("nihao");
        String b = new String("nihao");
        System.out.println(a==b);
    }


    @Test
    public void hashCode1(){

        HashMap<Integer,String> map =new HashMap<>();
        map.put(new Integer(10000),"a");


        System.out.println(map.get(new Integer(10000)));
    }




    private static final int CAP_TO_BEER = 4;		//	4个瓶盖兑换一瓶啤酒
    private static final int BOTTLE_TO_BEER = 2;	        //	2个瓶子兑换一瓶啤酒
    private static final int MONEY_TO_BEER = 2;		//	2元买下一瓶啤酒
    @Test
    public void test(){
        int init_money = 10;
        int totalBeers = consume(init_money);
        System.out.println(String.format("%d元钱，可以得到%d瓶啤酒", init_money, totalBeers));
    }

    private int consume(int money){
        int beersByMoney = money / MONEY_TO_BEER;
        System.out.println(String.format("用%d元钱，买下%d瓶啤酒，得到%d 个瓶盖和 %d 个瓶子",
                money, beersByMoney, beersByMoney, beersByMoney));
        return beersByMoney + exchange(beersByMoney, beersByMoney);
    }
    private int exchange(int caps, int bottles){
        //当剩余的瓶盖数量和酒瓶数量都小于兑换基数时，就不能再兑换了。
        if (caps < CAP_TO_BEER && bottles < BOTTLE_TO_BEER) return 0;

        int byCap = caps / CAP_TO_BEER;			//	用瓶盖兑换的啤酒
        int byBottle = bottles / BOTTLE_TO_BEER;	//用酒瓶兑换的啤酒
        int totalExchangedBeers = byCap + byBottle;		//瓶盖 和 酒瓶兑换的总共啤酒数量

        //剩余的瓶盖数量（因为原有的瓶盖兑换完啤酒后，又得到了新的瓶盖，所以要加上得到的啤酒数量）
        int remainingCaps = caps % CAP_TO_BEER + totalExchangedBeers;
        int remainingBottles = bottles % BOTTLE_TO_BEER + totalExchangedBeers;
        System.out.println(String.format("本次用 %d 个瓶盖和 %d 个瓶子兑换了 %d 瓶啤酒，剩余 %d 个瓶盖和 %d 个瓶子",
                caps, bottles, totalExchangedBeers, remainingCaps, remainingBottles));

        //返回的是本次兑换的啤酒数量加上剩余的瓶盖和瓶子能兑换的数量
        return totalExchangedBeers + exchange(remainingCaps, remainingBottles);
    }


}
