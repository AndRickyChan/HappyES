package com.ricky.happyes.ui.main.home;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.MyMessageListBean;
import com.ricky.happyes.bean.TravelBean;
import com.ricky.happyes.bean.home.BannerBean;
import com.ricky.happyes.bean.home.HomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Created by Ricky on 2017-3-9.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {

    public HomePresenter(HomeContract.View mView) {
        super(mView);
    }

    @Override
    public void getHomeBanner(Context mContext) {
        List<BannerBean> beanList = new ArrayList<>();
        beanList.add(new BannerBean("1", "http://img3.imgtn.bdimg.com/it/u=879408061,688660268&fm=23&gp=0.jpg"));
        beanList.add(new BannerBean("2", "http://cdn.duitang.com/uploads/item/201412/05/20141205154819_mCWHW.jpeg"));
        beanList.add(new BannerBean("3", "http://bbs.9you.com/data/attachment/forum/201703/27/142234v5o05ozlnly9gi3y.jpg"));
        beanList.add(new BannerBean("4", "http://imgsrc.baidu.com/forum/pic/item/9825bc315c6034a857621e38cb13495408237682.jpg"));
        beanList.add(new BannerBean("5", "http://img0.imgtn.bdimg.com/it/u=2395202639,1879296775&fm=23&gp=0.jpg"));
        mView.onLoadBannerSuccess(beanList);
    }

    @Override
    public void getHomeData(Context mContext) {
        HomeBean bean = new HomeBean();
        bean.setMessage_id("afagaaergarg");
        bean.setMessage_content("我间中饮醉酒 很喜欢自由 常犯错爱说谎 但总会内疚 遇过很多的损友 学到贪新厌旧 亦欠过很多女人 怕结婚只会守 三分钟诺言 曾话过要戒烟 但讲了就算 梦与想丢低很远 但对返工厌倦 自小不会打算");
        bean.setMessage_time("2017-04-19 11:00");
        List<TravelBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TravelBean travelBean = new TravelBean();
            travelBean.setTravel_id("agargarga");
            travelBean.setTravel_title("恩施大峡谷");
            travelBean.setTravel_logo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492583024064&di=3269c140197edd0484100bd39c2f3066&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd833c895d143ad4b2ed2948a84025aafa50f06f8.jpg");
            travelBean.setTravel_des("恩施大峡谷是国家级别5星旅游景点，是具有恩施土家风情的风景名胜区。");
            travelBean.setGood_point(99);
            travelBean.setTravel_price(180);
            list.add(travelBean);
        }
        bean.setHot_travel(list);
        mView.showHomeData(bean);
    }
}
