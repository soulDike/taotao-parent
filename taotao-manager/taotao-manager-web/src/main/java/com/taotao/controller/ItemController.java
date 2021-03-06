package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getTbItemById(@PathVariable Long itemId) {
        return itemService.getTbItemById(itemId);
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(int page, int rows) {
        EUDataGridResult result = itemService.getTbItemList(page, rows);
        return result;
    }
}
