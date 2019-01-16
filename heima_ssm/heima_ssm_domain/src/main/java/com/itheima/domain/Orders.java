package com.itheima.domain;

import com.itheima.ssm.utils.DateUtilS;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/9 20:24
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */
public class Orders {

        private String id;
        private String orderNum;
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
        private Date orderTime;
        private String orderTimeStr;
        private Integer orderStatus;
        private String orderStatusStr;
        private Integer peopleCount;
        private Product product;            /**/
        private List<Traveller> travellers;  /*1 V N*/
        private Member member;              /*1 V 1*/
        private Integer payType;
        private String payTypeStr;
        private String orderDesc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtilS.dateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType==0){
            payTypeStr="支付宝";
        }
        if (payType==1){
            payTypeStr="微信";
        }
        if (payType==2){
            payTypeStr="其它";
        }

        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderStatusStr() {
        if(orderStatus==0){
            orderStatusStr="关闭";
        }
        if(orderStatus==1){
            orderStatusStr="开启";
        }
        return orderStatusStr;
    }
}
