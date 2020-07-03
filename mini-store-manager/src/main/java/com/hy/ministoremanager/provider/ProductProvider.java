package com.hy.ministoremanager.provider;

import org.springframework.util.StringUtils;

public class ProductProvider {



    public String queryProdyct(Integer classes){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from product where 1=1 ");
        if(!StringUtils.isEmpty(classes)){
            sb.append(" and classes = "+classes+"");
        }
        return sb.toString();
    }

    /**
     * 根据轮播id查询所属轮播的商品
     * @param id
     * @return
     */
    public String querySlideshowProduct(Integer id,String style){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from product ");
        if(!StringUtils.isEmpty(id)){
            if(id ==1){
                sb.append(" where classes in (11,12)");
            }else if(id ==2){
                sb.append(" where classes =12");
            }else if(id ==3){
                sb.append(" where classes in (11,12) and productName like '%羽绒%'");
            }else if(id ==4){
                sb.append(" where classes =10 ");
            }
        }
        if(!StringUtils.isEmpty(style)){
            if(style.equals("all")){

            }else if(style.equals("gao")){
                sb.append(" order by price desc");
            }else if(style.equals("di")){
                sb.append(" order by price");
            }else if(style.equals("volumn")){
                sb.append(" order by volumn desc");
            }

        }
        return sb.toString();
    }



    /**
     * 根据导航id查询所属导航的商品
     * @param id
     * @return
     */
    public String queryNavigaterProduct(Integer id,String style){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from product ");
        if(!StringUtils.isEmpty(id)){
            //衣服  男装和女装
            if(id ==3){
                sb.append(" where classes in (11,12) ");
            }else{
                sb.append(" where classes =(select classes from navigation where id="+id+") ");
            }
        }
        if(!StringUtils.isEmpty(style)){
            if(style.equals("all")){

            }else if(style.equals("gao")){
                sb.append(" order by price desc");
            }else if(style.equals("di")){
                sb.append(" order by price");
            }else if(style.equals("volumn")){
                sb.append(" order by volumn desc");
            }

        }
        return sb.toString();
    }



    /**
     * 根据导航id查询所属类别的商品
     * @param classes
     * @return
     */
    public String queryProductByClasses(Integer classes,String style){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from product ");
        if(!StringUtils.isEmpty(classes)){
            //衣服  男装和女装
                sb.append(" where classes = "+classes+" ");
        }
        if(!StringUtils.isEmpty(style)){
            if(style.equals("all")){

            }else if(style.equals("gao")){
                sb.append(" order by price desc");
            }else if(style.equals("di")){
                sb.append(" order by price");
            }else if(style.equals("volumn")){
                sb.append(" order by volumn desc");
            }

        }
        return sb.toString();
    }


    /**
     * 删除购物车
     * @param ids
     * @return
     */
    public String deleteGoodsCar(String ids){
        StringBuffer sb =new StringBuffer();
        sb.append("delete from goodscar where id in (");
        String [] id =ids.split(",");
        for(int i=0;i<id.length;i++){
            sb.append(id[i]);
            if(i<id.length-1){
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * 价钱
     * @param ids
     * @return
     */
    public String sumPrice(String ids){
        StringBuffer sb =new StringBuffer();
        sb.append("SELECT price,counts FROM goodscar WHERE id IN(");
        String [] id =ids.split(",");
        for(int i=0;i<id.length;i++){
            sb.append(id[i]);
            if(i<id.length-1){
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }












}
