package com.example.administrator.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "RxJavaDemo";
    private final String[] names = {"Jack", "Tom", "Lucy", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable observable = Observable.create(new ObservableOnSubscribe() {
//            @Override
//            public void subscribe(ObservableEmitter e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onNext(4);
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.io())//通过Scheduler切换线程,subscribeOn指定在io线程发送事件
//                .observeOn(AndroidSchedulers.mainThread());//observeOn指定在主线程接收事件

//        Observable observable=Observable.fromArray("Jack","Tom","Lucy","");//用just、from等运算符同样可以像create一样快捷创建事件队列
//        Observer<String> observer = new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.d(TAG, value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError");
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        };

//        observable.subscribe(observer);

        Observable.range(310, 11)//从310开始，发送11个数据元素
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer != 315;
                    }
                })//去除315（false）
                .takeLast(5) //只选取最后5个元素
                .map(new Function<Integer, String>() {

                    @Override
                    public String apply(Integer integer) throws Exception {
                        return integer + "00";
                    }
                })//将发送Integer数据的Observable转换为发送String类型数据的Observable
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        Log.d(TAG, value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
