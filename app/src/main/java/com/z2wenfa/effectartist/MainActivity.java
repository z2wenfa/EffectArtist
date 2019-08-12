package com.z2wenfa.effectartist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    private RecyclerView recyclerView;

    private List<EffectEntity> efftectEntityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new BaseSectionQuickAdapter<EffectEntity, BaseViewHolder>(R.layout.item_effect, R.layout.header,efftectEntityList ) {
            @Override
            protected void convert(BaseViewHolder helper, EffectEntity item) {

            }

            @Override
            protected void convertHead(BaseViewHolder helper, EffectEntity item) {

            }

        });
    }

    public class EffectEntity extends SectionEntity {

        public EffectEntity(boolean isHeader, String header) {
            super(isHeader, header);
        }
    }
}
