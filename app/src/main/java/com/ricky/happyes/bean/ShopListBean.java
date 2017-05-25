package com.ricky.happyes.bean;

import java.util.List;

/**
 * 商家
 * Created by Ricky on 2017-5-25.
 */

public class ShopListBean {
    private int total ;
    private int page;
    private int count;
    private List<ShopBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ShopBean> getList() {
        return list;
    }

    public void setList(List<ShopBean> list) {
        this.list = list;
    }

    public class ShopBean{
        private String shop_id;
        private String shop_logo;
        private String shop_title;
        private int shop_price;
        private int shop_star;
        private String shop_address;
        private String shop_type;

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_logo() {
            return shop_logo;
        }

        public void setShop_logo(String shop_logo) {
            this.shop_logo = shop_logo;
        }

        public String getShop_title() {
            return shop_title;
        }

        public void setShop_title(String shop_title) {
            this.shop_title = shop_title;
        }

        public int getShop_price() {
            return shop_price;
        }

        public void setShop_price(int shop_price) {
            this.shop_price = shop_price;
        }

        public int getShop_star() {
            return shop_star;
        }

        public void setShop_star(int shop_star) {
            this.shop_star = shop_star;
        }

        public String getShop_address() {
            return shop_address;
        }

        public void setShop_address(String shop_address) {
            this.shop_address = shop_address;
        }

        public String getShop_type() {
            return shop_type;
        }

        public void setShop_type(String shop_type) {
            this.shop_type = shop_type;
        }
    }
}
