package com.hy.ministoremanager.controller.index;

import com.hy.ministoremanager.bean.*;
import com.hy.ministoremanager.service.index.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IIndexService iIndexService;



    /**
     * 查询轮播图
     * @return
     */
    @RequestMapping("queryLunbo")
    public List<Slideshow> queryLunbo(){
        return iIndexService.queryLunbo();
    }


    /**
     * 根据id查询轮播信息
     * @param id
     * @return
     */
    @RequestMapping("querySlideshowById")
    public Slideshow querySlideshowById(Integer id){
        return iIndexService.querySlideshowById(id);
    }

    /**
     * 查询轮播的商品
     * @param id
     * @return
     */
    @RequestMapping("querySlideshowProduct")
    public List<Product> querySlideshowProduct(Integer id,String style){
        return iIndexService.querySlideshowProduct(id,style);
    }

    /**
     * 根据id查询导航信息
     * @param id
     * @return
     */
    @RequestMapping("queryNavigaterById")
    public Slideshow queryNavigaterById(Integer id){
        return iIndexService.queryNavigaterById(id);
    }

    /**
     * 查询导航的商品
     * @param id
     * @return
     */
    @RequestMapping("queryNavigaterProduct")
    public List<Product> queryNavigaterProduct(Integer id,String style){
        return iIndexService.queryNavigaterProduct(id,style);
    }



    /**
     * 查询导航栏
     * @return
     */
    @RequestMapping("queryNavigation")
    public List<Slideshow> queryNavigation(){
        return iIndexService.queryNavigation();
    }


    /**
     * 查询商品
     * @param classes
     * @return
     */
    @RequestMapping("queryProductList")
    public List<Product> queryProductList(Integer classes){
        return iIndexService.queryProductList(classes);
    }

    /**
     * 查询一条商品
     * @param id
     * @return
     */
    @RequestMapping("queryOneProductById")
    public Product queryOneProductById(Integer id){
        return iIndexService.queryOneProductById(id);
    }


    /**
     * 根据id查询商品图片
     * @param pid
     * @return
     */
    @RequestMapping("queryImgByPid")
    public List<String>  queryImgByPid(Integer pid){
        return iIndexService.queryImgByPid(pid);
    }

    /**
     * 根据id查询商品详情图
     * @param pid
     * @return
     */
    @RequestMapping("queryProductDetailsImgByPid")
    public List<String>  queryProductDetailsImgByPid(Integer pid){
        return iIndexService.queryProductDetailsImgByPid(pid);
    }


    /**
     * 查询大的类别
     * @return
     */
    @RequestMapping("queryBigClass")
    public List<BigClass> queryBigClass(){
        return iIndexService.queryBigClass();
    }

    /**
     * 根据商品编号查询规格
     * @return
     */
    @RequestMapping("queryModelByPid")
    public List<ModelAndColor> queryModelByPid(Integer pid){
        return  iIndexService.queryModelByPid(pid);
    }


    /**
     * 根据商品编号查询颜色
     * @return
     */
    @RequestMapping("queryColorByPid")
    public List<ModelAndColor> queryColorByPid(Integer pid){
        return  iIndexService.queryColorByPid(pid);
    }

    /**
     * 根据颜色查类别
     * @param val
     * @return
     */
    @RequestMapping("queryModelByColor")
    public List<ModelAndColor> queryModelByColor(String val,Integer pid){
        return iIndexService.queryModelByColor(val,pid);
    }

    /**
     * 相反
     * @param val
     * @return
     */
    @RequestMapping("queryColorByModel")
    public List<ModelAndColor> queryColorByModel(String val,Integer pid){
        return iIndexService.queryColorByModel(val,pid);
    }

    /**
     * 查库存
     * @param model
     * @param color
     * @return
     */
    @RequestMapping("queryCounts")
    public Integer queryCounts(String model,String color,Integer pid){
        return iIndexService.queryCounts(model,color,pid);
    }

    /**
     * 查价格
     * @param model
     * @param color
     * @return
     */
    @RequestMapping("queryPrice")
    public Integer queryPrice(String model,String color,Integer pid){
        return iIndexService.queryPrice(model,color,pid);
    }

    /**
     * 根据类别查询商品
     * @param classes
     * @return
     */
    @RequestMapping("queryProductByClasses")
    public List<Product> queryProductByClasses(Integer classes,String style){
        return iIndexService.queryProductByClasses(classes,style);
    }


    /**
     * 查询购物车
     * @param id
     * @return
     */
    @RequestMapping("queryGoodsCar")
    public List<GoodsCar> queryGoodsCar(String id){
          return iIndexService.queryGoodsCar(id);
    }


    /**
     * 添加购物车
     * @return
     */
    @RequestMapping("insertGoodsCar")
    public boolean insertGoodsCar(Integer pid,String model,String color,Integer counts,String price){
        Integer i = iIndexService.insertGoodsCar(pid,model,color,counts,price);
        if( i>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除购物车
     * @param result
     * @return
     */
    @RequestMapping("deleteGoodsCar")
    public boolean deleteGoodsCar(String result){
        String[] ids =result.split("_");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<ids.length;i++){
            if(i%2 !=0){
                sb.append(ids[i]);
                if(i<ids.length-2){
                    sb.append(",");
                }
            }
        }
        //return true;
       Integer num =  iIndexService.deleteGoodsCar(sb.toString());
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 计算购物车价钱
     * @return
     */
    @RequestMapping("SumPrice")
    public BigDecimal SumPrice(String ids){
        String[] id =ids.split("_");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<id.length;i++){
            if(i%2 !=0){
                sb.append(id[i]);
                if(i<id.length-2){
                    sb.append(",");
                }
            }
        }
        System.out.println(sb.toString());
      return  iIndexService.SumPrice(sb.toString());
    }








}
