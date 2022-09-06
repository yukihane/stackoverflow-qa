package com.example.jaso90958

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select


@Mapper
interface MyMapper {

    @Select(
        """
            <script>
                SELECT 
                    COUNT(*)
                FROM 
                    `order`
                <where>
                    <foreach item="id" collection="orderIds" open="order_id IN (" separator="," close=")" >
                        #{id}
                    </foreach>
                </where>
            </script>
        """
    )
    fun findByOrderIds(@Param(value = "orderIds") orderIds: List<String>): Int

}