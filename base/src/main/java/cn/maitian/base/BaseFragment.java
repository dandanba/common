package cn.maitian.base;


import android.content.Context;
import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.maitian.eventbus.EventUtil;
import cn.maitian.eventbus.event.BaseEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private BaseActivity mBaseActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBaseActivity = (BaseActivity) context;
        EventUtil.register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventUtil.unregister(this);
    }

    // This method will be called when a BaseEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent event) {
    }

    public void postEvent(Object event) {
        EventUtil.postEvent(event);
    }


    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }
}
