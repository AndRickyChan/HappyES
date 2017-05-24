package com.ricky.happyes.ui.main.travel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.TravelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 旅行
 * Created by Ricky on 2017-3-9.
 */

public class TravelPresenter extends RxPresenter<TravelContract.View> implements TravelContract.Presenter {

    public TravelPresenter(TravelContract.View mView) {
        super(mView);
    }

    @Override
    public void getTravelList(Context mContext, int page, int count) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<TravelBean> list = new ArrayList<TravelBean>();
                for (int i = 0; i < 10; i++) {
                    TravelBean travelBean = new TravelBean();
                    travelBean.setTravel_id("agargarga");
                    travelBean.setTravel_title("恩施大峡谷");
                    travelBean.setTravel_logo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492583024064&di=3269c140197edd0484100bd39c2f3066&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd833c895d143ad4b2ed2948a84025aafa50f06f8.jpg");
                    travelBean.setTravel_des("恩施大峡谷是国家级别5星旅游景点，是具有恩施土家风情的风景名胜区。");
                    travelBean.setGood_point(99);
                    travelBean.setTravel_price(180);
                    list.add(travelBean);
                }
                if (page == 1) {
                    mView.onLoadRefresh(list);
                } else if (page == 3) {
                    mView.onNoMore();
                } else {
                    mView.onLoadMore(list);
                }
            }
        }, 1000);
    }
}
