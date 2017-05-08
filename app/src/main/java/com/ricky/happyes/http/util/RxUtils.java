package com.ricky.happyes.http.util;

import com.ricky.happyes.bean.BaseBean;
import com.ricky.happyes.http.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Rx结果处理类
 * Created by Ricky on 2017-4-10.
 */

public class RxUtils {
    private static final int SUCCESS = 0; // 请求成功
    private static final int LOGIC_ERROR = 2; // 业务逻辑错误（显示 msg)

    /**
     * 统一线程处理
     */
    public static <T> rx.Observable.Transformer<T, T> rxSchedulerHelper() {
        return new rx.Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     */
    public static <T> Observable.Transformer<BaseBean<T>, T> handleResult() {
        return new Observable.Transformer<BaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseBean<T>> httpResponseObservable) {
                return httpResponseObservable.flatMap(new Func1<BaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(BaseBean<T> httpResponse) {
                        if (httpResponse == null) {
                            return Observable.empty();
                        } else if (httpResponse.getCode() == SUCCESS) {
                            return createData(httpResponse.getData());
                        } else if (httpResponse.getCode() == LOGIC_ERROR) {
                            return Observable.error(new ApiException(httpResponse.getMsg()));
                        } else {
                            return Observable.error(new ApiException("服务器繁忙，请稍后重试"));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成 Observable
     */
    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
