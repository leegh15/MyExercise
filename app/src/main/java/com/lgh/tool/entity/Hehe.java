package com.lgh.tool.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class Hehe {

    /**
     * currentPage : 1
     * list : [{"ID":50684,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/22/20150323_Shop_22_221833940545.jpg","ProductID":1765,"StoreID":49707,"Title":"苹果（Apple）iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机","TruePrice":59880},{"ID":50680,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/22/20150323_Shop_22_221203467021.jpg","ProductID":1777,"StoreID":49707,"Title":"韩国乐天夹心薄荷糖","TruePrice":399},{"ID":50679,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/22/20150323_Shop_22_221119724250.jpg","ProductID":1778,"StoreID":49707,"Title":"老鲜生鱿鱼仔500g","TruePrice":339},{"ID":50678,"PicID":"http://image.rexian.cn/Upload/20160130/Shop/11/20160130_Shop_11_115645902754.jpg","ProductID":34643,"StoreID":49707,"Title":"洛川绿色原生态苹果","TruePrice":65},{"ID":50298,"PicID":"http://image.rexian.cn/Upload/20160130/Stores/10/20160130_Stores_10_105015254656.jpg","ProductID":34645,"StoreID":49707,"Title":"宁夏历之源原生枸杞","TruePrice":48},{"ID":50257,"PicID":"http://image.rexian.cn/Upload/20160130/Stores/10/20160130_Stores_10_104852613345.jpg","ProductID":34647,"StoreID":49707,"Title":"宁夏历之源苦荞茶","TruePrice":24},{"ID":50104,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/22/20150323_Shop_22_220438890754.jpg","ProductID":1792,"StoreID":49707,"Title":"ZK蝙蝠袖长款毛衣套头女宽松粗针毛衣2014秋冬新款钉珠片刺绣毛衣","TruePrice":2980},{"ID":50103,"PicID":"http://image.rexian.cn/Upload/20150323/Shop/23/20150323_Shop_23_230412317357.jpg","ProductID":1744,"StoreID":49707,"Title":"0首付 412.1元X9期4K平板液晶高清电视MIUI/小米 小米电视2-单品","TruePrice":33990}]
     * pagesize : 10
     * status : 0
     * statusMsg : 请求成功
     * totalPage : 1
     * totalRecord : 8
     */

    private int currentPage;
    private int pagesize;
    private int status;
    private String statusMsg;
    private int totalPage;
    private int totalRecord;
    /**
     * ID : 50684
     * PicID : http://image.rexian.cn/Upload/20150323/Shop/22/20150323_Shop_22_221833940545.jpg
     * ProductID : 1765
     * StoreID : 49707
     * Title : 苹果（Apple）iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机
     * TruePrice : 59880
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
        private String PicID;
        private int ProductID;
        private int StoreID;
        private String Title;
        private int TruePrice;

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setPicID(String PicID) {
            this.PicID = PicID;
        }

        public void setProductID(int ProductID) {
            this.ProductID = ProductID;
        }

        public void setStoreID(int StoreID) {
            this.StoreID = StoreID;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public void setTruePrice(int TruePrice) {
            this.TruePrice = TruePrice;
        }

        public int getID() {
            return ID;
        }

        public String getPicID() {
            return PicID;
        }

        public int getProductID() {
            return ProductID;
        }

        public int getStoreID() {
            return StoreID;
        }

        public String getTitle() {
            return Title;
        }

        public int getTruePrice() {
            return TruePrice;
        }
    }
}
