package com.lgh.tool.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class GsonFormatDemo {

    /**
     * currentPage : 1
     * list : [{"ID":1922,"OrComment":false,"OrKill":false,"OrderNumber":"16021715582035","OrderProducts":[{"ID":2370,"MarketPrice":30,"Num":1,"PicID":"http://image.rexian.cn/Upload/20160130/Stores/10/20160130_Stores_10_104852613345.jpg","ProductID":34647,"ProductTitle":"宁夏历之源苦荞茶","SpeID":36724,"SpeOneName":"品牌","SpeOneNameValue":"历之源","SpeTwoName":"单盒容量","SpeTwoNameValue":"200g","TruePrice":198,"Unit":"公斤"}],"OutTypesPrice":0,"State":1,"StateName":"未付款","StoreID":49707,"StoreName":"洛阳市自营店","TotalPrice":198,"TruePrice":198,"UserID":27964},{"ID":1724,"OrComment":false,"OrKill":false,"OrderNumber":"1601301606007","OrderProducts":[{"ID":2168,"MarketPrice":33990,"Num":1,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/23/20150323_Shop_23_230412317357.jpg","ProductID":1744,"ProductTitle":"0首付 412.1元X9期4K平板液晶高清电视MIUI/小米 小米电视2-单品","SpeID":1767,"SpeOneName":"","SpeOneNameValue":"","SpeTwoName":"","SpeTwoNameValue":"","TruePrice":33990,"Unit":"件"}],"OutTypesPrice":10,"State":1,"StateName":"未付款","StoreID":49707,"StoreName":"洛阳市自营店","TotalPrice":34000,"TruePrice":33990,"UserID":27964},{"ID":1723,"OrComment":false,"OrKill":false,"OrderNumber":"16013016045322","OrderProducts":[{"ID":2167,"MarketPrice":59880,"Num":1,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/22/20150323_Shop_22_221833940545.jpg","ProductID":1765,"ProductTitle":"苹果（Apple）iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机","SpeID":1788,"SpeOneName":"","SpeOneNameValue":"","SpeTwoName":"","SpeTwoNameValue":"","TruePrice":59880,"Unit":"件"}],"OutTypesPrice":10,"State":1,"StateName":"未付款","StoreID":49707,"StoreName":"洛阳市自营店","TotalPrice":59890,"TruePrice":59880,"UserID":27964},{"ID":1722,"OrComment":false,"OrKill":false,"OrderNumber":"16013015315668","OrderProducts":[{"ID":2166,"MarketPrice":30,"Num":1,"PicID":"http://image.rexian.cn/Upload/20160130/Stores/10/20160130_Stores_10_104852613345.jpg","ProductID":34647,"ProductTitle":"宁夏历之源苦荞茶","SpeID":36724,"SpeOneName":"品牌","SpeOneNameValue":"历之源","SpeTwoName":"单盒容量","SpeTwoNameValue":"200g","TruePrice":198,"Unit":"公斤"}],"OutTypesPrice":0,"State":1,"StateName":"未付款","StoreID":49707,"StoreName":"洛阳市自营店","TotalPrice":198,"TruePrice":198,"UserID":27964}]
     * pagesize : 10
     * status : 0
     * statusMsg : 请求成功
     * totalPage : 1
     * totalRecord : 4
     */

    private int currentPage;
    private int pagesize;
    private int status;
    private String statusMsg;
    private int totalPage;
    private int totalRecord;
    /**
     * ID : 1922
     * OrComment : false
     * OrKill : false
     * OrderNumber : 16021715582035
     * OrderProducts : [{"ID":2370,"MarketPrice":30,"Num":1,"PicID":"http://image.rexian.cn/Upload/20160130/Stores/10/20160130_Stores_10_104852613345.jpg","ProductID":34647,"ProductTitle":"宁夏历之源苦荞茶","SpeID":36724,"SpeOneName":"品牌","SpeOneNameValue":"历之源","SpeTwoName":"单盒容量","SpeTwoNameValue":"200g","TruePrice":198,"Unit":"公斤"}]
     * OutTypesPrice : 0
     * State : 1
     * StateName : 未付款
     * StoreID : 49707
     * StoreName : 洛阳市自营店
     * TotalPrice : 198
     * TruePrice : 198
     * UserID : 27964
     */

    private List<ListEntity> list;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        private int ID;
        private boolean OrComment;
        private boolean OrKill;
        private String OrderNumber;
        private int OutTypesPrice;
        private int State;
        private String StateName;
        private int StoreID;
        private String StoreName;
        private int TotalPrice;
        private int TruePrice;
        private int UserID;
        /**
         * ID : 2370
         * MarketPrice : 30
         * Num : 1
         * PicID : http://image.rexian.cn/Upload/20160130/Stores/10/20160130_Stores_10_104852613345.jpg
         * ProductID : 34647
         * ProductTitle : 宁夏历之源苦荞茶
         * SpeID : 36724
         * SpeOneName : 品牌
         * SpeOneNameValue : 历之源
         * SpeTwoName : 单盒容量
         * SpeTwoNameValue : 200g
         * TruePrice : 198
         * Unit : 公斤
         */

        private List<OrderProductsEntity> OrderProducts;

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setOrComment(boolean OrComment) {
            this.OrComment = OrComment;
        }

        public void setOrKill(boolean OrKill) {
            this.OrKill = OrKill;
        }

        public void setOrderNumber(String OrderNumber) {
            this.OrderNumber = OrderNumber;
        }

        public void setOutTypesPrice(int OutTypesPrice) {
            this.OutTypesPrice = OutTypesPrice;
        }

        public void setState(int State) {
            this.State = State;
        }

        public void setStateName(String StateName) {
            this.StateName = StateName;
        }

        public void setStoreID(int StoreID) {
            this.StoreID = StoreID;
        }

        public void setStoreName(String StoreName) {
            this.StoreName = StoreName;
        }

        public void setTotalPrice(int TotalPrice) {
            this.TotalPrice = TotalPrice;
        }

        public void setTruePrice(int TruePrice) {
            this.TruePrice = TruePrice;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public void setOrderProducts(List<OrderProductsEntity> OrderProducts) {
            this.OrderProducts = OrderProducts;
        }

        public int getID() {
            return ID;
        }

        public boolean isOrComment() {
            return OrComment;
        }

        public boolean isOrKill() {
            return OrKill;
        }

        public String getOrderNumber() {
            return OrderNumber;
        }

        public int getOutTypesPrice() {
            return OutTypesPrice;
        }

        public int getState() {
            return State;
        }

        public String getStateName() {
            return StateName;
        }

        public int getStoreID() {
            return StoreID;
        }

        public String getStoreName() {
            return StoreName;
        }

        public int getTotalPrice() {
            return TotalPrice;
        }

        public int getTruePrice() {
            return TruePrice;
        }

        public int getUserID() {
            return UserID;
        }

        public List<OrderProductsEntity> getOrderProducts() {
            return OrderProducts;
        }

        public static class OrderProductsEntity {
            private int ID;
            private int MarketPrice;
            private int Num;
            private String PicID;
            private int ProductID;
            private String ProductTitle;
            private int SpeID;
            private String SpeOneName;
            private String SpeOneNameValue;
            private String SpeTwoName;
            private String SpeTwoNameValue;
            private int TruePrice;
            private String Unit;

            public void setID(int ID) {
                this.ID = ID;
            }

            public void setMarketPrice(int MarketPrice) {
                this.MarketPrice = MarketPrice;
            }

            public void setNum(int Num) {
                this.Num = Num;
            }

            public void setPicID(String PicID) {
                this.PicID = PicID;
            }

            public void setProductID(int ProductID) {
                this.ProductID = ProductID;
            }

            public void setProductTitle(String ProductTitle) {
                this.ProductTitle = ProductTitle;
            }

            public void setSpeID(int SpeID) {
                this.SpeID = SpeID;
            }

            public void setSpeOneName(String SpeOneName) {
                this.SpeOneName = SpeOneName;
            }

            public void setSpeOneNameValue(String SpeOneNameValue) {
                this.SpeOneNameValue = SpeOneNameValue;
            }

            public void setSpeTwoName(String SpeTwoName) {
                this.SpeTwoName = SpeTwoName;
            }

            public void setSpeTwoNameValue(String SpeTwoNameValue) {
                this.SpeTwoNameValue = SpeTwoNameValue;
            }

            public void setTruePrice(int TruePrice) {
                this.TruePrice = TruePrice;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getID() {
                return ID;
            }

            public int getMarketPrice() {
                return MarketPrice;
            }

            public int getNum() {
                return Num;
            }

            public String getPicID() {
                return PicID;
            }

            public int getProductID() {
                return ProductID;
            }

            public String getProductTitle() {
                return ProductTitle;
            }

            public int getSpeID() {
                return SpeID;
            }

            public String getSpeOneName() {
                return SpeOneName;
            }

            public String getSpeOneNameValue() {
                return SpeOneNameValue;
            }

            public String getSpeTwoName() {
                return SpeTwoName;
            }

            public String getSpeTwoNameValue() {
                return SpeTwoNameValue;
            }

            public int getTruePrice() {
                return TruePrice;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }
}
