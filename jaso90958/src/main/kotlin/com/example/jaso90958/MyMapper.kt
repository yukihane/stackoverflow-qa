package com.example.jaso90958

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select


@Mapper
interface MyMapper {

    @Select(
        """
            SELECT 
                COUNT(*)
            FROM 
                order
            WHERE 
                order_id IN 
            <foreach item="id" collection="orderIds" open="(" separator="," close=")" >
                #{id}
            </foreach>
        """
    )
    fun findByOrderIds(@Param(value = "orderIds") orderIds: List<String>): Int

}