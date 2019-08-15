package com.z2wenfa.effectartist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.z2wenfa.effectartist.effect.DynamicsBackgroundActivity;
import com.z2wenfa.effectartist.effect.TelescopeActivity;
import com.z2wenfa.effectartist.wiget.DynamicBakckgroudView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private List<EffectContainerEntity> effectEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new BaseSectionQuickAdapter<EffectContainerEntity, BaseViewHolder>(R.layout.item_effect, R.layout.header, effectEntities) {
            @Override
            protected void convert(BaseViewHolder helper, EffectContainerEntity item) {
                helper.setText(R.id.tv_name, item.t.name);
                helper.convertView.setOnClickListener(item.t.onClickListener);
            }

            @Override
            protected void convertHead(BaseViewHolder helper, EffectContainerEntity item) {
                helper.setText(R.id.tv_head, item.header);
            }
        });

    }

    private void initData() {
        //特效
        effectEntities.add(new EffectContainerEntity(true, "特效"));
        effectEntities.add(new EffectContainerEntity(new Effect("望远镜效果", v -> {
            startActivity(TelescopeActivity.class);
        })));

        //动画
        effectEntities.add(new EffectContainerEntity(true, "动画"));
        effectEntities.add(new EffectContainerEntity(new Effect("动态背景", v -> {
            startActivity(DynamicsBackgroundActivity.class);
        })));
    }

    private void startActivity(Class activityClass) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public class EffectContainerEntity extends SectionEntity<Effect> {

        EffectContainerEntity(boolean isHeader, String header) {
            super(isHeader, header);
        }

        EffectContainerEntity(Effect effect) {
            super(effect);
        }
    }

    class Effect {
        private String name;
        private View.OnClickListener onClickListener;

        Effect(String name, View.OnClickListener onClickListener) {
            this.name = name;
            this.onClickListener = onClickListener;
        }
    }
}
