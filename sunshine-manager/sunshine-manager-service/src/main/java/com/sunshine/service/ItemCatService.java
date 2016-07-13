package com.sunshine.service;

import java.util.List;

import com.sunshine.common.pojo.TreeNode;

public interface ItemCatService {

	public List<TreeNode> getItemCatList(Long parentId);
}
