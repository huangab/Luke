package com.hyp.luke.module_home.bean;

import java.util.List;

/**
 * Created by  HuangYP on 2017/6/26 0026.
 */

public class DayEntity {

    /**
     * title : 凯叔·声律启蒙
     * subtitle : ["每天三分钟，国学童子功"]
     * layout : 5
     * content : [{"story":{},"ablum":{"storycount":14,"ablumname":"凯叔·声律启蒙","product":{"showprice":99,"alreadybuy":0,"productid":1145,"realityprice":99,"contentid":192,"productname":"凯叔·声律启蒙","contenttype":3},"lastupdatedesc":"更新到:更新到： 凯叔·声律启蒙·五微②","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/bbd7ce34-ccef-42f2-aa01-79dcf4017570.jpg","subhead":"每天三分钟，国学童子功","feetype":"01","isfinish":0,"ablumid":"192"},"product":{},"adver":{},"index":0,"contenttype":"ablum","contentid":192,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/2a1fc422-c8c4-4a5f-b55e-7f75f42203a5.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/2a1fc422-c8c4-4a5f-b55e-7f75f42203a5.jpg","publishtime":1494543540000},{"story":{"storyid":"102608","product":{"showprice":99,"alreadybuy":0,"productid":1145,"realityprice":99,"contentid":192,"productname":"凯叔·声律启蒙","contenttype":3},"alreadybuy":0,"timetext":"03:12","articleid":136,"subhead":"明对暗，淡对浓，上智对中庸 。","isdownload":false,"duration":192,"playcount":270746,"iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/710e7c68-d31f-4d2e-920a-deba1dbc1a17.png","feetype":"01","banduid":107,"storyname":"凯叔·声律启蒙·二冬②"},"ablum":{},"product":{},"adver":{},"index":1,"contenttype":"story","contentid":102608,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/12e120a4-401a-4afd-9d40-bba4595ede91.png","recomimgurl":"","publishtime":1495610040000},{"story":{"storyid":"102530","product":{"showprice":99,"alreadybuy":0,"productid":1145,"realityprice":99,"contentid":192,"productname":"凯叔·声律启蒙","contenttype":3},"alreadybuy":0,"timetext":"03:18","articleid":107,"subhead":"贫对富，塞对通，野叟对溪童。","isdownload":false,"duration":198,"playcount":463963,"iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/bd8d0af8-d652-47ad-b583-762f3c66510b.jpg","feetype":"01","banduid":105,"storyname":"凯叔·声律启蒙·一东③"},"ablum":{},"product":{},"adver":{},"index":2,"contenttype":"story","contentid":102530,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/d6fb9b46-bfaf-4830-9d26-ff2c995bd809.jpg","recomimgurl":"","publishtime":1495610100000}]
     * adver : {}
     * index : 1
     * layoutid : 10
     * shownumber : 3
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
         * ablum : {"storycount":14,"ablumname":"凯叔·声律启蒙","product":{"showprice":99,"alreadybuy":0,"productid":1145,"realityprice":99,"contentid":192,"productname":"凯叔·声律启蒙","contenttype":3},"lastupdatedesc":"更新到:更新到： 凯叔·声律启蒙·五微②","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/bbd7ce34-ccef-42f2-aa01-79dcf4017570.jpg","subhead":"每天三分钟，国学童子功","feetype":"01","isfinish":0,"ablumid":"192"}
         * product : {}
         * adver : {}
         * index : 0
         * contenttype : ablum
         * contentid : 192
         * coverurl : http://cdn.kaishuhezi.com/kstory/story/image/2a1fc422-c8c4-4a5f-b55e-7f75f42203a5.jpg
         * recomimgurl : http://cdn.kaishuhezi.com/kstory/story/image/2a1fc422-c8c4-4a5f-b55e-7f75f42203a5.jpg
         * publishtime : 1494543540000
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
             * storyid : 102608
             * product : {"showprice":99,"alreadybuy":0,"productid":1145,"realityprice":99,"contentid":192,"productname":"凯叔·声律启蒙","contenttype":3}
             * alreadybuy : 0
             * timetext : 03:12
             * articleid : 136
             * subhead : 明对暗，淡对浓，上智对中庸 。
             * isdownload : false
             * duration : 192
             * playcount : 270746
             * iconurl : http://cdn.kaishuhezi.com/kstory/story/image/710e7c68-d31f-4d2e-920a-deba1dbc1a17.png
             * feetype : 01
             * banduid : 107
             * storyname : 凯叔·声律启蒙·二冬②
             */

            private String storyid;
            private ProductBean product;
            private int alreadybuy;
            private String timetext;
            private int articleid;
            private String subhead;
            private boolean isdownload;
            private int duration;
            private int playcount;
            private String iconurl;
            private String feetype;
            private int banduid;
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

            public int getArticleid() {
                return articleid;
            }

            public void setArticleid(int articleid) {
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

            public int getBanduid() {
                return banduid;
            }

            public void setBanduid(int banduid) {
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
                 * showprice : 99
                 * alreadybuy : 0
                 * productid : 1145
                 * realityprice : 99
                 * contentid : 192
                 * productname : 凯叔·声律启蒙
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
             * storycount : 14
             * ablumname : 凯叔·声律启蒙
             * product : {"showprice":99,"alreadybuy":0,"productid":1145,"realityprice":99,"contentid":192,"productname":"凯叔·声律启蒙","contenttype":3}
             * lastupdatedesc : 更新到:更新到： 凯叔·声律启蒙·五微②
             * iconurl : http://cdn.kaishuhezi.com/kstory/story/image/bbd7ce34-ccef-42f2-aa01-79dcf4017570.jpg
             * subhead : 每天三分钟，国学童子功
             * feetype : 01
             * isfinish : 0
             * ablumid : 192
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
                 * showprice : 99
                 * alreadybuy : 0
                 * productid : 1145
                 * realityprice : 99
                 * contentid : 192
                 * productname : 凯叔·声律启蒙
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

        public static class ProductBeanX {
        }

        public static class AdverBeanX {
        }
    }
}
