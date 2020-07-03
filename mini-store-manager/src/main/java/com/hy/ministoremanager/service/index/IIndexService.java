package com.hy.ministoremanager.service.index;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ministoremanager.bean.*;
import lombok.val;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IIndexService extends IService<Slideshow> {

    public List<Slideshow> queryLunbo();
    public List<Slideshow> queryNavigation();
    public List<Product> queryProductList(Integer classes);
    public List<String> queryImgByPid(Integer pid);
    public List<String> queryProductDetailsImgByPid(Integer pid);
    public List<BigClass> queryBigClass();
    public Product queryOneProductById(Integer id);
    public List<Product> querySlideshowProduct(Integer id,String style);
    public List<Product> queryNavigaterProduct(Integer id,String style);
    public Slideshow querySlideshowById(Integer id);
    public Slideshow queryNavigaterById(Integer id);
    public List<ModelAndColor> queryModelByPid(Integer pid);
    public List<ModelAndColor> queryColorByPid(Integer pid);
    public List<ModelAndColor> queryModelByColor(String val,Integer pid);
    public List<ModelAndColor> queryColorByModel(String val,Integer pid);
    public List<Product> queryProductByClasses(Integer classes,String style);
    public List<GoodsCar> queryGoodsCar(String id);
    public Integer queryCounts(String model,String color,Integer pid);
    public Integer queryPrice(String model,String color,Integer pid);
    public Integer insertGoodsCar(Integer pid,String model,String color,Integer counts,String price);
    public Integer deleteGoodsCar(String ids);
    public BigDecimal SumPrice(String ids);

}
