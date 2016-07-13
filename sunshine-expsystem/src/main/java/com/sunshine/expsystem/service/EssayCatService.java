package com.sunshine.expsystem.service;

import com.sunshine.common.pojo.TreeNode;
import com.sunshine.pojo.TbEssayCat;

import java.util.List;

public interface EssayCatService {

	public List<TreeNode> getItemCatList(Long parentId);

	public TbEssayCat getEssayCatById(long id);
}
