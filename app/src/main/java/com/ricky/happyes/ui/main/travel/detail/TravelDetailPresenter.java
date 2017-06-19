package com.ricky.happyes.ui.main.travel.detail;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.traveldetail.AdviceBean;
import com.ricky.happyes.bean.traveldetail.PriceBean;
import com.ricky.happyes.bean.traveldetail.TravelDetailBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 景点详情
 * Created by Ricky on 2017-6-19.
 */

public class TravelDetailPresenter extends RxPresenter<TravelDetailContract.View> implements TravelDetailContract.Presenter {

    public TravelDetailPresenter(TravelDetailContract.View mView) {
        super(mView);
    }

    @Override
    public void getTravelDetail(Context mContext, String travelId) {
        TravelDetailBean bean = new TravelDetailBean();
        bean.setIs_collect(true);
        bean.setTravel_id("1111");
        bean.setTravel_name("恩施大峡谷");
        bean.setTravel_location("湖北省恩施市木府镇境内");
        bean.setTravel_star(5);
        bean.setComment_count(222);
        bean.setTravel_bg("https://www.baidu.com");
        List<PriceBean> priceList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            PriceBean priceBean = new PriceBean();
            priceBean.setTravel_name("【恩施大峡谷】成人套票（七星寨+地缝+观光车+索道上行票）");
            priceBean.setPrice_id(""+i);
            priceBean.setTravel_price("189.0");
            priceList.add(priceBean);
        }
        bean.setPrice_list(priceList);
        List<AdviceBean> adviceList = new ArrayList<>();
        AdviceBean time = new AdviceBean();
        time.setAdvice_title("开放时间");
        time.setAdvice_content("3月~10月：08：00~16：00开放；\n11月~2月：08：30~15：30开放；");
        adviceList.add(time);
        AdviceBean free = new AdviceBean();
        free.setAdvice_title("免费政策");
        free.setAdvice_content("儿童身高1.2米一下免费，70岁以上老人免费，军人和残疾人免费");
        adviceList.add(free);
        AdviceBean youhui = new AdviceBean();
        youhui.setAdvice_title("优惠政策");
        youhui.setAdvice_content("学生证半价，60~70岁优惠票");
        adviceList.add(youhui);
        bean.setAdvice_list(adviceList);

        mView.onLoadTravelDetailSuccess(bean);
    }
}
