package com.withever.blind.ui.notice

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.withever.blind.R
import com.withever.blind.base.BaseActivity
import com.withever.blind.base.recyclerview.Item
import com.withever.blind.databinding.ActivityNoticeBinding
import com.withever.blind.ui.adapter.NoticeListRecyclerviewAdapter
import com.withever.blind.ui.data.PostingAttributeData
import com.withever.blind.ui.data.PostingSimpleData
import kotlinx.android.synthetic.main.activity_main.*

class NoticeActivity : BaseActivity<ActivityNoticeBinding>() {

    /**----------------------------------------------------
     * Life Cycle
     *----------------------------------------------------*/
    override fun getLayoutId(): Int = R.layout.activity_notice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        initData()
    }

    override fun onResume() {
        super.onResume()
    }


    /**----------------------------------------------------
     * Initialize
     *----------------------------------------------------*/
    override fun initLayout() {
        binding?.noticeList?.adapter = NoticeListRecyclerviewAdapter()
        binding?.noticeList?.layoutManager = LinearLayoutManager(this)

        binding?.textTitle?.underline()

        toolbar.addBackButtonAction {
            finish()
        }
    }

    override fun initData() {
        val adapter = binding?.noticeList?.adapter as NoticeListRecyclerviewAdapter

        for(i in 1..15 step 1){
            val data: PostingSimpleData = PostingSimpleData(""+i, ""+(i+1), ""+(i+2), ""+(i+3),"아는 지인이 스타으업으로 오퍼가 왔다는데, 처음 가는거라 연봉땜에 갈지말지 고민\n처음 가는거라 연봉땜에 갈지말지 고민"+(i+4), i+5, i+6, PostingAttributeData(i+7, i+8, i+9, true))
            var item : Item<PostingSimpleData> = Item<PostingSimpleData>(1, data)
            adapter.addItem(item)
        }
    }
}