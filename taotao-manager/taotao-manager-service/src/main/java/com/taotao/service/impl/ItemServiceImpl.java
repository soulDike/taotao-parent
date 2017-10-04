package com.taotao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getTbItemById(long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public EUDataGridResult getTbItemList(int page, int rows) {
        TbItemExample example = new TbItemExample();
        PageHelper.startPage(page, rows);
        //返回数据
        EUDataGridResult result = new EUDataGridResult();
        PageInfo<TbItem> pageItem = PageHelper.startPage(page, rows).doSelectPageInfo(() ->itemMapper.selectByExample(example));
        result.setRows(pageItem.getList());
        result.setTotal(pageItem.getTotal());

        return result;
    }
}
