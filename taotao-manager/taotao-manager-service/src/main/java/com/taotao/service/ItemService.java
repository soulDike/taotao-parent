package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

    TbItem getTbItemById(long id);

    /**
     * 查询商品列表
     * @param page
     * @param rows
     * @return
     */
    EUDataGridResult getTbItemList(int page, int rows);
}
