package com.taotao.controller;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> list(@RequestParam(value = "id", defaultValue = "0") long parentId) {
        return itemCatService.getItemCatByParentId(parentId);
    }

}
