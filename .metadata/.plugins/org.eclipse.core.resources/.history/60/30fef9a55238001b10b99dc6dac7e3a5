package com.dao;

import java.util.List;

import com.entity.Gchild;
import com.entity.Goodc;
import com.entity.Goods;

public interface GoodDao {
	//查看所有商品
	public  List<Goods>  getAll();
	//根据分类查看商品
	public  List<Goods>  getGc(int gcid);
	public  List<Goods>  getGch(int gchid);
	//查看品牌商品
	public  List<Goods>  getBrand();
	//查看一级分类名称
	public  List<Goodc>  getAllc();
	//查看所有二级分类名称
	public List<Gchild>  getAllch();
	//查看一级分类下的二级分类名称
	public  List<Gchild>  getAllch(int gcid);
	//获得所有商品数量
	public int totalCount();
	//获得页数
	public int  pageCount(int pagesize,int totalCount );
	//获得当前页的数据
	public List<Goods>  pageData(int pagesize,int pageCount);
	//获取一级分类商品的数量
	public int gcCount(int gcid);
	//获取二级分类商品的数量
	public int gchCount(int gchid);
	//获取品牌商品的数量
	public int brandCount();
	//获得一级分类当前页的数据
	public List<Goods>  gcpageData(int pagesize,int pageCount,int gcid);
	//获得二级分类当前页的数据
	public List<Goods>  gchpageData(int pagesize,int pageCount,int gchid);
	//获得品牌分类当前页的数据
	public List<Goods>  brandpageData(int pagesize,int pageCount);
	//根据id获得商品对象
	public Goods  getGoodById(int gid);
	//修改商品信息
	public int updateGood(Gchild gch, Goods good);
	//根据类目名称获得类目对象
	public Gchild getGchild(String gchname);
	//删除商品
	public int deleteGood(int gid);
	//添加商品
	public int addGood(Goods good);
	//模糊搜索商品
	public List<Goods>  selectGood(String gname);
}
