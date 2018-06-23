package com.example.adapterandjson.model;

/**
 * Created by 爱我请给我二十块 on 2018/6/23.
 */

public class Bean {

    private String name;
    private String code;
    private String num;
    private String price;
    private String sum;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public Bean(String name,String code,String num,String sum,String price){
        this.name=name;
        this.code=code;
        this.num=num;
        this.sum=sum;
        this.price=price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
