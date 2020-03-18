package kr.co.youhyun.uitest02_jikbang_practice.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String detail;

    public String getFormattedPrice() {
        // 상황에 따라 몇억 몇천, 또는 몇천인지 나눠서 리턴!
        if (this.getPrice() >= 10000) {
            int uk = this.getPrice() / 10000;
            int thousand = this.getPrice() % 10000;
            if (thousand == 0) {
               return String.format("%d억", uk);
            } else {
                return String.format("%d억 %,d만원", uk, thousand);
            }
        } else {
            return String.format("%,d만원", this.getPrice());
        }
    }

    public String getFormattedFloor() {
        String floorStr = "";
        if (this.getFloor() > 0){
            floorStr = String.format("%d층",this.getFloor());
        } else if (this.getFloor() == 0) {
            floorStr = "반지하";
        } else {
            floorStr = String.format("지하 %d층",this.getFloor()*-1);
        }
        return floorStr;
    }

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
