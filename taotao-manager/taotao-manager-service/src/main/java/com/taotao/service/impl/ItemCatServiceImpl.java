package com.taotao.service.impl;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EUTreeNode> getItemCatByParentId(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andStatusEqualTo(1);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        if (tbItemCats != null && tbItemCats.size() > 0) {
            for (TbItemCat tbItemCat:tbItemCats) {
                EUTreeNode euTreeNode = new EUTreeNode();
                euTreeNode.setId(tbItemCat.getId());
                euTreeNode.setText(tbItemCat.getName());
                euTreeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
                resultList.add(euTreeNode);
            }
        }
        return resultList;
    }
}
