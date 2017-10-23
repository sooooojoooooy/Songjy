package com.songjy.introduction.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.songjy.introduction.R;
import com.songjy.introduction.adapter.MovieMsgAdapter;
import com.songjy.introduction.entity.douban.DbMovieEntity;
import com.songjy.introduction.entity.douban.SubjectsBean;
import com.songjy.introduction.listener.OnMovieMsgListener;
import com.songjy.introduction.model.MovieMsgModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class MovieMsgFragment extends BaseFragment implements OnMovieMsgListener,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.icv_movie_list)
    RecyclerView icvMovieList;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;
    @BindView(R.id.tv_error)
    TextView tvError;
    @BindView(R.id.llay_error)
    LinearLayout llayError;
    private MovieMsgModel movieMsgModel;
    private final int count = 10;
    private int start = 0;
    int lastVisibleItem;
    boolean isLoading = false;
    private MovieMsgAdapter movieMsgAdapter;
    private List<SubjectsBean> list;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        srlRefresh.setOnRefreshListener(this);
        srlRefresh.setRefreshing(true);
        movieMsgModel = new MovieMsgModel(this);
        list = new ArrayList<>();
        movieMsgModel.getT250MovieMsg(start, count);
        movieMsgAdapter = new MovieMsgAdapter(getContext(), list);
        movieMsgAdapter.setHasStableIds(true);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        icvMovieList.setLayoutManager(mLayoutManager);
        icvMovieList.setAdapter(movieMsgAdapter);
        icvMovieList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                /*
                 * 到达底部了,如果不加!isLoading的话到达底部如果还一滑动的话就会一直进入这个方法
                 * 就一直去做请求网络的操作,这样的用户体验肯定不好.添加一个判断,每次滑倒底只进行一次网络请求去请求数据
                 * 当请求完成后,在把isLoading赋值为false,下次滑倒底又能进入这个方法了
                 */
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                        lastVisibleItem + 1 == movieMsgAdapter.getItemCount()
                        && !isLoading) {
                    //到达底部之后如果footView的状态不是正在加载的状态,就将 他切换成正在加载的状态
                    if (start < 200) {
                        isLoading = true;
                        movieMsgAdapter.changeState(1);
                        movieMsgModel.getT250MovieMsg(start, count);
                    } else {
                        movieMsgAdapter.changeState(2);
                        movieMsgAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_msg;
    }

    @Override
    public void onSuccess(DbMovieEntity rqs) {
        srlRefresh.setRefreshing(false);
        start += count;
        isLoading = false;
        list.addAll(rqs.getSubjects());
        movieMsgAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail() {
        llayError.setVisibility(View.VISIBLE);
        srlRefresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        start = 0;
        list.clear();
        movieMsgModel.getT250MovieMsg(start, count);
    }

    @OnClick(R.id.llay_error)
    public void onViewClicked() {
        srlRefresh.setRefreshing(true);
        movieMsgModel.getT250MovieMsg(start, count);
        llayError.setVisibility(View.GONE);
    }
}
