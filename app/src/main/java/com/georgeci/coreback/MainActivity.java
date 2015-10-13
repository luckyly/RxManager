package com.georgeci.coreback;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.georgeci.coreback.i.SCommand;
import com.georgeci.coreback.rx.RxWorkManager;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends RxAppCompatActivity {

    RxWorkManager manager = new RxWorkManager();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.btn)
    void click() {
        SCommand command = new SCommand("awe");
        manager.rxExecute(command).subscribe(
                s -> Log.i("CSUBS", s),
                throwable -> Log.i("CSUBS", "qw"),
                () -> Log.i("CSUBS", "complete"));
    }

    @OnClick(R.id.btn2)
    void click2() {

    }

    @OnClick(R.id.btn3)
    void click3() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause: " + hashCode());
        manager.shouldStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager.start(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
