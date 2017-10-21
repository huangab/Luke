package com.hyp.luke.module_home.bean;

import java.util.List;

/**
 * Created by  HuangYP on 2017/6/22 0022.
 * https://api.kaishustory.com/homeservice/layout?userid=90479127
 * 今日推荐
 */

public class AblumEntity {


    /**
     * title : 今日推荐
     * subtitle : ["今天听什么？快看看这里"]
     * layout : 2
     * content : [{"story":{},"ablum":{"storycount":13,"ablumname":"小王子","product":{"showprice":39,"alreadybuy":0,"productid":1164,"realityprice":39,"contentid":202,"productname":"小王子","contenttype":1},"lastupdatedesc":"","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/55aa8b36-ad0f-44b2-a662-e7c32d83aae3.jpg","subhead":"最美童话，献给童年的你","feetype":"01","isfinish":0,"ablumid":"202"},"product":{},"adver":{},"index":0,"contenttype":"ablum","contentid":202,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/3a99ae6f-7f0e-4907-899b-212b7a2d2c10.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/b6b5c607-db7b-4d71-b8a5-0286cff5c449.jpg","publishtime":1498406400000},{"story":{"storyid":"100228","product":{},"alreadybuy":0,"timetext":"06:08","articleid":"","subhead":"一首自然界的父爱赞歌！","isdownload":false,"duration":368,"playcount":231124,"iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/d353957f-59ff-490e-ba3d-fd53a96d1be9.jpg","feetype":"00","banduid":"","storyname":"海马先生"},"ablum":{},"product":{},"adver":{},"index":1,"contenttype":"story","contentid":100228,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/894bab98-11a4-407f-8666-ae4aebb35f47.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/1855a2db-1d7f-482d-a505-1486d9680cfc.jpg","publishtime":1498406400000},{"story":{"storyid":"100193","product":{},"alreadybuy":0,"timetext":"11:40","articleid":"","subhead":"让孩子学会肯定自己，不因比较而迷失自我","isdownload":false,"duration":700,"playcount":125866,"iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/94b1a8ef-5f90-4dca-936b-e8e0fd66edd7.jpg","feetype":"00","banduid":"","storyname":"亚历山大和发条老鼠"},"ablum":{},"product":{},"adver":{},"index":2,"contenttype":"story","contentid":100193,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/601c7818-fe45-4dab-a921-78ed9979c9b9.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/ce867f0e-8ea3-4cc8-a13b-08bc63be5d36.jpg","publishtime":1498406400000},{"story":{"storyid":"102973","product":{"showprice":396,"alreadybuy":0,"productid":1009,"realityprice":298,"contentid":92,"productname":"凯叔365夜","contenttype":3},"alreadybuy":0,"timetext":"16:14","articleid":369,"subhead":"庞统当县令，杀鸡用牛刀","isdownload":false,"duration":974,"playcount":48,"iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/6f1dad26-31b0-45d6-b8cd-9f9b68d9a15f.jpg","feetype":"01","banduid":"","storyname":"大材小用"},"ablum":{},"product":{},"adver":{},"index":3,"contenttype":"story","contentid":102973,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/03cba612-bb37-4925-8b8c-25d9ef5ae079.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/56cd45c5-60fc-49dd-8848-a1c8b6ae654d.jpg","publishtime":1498406400000}]
     * adver : {}
     * index : 0
     * layoutid : 3
     * shownumber : 4
     * showmore : 0
     * nextpoint : 0
     */

    private String title;
    private int layout;
    private AdverBean adver;
    private int index;
    private int layoutid;
    private int shownumber;
    private int showmore;
    private int nextpoint;
    private List<String> subtitle;
    private List<ContentBean> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public AdverBean getAdver() {
        return adver;
    }

    public void setAdver(AdverBean adver) {
        this.adver = adver;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLayoutid() {
        return layoutid;
    }

    public void setLayoutid(int layoutid) {
        this.layoutid = layoutid;
    }

    public int getShownumber() {
        return shownumber;
    }

    public void setShownumber(int shownumber) {
        this.shownumber = shownumber;
    }

    public int getShowmore() {
        return showmore;
    }

    public void setShowmore(int showmore) {
        this.showmore = showmore;
    }

    public int getNextpoint() {
        return nextpoint;
    }

    public void setNextpoint(int nextpoint) {
        this.nextpoint = nextpoint;
    }

    public List<String> getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(List<String> subtitle) {
        this.subtitle = subtitle;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class AdverBean {
    }

    public static class ContentBean {
        /**
         * story : {}
         * ablum : {"storycount":13,"ablumname":"小王子","product":{"showprice":39,"alreadybuy":0,"productid":1164,"realityprice":39,"contentid":202,"productname":"小王子","contenttype":1},"lastupdatedesc":"","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/55aa8b36-ad0f-44b2-a662-e7c32d83aae3.jpg","subhead":"最美童话，献给童年的你","feetype":"01","isfinish":0,"ablumid":"202"}
         * product : {}
         * adver : {}
         * index : 0
         * contenttype : ablum
         * contentid : 202
         * coverurl : http://cdn.kaishuhezi.com/kstory/story/image/3a99ae6f-7f0e-4907-899b-212b7a2d2c10.jpg
         * recomimgurl : http://cdn.kaishuhezi.com/kstory/story/image/b6b5c607-db7b-4d71-b8a5-0286cff5c449.jpg
         * publishtime : 1498406400000
         */

        private StoryBean story;
        private AblumBean ablum;
        private ProductBeanX product;
        private AdverBeanX adver;
        private int index;
        private String contenttype;
        private int contentid;
        private String coverurl;
        private String recomimgurl;
        private long publishtime;

        public StoryBean getStory() {
            return story;
        }

        public void setStory(StoryBean story) {
            this.story = story;
        }

        public AblumBean getAblum() {
            return ablum;
        }

        public void setAblum(AblumBean ablum) {
            this.ablum = ablum;
        }

        public ProductBeanX getProduct() {
            return product;
        }

        public void setProduct(ProductBeanX product) {
            this.product = product;
        }

        public AdverBeanX getAdver() {
            return adver;
        }

        public void setAdver(AdverBeanX adver) {
            this.adver = adver;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getContenttype() {
            return contenttype;
        }

        public void setContenttype(String contenttype) {
            this.contenttype = contenttype;
        }

        public int getContentid() {
            return contentid;
        }

        public void setContentid(int contentid) {
            this.contentid = contentid;
        }

        public String getCoverurl() {
            return coverurl;
        }

        public void setCoverurl(String coverurl) {
            this.coverurl = coverurl;
        }

        public String getRecomimgurl() {
            return recomimgurl;
        }

        public void setRecomimgurl(String recomimgurl) {
            this.recomimgurl = recomimgurl;
        }

        public long getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(long publishtime) {
            this.publishtime = publishtime;
        }

        public static class StoryBean {

            /**
             * storyid : 100228
             * product : {}
             * alreadybuy : 0
             * timetext : 06:08
             * articleid :
             * subhead : 一首自然界的父爱赞歌！
             * isdownload : false
             * duration : 368
             * playcount : 231124
             * iconurl : http://cdn.kaishuhezi.com/kstory/story/image/d353957f-59ff-490e-ba3d-fd53a96d1be9.jpg
             * feetype : 00
             * banduid :
             * storyname : 海马先生
             */

            private String storyid;
            private ProductBean product;
            private int alreadybuy;
            private String timetext;
            private String articleid;
            private String subhead;
            private boolean isdownload;
            private int duration;
            private int playcount;
            private String iconurl;
            private String feetype;
            private String banduid;
            private String storyname;

            public String getStoryid() {
                return storyid;
            }

            public void setStoryid(String storyid) {
                this.storyid = storyid;
            }

            public ProductBean getProduct() {
                return product;
            }

            public void setProduct(ProductBean product) {
                this.product = product;
            }

            public int getAlreadybuy() {
                return alreadybuy;
            }

            public void setAlreadybuy(int alreadybuy) {
                this.alreadybuy = alreadybuy;
            }

            public String getTimetext() {
                return timetext;
            }

            public void setTimetext(String timetext) {
                this.timetext = timetext;
            }

            public String getArticleid() {
                return articleid;
            }

            public void setArticleid(String articleid) {
                this.articleid = articleid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public boolean isIsdownload() {
                return isdownload;
            }

            public void setIsdownload(boolean isdownload) {
                this.isdownload = isdownload;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public String getIconurl() {
                return iconurl;
            }

            public void setIconurl(String iconurl) {
                this.iconurl = iconurl;
            }

            public String getFeetype() {
                return feetype;
            }

            public void setFeetype(String feetype) {
                this.feetype = feetype;
            }

            public String getBanduid() {
                return banduid;
            }

            public void setBanduid(String banduid) {
                this.banduid = banduid;
            }

            public String getStoryname() {
                return storyname;
            }

            public void setStoryname(String storyname) {
                this.storyname = storyname;
            }

            public static class ProductBean {

                /**
                 * showprice : 396
                 * alreadybuy : 0
                 * productid : 1009
                 * realityprice : 298
                 * contentid : 92
                 * productname : 凯叔365夜
                 * contenttype : 3
                 */

                private int showprice;
                private int alreadybuy;
                private int productid;
                private int realityprice;
                private int contentid;
                private String productname;
                private int contenttype;

                public int getShowprice() {
                    return showprice;
                }

                public void setShowprice(int showprice) {
                    this.showprice = showprice;
                }

                public int getAlreadybuy() {
                    return alreadybuy;
                }

                public void setAlreadybuy(int alreadybuy) {
                    this.alreadybuy = alreadybuy;
                }

                public int getProductid() {
                    return productid;
                }

                public void setProductid(int productid) {
                    this.productid = productid;
                }

                public int getRealityprice() {
                    return realityprice;
                }

                public void setRealityprice(int realityprice) {
                    this.realityprice = realityprice;
                }

                public int getContentid() {
                    return contentid;
                }

                public void setContentid(int contentid) {
                    this.contentid = contentid;
                }

                public String getProductname() {
                    return productname;
                }

                public void setProductname(String productname) {
                    this.productname = productname;
                }

                public int getContenttype() {
                    return contenttype;
                }

                public void setContenttype(int contenttype) {
                    this.contenttype = contenttype;
                }
            }
        }

        public static class AblumBean {


            /**
             * storycount : 13
             * ablumname : 小王子
             * product : {"showprice":39,"alreadybuy":0,"productid":1164,"realityprice":39,"contentid":202,"productname":"小王子","contenttype":1}
             * lastupdatedesc :
             * iconurl : http://cdn.kaishuhezi.com/kstory/story/image/55aa8b36-ad0f-44b2-a662-e7c32d83aae3.jpg
             * subhead : 最美童话，献给童年的你
             * feetype : 01
             * isfinish : 0
             * ablumid : 202
             */

            private int storycount;
            private String ablumname;
            private ProductBean product;
            private String lastupdatedesc;
            private String iconurl;
            private String subhead;
            private String feetype;
            private int isfinish;
            private String ablumid;

            public int getStorycount() {
                return storycount;
            }

            public void setStorycount(int storycount) {
                this.storycount = storycount;
            }

            public String getAblumname() {
                return ablumname;
            }

            public void setAblumname(String ablumname) {
                this.ablumname = ablumname;
            }

            public ProductBean getProduct() {
                return product;
            }

            public void setProduct(ProductBean product) {
                this.product = product;
            }

            public String getLastupdatedesc() {
                return lastupdatedesc;
            }

            public void setLastupdatedesc(String lastupdatedesc) {
                this.lastupdatedesc = lastupdatedesc;
            }

            public String getIconurl() {
                return iconurl;
            }

            public void setIconurl(String iconurl) {
                this.iconurl = iconurl;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getFeetype() {
                return feetype;
            }

            public void setFeetype(String feetype) {
                this.feetype = feetype;
            }

            public int getIsfinish() {
                return isfinish;
            }

            public void setIsfinish(int isfinish) {
                this.isfinish = isfinish;
            }

            public String getAblumid() {
                return ablumid;
            }

            public void setAblumid(String ablumid) {
                this.ablumid = ablumid;
            }

            public static class ProductBean {

                /**
                 * showprice : 39
                 * alreadybuy : 0
                 * productid : 1164
                 * realityprice : 39
                 * contentid : 202
                 * productname : 小王子
                 * contenttype : 1
                 */

                private int showprice;
                private int alreadybuy;
                private int productid;
                private int realityprice;
                private int contentid;
                private String productname;
                private int contenttype;

                public int getShowprice() {
                    return showprice;
                }

                public void setShowprice(int showprice) {
                    this.showprice = showprice;
                }

                public int getAlreadybuy() {
                    return alreadybuy;
                }

                public void setAlreadybuy(int alreadybuy) {
                    this.alreadybuy = alreadybuy;
                }

                public int getProductid() {
                    return productid;
                }

                public void setProductid(int productid) {
                    this.productid = productid;
                }

                public int getRealityprice() {
                    return realityprice;
                }

                public void setRealityprice(int realityprice) {
                    this.realityprice = realityprice;
                }

                public int getContentid() {
                    return contentid;
                }

                public void setContentid(int contentid) {
                    this.contentid = contentid;
                }

                public String getProductname() {
                    return productname;
                }

                public void setProductname(String productname) {
                    this.productname = productname;
                }

                public int getContenttype() {
                    return contenttype;
                }

                public void setContenttype(int contenttype) {
                    this.contenttype = contenttype;
                }
            }


        }

        public static class ProductBeanX {
        }

        public static class AdverBeanX {
        }
    }
}
