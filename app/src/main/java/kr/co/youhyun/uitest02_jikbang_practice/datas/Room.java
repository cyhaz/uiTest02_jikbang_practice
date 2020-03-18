package kr.co.youhyun.uitest02_jikbang_practice.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String detail;

    // 생성자
    public Room(int price, String address, int floor, String detail) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.detail = detail;

    }

    // getter / setter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
