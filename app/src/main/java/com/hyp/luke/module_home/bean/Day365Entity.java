package com.hyp.luke.module_home.bean;

import java.util.List;

/**
 * Created by  HuangYP on 2017/6/22 0022.
 */

public class Day365Entity {

    /**
     * title : 凯叔365夜
     * subtitle : ["在好故事里学常识"]
     * layout : 5
     * content : [{"story":{},"ablum":{"storycount":283,"ablumname":"凯叔365夜","product":{"showprice":396,"alreadybuy":0,"productid":1009,"realityprice":298,"contentid":92,"productname":"凯叔365夜","contenttype":3},"lastupdatedesc":"更新到:更新到： 大材小用","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/70c44edf-089f-4e00-9484-06e3eabf7068.png","subhead":"在好故事里学常识","feetype":"01","isfinish":0,"ablumid":"92"},"product":{},"adver":{},"index":0,"contenttype":"ablum","contentid":92,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/e658fc74-0721-48ce-9c58-f65d3cc6c366.jpg","recomimgurl":"","publishtime":1492398120000},{"story":{},"ablum":{"storycount":61,"ablumname":"99个成语故事","product":{"showprice":99,"alreadybuy":0,"productid":1160,"realityprice":99,"contentid":198,"productname":"99个成语故事","contenttype":3},"lastupdatedesc":"更新到:更新到： 大材小用","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/3eb2e604-441b-418d-af67-216bdfa2bbe3.jpg","subhead":"让成语故事更好听","feetype":"01","isfinish":0,"ablumid":"198"},"product":{},"adver":{},"index":1,"contenttype":"ablum","contentid":198,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/58c541d8-51f5-4dc6-9754-25662f9fc9e8.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/2808d5e3-65b0-4ee8-bbd9-8aefe9cc66f3.jpg","publishtime":1495786080000},{"story":{},"ablum":{"storycount":72,"ablumname":"中国传统故事","product":{"showprice":99,"alreadybuy":0,"productid":1161,"realityprice":99,"contentid":199,"productname":"中国传统故事","contenttype":3},"lastupdatedesc":"更新到:更新到： 开天辟地(夏至的故事)","iconurl":"http://cdn.kaishuhezi.com/kstory/ablum/image/45a66838-7a71-4869-88f9-493a94fa682e.png","subhead":"了解源远流长的中华文明","feetype":"01","isfinish":0,"ablumid":"199"},"product":{},"adver":{},"index":2,"contenttype":"ablum","contentid":199,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/4376fcdf-2fa0-4815-a3a7-f3b4d40c619b.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/478cca95-dfca-489b-a981-753561c42e79.jpg","publishtime":1495786020000},{"story":{},"ablum":{"storycount":122,"ablumname":"外国童话传说","product":{"showprice":99,"alreadybuy":0,"productid":1162,"realityprice":99,"contentid":200,"productname":"外国童话传说","contenttype":3},"lastupdatedesc":"更新到:更新到： 半截蜡烛","iconurl":"http://cdn.kaishuhezi.com/kstory/ablum/image/0251a0d3-dd1e-41ef-b146-0f4ab51f4449.png","subhead":"感受西方文化的魅力","feetype":"01","isfinish":0,"ablumid":"200"},"product":{},"adver":{},"index":3,"contenttype":"ablum","contentid":200,"coverurl":"http://cdn.kaishuhezi.com/kstory/story/image/7f95cfcf-2422-44f1-a98e-ebb6ea9c4af7.jpg","recomimgurl":"http://cdn.kaishuhezi.com/kstory/story/image/8c8dfba4-7e99-4980-b56e-71a12ffb7c99.jpg","publishtime":1495786020000},{"story":{},"ablum":{"storycount":28,"ablumname":"经典长篇名著","product":{"showprice":99,"alreadybuy":0,"productid":1163,"realityprice":99,"contentid":201,"productname":"经典长篇名著","contenttype":3},"lastupdatedesc":"更新到:更新到： 绿野仙踪(八)","iconurl":"http://cdn.kaishuhezi.com/kstory/ablum/image/2de9738e-7bc0-4dac-b40a-124bd4f69565.png","subhead":"三部影响世界的儿童文学名著","feetype":"01","isfinish":0,"ablumid":"201"},"product":{},"adver":{},"index":4,"contenttype":"ablum","contentid":201,"coverurl":"http://cdn.kaishuhezi.com/kstory/ablum/image/75f71126-c2b9-49ef-9766-81c0ca5361e6.png","recomimgurl":"http://cdn.kaishuhezi.com/kstory/ablum/image/382cc388-d6e5-47d1-a086-bf77c24bda06.png","publishtime":1495786080000}]
     * adver : {}
     * index : 2
     * layoutid : 6
     * shownumber : 5
     * showmore : 0
     * nextpoint : 1
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
         * ablum : {"storycount":283,"ablumname":"凯叔365夜","product":{"showprice":396,"alreadybuy":0,"productid":1009,"realityprice":298,"contentid":92,"productname":"凯叔365夜","contenttype":3},"lastupdatedesc":"更新到:更新到： 大材小用","iconurl":"http://cdn.kaishuhezi.com/kstory/story/image/70c44edf-089f-4e00-9484-06e3eabf7068.png","subhead":"在好故事里学常识","feetype":"01","isfinish":0,"ablumid":"92"}
         * product : {}
         * adver : {}
         * index : 0
         * contenttype : ablum
         * contentid : 92
         * coverurl : http://cdn.kaishuhezi.com/kstory/story/image/e658fc74-0721-48ce-9c58-f65d3cc6c366.jpg
         * recomimgurl :
         * publishtime : 1492398120000
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
             * storyid : 100176
             * product : {}
             * alreadybuy : 0
             * timetext : 07:12
             * articleid :
             * subhead : 学会关心和陪伴
             * isdownload : false
             * duration : 432
             * playcount : 160908
             * iconurl : http://cdn.kaishuhezi.com/kstory/story/image/18f03848-a510-43c5-a25c-b6cc5873a559.jpg
             * feetype : 00
             * banduid :
             * storyname : 兔小弟进城
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
            }
        }

        public static class AblumBean {

            /**
             * storycount : 283
             * ablumname : 凯叔365夜
             * product : {"showprice":396,"alreadybuy":0,"productid":1009,"realityprice":298,"contentid":92,"productname":"凯叔365夜","contenttype":3}
             * lastupdatedesc : 更新到:更新到： 大材小用
             * iconurl : http://cdn.kaishuhezi.com/kstory/story/image/70c44edf-089f-4e00-9484-06e3eabf7068.png
             * subhead : 在好故事里学常识
             * feetype : 01
             * isfinish : 0
             * ablumid : 92
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

        public static class ProductBeanX {
        }

        public static class AdverBeanX {
        }
    }
}
