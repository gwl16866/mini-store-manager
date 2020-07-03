package com.hy.ministoremanager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.ministoremanager.bean.*;
import com.hy.ministoremanager.provider.ProductProvider;
import lombok.val;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface IndexMapper  extends BaseMapper<Slideshow> {

    /**
     * 轮播图
     * @return
     */
    @Select("select * from slideshow")
    public List<Slideshow> queryLunbo();


    /**
     * 导航栏 两行
     * @return
     */
    @Select("select * from navigation")
    public List<Slideshow> queryNavigation();


    /**
     * 查询商品
     * @param classes
     * @return
     */
    @SelectProvider(type = ProductProvider.class,method = "queryProdyct")
    public List<Product> queryProductList(Integer classes);


    /**
     * 根据id查一条商品
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    public Product queryOneProductById(Integer id);


    /**
     * 查询轮播信息
     * @param id
     * @return
     */
    @Select("select * from slideshow where id=#{id}")
    public Slideshow querySlideshowById(Integer id);

    /**
     * 查询导航信息
     * @param id
     * @return
     */
    @Select("select * from navigation where id=#{id}")
    public Slideshow queryNavigaterById(Integer id);


    /**
     * 根据导航id查询所属轮播的商品
     * @param id
     * @return
     */
    @SelectProvider(type = ProductProvider.class,method = "querySlideshowProduct")
    public List<Product> querySlideshowProduct(Integer id,String style);


    /**
     * 根据导航id查询所属导航的商品
     * @param id
     * @return
     */
    @SelectProvider(type = ProductProvider.class,method = "queryNavigaterProduct")
    public List<Product> queryNavigaterProduct(Integer id,String style);

    /**
     * 根据id查询商品图片
     * @param pid
     * @return
     */
    @Select("select url from detailimg where pid =#{pid}")
    public  List<String>  queryImgByPid(Integer pid);

    /**
     * 根据id查询商品详情
     * @param pid
     * @return
     */
    @Select("select url from productDetails where pid =#{pid}")
    public  List<String>  queryProductDetailsImgByPid(Integer pid);


    /**
     * 查询大的类别
     * @return
     */
    @Select("select id,className text from bigclass where id =#{id}")
    public BigClass queryAllBigClass(Integer id);


    /**
     * 查询大的类别及旗下小类别
     * @return
     */
    @Select("SELECT  c.id,c.className text,c.url FROM  class c,bigclass bc,bigsmillclass t WHERE c.id=t.sid AND bc.id=t.bid AND bc.id=#{id}")
    public List<BigClassTwo> queryBigClass(Integer id);


    /**
     * 规格
     * @param pid
     * @return
     */
    @Select("SELECT DISTINCT(model) FROM modelcolor WHERE pid=#{pid} AND counts !=0")
    public List<ModelAndColor> queryModelByPid(Integer pid);


    /**
     * 颜色
     * @param pid
     * @return
     */
    @Select("SELECT DISTINCT(color) FROM modelcolor WHERE pid=#{pid} AND counts !=0")
    public List<ModelAndColor> queryColorByPid(Integer pid);


    /**
     * 根据颜色查类别
     * @param val
     * @return
     */
    @Select("SELECT model FROM modelcolor WHERE color =#{val} AND counts !=0 and pid=#{pid}")
    public List<ModelAndColor> queryModelByColor(String val,Integer pid);

    /**
     * 根据类别查颜色
     * @param val
     * @return
     */
    @Select("SELECT color FROM modelcolor WHERE model =#{val} AND counts !=0 and pid=#{pid}")
    public List<ModelAndColor> queryColorByModel(String val,Integer pid);


    /**
     * 查询库存
     * @param model
     * @param color
     * @return
     */
    @Select("select counts from modelcolor where model=#{model} and color=#{color} and pid=#{pid}")
    public Integer queryCounts(String model, String color,Integer pid);


    /**
     * 查询价格
     * @param model
     * @param color
     * @return
     */
    @Select("select price from modelcolor where model=#{model} and color=#{color} and pid=#{pid}")
    public Integer queryPrice(String model, String color,Integer pid);




    /**
     * 根据类别id查询商品
     * @param classes
     * @return
     */
    @SelectProvider(type = ProductProvider.class,method = "queryProductByClasses")
    public List<Product> queryProductByClasses(Integer classes,String style);

    /**
     * 查询购物车
     * @param id
     * @return
     */
    @Select("SELECT g.id,p.productName,p.indexImg,p.material,p.address,g.model,g.color,g.price,g.counts FROM product p,goodscar g WHERE p.id=g.pid")
    public List<GoodsCar> queryGoodsCar(String id);


    /**
     * 查询这个人购物车中有没有此商品
     * @param pid
     * @param model
     * @param color
     * @return
     */
    @Select("select counts from goodscar where pid=#{pid} and model=#{model} and color =#{color} and byman=1")
    public Integer queryGoodsCarCountsById(Integer pid,String model,String color);


    /**
     * 修改购物车商品数量
     * @param pid
     * @param model
     * @param color
     * @param counts
     * @return
     */
    @Update("update goodscar set counts = counts+#{counts} where pid=#{pid} and model=#{model} and color =#{color} and byman=1")
    public Integer updateGoodsCarCountsById(Integer pid,String model,String color,Integer counts);


    /**
     * 添加购物车
     * @param pid
     * @param model
     * @param color
     * @param counts
     * @return
     */
    @Insert("insert into goodscar values(null,#{pid},#{counts},1,#{model},#{color},#{price})")
    public Integer insertGoodsCar(Integer pid,String model,String color,Integer counts,String price);


    /**
     * 删除购物车
     * @param ids
     * @return
     */
    @DeleteProvider(type = ProductProvider.class,method = "deleteGoodsCar")
    public Integer deleteGoodsCar(String ids);

    /**
     * 查询价格和数量
     * @param ids
     * @return
     */
    @SelectProvider(type = ProductProvider.class,method = "sumPrice")
    public List<GoodsCar> SumPrice(String ids);

}
